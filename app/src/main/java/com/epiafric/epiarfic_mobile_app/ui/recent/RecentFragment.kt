package com.epiafric.epiarfic_mobile_app.ui.recent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.epiafric.epiarfic_mobile_app.adapter.EntriesDataAdapter
import com.epiafric.epiarfic_mobile_app.databinding.FragmentRecentBinding

class RecentFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val application = requireNotNull(this.activity).application
         val recentViewModelFactory = RecentViewModelFactory(application)

         val recentViewModel by lazy {
            ViewModelProvider(this, recentViewModelFactory).get(RecentViewModel::class.java)
        }
        val binding = FragmentRecentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.recentRecyclerView.adapter = EntriesDataAdapter()


        binding.viewModel = recentViewModel



        return binding.root
    }
}
