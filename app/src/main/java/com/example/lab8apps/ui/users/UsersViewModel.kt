package com.example.lab8apps.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab8apps.network.GithubApi
import com.example.lab8apps.network.GitUserProperty
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
    //Url para la imagen
    private val _exists = MutableLiveData<Boolean>().apply { value = false }
    val exists: LiveData<Boolean>
        get() = _exists

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
                    _name.value = response.body()?.login
                    _urlAvatar.value = response.body()?.avatarUrl
                    _exists.value = true
                }else{
                    _name.value = "El usuario no existe"
                    //imagen tomada de internet
                    _urlAvatar.value = "https://cdn2.iconfinder.com/data/icons/office-business-vol-2-part-1/512/error-512.png"
                    _exists.value = false
                }
            }
        })
    }

}