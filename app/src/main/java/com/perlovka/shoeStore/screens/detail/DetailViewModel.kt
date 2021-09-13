package com.perlovka.shoeStore.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel: ViewModel(){
    // entered label
    private val _label = MutableLiveData<String>()
    val label : LiveData<String>
        get() = _label

    // entered company
    private val _company= MutableLiveData<String>()
    val company : LiveData<String>
        get() = _company

    // Entered size
    private val _size = MutableLiveData<Int>()
    val size : LiveData<Int>
        get() = _size

    // entered description
    private val _description= MutableLiveData<String>()
    val description : LiveData<String>
        get() = _description



}