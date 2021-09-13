package com.perlovka.shoeStore.screens.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.perlovka.shoeStore.models.Shoes

class ShoeListModelView : ViewModel(){
    // list of shoes
    private val shoes = mutableListOf<Shoes>()

    // LiveData to hold the information related to all the shoes
    private val _shoeList = MutableLiveData<List<Shoes>>()
    val shoeList: LiveData<List<Shoes>>
        get() = _shoeList


}