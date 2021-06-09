package br.com.alura.aluraesporte.repository

import android.content.SharedPreferences
import androidx.core.content.edit

private const val LOGGED_KEY = "LOGGED"

class LoginRepository(private val preferences : SharedPreferences){

    fun login() = salva(true)

    fun loggout() = salva(false)

    private fun salva(status: Boolean) = preferences.edit {
        putBoolean(LOGGED_KEY, status)
    }

    fun isLogged() =  preferences.getBoolean(LOGGED_KEY, false)

}
