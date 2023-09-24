package com.example.registrationpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrationpage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            regButton.setOnClickListener {
                if (username.text.toString().isEmpty()) {
                    username.error = "Mohon masukkan username"
                    return@setOnClickListener
                }
                if (email.text.toString().isEmpty()) {
                    email.error = "Mohon masukkan email"
                    return@setOnClickListener
                }
                if (phone.text.toString().isEmpty()) {
                    phone.error = "Mohon masukkan nomor"
                    return@setOnClickListener
                }
                if (password.text.toString().isEmpty()) {
                    password.error = "Mohon masukkan password"
                    return@setOnClickListener
                }

                val intentToHomepage = Intent(this@MainActivity, SecondActivity::class.java)
                intentToHomepage.putExtra(EXTRA_USERNAME, username.text.toString())
                intentToHomepage.putExtra(EXTRA_EMAIL, email.text.toString())
                intentToHomepage.putExtra(EXTRA_PHONE, phone.text.toString())
                startActivity(intentToHomepage)
            }
        }
    }
}