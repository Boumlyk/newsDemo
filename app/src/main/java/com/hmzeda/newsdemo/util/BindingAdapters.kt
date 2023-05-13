package com.hmzeda.newsdemo.util

import android.text.Html
import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("htmlText")
    fun TextView.htmlText(html: String?) {
        if (html != null) {
            text = Html.fromHtml(html)
        }
    }
}