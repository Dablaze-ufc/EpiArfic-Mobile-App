package com.epiafric.epiarfic_mobile_app.ui.vunerable_population

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.epiafric.epiarfic_mobile_app.adapter.EntriesDataAdapter
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

        val application = requireNotNull(this.activity).application

        val vulnerableViewModelFactory = VunerablePopulationViewModelFactory(application)

        vulnerableViewModel = ViewModelProvider(this, vulnerableViewModelFactory).
                    get(VunerablePopulationViewModel::class.java)

        binding.viewModel = vulnerableViewModel



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vulnerableRecyclerView.adapter = EntriesDataAdapter()
    }

}
