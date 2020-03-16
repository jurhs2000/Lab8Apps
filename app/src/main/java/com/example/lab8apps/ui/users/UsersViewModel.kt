package com.example.lab8apps.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UsersViewModel : ViewModel() {

    //Nombre del usuario
    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name
    //Url para la imagen
    private val _urlAvatar = MutableLiveData<String>()
    val urlAvatar: LiveData<String>
        get() = _urlAvatar

    fun getUser(username: String) {
        _name.value = "set the name here"
        _urlAvatar.value = "https://dam.ngenespanol.com/wp-content/uploads/2019/06/mirada-perros-768x394.png"
    }

}