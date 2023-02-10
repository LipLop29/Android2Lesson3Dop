package com.example.android2lesson3dop.utils

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {

    private lateinit var sharedPreferences: SharedPreferences

    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }

    var safeText: String?
        set(value) = sharedPreferences.edit().putString("key", value).apply()
        get() = sharedPreferences.getString("key", "")

    var safeText2: String?
        set(value) = sharedPreferences.edit().putString("key2", value).apply()
        get() = sharedPreferences.getString("key2", "")
}