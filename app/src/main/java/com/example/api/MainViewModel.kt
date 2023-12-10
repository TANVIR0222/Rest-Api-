package com.example.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.Datas.Product
import com.example.api.Datas.ResponseProduct
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _allProductResponse = MutableLiveData<ResponseProduct>()
    val allProductResponse: LiveData<ResponseProduct> = _allProductResponse

    fun getAllProduct() {
        viewModelScope.launch {

            val data = RetrofitClient.getApiDao().getAllProduct().body()
            _allProductResponse.postValue(data)
        }
    }

    // one product

    private val _productResponse = MutableLiveData<Product>()
    val productResponse: LiveData<Product> = _productResponse


    fun getProductById(pid: Int) {
        viewModelScope.launch {

            val data = RetrofitClient.getApiDao().getProductById(pid).body()
            _productResponse.postValue(data)
        }
    }


}