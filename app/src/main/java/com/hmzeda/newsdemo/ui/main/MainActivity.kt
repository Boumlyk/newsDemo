package com.hmzeda.newsdemo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.hmzeda.newsdemo.R
import com.hmzeda.newsdemo.databinding.ActivityMainBinding
import com.hmzeda.newsdemo.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel= ViewModelProvider(this)[MainActivityViewModel::class.java]
        (viewModel as MainActivityViewModel).initiateViewModel(this as BaseActivity)
    }
}