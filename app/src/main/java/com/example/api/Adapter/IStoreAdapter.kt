package com.example.api.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.api.Datas.Product
import com.example.api.databinding.ItemRcvBinding

class IStockAdapter(var productList: List<Product>?, val listener: Listener) :
    RecyclerView.Adapter<IStockAdapter.ISViewHolder>() {

    class ISViewHolder(val binding: ItemRcvBinding) : RecyclerView.ViewHolder(binding.root)


    fun interface Listener {

        fun onItemClick(pid: Int)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ISViewHolder {

        return ISViewHolder(
            ItemRcvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return productList?.size ?: 0
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ISViewHolder, position: Int) {

        productList?.get(position)?.let { product ->

            holder.binding.apply {

                Brand.text = product.brand
                off.text = "OFF   :${product.discountPercentage} %"
                price.text = "Price :$${product.price} "
                stock.text = "Stock :${product.stock}"
                name.text = product.title

                imageView.load(product.thumbnail)

            }
            holder.itemView.setOnClickListener {
                listener.onItemClick(product.id)

            }

        }


    }
}