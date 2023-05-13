package com.hmzeda.newsdemo.ui.main

import android.view.View
import com.hmzeda.newsdemo.ui.BaseActivity
import com.hmzeda.newsdemo.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MainActivityViewModel: BaseViewModel() {

    override fun initiateViewModel(activity: BaseActivity) {
        super.initiateViewModel(activity)
    }

    override fun onClickListner(view: View) {
        super.onClickListner(view)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}