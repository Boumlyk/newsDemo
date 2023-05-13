package com.hmzeda.newsdemo.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class Utils {
    companion object{

        fun convertDate(dateString: String): String {
            val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
            val outputFormatter = DateTimeFormatter.ofPattern("yyyy MMMM dd", Locale("ar"))
            val dateTime = LocalDateTime.parse(dateString, inputFormatter)
            return outputFormatter.format(dateTime)
        }
    }
}