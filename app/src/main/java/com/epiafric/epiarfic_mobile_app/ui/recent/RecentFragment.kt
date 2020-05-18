package com.epiafric.epiarfic_mobile_app.ui.recent

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
import com.epiafric.epiarfic_mobile_app.databinding.FragmentRecentBinding

class RecentFragment : Fragment() {

    private lateinit var recentViewModel: RecentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recentViewModel =
            ViewModelProvider(this).get(RecentViewModel::class.java)
        val binding = FragmentRecentBinding.inflate(inflater)

        recentViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textHome.text = it
        })
        return binding.root
    }
}
