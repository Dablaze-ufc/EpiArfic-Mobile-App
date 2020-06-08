package com.epiafric.epiarfic_mobile_app.ui.business
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.epiafric.epiarfic_mobile_app.adapter.EntriesDataAdapter
import com.epiafric.epiarfic_mobile_app.databinding.BusinessFragmentBinding

class BusinessFragment : Fragment() {

    companion object {
     //   fun newInstance() = BusinessFragment()
    }

    private lateinit var viewModel: BusinessViewModel
    private lateinit var binding: BusinessFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = BusinessFragmentBinding.inflate(inflater)
        val application = requireNotNull(this.activity).application

        val businessViewModelFactory = BusinessViewModelFactory(application)

        viewModel = ViewModelProvider(this, businessViewModelFactory).get(BusinessViewModel::class.java)


        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.businessRecyclerView.adapter = EntriesDataAdapter()

    }
}
