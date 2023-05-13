package com.hmzeda.newsdemo.ui.main.home

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.hmzeda.newsdemo.data.NewsRepository
import com.hmzeda.newsdemo.ui.BaseActivity
import com.hmzeda.newsdemo.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class FragmentHomeViewModel @Inject constructor(private val newsRepository: NewsRepository) :
    BaseViewModel() {

    lateinit var page: MutableLiveData<Int>
    override fun initiateViewModel(activity: BaseActivity) {
        super.initiateViewModel(activity)
        page.value = 0
        getNews()
    }

    override fun onClickListner(view: View) {
        super.onClickListner(view)
    }

    fun getNews() {
        page.value = page.value?.plus(1)
        page.value?.let {
            newsRepository.getNews(it).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(Consumer {
                    if (!it.isNullOrEmpty()) {
                        // TODO: call adapter
                    }
                }).doOnError(Consumer { it.stackTrace})
                .subscribe()
        }
    }

}