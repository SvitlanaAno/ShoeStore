package com.perlovka.shoeStore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel (){

    // email
    private val _email= MutableLiveData<String>()
    val email : LiveData<String>
        get() = _email

    // password
    private val _password= MutableLiveData<String>()
    val password : LiveData<String>
        get() = _password

    /** Methods for buttons presses **/
    fun saveCredentials(){

    }
}