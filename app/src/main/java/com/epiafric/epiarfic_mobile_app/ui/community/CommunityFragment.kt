package com.epiafric.epiarfic_mobile_app.ui.community

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
import com.epiafric.epiarfic_mobile_app.database.EntriesDatabase
import com.epiafric.epiarfic_mobile_app.databinding.CommunityFragmentBinding

class CommunityFragment : Fragment() {

    companion object {
        fun newInstance() = CommunityFragment()
    }

    private lateinit var communityViewModel: CommunityViewModel
    private lateinit var binding: CommunityFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //viewModel = ViewModelProvider(this).get(CommunityViewModel::class.java)
        binding = CommunityFragmentBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application

        val dataSource = EntriesDatabase.getInstance(application).entriesDao

        val viewModelFactory = CommunityViewModelFactory(dataSource, application)

        communityViewModel =
            ViewModelProvider(this, viewModelFactory).get(CommunityViewModel::class.java)


        binding.lifecycleOwner = this

        binding.viewModel = communityViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.communityRecyclerView.adapter = EntriesDataAdapter(OnclickListener { data ->
            communityViewModel.onDataClicked(data)

        })
        communityViewModel.navigateToDataDetail.observe(viewLifecycleOwner, Observer {
            val bundle = Bundle()
            bundle.putParcelable("data", it)
            it?.let {
                this.findNavController().navigate(R.id.detailsFragment, bundle)
                communityViewModel.onDetailsNavigatedDone()
            }
        })

    }
}

