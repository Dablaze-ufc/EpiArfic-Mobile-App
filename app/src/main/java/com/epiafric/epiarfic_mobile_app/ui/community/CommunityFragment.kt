package com.epiafric.epiarfic_mobile_app.ui.community

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.epiafric.epiarfic_mobile_app.R
import com.epiafric.epiarfic_mobile_app.databinding.CommunityFragmentBinding

class CommunityFragment : Fragment() {

    companion object {
        fun newInstance() = CommunityFragment()
    }

    private lateinit var viewModel: CommunityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(CommunityViewModel::class.java)
        val binding = CommunityFragmentBinding.inflate(inflater)

        return binding.root
    }
}
