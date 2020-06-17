package com.epiafric.epiarfic_mobile_app.ui.research

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
import com.epiafric.epiarfic_mobile_app.databinding.FragmentResearchBinding

class ResearchFragment : Fragment() {

    private lateinit var researchViewModel: ResearchViewModel
    private lateinit var binding: FragmentResearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResearchBinding.inflate(inflater)

        researchViewModel =
            ViewModelProvider(this).get(ResearchViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = researchViewModel



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.researchRecyclerView.adapter = EntriesDataAdapter(OnclickListener { data ->
            researchViewModel.onDataClicked(data)

        })
        researchViewModel.navigateToDataDetail.observe(viewLifecycleOwner, Observer {
            val bundle = Bundle()
            bundle.putParcelable("data", it)
            it?.let {
                this.findNavController().navigate(R.id.detailsFragment, bundle)
                researchViewModel.onDetailsNavigatedDone()
            }
        })
    }

}

