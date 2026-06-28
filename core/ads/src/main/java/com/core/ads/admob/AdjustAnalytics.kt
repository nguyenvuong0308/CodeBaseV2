package com.core.ads.admob

interface AdjustAnalytics {
    fun trackRevenueNetwork(adUnitId: String, adValueMicros: Long, adValueCurrencyCode: String)
}