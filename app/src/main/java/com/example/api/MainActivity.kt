package com.example.api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import androidx.activity.viewModels
import com.example.api.Adapter.IStockAdapter
import com.example.api.Datas.ResponseProduct
import com.example.api.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel : MainViewModel by viewModels()
    private lateinit var iStoreProductAdapter: IStockAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.getAllProduct()

        viewModel.allProductResponse.observe(this){  respoce->

//            Log.d("TAG", "onCreate: ${respoce.products}")

            iStoreProductAdapter = IStockAdapter(respoce.products){

                val intent = Intent(this@MainActivity , DetailActivity::class.java)

                intent.putExtra(DetailActivity.Key,it)

                startActivity(intent)

            }
            binding.ApiRcv.adapter = iStoreProductAdapter

        }

    }
}