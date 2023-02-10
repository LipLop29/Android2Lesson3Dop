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

    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setupListener()
    }

    private fun init() {
        PreferenceHelper.unit(requireContext())
    }

    private fun setupListener() = with(binding) {
        btnReg.setOnClickListener {
            PreferenceHelper.safeText = etName.text.toString().trim()
            PreferenceHelper.safeText2 = etPsw.text.toString().trim()

            if (etName.text.isEmpty() || etPsw.text.isEmpty()) {
                if (etName.text.isEmpty()) {
                    etName.error = "Заполните поля!"
                }
                if (etPsw.text.isEmpty()) {
                    etPsw.error = "Заполните поля!"
                }
            }
            if (etName.length() in 0..4 || etPsw.length() in 0..7) {
                if (etName.length() in 1..4) {
                    etName.error = "Должно быть не менее 5 символов"
                }
                if (etPsw.length() in 1..7) {
                    etPsw.error = "Должно быть не менее 8 символов"
                }
            } else {
                findNavController().navigate(R.id.action_registrationFragment_to_getRegistrationDataFragment)
            }
        }
    }
}

