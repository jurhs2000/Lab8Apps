package com.example.lab8apps.ui.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab8apps.MainActivity
import com.example.lab8apps.network.GitUserProperty
import com.example.lab8apps.network.GithubApi
import com.example.lab8apps.network.RepoProperty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReposViewModel : ViewModel() {

    private val _message = MutableLiveData<String>().apply { value = "Repositorios: " }
    val message: LiveData<String>
        get() = _message
    //repos
    private val _repos = MutableLiveData<List<RepoProperty>>()
    val repos: LiveData<List<RepoProperty>>
        get() = _repos

    init {
        getRepos(MainActivity.user)
    }

    fun getRepos(username: String) {
        GithubApi.retrofitService.getRepos(username).enqueue(object: Callback<List<RepoProperty>> {
            override fun onFailure(call: Call<List<RepoProperty>>, t: Throwable) {
                _message.value = "Error: " + t.message
            }

            override fun onResponse(
                call: Call<List<RepoProperty>>,
                response: Response<List<RepoProperty>>
            ) {
                if (response.body()?.size != 0){
                    _repos.value = response.body()
                }else{
                    _message.value = "No hay ningun repositorio"
                }
            }
        })
    }

}