package com.mkeeda.runchdomain.entity

import java.util.Date

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
    val parking_lots: Int,
    val pr: Pr,
    val code: Code,
    val budget: Int,
    val party: Int,
    val lunch: Int,
    val credit_card: String,
    val e_money: String,
    val flags: Flags
)

data class CouponUrl(
    val pc: String,
    val mobile: String
)

data class ImageUrl(
    val shop_image1: String,
    val shop_image2: String,
    val qrcode: String
)

data class Access(
    val line: String,
    val station: String,
    val station_exit: String,
    val walk: Int,
    val note: String
)

data class Pr(
    val pr_short: String,
    val pr_long: String
)

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

data class Flags(
    val mobile_site: Int,
    val mobile_coupon: Int,
    val pc_coupon: Int
)
