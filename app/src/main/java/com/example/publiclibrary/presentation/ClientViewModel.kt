package com.example.publiclibrary.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.publiclibrary.core.UseCase
import com.example.publiclibrary.data.model.Client
import com.example.publiclibrary.domain.AddClientUseCase
import com.example.publiclibrary.domain.ListClientAllUseCase
import com.example.publiclibrary.domain.ListClientCpfUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import org.json.JSONObject

class ClientViewModel(private val listClientUseCase: ListClientCpfUseCase,
                      private val listAllUseCase: ListClientAllUseCase,
                      private val addClientUseCase: AddClientUseCase
): ViewModel() {

    private val _client = MutableLiveData<State>()
    val clients: LiveData<State> = _client

    fun getClientList(user: String){
        viewModelScope.launch {
            listClientUseCase.execute(user)
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

    fun getAllClients(){
        viewModelScope.launch {
            listAllUseCase.execute(UseCase.None)
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

    fun addClientUseCase(json: JSONObject){
        viewModelScope.launch {
            addClientUseCase.execute(json)
                .onStart{
                    _client.postValue(State.Loading)
                }
                .catch{
                    _client.postValue(State.Error(it))
                }
        }
    }

    sealed class State{
        object Loading : State()
        data class Success(val list: List<Client>) : State()
        data class Error(val error: Throwable) : State()
    }
}