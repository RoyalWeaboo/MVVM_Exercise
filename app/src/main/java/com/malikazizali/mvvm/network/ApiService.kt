package com.malikazizali.mvvm.network

import com.malikazizali.mvvm.model.CarDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("admin/car")
    fun getAllCar() : Call<List<CarDataItem>>
}