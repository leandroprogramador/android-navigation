package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EstadoAppViewModel : ViewModel(){
    val components: LiveData<ViewComponents> get() = _components
    private var _components: MutableLiveData<ViewComponents> = MutableLiveData<ViewComponents>().also { it.value = hasComponents }
    var hasComponents : ViewComponents = ViewComponents()
        set(value){
            field = value
            _components.value = value
        }

}

class ViewComponents(
    val appBar : Boolean = false,
    val bottomNav : Boolean = false
)
