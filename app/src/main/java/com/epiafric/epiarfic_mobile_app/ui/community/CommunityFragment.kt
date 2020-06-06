package com.epiafric.epiarfic_mobile_app.ui.community

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.epiafric.epiarfic_mobile_app.R
import com.epiafric.epiarfic_mobile_app.adapter.EntriesDataAdapter
import com.epiafric.epiarfic_mobile_app.database.EntriesDatabase
import com.epiafric.epiarfic_mobile_app.databinding.CommunityFragmentBinding

class CommunityFragment : Fragment() {

    companion object {
        fun newInstance() = CommunityFragment()
    }

    //private lateinit var viewModel: CommunityViewModel
   private lateinit var binding: CommunityFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //viewModel = ViewModelProvider(this).get(CommunityViewModel::class.java)
        binding = CommunityFragmentBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application

        val dataSource = EntriesDatabase.getInstance(application).entriesDao

        val viewModelFactory = CommunityViewModelFactory(dataSource, application)

        val communityViewModel = ViewModelProviders.of(this,viewModelFactory).get(CommunityViewModel::class.java)

//        val communityViewModel = ViewModelProviders.of(this, viewModelFactory).get(CommunityViewModel
//            ::class.java)
        binding.setLifecycleOwner(this)

        binding.viewModel = communityViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.communityRecyclerView.adapter = EntriesDataAdapter()
    }
}
