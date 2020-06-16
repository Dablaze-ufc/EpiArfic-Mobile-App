package com.epiafric.epiarfic_mobile_app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recent_entries")
data class Data(
        val are_there_anymore_bottle_necks_within_your_organisationprocess: String?,
        val brief_description_of_innovation: String?,
        val category_of_innovation: String?,
        val date_created: String?,
        val date_of_entry: String?,
        val email: String?,
        val general_comments: String?,
        @PrimaryKey
        val id: Int,
        val if_yes_enter_country: String?,
        val is_the_innovation_specific_to_a_particular_country: String?,
        val is_your_organisationprocess_specific_to_a_particular_country: String?,
        val kindly_select_a_category: String?,
        val location_country: String?,
        val name: String?,
        val next_steps_support_needed_if_any: String?,
        val open_source_url: String?,
        val phone_number_please_include_country_code: String?,
        val stage_of_innovation: String?,
        val url_link: String?,
        val url_link_to_the_platform: String?,
        val website: String?,
        val what_category_do_you_fall_into: String?,
        val what_did_it_cost_you: String?,
        val what_existing_platform_did_you_leverage_on_and_how: String?,
        val what_problem_were_you_looking_to_solve: String?
)