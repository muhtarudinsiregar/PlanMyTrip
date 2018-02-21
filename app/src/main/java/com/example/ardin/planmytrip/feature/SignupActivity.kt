package com.example.ardin.planmytrip.feature

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.ardin.planmytrip.R
import com.example.ardin.planmytrip.db.UserDbHelper
import com.example.ardin.planmytrip.model.UserModel
import com.example.ardin.planmytrip.presenter.SignupPresenter
import kotlinx.android.synthetic.main.activity_signup.*

/**
 * Created by ardin on 21/02/18.
 */
class SignupActivity : AppCompatActivity() {
    private lateinit var userDbHelper: UserDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        userDbHelper = UserDbHelper(this)

        btnSubmitSignup.setOnClickListener {
            val age = textAge.text.toString().toInt()
            val name = textName.text.toString()
            val email = textEmail.text.toString()
            val password = textPassword.text.toString()

            val result = userDbHelper.insert(UserModel(email, password, name, age))
            Log.d("SignupActivity", email)
            Toast.makeText(this, "Ntak", Toast.LENGTH_LONG).show()
        }
    }
}