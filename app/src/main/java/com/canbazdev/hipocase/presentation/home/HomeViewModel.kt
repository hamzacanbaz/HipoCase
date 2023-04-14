package com.canbazdev.hipocase.presentation.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canbazdev.hipocase.data.model.hipo.HipoResponse
import com.canbazdev.hipocase.data.model.hipo.Member
import com.canbazdev.hipocase.domain.repository.HipoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
*   Created by hamzacanbaz on 4/5/2023
*/
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val hipoRepository: HipoRepository) : ViewModel() {

    init {
        getDevelopers()
    }

    private val _developers = MutableStateFlow<ArrayList<Member>>(arrayListOf())
    val developers: StateFlow<List<Member>> = _developers

    fun getDevelopers(){
        viewModelScope.launch {
            val response = hipoRepository.getDevelopers()
//            println(response)
            _developers.update {
                response.members?.let { it1 -> ArrayList(it1) } ?: arrayListOf()
            }
        }
    }

    fun addNewMemberToDevelopers(developer:Member){
        _developers.value.add(developer)
        println(developer)
    }

}