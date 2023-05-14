package com.hmzeda.newsdemo.ui.main.detailNews

import android.content.Intent
import android.view.View
import androidx.core.util.Pair
import androidx.lifecycle.MutableLiveData
import com.hmzeda.newsdemo.module.cookies.Cookies
import com.hmzeda.newsdemo.module.news.NewsObject
import com.hmzeda.newsdemo.ui.BaseActivity
import com.hmzeda.newsdemo.ui.BaseViewModel
import com.hmzeda.newsdemo.ui.main.MainActivity
import com.hmzeda.newsdemo.util.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentDetailNewsViewModel @Inject constructor() :
    BaseViewModel() {

    @Inject
    lateinit var cookies: Cookies
    public lateinit var title:MutableLiveData<String>
    public lateinit var date:MutableLiveData<String>
    public lateinit var content:MutableLiveData<String>

   fun initiateViewModel(activity: BaseActivity,newsobject: NewsObject) {
        super.initiateViewModel(activity)
//       isDetailDisplayed?.postValue(true)
       title=MutableLiveData(newsobject.newsInfoMoreInfo.title)
        date=MutableLiveData(Utils.convertDateToWithoutNameOfMonth(newsobject.date))
        content=MutableLiveData(newsobject.description.rendered)

    }

    override fun onClickListner(view: View) {
        super.onClickListner(view)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        intentClass?.postValue(Pair(Intent(), MainActivity::class.java))
    }

}