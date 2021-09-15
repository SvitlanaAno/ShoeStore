package com.perlovka.shoeStore.screens.shoeList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.perlovka.shoeStore.models.Shoes

class SharedViewModel : ViewModel(){

    // List of shoes
    private var shoesItemList = mutableListOf<Shoes>()

    private val _shoesList = MutableLiveData<List<Shoes>>()
    val shoesList: LiveData<List<Shoes>>
    get() = _shoesList


     // Add a new shoe to the shoe list
    fun add(shoe: Shoes?) {
        if (shoe != null) {
            shoesItemList.add(shoe)
            _shoesList.value = shoesItemList
        }
    }

    //  Callback before ViewModel is destroyed
    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel","ViewModel Lifecycle Destroyed!")
    }

}