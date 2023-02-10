package com.example.android2lesson3dop.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android2lesson3dop.databinding.FragmentGetRegisterDataBinding
import com.example.android2lesson3dop.utils.PreferenceHelper

class GetRegistrationDataFragment : Fragment() {

    private lateinit var binding: FragmentGetRegisterDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGetRegisterDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() = with(binding) {
        PreferenceHelper.unit(requireContext())
        tvName2.text = PreferenceHelper.safeText?.trim()
        tvPsw2.text = PreferenceHelper.safeText2?.trim()
    }
}