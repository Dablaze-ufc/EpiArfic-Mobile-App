package com.epiafric.epiarfic_mobile_app.ui.research

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.epiafric.epiarfic_mobile_app.R
import com.epiafric.epiarfic_mobile_app.adapter.EntriesDataAdapter
import com.epiafric.epiarfic_mobile_app.databinding.FragmentResearchBinding

class ResearchFragment : Fragment() {

    private lateinit var researchViewModel: ResearchViewModel
    private lateinit var binding: FragmentResearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentResearchBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application

        val researchViewModelFactory = ResearchViewModelFactory(application)

        researchViewModel =
            ViewModelProvider(this, researchViewModelFactory).get(ResearchViewModel::class.java)

       binding.lifecycleOwner = this

       binding.viewModel = researchViewModel



        return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.researchRecyclerView.adapter = EntriesDataAdapter()
         }

    }

