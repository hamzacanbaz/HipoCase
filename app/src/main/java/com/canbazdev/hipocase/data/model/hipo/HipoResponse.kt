package com.canbazdev.hipocase.data.model.hipo

data class HipoResponse(
    val company: String? = null,
    var members: List<Member>? = null,
    val team: String? = null
)