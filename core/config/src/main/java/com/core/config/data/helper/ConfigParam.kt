package com.core.config.data.helper

import com.core.config.data.model.AdPlaceModel
import com.core.config.data.model.AppConfigModel
import com.core.config.data.model.AppOpenAdConfigModel
import com.core.config.data.model.BannerAdConfigModel
import com.core.config.data.model.IapConfigModel
import com.core.config.data.model.InterstitialAdConfigModel
import com.core.config.data.model.NativeAdConfigModel
import com.core.config.data.model.RewardedAdConfigModel
import com.core.config.data.model.RewardedInterstitialAdConfigModel
import com.core.config.data.model.PreventAdClickConfigModel
import com.core.config.data.model.RequestConsentConfigModel
import com.core.config.data.model.SplashScreenConfigModel

internal sealed class ConfigParam<T : Any> {
    abstract val key: String

    companion object {
        const val DEFAULT_OPEN_APP_AD_TIME_MILLIS_DELAY_BEFORE_SHOW = 200L
        const val DEFAULT_OPEN_APP_AD_TIME_INTERVAL = 3600L

        const val INTERSTITIAL_AD_CONFIG_DEFAULT_ADS_PER_SESSION = 50
        const val INTERSTITIAL_AD_CONFIG_DEFAULT_TIME_PER_SESSION = 600L
        const val INTERSTITIAL_AD_CONFIG_DEFAULT_TIME_INTERVAL = 37L
        const val REOPEN_TO_INTERSTITIAL_AD_CONFIG_DEFAULT_TIME_INTERVAL = 30L

        const val PREVENT_AD_CLICK_CONFIG_DEFAULT_MAX_AD_CLICK_PER_SESSION = 6
        const val PREVENT_AD_CLICK_CONFIG_DEFAULT_TIME_PER_SESSION = 120L
        const val PREVENT_AD_CLICK_CONFIG_DEFAULT_TIME_DISABLE = 1800L

        const val SPLASH_SCREEN_CONFIG_DEFAULT_MAX_TIME_TO_WAIT_APP_OPEN_AD = 30L
        const val SPLASH_SCREEN_CONFIG_DEFAULT_TIME_SKIP_APP_OPEN_AD_WHEN_NOT_AVAILABLE = 5L
        const val SPLASH_SCREEN_CONFIG_DEFAULT_MIN_TIME_WAIT_PROGRESS_BEFORE_SHOW_AD = 5L
        const val SPLASH_SCREEN_CONFIG_DEFAULT_ENABLE_RETRY = true
        const val SPLASH_SCREEN_CONFIG_DEFAULT_MAX_RETRY_COUNT = 10
        const val SPLASH_SCREEN_CONFIG_DEFAULT_RETRY_FIXED_DELAY = 1000L
        const val SPLASH_SCREEN_CONFIG_DEFAULT_IS_LOAD_BEFORE_CONSENT = true

        const val RETRY_IS_ENABLE_RETRY = false
        const val RETRY_MAX_RETRY_COUNT = 5
        const val EXPIRED_NATIVE_TIME_DEFAULT = 60
        val RETRY_INTERVAL_LIST = listOf(3L, 6L, 9L, 12L, 15L)

        const val TIME_WAIT_RETRY_ON_CONTEXT = 5
        const val MAX_RETRY_ON_CONTEXT = 2
    }

    internal object AppSettings : ConfigParam<AppConfigModel>() {

        override val key = "app_config"

    }

    internal object PurchaseConfig : ConfigParam<IapConfigModel>() {

        override val key = "purchase_config"

    }

    internal object AdClickGuardConfig : ConfigParam<PreventAdClickConfigModel>() {

        override val key = "ad_click_guard_config"

    }

    internal object DisabledAdCountries : ConfigParam<String>() {

        override val key = "ad_disabled_countries"

    }

    internal object TestAdDetectedDisabledPlacements : ConfigParam<String>() {

        override val key = "test_ad_detected_disabled_placements"

    }

    internal object TestAdDetectionPlacementFilterEnabled : ConfigParam<Boolean>() {

        override val key = "is_test_ad_detection_placement_filter_enabled"

    }

    internal object SplashAdConfig : ConfigParam<SplashScreenConfigModel>() {

        override val key = "splash_ad_config"

    }

    internal object VersionedAdPlacementConfig : ConfigParam<com.core.config.data.model.AdPlacesVersionConfigModel>() {

        override val key = "versioned_ad_placement_config"

    }

    internal object BannerNativeAdPlacements : ConfigParam<AdPlaceModel>() {

        override val key = "banner_native_ad_placements"

    }

    internal object BannerNativeAdPlacementOverride : ConfigParam<AdPlaceModel>() {

        override val key = "banner_native_ad_placement_override"

    }

    internal object AppOpenAdPlacements : ConfigParam<AdPlaceModel>() {

        override val key = "app_open_ad_placements"

    }

    internal object AppOpenAdPlacementOverride : ConfigParam<AdPlaceModel>() {

        override val key = "app_open_ad_placement_override"

    }

    internal object FullscreenAdPlacements : ConfigParam<AdPlaceModel>() {

        override val key = "fullscreen_ad_placements"

    }

    internal object FullscreenAdPlacementOverride : ConfigParam<AdPlaceModel>() {

        override val key = "fullscreen_ad_placement_override"

    }

    internal object BannerAdSettings : ConfigParam<BannerAdConfigModel>() {

        override val key = "banner_ad_settings"

    }

    internal object NativeAdSettings : ConfigParam<NativeAdConfigModel>() {

        override val key = "native_ad_settings"

    }

    internal object InterstitialAdSettings : ConfigParam<InterstitialAdConfigModel>() {

        override val key = "interstitial_ad_settings"

    }

    internal object RewardedInterstitialAdSettings : ConfigParam<RewardedInterstitialAdConfigModel>() {

        override val key = "rewarded_interstitial_ad_settings"

    }

    internal object RewardedAdSettings : ConfigParam<RewardedAdConfigModel>() {

        override val key = "rewarded_ad_settings"

    }

    internal object AppOpenAdSettings : ConfigParam<AppOpenAdConfigModel>() {

        override val key = "app_open_ad_settings"

    }

    internal object ConsentRequestConfig : ConfigParam<RequestConsentConfigModel>() {

        override val key = "consent_request_config"

    }
}
