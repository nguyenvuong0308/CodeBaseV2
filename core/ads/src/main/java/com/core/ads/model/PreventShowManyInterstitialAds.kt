package com.core.ads.model

import android.os.CountDownTimer
import com.core.config.domain.data.AdPlace
import com.core.config.domain.data.InterstitialAdPlace
import com.core.config.domain.data.InterstitialAdTypeConfig
import com.core.utilities.getCurrentTimeInSecond
import com.core.utilities.util.Timber

object PreventShowManyInterstitialAds {

    private var showInterAdLastTime = 0L

    private var showOpenAdLastTime = 0L

    private var startTimeSession = 0L

    private var adShownInSessionCount = 0

    private var countDownTimer: CountDownTimer? = null

    fun initIntervalTimeShowInterstitialMillis() {
        showInterAdLastTime = 0L
        showOpenAdLastTime = 0L
    }

    internal fun updateLastTimeShowedInterAd() {
        showInterAdLastTime = getCurrentTimeInSecond()
    }

    internal fun updateLastTimeShowedAppOpenAd() {
        showOpenAdLastTime = getCurrentTimeInSecond()
    }

    internal fun getLastTimeShowedInterAd() = showInterAdLastTime

    internal fun getLastTimeShowedAppOpenAd() = showOpenAdLastTime

    internal fun increaseNumberOfShowingInterAdInSession() {
        adShownInSessionCount++
    }

    internal fun startCountDownTimerIfNeed(timePerSession: Long) {
        if (startTimeSession != 0L) {
            return
        }
        startTimeSession = getCurrentTimeInSecond()
        if (countDownTimer != null) {
            countDownTimer?.cancel()
            countDownTimer = null
        }
        countDownTimer = object : CountDownTimer(timePerSession * 1000L, 1000) {
            override fun onTick(secondUntilFinished: Long) {}

            override fun onFinish() {
                resetInterAdSession()
            }
        }
        countDownTimer?.start()
    }

    internal fun isNotValidTimeToShow(interstitialAdConfig: InterstitialAdTypeConfig, adPlace: AdPlace): Boolean {
        return isNotValidIntervalTimeShowAds(interstitialAdConfig, adPlace) || isNotValidSessionTimeShowAds(interstitialAdConfig)
    }

    private fun isNotValidIntervalTimeShowAds(interstitialAdConfig: InterstitialAdTypeConfig, adPlace: AdPlace): Boolean {
        val timeInterActive = getCurrentTimeInSecond() - showInterAdLastTime
        val timeOpenAdActive = getCurrentTimeInSecond() - showOpenAdLastTime
        val plusInterval = (adPlace as? InterstitialAdPlace)?.plusInterval ?: 0
        Timber.d("timeInterActive $timeInterActive timeOpenAdActive $timeOpenAdActive plusInterval $plusInterval")
        return if (showOpenAdLastTime > showInterAdLastTime) {
            timeOpenAdActive < interstitialAdConfig.timeIntervalAfterShowOpenAd
        } else {
            timeInterActive < interstitialAdConfig.timeInterval + plusInterval
        }
    }

    private fun isNotValidSessionTimeShowAds(interstitialAdConfig: InterstitialAdTypeConfig): Boolean {
        return adShownInSessionCount >= interstitialAdConfig.adsPerSession
    }

    private fun resetInterAdSession() {
        startTimeSession = 0L
        adShownInSessionCount = 0
    }

}