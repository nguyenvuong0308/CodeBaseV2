package com.core.ads.customviews.ads

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.graphics.toColorInt
import com.core.ads.extensions.updateBackgroundColor
import com.google.android.gms.ads.nativead.NativeAd

abstract class BaseNativeTemplateView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var onClose: (() -> Unit) ?= null
    abstract fun destroyNativeAd()

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
//        try {
//            removeAllViews()
//            destroyNativeAd()
//        } catch (e: Exception) {
//            Log.e("BaseNativeTemplateView", "onDetachedFromWindow : $e")
//        }

    }

    abstract fun setNativeAd(nativeAd: NativeAd)

    /**
     * To prevent memory leaks, make sure to destroy your ad when you don't need it anymore. This
     * method does not destroy the template view.
     * https://developers.google.com/admob/android/native-unified#destroy_ad
     */
    fun applyStyles(styles: NativeTemplateStyle) {
        applyTemplateStyles(styles)
    }

    protected abstract fun applyTemplateStyles(styles: NativeTemplateStyle)

    open fun onHostPause() = Unit

    open fun onHostResume() = Unit

    fun adHasOnlyStore(nativeAd: NativeAd): Boolean {
        val store = nativeAd.store
        val advertiser = nativeAd.advertiser
        return !TextUtils.isEmpty(store) && TextUtils.isEmpty(advertiser)
    }

    protected fun applyAdNotificationStyles(
        styles: NativeTemplateStyle,
        vararg adNotificationViews: TextView
    ) {
        styles.adNotificationBackgroundColor?.let { color ->
            adNotificationViews.forEach { it.updateBackgroundColor(color) }
        }

        styles.adNotificationTextColor?.let { color ->
            runCatching { color.toColorInt() }.getOrNull()?.let { colorInt ->
                adNotificationViews.forEach { it.setTextColor(colorInt) }
            }
        }
    }
}
