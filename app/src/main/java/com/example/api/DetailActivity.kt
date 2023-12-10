package com.example.api

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import coil.load
import com.example.api.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{

        const val Key = "DetailActivity"

    }

    private val viewModel : MainViewModel by viewModels()

    private lateinit var binding:ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pid = intent .getIntExtra(Key , 0)
        if (pid != 0){
            getProductById(pid)
        }
        setProductObserver()

    }


    @SuppressLint("SetTextI18n")
    private fun setProductObserver() {
        viewModel.productResponse.observe(this){ product ->

            binding.apply {
                Brand.text = product.brand
                off.text   = "OFF   :${product.discountPercentage} %"
                price.text = "Price :$${product.price} "
                stock.text = "Stock :${product.stock}"
                name.text  = product.title
                imageView.load(product.thumbnail)

            }



        }
    }


    private fun getProductById(pid: Int) {

        viewModel.getProductById(pid)

    }

}