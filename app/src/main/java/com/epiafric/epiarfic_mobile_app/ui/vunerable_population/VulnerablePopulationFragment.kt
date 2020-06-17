package com.epiafric.epiarfic_mobile_app.ui.vunerable_population

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
import com.epiafric.epiarfic_mobile_app.databinding.VunerablePopulationFragmentBinding

class VulnerablePopulationFragment : Fragment() {

    companion object {
       // fun newInstance() = VulnerablePopulationFragment()
    }

    private lateinit var vulnerableViewModel: VunerablePopulationViewModel
    private lateinit var binding: VunerablePopulationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = VunerablePopulationFragmentBinding.inflate(inflater)


        vulnerableViewModel = ViewModelProvider(this).
                    get(VunerablePopulationViewModel::class.java)

        binding.viewModel = vulnerableViewModel



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vulnerableRecyclerView.adapter = EntriesDataAdapter(OnclickListener { data ->
            vulnerableViewModel.onDataClicked(data)

        })
        vulnerableViewModel.navigateToDataDetail.observe(viewLifecycleOwner, Observer {
            val bundle = Bundle()
            bundle.putParcelable("data", it)
            it?.let {
                this.findNavController().navigate(R.id.detailsFragment, bundle)
                vulnerableViewModel.onDetailsNavigatedDone()
            }
        })
    }

}
