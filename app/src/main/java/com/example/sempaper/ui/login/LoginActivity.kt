package com.example.sempaper.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sempaper.MainActivity
import com.example.sempaper.R
import com.example.sempaper.databinding.ActivityLoginBinding
import com.example.sempaper.shared.MySharedPref

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.vm = viewModel
        binding.lifecycleOwner = this

        binding.btnLogin.setOnClickListener {
            if (validateCredentials()) {
                MySharedPref(this).saveUsername(viewModel.username)
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this@LoginActivity, "Invalid Credentials!", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun validateCredentials(): Boolean {
        val username = viewModel.username
        val password = viewModel.password

        return if (username.isNullOrEmpty()) {
            false
        } else if (password.isNullOrEmpty()) {
            false
        } else {
            val userSaved = MySharedPref(this).getUsername()
            username == userSaved && password == "password"
        }
    }
}