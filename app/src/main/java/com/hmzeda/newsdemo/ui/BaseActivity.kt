package com.hmzeda.newsdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hmzeda.newsdemo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    lateinit var viewModel: BaseViewModel

    companion object{
        const val ACTION_START_LOADING = "START_LOADING"
        const val ACTION_FINISH_LOADING = "FINISH_LOADING"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(R.id.fragment) as BaseFragment).onBackPressed()
        viewModel.onBackPressed()
    }
}