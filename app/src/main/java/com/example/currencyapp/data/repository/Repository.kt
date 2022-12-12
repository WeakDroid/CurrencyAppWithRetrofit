package com.example.currencyapp.data.repository

import com.example.currencyapp.data.api.RetrofitInstance
import com.example.currencyapp.model.beznal.Beznal
import com.example.currencyapp.model.nal.Nalichka
import retrofit2.Response

class Repository {

    suspend fun getNal(): Response<Nalichka> {
        return RetrofitInstance.api.getNalMoneys()
    }

    suspend fun getBeznal(): Response<Beznal> {
        return RetrofitInstance.api.getBeznalMoney()
    }
}