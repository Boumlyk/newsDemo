package com.hmzeda.newsdemo.ui

import android.content.Intent
import android.view.View
import androidx.core.util.Pair
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hmzeda.newsdemo.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(): ViewModel() {
    var fragment: MutableLiveData<Fragment>? = null
    var intentClass: MutableLiveData<Pair<Intent, Class<*>>>? = null
    var actions: MutableLiveData<List<String>>? = null


    open fun initiateViewModel(activity: BaseActivity){
        // here where should initiate a variable
        fragment = MutableLiveData()
        intentClass = MutableLiveData()
        actions=MutableLiveData()

        intentClass!!.observe(activity) { value ->
            activity.startActivity(value.first.setClass(activity, value.second))
        }

        fragment!!.observe(activity) { fragment: Fragment ->
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, fragment, fragment.tag)
                .addToBackStack(null)
                .commit()
        }
    }

    open fun onBackPressed(){
    }

    open fun onClickListner(view: View){
    }

}