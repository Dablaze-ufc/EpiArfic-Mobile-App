package com.epiafric.epiarfic_mobile_app.ui.others

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.epiafric.epiarfic_mobile_app.adapter.EntriesDataAdapter

import com.epiafric.epiarfic_mobile_app.databinding.OthersFragmentBinding


class OthersFragment : Fragment() {

    companion object {
      //  fun newInstance() = OthersFragment()
    }

    private lateinit var othersViewModel: OthersViewModel
    private lateinit var binding: OthersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OthersFragmentBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application

       // val dataSource = EntriesDatabase.getInstance(application).entriesDao

        val othersViewModelFactory = OthersViewModelFactory(application)

        othersViewModel =
            ViewModelProvider(this, othersViewModelFactory).get(OthersViewModel::class.java)

        binding.viewModel = othersViewModel

        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.othersRecyclerView.adapter = EntriesDataAdapter()
    }

}
