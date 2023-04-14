package com.canbazdev.hipocase.data.remote

import com.canbazdev.hipocase.data.model.hipo.HipoResponse
import com.canbazdev.hipocase.util.serviceUrl
import retrofit2.http.GET
import retrofit2.http.Headers

/*
*   Created by hamzacanbaz on 4/5/2023
*/
interface HipoService {

    @GET(serviceUrl)
    suspend fun getCharacters(): HipoResponse

}