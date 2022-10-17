package com.malikazizali.mvvm.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.malikazizali.mvvm.databinding.ActivityMainBinding
import com.malikazizali.mvvm.viewmodel.CarViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var carAdapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vm = ViewModelProvider(this).get(CarViewModel::class.java)
        vm.getData().observe(this, Observer {
            if (it != null) {
                binding.rvMain.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                carAdapter = CarAdapter(it)
                binding.rvMain.adapter = carAdapter
//                carAdapter.onDelete = {
//                    vm.callDeleteCar(it.toInt())
//                    vm.deleteCarData().observe(this, Observer {
//                        if (it != null){
//                            Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show()
//                        }
//                    })
//                }
//                carAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "There is no data to show", Toast.LENGTH_LONG).show()
            }
        })
        vm.callGet()
    }
}
