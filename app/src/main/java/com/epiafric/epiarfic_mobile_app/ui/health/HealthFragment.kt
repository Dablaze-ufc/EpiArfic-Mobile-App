package com.epiafric.epiarfic_mobile_app.ui.health

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.epiafric.epiarfic_mobile_app.databinding.FragmentHealthBinding

class HealthFragment : Fragment() {

    private lateinit var healthViewModel: HealthViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHealthBinding.inflate(inflater)
        healthViewModel =
            ViewModelProvider(this).get(HealthViewModel::class.java)
        healthViewModel.text.observe(viewLifecycleOwner, Observer {
           binding.textGallery.text = it
        })
        return binding.root
    }
}
