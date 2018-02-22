package com.example.ardin.planmytrip

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.ardin.planmytrip.db.UserDbHelper
import com.example.ardin.planmytrip.feature.SignupActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var userDbHelper: UserDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userDbHelper = UserDbHelper(this)

        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val name = textUsername.text.toString()
            val password = textPassword.text.toString()

            val loginCheck = userDbHelper.login(name, password)
            Log.d("MainActivity", loginCheck.toString())
        }
    }
}
