package com.example.lab8apps.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab8apps.network.GithubApi
import com.example.lab8apps.ui.repos.GitUserProperty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        GithubApi.retrofitService.getUser(username).enqueue(object: Callback<GitUserProperty> {
            override fun onFailure(call: Call<GitUserProperty>, t: Throwable) {
                _name.value = "Error: " + t.message
            }

            override fun onResponse(
                call: Call<GitUserProperty>,
                response: Response<GitUserProperty>
            ) {
                if (response.body()?.login!=null){
                    _name.value = "Usuario: " + response.body()?.login
                    _urlAvatar.value = response.body()?.avatarUrl


                }else{
                    _name.value = "El usuario no existe"
                }
            }
        })
    }

}