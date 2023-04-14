package com.canbazdev.hipocase.data.repository

import com.canbazdev.hipocase.data.model.hipo.HipoResponse
import com.canbazdev.hipocase.data.remote.HipoService
import com.canbazdev.hipocase.domain.repository.HipoRepository
import javax.inject.Inject

/*
*   Created by hamzacanbaz on 4/5/2023
*/
class HipoRepositoryImpl @Inject constructor(
    private val hipoService: HipoService
) : HipoRepository {
    override suspend fun getDevelopers(): HipoResponse =
        hipoService.getCharacters()


}