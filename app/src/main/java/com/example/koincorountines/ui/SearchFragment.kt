package com.example.koincorountines.ui

import androidx.activity.addCallback
import androidx.navigation.findNavController
import com.example.koincorountines.R
import com.example.koincorountines.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val fragmentLayout: Int = R.layout.fragment_search

    companion object {
        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }

    override fun init() {
//        requireActivity().onBackPressedDispatcher
//            .addCallback(this) {
//                view?.findNavController()?.navigate(R.id.navigationHome)
//            }
    }

}