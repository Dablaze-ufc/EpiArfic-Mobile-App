package com.epiafric.epiarfic_mobile_app.ui.business

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.epiafric.epiarfic_mobile_app.R
import com.epiafric.epiarfic_mobile_app.databinding.BusinessFragmentBinding

class BusinessFragment : Fragment() {

    companion object {
        fun newInstance() = BusinessFragment()
    }

    private lateinit var viewModel: BusinessViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(BusinessViewModel::class.java)
        val binding = BusinessFragmentBinding.inflate(inflater)
        return binding.root
    }
}
