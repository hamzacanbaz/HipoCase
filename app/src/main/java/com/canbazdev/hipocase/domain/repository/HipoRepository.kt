package com.canbazdev.hipocase.domain.repository

import com.canbazdev.hipocase.data.model.hipo.HipoResponse

/*
*   Created by hamzacanbaz on 4/5/2023
*/
interface HipoRepository {

    suspend fun getDevelopers(): HipoResponse

}