package com.epiafric.epiarfic_mobile_app.model

data class Meta(
    val current_page: Int,
    val from: Int,
    val last_page: Int,
    val path: String,
    val per_page: String,
    val to: Int,
    val total: Int
)