package com.hmzeda.newsdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hmzeda.newsdemo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    lateinit var viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(R.id.fragment) as BaseFragment).onBackPressed()
        viewModel.onBackPressed()
    }
}