package com.example.koincorountines.ui

import androidx.activity.addCallback
import androidx.navigation.findNavController
import com.example.koincorountines.R
import com.example.koincorountines.databinding.FragmentMylistBinding

class MyListFragment : BaseFragment<FragmentMylistBinding>() {
    override val fragmentLayout: Int = R.layout.fragment_mylist

    companion object {
        fun newInstance(): MyListFragment {
            return MyListFragment()
        }
    }

    override fun init() {
//        requireActivity().onBackPressedDispatcher
//            .addCallback(this) {
//                view?.findNavController()?.navigate(R.id.navigationHome)
//            }
    }

}