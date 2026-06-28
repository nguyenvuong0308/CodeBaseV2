package com.core.rate

data class RateConfig(
    /**
     * Vị trí dialog rate
     * true  -> căn giữa
     * false -> căn dưới
     */
    var isRateGravityBottom: Boolean = false,

    /**
     * Vị trí dialog thank
     * true  -> căn dưới
     * false -> căn giữa
     */
    var isThankForFeedbackGravityBottom: Boolean = true,

    /**
     * Ẩn navigation bar
     * true -> Ẩn
     * false -> hiển thị
     */
    var isHideNavigationBar: Boolean = false,

    /**
     * Ẩn status bar
     * true -> Ẩn
     * false -> hiển thị
     */
    var isHideStatusBar: Boolean = false,

    /**
     * Giữ kích thước status bar
     */
    var isSpaceStatusBar: Boolean = true,

    /**
     * Giữ kích thước cutout
     */
    var isSpaceDisplayCutout: Boolean = true,
    /**
     * Số sao tối thiểu để mở CH Play
     * */
    var minStarRateOK: Int = 5
)