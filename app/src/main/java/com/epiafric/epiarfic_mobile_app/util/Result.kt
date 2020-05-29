package com.epiafric.epiarfic_mobile_app.util

/**
 * Created by ChukwuwaUchhenna
 */

class Result<out T>(
    val status: State,
    val message: String? = null,
    val data: T? = null,
    val error: Throwable? = null,
    val isRefreshing: Boolean? = null
)