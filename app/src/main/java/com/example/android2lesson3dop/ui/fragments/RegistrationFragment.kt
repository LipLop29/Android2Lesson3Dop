package com.example.android2lesson3dop.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android2lesson3dop.R
import com.example.android2lesson3dop.databinding.FragmentRegistrationBinding
import com.example.android2lesson3dop.utils.PreferenceHelper

class RegistrationFragment : Fragment() {

    private var binding: FragmentRegistrationBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setupListener()
    }

    private fun init() {
        PreferenceHelper.unit(requireContext())
    }

    private fun setupListener() {
        binding?.btnReg?.setOnClickListener {
            if (binding?.etName?.text?.isNotEmpty() != null || binding?.etPsw?.text?.isEmpty() != null) {
                PreferenceHelper.safeText = binding?.etName?.text.toString().trim()
                PreferenceHelper.safeText2 = binding?.etPsw?.text.toString().trim()
            }
            if (binding?.etName?.text!!.isEmpty() || binding?.etPsw?.text!!.isEmpty()) {
                if (binding?.etName?.text!!.isEmpty()) {
                    binding?.etName?.error = "Заполните поля!"
                }
                if (binding?.etPsw?.text!!.isEmpty()) {
                    binding?.etPsw?.error = "Заполните поля!"
                }
            }
            if (binding?.etName?.length() in 0..4 || binding?.etPsw?.length() in 0..7) {
                if (binding?.etName?.length() in 1..4) {
                    binding?.etName?.error = "Должно быть не менее 5 символов"
                }
                if (binding?.etPsw?.length() in 1..7) {
                    binding?.etPsw?.error = "Должно быть не менее 8 символов"
                }
            } else {
                findNavController().navigate(R.id.action_registrationFragment_to_getRegistrationDataFragment)
            }
        }
    }
}

