package com.epiafric.epiarfic_mobile_app.ui.education

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.epiafric.epiarfic_mobile_app.R
import com.epiafric.epiarfic_mobile_app.databinding.EducationFragmentBinding

class EducationFragment : Fragment() {

    companion object {
        fun newInstance() = EducationFragment()
    }

    private lateinit var viewModel: EducationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(EducationViewModel::class.java)
        val binding = EducationFragmentBinding.inflate(inflater)


        return binding.root
    }


}
