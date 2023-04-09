package com.example.sempaper.ui.login

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    @get:Bindable
    var username: String = ""

    @get:Bindable
    var password: String = ""

}