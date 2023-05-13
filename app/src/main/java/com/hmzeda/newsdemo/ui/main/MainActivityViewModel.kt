package com.hmzeda.newsdemo.ui.main

import android.view.View
import com.hmzeda.newsdemo.ui.BaseActivity
import com.hmzeda.newsdemo.ui.BaseViewModel
import com.hmzeda.newsdemo.ui.main.home.FragmentHome
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(): BaseViewModel() {

    override fun initiateViewModel(activity: BaseActivity) {
        super.initiateViewModel(activity)
        fragment?.postValue(FragmentHome())
    }

    override fun onClickListner(view: View) {
        super.onClickListner(view)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}