package com.hmzeda.newsdemo.ui.detailNews

import android.content.Intent
import android.view.View
import com.hmzeda.newsdemo.module.cookies.Cookies
import com.hmzeda.newsdemo.ui.BaseActivity
import com.hmzeda.newsdemo.ui.BaseViewModel
import com.hmzeda.newsdemo.ui.main.detailNews.FragmentDetailNews
import com.hmzeda.newsdemo.ui.main.home.FragmentHome
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.Serializable
import javax.inject.Inject

@HiltViewModel
class DetailNewsActivityViewModel @Inject constructor(): BaseViewModel() {

    @Inject
    lateinit var cookies:Cookies
    override fun initiateViewModel(activity: BaseActivity) {
        super.initiateViewModel(activity)
        fragment?.postValue(FragmentDetailNews(cookies.newsClicked))
    }

    override fun onClickListner(view: View) {
        super.onClickListner(view)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}