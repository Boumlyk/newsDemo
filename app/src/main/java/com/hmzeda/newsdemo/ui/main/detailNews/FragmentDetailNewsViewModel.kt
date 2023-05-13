package com.hmzeda.newsdemo.ui.main.detailNews

import NewsObject
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.util.Pair
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hmzeda.newsdemo.data.NewsRepository
import com.hmzeda.newsdemo.module.cookies.Cookies
import com.hmzeda.newsdemo.ui.BaseActivity
import com.hmzeda.newsdemo.ui.BaseViewModel
import com.hmzeda.newsdemo.ui.adapter.NewsAdapter
import com.hmzeda.newsdemo.ui.detailNews.DetaitNewsActivity
import com.hmzeda.newsdemo.ui.main.MainActivity
import com.hmzeda.newsdemo.ui.main.home.FragmentHome
import com.hmzeda.newsdemo.util.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
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
       title=MutableLiveData(newsobject.title.rendered)
        date=MutableLiveData(Utils.convertDateToWithoutNameOfMonth(newsobject.date))
        content=MutableLiveData(newsobject.content.rendered)

    }

    override fun onClickListner(view: View) {
        super.onClickListner(view)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        intentClass?.postValue(Pair(Intent(), MainActivity::class.java))
    }

}