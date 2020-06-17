package com.epiafric.epiarfic_mobile_app.ui.business

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
import com.epiafric.epiarfic_mobile_app.databinding.BusinessFragmentBinding

class BusinessFragment : Fragment() {

    private lateinit var viewModel: BusinessViewModel
    private lateinit var binding: BusinessFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = BusinessFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(BusinessViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.businessRecyclerView.adapter = EntriesDataAdapter(OnclickListener { data ->
            viewModel.onDataClicked(data)

        })
        viewModel.navigateToDataDetail.observe(viewLifecycleOwner, Observer {
            val bundle = Bundle()
            bundle.putParcelable("data", it)
            it?.let {
                this.findNavController().navigate(R.id.detailsFragment, bundle)
                viewModel.onDetailsNavigatedDone()
            }
        })

    }
}
