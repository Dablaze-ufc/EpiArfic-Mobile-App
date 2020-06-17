package com.epiafric.epiarfic_mobile_app.ui.health

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
import com.epiafric.epiarfic_mobile_app.databinding.FragmentHealthBinding

class HealthFragment : Fragment() {

    private lateinit var healthViewModel: HealthViewModel
    private lateinit var binding: FragmentHealthBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHealthBinding.inflate(inflater)

        healthViewModel =
            ViewModelProvider(this).get(HealthViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = healthViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.healthRecyclerView.adapter = EntriesDataAdapter(OnclickListener { data ->
            healthViewModel.onDataClicked(data)

        })
        healthViewModel.navigateToDataDetail.observe(viewLifecycleOwner, Observer {
            val bundle = Bundle()
            bundle.putParcelable("data", it)
            it?.let {
                this.findNavController().navigate(R.id.detailsFragment, bundle)
                healthViewModel.onDetailsNavigatedDone()
            }
        })

    }


}

