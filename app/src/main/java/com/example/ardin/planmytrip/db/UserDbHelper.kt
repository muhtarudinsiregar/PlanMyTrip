package com.example.ardin.planmytrip.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.ardin.planmytrip.model.UserModel

/**
 * Created by ardin on 21/02/18.
 */
class UserDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insert(user: UserModel): Boolean {
        val db = writableDatabase

        //create new map, where column names are the key
        val values = ContentValues()
        val table = DBContract.UserCreate

        values.apply {
            put(table.COLUMN_USER_ID, 1)
            put(table.COLUMN_PASSWORD, user.password)
            put(table.COLUMN_EMAIL, user.email)
            put(table.COLUMN_AGE, user.age)
            put(table.COLUMN_NAME, user.name)
        }

        db.insert(table.TABLE_NAME, null, values)
        return true
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "FeedReader.db"

        private val SQL_CREATE_ENTRIES =
                "CREATE TABLE " + DBContract.UserCreate.TABLE_NAME + " (" +
                        DBContract.UserCreate.COLUMN_USER_ID + " TEXT PRIMARY KEY," +
                        DBContract.UserCreate.COLUMN_NAME + " TEXT," +
                        DBContract.UserCreate.COLUMN_PASSWORD + " TEXT," +
                        DBContract.UserCreate.COLUMN_EMAIL + " TEXT," +
                        DBContract.UserCreate.COLUMN_AGE + " INTEGER)"

        private val SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + DBContract.UserCreate.TABLE_NAME
    }

}