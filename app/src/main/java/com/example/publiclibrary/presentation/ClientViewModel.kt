package com.example.publiclibrary.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.publiclibrary.data.model.Client
import com.example.publiclibrary.domain.ListClientRepositoryUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ClientViewModel(private val listClientRepositoryUseCase: ListClientRepositoryUseCase)
    : ViewModel() {

    private val _client = MutableLiveData<State>()
    val clients: LiveData<State> = _client

    fun getClientList(user: String){
        viewModelScope.launch {
            listClientRepositoryUseCase(user)
                .onStart{
                    _client.postValue(State.Loading)
                }
                .catch{
                    _client.postValue(State.Error(it))
                }
                .collect{
                    _client.postValue(State.Success(it))
                }
        }
    }

    sealed class State{
        object Loading : State()
        data class Success(val list: List<Client>) : State()
        data class Error(val error: Throwable) : State()
    }
}