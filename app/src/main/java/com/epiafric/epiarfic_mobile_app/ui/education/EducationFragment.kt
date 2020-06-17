package com.epiafric.epiarfic_mobile_app.ui.education

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.epiafric.epiarfic_mobile_app.R
import com.epiafric.epiarfic_mobile_app.adapter.EntriesDataAdapter
import com.epiafric.epiarfic_mobile_app.adapter.OnclickListener
import com.epiafric.epiarfic_mobile_app.databinding.EducationFragmentBinding

class EducationFragment : Fragment() {

    companion object {
        //  fun newInstance() = EducationFragment()
    }

    private lateinit var binding: EducationFragmentBinding
    private lateinit var educationViewModel: EducationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // viewModel = ViewModelProvider(this).get(EducationViewModel::class.java)
        binding = EducationFragmentBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application

        // val dataSource = EntriesDatabase.getInstance(application).entriesDao

        val viewModelFactory = EducationViewModelFactory(application)

        educationViewModel = ViewModelProvider(this, viewModelFactory)
            .get(EducationViewModel::class.java)

        binding.viewModel = educationViewModel

        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.educationRecyclerView.adapter = EntriesDataAdapter(OnclickListener { data ->
            educationViewModel.onDataClicked(data)

        })
        educationViewModel.navigateToDataDetail.observe(viewLifecycleOwner, Observer {
            val bundle = Bundle()
            bundle.putParcelable("data", it)
            it?.let {
                this.findNavController().navigate(R.id.detailsFragment, bundle)
                educationViewModel.onDetailsNavigatedDone()
            }
        })

    }
}

