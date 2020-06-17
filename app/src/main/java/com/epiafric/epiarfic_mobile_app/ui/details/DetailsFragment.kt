package com.epiafric.epiarfic_mobile_app.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.epiafric.epiarfic_mobile_app.databinding.DetailsFragmentBinding
import com.epiafric.epiarfic_mobile_app.model.Data

class DetailsFragment : Fragment() {


    private lateinit var viewModel: DetailsViewModel
    private lateinit var binding: DetailsFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DetailsFragmentBinding.inflate(inflater)
        val factory = DetailsViewModelFactory(arguments?.get("data") as Data)
        viewModel = ViewModelProvider(this,factory).get(DetailsViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}