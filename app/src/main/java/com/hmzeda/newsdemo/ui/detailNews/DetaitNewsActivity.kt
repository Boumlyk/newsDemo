package com.hmzeda.newsdemo.ui.detailNews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.hmzeda.newsdemo.R
import com.hmzeda.newsdemo.databinding.ActivityDetailNewsBinding
import com.hmzeda.newsdemo.databinding.ActivityMainBinding
import com.hmzeda.newsdemo.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetaitNewsActivity : BaseActivity() {

    lateinit var binding:ActivityDetailNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_detail_news)
        binding.toolbar.indicator.reattach()
        viewModel= ViewModelProvider(this)[DetailNewsActivityViewModel::class.java]
        binding.viewModel=(viewModel as DetailNewsActivityViewModel)
        (viewModel as DetailNewsActivityViewModel).initiateViewModel(this as BaseActivity)
    }
}