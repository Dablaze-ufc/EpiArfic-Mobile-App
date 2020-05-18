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
import com.epiafric.epiarfic_mobile_app.databinding.FragmentResearchBinding

class ResearchFragment : Fragment() {

    private lateinit var researchViewModel: ResearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        researchViewModel =
            ViewModelProvider(this).get(ResearchViewModel::class.java)
        val binding  = FragmentResearchBinding.inflate(inflater)

        researchViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textSlideshow.text = it
        })
        return binding.root
    }
}
