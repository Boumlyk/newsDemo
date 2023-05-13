package com.hmzeda.newsdemo.ui.main.home

import android.app.ProgressDialog
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
import com.hmzeda.newsdemo.ui.util.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHome:BaseFragment() {

    lateinit var binding: FHomeBinding
    var progressDialog: ProgressDialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.f_home,container,false)

        initView()
        return binding.root
    }

    private fun initView(){
        viewModel= ViewModelProvider(this)[FragmentHomeViewModel::class.java]
        binding.viewModel=(viewModel as FragmentHomeViewModel)
        binding.recyclerView.adapter=(viewModel as FragmentHomeViewModel).getAdapter(requireActivity())
        (viewModel as FragmentHomeViewModel).initiateViewModel(requireActivity() as BaseActivity,binding.recyclerView)

        viewModel.actions?.observe(requireActivity()) { actions ->
            for (action in actions) {
                when (action) {
                    BaseActivity.ACTION_START_LOADING -> onStartLoading()
                    BaseActivity.ACTION_FINISH_LOADING -> onFinishLoading()
                }
            }
        }
    }
    private fun onStartLoading() {
        progressDialog = Utils.createProgressDialog(requireActivity())
    }

    private fun onFinishLoading() {
        progressDialog?.dismiss()
    }

}