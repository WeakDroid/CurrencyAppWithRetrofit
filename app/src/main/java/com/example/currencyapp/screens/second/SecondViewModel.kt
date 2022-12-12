package com.example.currencyapp.screens.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyapp.data.repository.Repository
import com.example.currencyapp.model.beznal.Beznal
import kotlinx.coroutines.launch
import retrofit2.Response

class SecondViewModel: ViewModel() {

    private var repo = Repository()
    val myMoneyList: MutableLiveData<Response<Beznal>> = MutableLiveData()

    fun getBeznalMoney() {
        viewModelScope.launch {

            myMoneyList.value = repo.getBeznal()
        }
    }
}