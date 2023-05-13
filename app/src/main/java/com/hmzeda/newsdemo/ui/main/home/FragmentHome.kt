package com.hmzeda.newsdemo.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hmzeda.newsdemo.R
import com.hmzeda.newsdemo.databinding.FHomeBinding
import com.hmzeda.newsdemo.ui.BaseActivity
import com.hmzeda.newsdemo.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHome:BaseFragment() {

    lateinit var binding: FHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.f_home,container,false)

        initView()
        return binding.root
    }

    private fun initView(){
        viewModel=ViewModelProvider(this).get(FragmentHomeViewModel::class.java)
        binding.viewModel=(viewModel as FragmentHomeViewModel)


        (viewModel as FragmentHomeViewModel).initiateViewModel(requireActivity() as BaseActivity)
    }
}