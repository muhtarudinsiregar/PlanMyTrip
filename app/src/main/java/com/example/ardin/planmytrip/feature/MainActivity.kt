package com.example.ardin.planmytrip.feature

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.ardin.planmytrip.R
import com.example.ardin.planmytrip.db.UserDbHelper
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

            val loginSuccess = userDbHelper.login(name, password)

            if (loginSuccess) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Username/Password anda salah", Toast.LENGTH_LONG)
                        .show()
                textPassword.setText("")
                textUsername.setText("")
            }
        }
    }
}
