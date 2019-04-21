package com.mkeeda.runchdomain.entity

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class Restaurant(
    val id: String,
    val update_date: Date,
    val name: String,
    val name_kana: String,
    val latitude: Double,
    val longitude: Double,
    val category: String,
    val url: String,
    val url_mobile: String,
    val coupon_url: CouponUrl,
    val image_url: ImageUrl,
    val address: String,
    val tel: String,
    val tel_sub: String,
    val fax: String,
    val opentime: String,
    val holiday: String,
    val access: Access,
    val parking_lots: String,
    val pr: Pr,
    val code: Code,
    val budget: String,
    val party: String,
    val lunch: String,
    val credit_card: String,
    val e_money: String,
    val flags: Flags
)

@JsonClass(generateAdapter = true)
data class CouponUrl(
    val pc: String,
    val mobile: String
)

@JsonClass(generateAdapter = true)
data class ImageUrl(
    val shop_image1: String,
    val shop_image2: String,
    val qrcode: String
)

@JsonClass(generateAdapter = true)
data class Access(
    val line: String,
    val station: String,
    val station_exit: String,
    val walk: String,
    val note: String
)

@JsonClass(generateAdapter = true)
data class Pr(
    val pr_short: String,
    val pr_long: String
)

@JsonClass(generateAdapter = true)
data class Code(
    val areacode: String,
    val areaname: String,
    val prefcode: String,
    val prefname: String,
    val areacode_s: String,
    val areaname_s: String,
    val category_code_l: List<String>,
    val category_name_l: List<String>,
    val category_code_s: List<String>,
    val category_name_s: List<String>
)

@JsonClass(generateAdapter = true)
data class Flags(
    val mobile_site: String,
    val mobile_coupon: String,
    val pc_coupon: String
)
