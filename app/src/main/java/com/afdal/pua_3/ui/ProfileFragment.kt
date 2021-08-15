package com.afdal.pua_3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.afdal.pua_3.R
import com.afdal.pua_3.databinding.FragmentProfileBinding
import com.afdal.pua_3.repository.source.localSource.MainRepository

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        binding.lifecycleOwner = this

        val repository = MainRepository()
        val viewModel: ProfileViewModel = ViewModelProvider(
            this,
            ProfileViewModel.FACTORY(repository)
        )[ProfileViewModel::class.java]
        binding.viewModel = viewModel

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // FirebaseService.getDataUserName()
    }

}