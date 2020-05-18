package com.epiafric.epiarfic_mobile_app.ui.others

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.epiafric.epiarfic_mobile_app.databinding.OthersFragmentBinding

class OthersFragment : Fragment() {

    companion object {
        fun newInstance() = OthersFragment()
    }

    private lateinit var viewModel: OthersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(OthersViewModel::class.java)
        val binding = OthersFragmentBinding.inflate(inflater)
        return binding.root
    }

}
