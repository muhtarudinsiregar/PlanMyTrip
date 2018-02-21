package com.example.ardin.planmytrip.db

import android.provider.BaseColumns


/**
 * Created by ardin on 21/02/18.
 */
object DBContract{
    class UserCreate : BaseColumns {
        companion object {
            val TABLE_NAME = "users"
            val COLUMN_USER_ID = "userid"
            val COLUMN_NAME = "name"
            val COLUMN_PASSWORD = "password"
            val COLUMN_EMAIL = "email"
            val COLUMN_AGE = "age"
        }
    }
}