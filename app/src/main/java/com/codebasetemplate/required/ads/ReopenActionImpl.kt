package com.codebasetemplate.required.ads

import android.app.Activity
import android.util.Log
import com.codebasetemplate.BuildConfig
import com.core.ads.admob.ReopenAction
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "ReopenActionImpl"
@Singleton
class ReopenActionImpl @Inject constructor(): ReopenAction {
    override fun reopenAction(activity: Activity) {
        if (activity.isFinishing || activity.isDestroyed) return
//        if (activity is TargetActivity) return
//
//        activity.startActivity(Intent(activity, TargetActivity::class.java))

    }

    override fun isCustomAction(): Boolean {
        return if(BuildConfig.DEBUG) true else false
    }
}