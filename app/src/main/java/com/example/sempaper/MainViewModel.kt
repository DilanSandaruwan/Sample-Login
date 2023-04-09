package com.example.sempaper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    private val _user = MutableLiveData<String>("")
    val user: LiveData<String>
        get() = _user

    private val _psw = MutableLiveData<String>("")
    val psw: LiveData<String>
        get() = _psw

    private val _text = MutableLiveData<String>().apply {
        value = "This is Home Fragment"
    }
    val text: LiveData<String> = _text

    fun setLiveUsername(user:String) {
        _user.value = user
    }
}