package com.malikazizali.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malikazizali.mvvm.model.CarDataItem
import com.malikazizali.mvvm.network.ApiClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarViewModel : ViewModel() {

    var liveCarData: MutableLiveData<List<CarDataItem>> = MutableLiveData()

    fun getData(): MutableLiveData<List<CarDataItem>> {
        return liveCarData
    }

    fun callGet() {
        GlobalScope.async {
            ApiClient.instance.getAllCar()
                .enqueue(object : Callback<List<CarDataItem>> {
                    override fun onResponse(
                        call: Call<List<CarDataItem>>,
                        response: Response<List<CarDataItem>>
                    ) {
                        if (response.isSuccessful) {
                            liveCarData.postValue(response.body())
                        } else {
                            liveCarData.postValue(null)
                        }
                    }

                    override fun onFailure(call: Call<List<CarDataItem>>, t: Throwable) {
                        liveCarData.postValue(null)
                    }

                })
        }
    }

}