package com.hmzeda.newsdemo.ui.util

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager.BadTokenException
import com.hmzeda.newsdemo.R

class Utils {
    companion object{

        fun createProgressDialog(context: Context?): ProgressDialog? {
            return try {
                val dialog = ProgressDialog(context)
                dialog.show()
                dialog.setCancelable(false)
                dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                dialog.setContentView(R.layout.dialog_white_progress_bar)
                dialog
            } catch (ignored: BadTokenException) {
                null
            }
        }
    }
}