package com.core.config.domain.data


interface IAdPlaceName {
    val name: String
}

private const val TAG = "IAdPlaceName"
sealed class CoreAdPlaceName(
    override val name: String
) : IAdPlaceName {
    // ------- Danh sách các ad place -------
    object NONE : CoreAdPlaceName("")
    object APP_REOPEN : CoreAdPlaceName("reopen_app")

    companion object {
        // Tự động lấy danh sách tất cả instance
        val ALL: List<CoreAdPlaceName> by lazy {
            CoreAdPlaceName::class.sealedSubclasses.mapNotNull { it.objectInstance }
        }

        // Hàm lấy ad theo key string
        fun fromKey(key: String): CoreAdPlaceName {
            return ALL.find { it.name == key } ?: NONE
        }
    }
}