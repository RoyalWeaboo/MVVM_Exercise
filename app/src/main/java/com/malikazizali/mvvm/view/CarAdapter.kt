package com.malikazizali.mvvm.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.malikazizali.mvvm.databinding.ItemCarBinding
import com.malikazizali.mvvm.model.CarDataItem

class CarAdapter (var listCar : List<CarDataItem>): RecyclerView.Adapter<CarAdapter.ViewHolder>(){
    class ViewHolder(var binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val id = listCar[position].id.toString()
        val nama = listCar[position].name
        val cat = listCar[position].category
        val price = listCar[position].price.toString()
        val img = listCar[position].image

        holder.binding.tvIdCar.text = id
        holder.binding.tvNameUser.text = nama
        holder.binding.tvCategory.text = cat
        holder.binding.tvPrice.text = "Rp."+ price
        Glide.with(holder.itemView).load(img).into(holder.binding.carImage)

//        holder.binding.carCard.setOnClickListener {
//            val i = Intent(holder.itemView.context, DetailActivity::class.java)
//            i.putExtra("id", id)
//            i.putExtra("nama", nama)
//            i.putExtra("cat", cat)
//            i.putExtra("price", price)
//            i.putExtra("img", img)
//            holder.itemView.context.startActivity(i)
//        }

    }

    override fun getItemCount(): Int {
        return listCar.size
    }
}