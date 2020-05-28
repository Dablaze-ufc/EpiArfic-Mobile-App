package com.epiafric.epiarfic_mobile_app.ui.recent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.epiafric.epiarfic_mobile_app.adapter.EntriesDataAdapter
import com.epiafric.epiarfic_mobile_app.databinding.FragmentRecentBinding
import com.epiafric.epiarfic_mobile_app.util.State
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_recent.*

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

        recentViewModel.recentResponse.observe(viewLifecycleOwner, Observer {
            it.getContentIfEventNotHandled()?.let {result ->
                when(result.status){
                    State.LOADING -> refresh(result.isRefreshing!!)
                    State.SUCCESS -> { showSnackBar(result.message!!)
                                        refresh(result.isRefreshing!!)   }
                    State.ERROR -> {showSnackBar(result.message!!)
                                    refresh(result.isRefreshing!!)}
                }
            }
        })



        return binding.root
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(refreshLayout, message, Snackbar.LENGTH_LONG).show()
    }

    private fun refresh(value: Boolean){
        refreshLayout.isRefreshing = value
    }
}
