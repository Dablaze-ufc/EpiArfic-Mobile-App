package com.epiafric.epiarfic_mobile_app.ui.health

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.epiafric.epiarfic_mobile_app.adapter.EntriesDataAdapter
import com.epiafric.epiarfic_mobile_app.databinding.FragmentHealthBinding

class HealthFragment : Fragment() {

    private lateinit var healthViewModel: HealthViewModel
    private lateinit var binding: FragmentHealthBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(this.activity).application

        val healthViewModelFactory = HealthViewModelFactory(application)

        binding = FragmentHealthBinding.inflate(inflater)

        healthViewModel =
            ViewModelProvider(this, healthViewModelFactory).get(HealthViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = healthViewModel

        return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.healthRecyclerView.adapter = EntriesDataAdapter()
    }

    }

