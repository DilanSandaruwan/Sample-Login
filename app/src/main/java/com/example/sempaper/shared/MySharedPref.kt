package com.example.sempaper.shared

import android.content.Context
import android.content.SharedPreferences

class MySharedPref(context:Context) {
    private val PREF_CREDENTIALS = "MySharedPref"
    private val KEY_USER = "user"
    private val sharedPref: SharedPreferences = context.getSharedPreferences(PREF_CREDENTIALS, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPref.edit()


    fun getUsername() : String? = sharedPref.getString(KEY_USER, "admin")
    fun saveUsername(username: String) {
        editor.putString(KEY_USER, username).commit()
    }

    fun getPassword():String?=sharedPref.getString(KEY_USER,"password")
    fun savePassword(password:String){
        editor.putString(KEY_USER, password).commit()
    }
}