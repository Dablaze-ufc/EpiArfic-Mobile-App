package com.epiafric.epiarfic_mobile_app.ui.vunerable_population

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.epiafric.epiarfic_mobile_app.R
import com.epiafric.epiarfic_mobile_app.databinding.VunerablePopulationFragmentBinding

class VulnerablePopulationFragment : Fragment() {

    companion object {
        fun newInstance() = VulnerablePopulationFragment()
    }

    private lateinit var viewModel: VunerablePopulationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(VunerablePopulationViewModel::class.java)
        val binding = VunerablePopulationFragmentBinding.inflate(inflater)

        return binding.root
    }

}
