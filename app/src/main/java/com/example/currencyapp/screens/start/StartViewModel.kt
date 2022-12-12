package com.example.currencyapp.screens.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyapp.data.repository.Repository
import com.example.currencyapp.model.nal.Nalichka
import kotlinx.coroutines.launch
import retrofit2.Response

class StartViewModel : ViewModel() {


    private var repo = Repository()
    val myMoneyList: MutableLiveData<Response<Nalichka>> = MutableLiveData()

    fun getNalMoney() {
        viewModelScope.launch {

            myMoneyList.value = repo.getNal()
        }
    }

}