package com.core.ads

interface AdsSdkInitializer {
    fun onUpdateGdprConsent(consentGranted: Boolean?)

    fun onAdInitCompleted()
}