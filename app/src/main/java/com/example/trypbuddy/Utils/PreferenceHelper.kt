package com.example.biz_intelligence.Utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by Chirag on 28-11-2018.
 */

class PreferenceHelper constructor(context: Context) {

    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    var value: Any? = null

    fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        editor = this.edit()
        operation(editor!!)
        editor!!.apply()
    }

    // set key value in shared preference
    // set key value in shared preference
    fun <T> setValue(context: Context, key: String, value: T) {

        if (value is String) {
            sharedPreferences!!.edit { editor!!.putString(key, value as String) }
        } else if (value is Boolean) {
            sharedPreferences!!.edit { editor!!.putBoolean(key, value as Boolean) }
        } else if (value is Int) {
            sharedPreferences!!.edit { editor!!.putInt(key, value as Int) }
        } else if (value is Float) {
            sharedPreferences!!.edit { editor!!.putFloat(key, value as Float) }
        } else {
            throw UnsupportedOperationException("Not yet implemented.")
        }
    }

    // get key value in shared prefrence
    fun <T> getValue(context: Context, key: String, aClass: Class<*>, defaultValue: T): T {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (aClass == String::class.java) {
            value = sharedPreferences!!.getString(key!!, defaultValue as String)
        } else if (aClass == Boolean::class.java) {
            value = sharedPreferences!!.getBoolean(key!!, defaultValue as Boolean)
        } else if (aClass == Int::class.java) {
            value = sharedPreferences!!.getInt(key!!, defaultValue as Int)
        } else if (aClass == Float::class.java) {
            value = sharedPreferences!!.getFloat(key!!, defaultValue as Float)
        } else {
            throw UnsupportedOperationException("Not yet implemented.")
        }
        return (value as T?)!!
    }

    interface Performer<T> {
        fun performOperation(victim: T)
    }

}