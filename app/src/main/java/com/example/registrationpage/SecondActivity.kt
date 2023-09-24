package com.example.registrationpage

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import com.example.registrationpage.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            val username = intent.getStringExtra(MainActivity.EXTRA_USERNAME)?: ""
            val email = intent.getStringExtra(MainActivity.EXTRA_EMAIL)?: ""
            val phone = intent.getStringExtra(MainActivity.EXTRA_PHONE)?: ""

            val usernameSpan = SpannableString(username)
            usernameSpan.setSpan(
                ForegroundColorSpan(Color.BLUE),
                0,
                username.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            val emailSpan = SpannableString(email)
            emailSpan.setSpan(
                ForegroundColorSpan(Color.BLUE),
                0,
                email.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            val phoneSpan = SpannableString(phone)
            phoneSpan.setSpan(
                ForegroundColorSpan(Color.BLUE),
                0,
                phone.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            with(binding) {
                firstRow.text = SpannableStringBuilder().append("Welcome ").append(usernameSpan)
                secondRow.text = SpannableStringBuilder().append("Your email ").append(emailSpan).append(" has been activated")
                thirdRow.text = SpannableStringBuilder().append("Your phone ").append(phoneSpan).append(" has been registered")

                logoutBtn.setOnClickListener {
                    val intentToMainActivity = Intent(this@SecondActivity, MainActivity::class.java)
                    startActivity(intentToMainActivity)
                }
            }
        }
    }
}