package com.lucasyago.gastoviagem.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasyago.gastoviagem.util.format

class MainViewModel : ViewModel() {

    val autonomy = MutableLiveData<String>()
    val price = MutableLiveData<String>()
    val distance = MutableLiveData<String>()
    val totalValue = MutableLiveData<String>()

    init {
        autonomy.value = ""
        price.value = ""
        distance.value = ""
        totalValue.value = ""
    }

    fun calculate(){
        if(distance.value.isNullOrEmpty() ||
            price.value.isNullOrEmpty() ||
            autonomy.value.isNullOrEmpty())
            return

        val vDistance = distance.value!!.toDouble()
        val vPrice = price.value!!.toDouble()
        val vAutonomy = autonomy.value!!.toDouble()

        val vProduct = vDistance.times(vPrice)
        totalValue.value = vProduct.div(vAutonomy).format(2)
    }

    // Support operators
    operator fun times(other: Double): Double {
        return this * other
    }

    operator fun div(other: Double): Double {
        return this / other
    }

}

