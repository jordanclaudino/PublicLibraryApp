package com.example.publiclibrary.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.publiclibrary.core.UseCase
import com.example.publiclibrary.data.model.Book
import com.example.publiclibrary.domain.ListBookAllUseCase
import com.example.publiclibrary.domain.ListBookIdUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class BookViewModel(private val listBookAllUseCase: ListBookAllUseCase,
                    private val listBookIdUseCase: ListBookIdUseCase
) : ViewModel() {

    private val _book = MutableLiveData<State>()
    val books: LiveData<State> = _book

    fun getBookById(bookId: Long){
        viewModelScope.launch {
            listBookIdUseCase.execute(bookId)
                .onStart{
                    _book.postValue(State.Loading)
                }
                .catch{
                    _book.postValue(State.Error(it))
                }
                .collect{
                    _book.postValue(State.Success(it))
                }
        }
    }

    fun getAllBooks(){
        viewModelScope.launch {
            listBookAllUseCase.execute(UseCase.None)
                .onStart{
                    _book.postValue(State.Loading)
                }
                .catch{
                    _book.postValue(State.Error(it))
                }
                .collect{
                    _book.postValue(State.Success(it))
                }
        }
    }

    sealed class State{
        object Loading : State()
        data class Success(val list: List<Book>) : State()
        data class Error(val error: Throwable) : State()
    }


}

