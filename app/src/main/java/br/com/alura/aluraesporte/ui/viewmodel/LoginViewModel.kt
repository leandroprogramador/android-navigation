package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.aluraesporte.repository.LoginRepository

class LoginViewModel(private val repository : LoginRepository) : ViewModel() {

    fun login(){
        repository.login()
    }

    fun desloga(){
        repository.loggout()
    }

    fun isLogged() : Boolean = repository.isLogged()

}
