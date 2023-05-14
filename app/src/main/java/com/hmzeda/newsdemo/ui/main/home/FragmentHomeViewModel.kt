package com.hmzeda.newsdemo.ui.main.home

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.core.util.Pair
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.hmzeda.newsdemo.data.NewsRepository
import com.hmzeda.newsdemo.module.cookies.Cookies
import com.hmzeda.newsdemo.module.news.NewsObject
import com.hmzeda.newsdemo.ui.BaseActivity
import com.hmzeda.newsdemo.ui.BaseViewModel
import com.hmzeda.newsdemo.ui.adapter.NewsAdapter
import com.hmzeda.newsdemo.ui.detailNews.DetaitNewsActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class FragmentHomeViewModel @Inject constructor(private val newsRepository: NewsRepository) :
    BaseViewModel() {

    private var newsAdapter: NewsAdapter?=null
    lateinit var activity: Activity
    @Inject
    lateinit var cookies: Cookies

    lateinit var page: MutableLiveData<Int>
    fun initiateViewModel(activity: BaseActivity,recyclerView: RecyclerView) {
        super.initiateViewModel(activity)
        this.activity=activity
//        isDetailDisplayed?.postValue(false)
        page= MutableLiveData(0)
        getNews()

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(!recyclerView.canScrollVertically(1)){
                    getNews()
                }
            }
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(newState==RecyclerView.SCROLL_INDICATOR_BOTTOM){
//                    getNews()
                }
            }
        })
    }

    override fun onClickListner(view: View) {
        super.onClickListner(view)
    }

    fun getNews() {
        actions?.postValue(listOf(BaseActivity.ACTION_START_LOADING))
        page.value = page.value?.plus(1)
        page.value?.let {p->
            newsRepository.getNews(p).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(Consumer { list ->
                    if (!list.isNullOrEmpty()) {
                        Log.e("TAG", "getNews: "+ list.get(0).newsInfoMoreInfo.title)
                        if (page.value!=1){
                            list.forEach {
                                insertInLocalDb(it)
                                newsAdapter?.addToList(it, newsAdapter!!.getList().size) }
                        }else{
                            newsAdapter?.feedList(list)
                            insertInLocalDb(list)
                        }
                    }
                }).doOnError(Consumer { it.stackTrace})
                .doFinally(Action { actions?.postValue(listOf(BaseActivity.ACTION_FINISH_LOADING)) })
                .subscribe()
        }
    }

    fun getAdapter(context: Context):NewsAdapter {
        if (newsAdapter==null){
            newsAdapter= NewsAdapter(context,this)
        }
        return newsAdapter as NewsAdapter
    }

    fun insertInLocalDb(news: NewsObject) {
        newsRepository.insertNewsInRoom(news).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess(Consumer {
                Log.e("TAG", "insertInLocalDb: "+ it )
            })
            .subscribe()

    }

    fun insertInLocalDb(news: List<NewsObject>) {
        news.forEach { insertInLocalDb(it) }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        activity.finishAffinity()
    }

    fun onItemClicked(news: NewsObject) {
        cookies.newsClicked=news
        intentClass?.postValue(Pair(Intent(),DetaitNewsActivity::class.java))
    }

}