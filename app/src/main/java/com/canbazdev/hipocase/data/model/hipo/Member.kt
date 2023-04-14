package com.canbazdev.hipocase.data.model.hipo

data class Member(
    val age: Int? = null,
    val github: String? = null,
    val hipo: Hipo,
    val location: String? = null,
    val name: String
)