package com.epiafric.epiarfic_mobile_app.ui.recent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.epiafric.epiarfic_mobile_app.R
import com.epiafric.epiarfic_mobile_app.adapter.EntriesDataAdapter
import com.epiafric.epiarfic_mobile_app.adapter.OnclickListener
import com.epiafric.epiarfic_mobile_app.databinding.FragmentRecentBinding
import com.epiafric.epiarfic_mobile_app.util.State
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_recent.*

class RecentFragment : Fragment() {
    private lateinit var binding: FragmentRecentBinding
    private lateinit var recentViewModel: RecentViewModel


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(this.activity).application
        val recentViewModelFactory = RecentViewModelFactory(application)

        recentViewModel =
                ViewModelProvider(this, recentViewModelFactory).get(RecentViewModel::class.java)

        binding = FragmentRecentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = recentViewModel


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.refreshLayout.setOnRefreshListener {
            recentViewModel.refreshCall()
        }
        refresh(false)

        binding.recentRecyclerView.adapter = EntriesDataAdapter(OnclickListener { data ->
            recentViewModel.onDataClicked(data)

        })

        recentViewModel.navigateToDataDetail.observe(viewLifecycleOwner, Observer {
            val bundle = Bundle()
            bundle.putParcelable("data", it)
            it?.let {
                this.findNavController().navigate(R.id.detailsFragment, bundle)
                recentViewModel.onDetailsNavigatedDone()
            }
        })
        recentViewModel.recentResponse.observe(viewLifecycleOwner, Observer {
            it.getContentIfEventNotHandled()?.let { result ->
                when (result.status) {
                    State.LOADING -> refresh(result.isRefreshing!!)
                    State.SUCCESS -> {
                        showSnackBar(result.message!!)
                        refresh(result.isRefreshing!!)
                    }
                    State.ERROR -> {
                        showSnackBar(result.message!!)
                        refresh(result.isRefreshing!!)
                    }
                }
            }
        })



    }

    private fun showSnackBar(message: String) {
        Snackbar.make(refreshLayout, message, Snackbar.LENGTH_LONG).show()
    }

    private fun refresh(value: Boolean) {
        refreshLayout.isRefreshing = value
    }


}
