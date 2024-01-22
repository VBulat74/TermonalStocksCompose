package ru.com.bulat.termonalstockscompose.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.com.bulat.termonalstockscompose.data.ApiFactory

class TerminalViewModel : ViewModel() {

    private val apiService = ApiFactory.apiService

    private val _state = MutableStateFlow<TerminalScreenState>(TerminalScreenState.Initial)
    val state = _state.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.d("TerminalViewModel", "Exception : $throwable")
    }

    init {
        loadBarList()
    }

    private fun loadBarList() {
        viewModelScope.launch(exceptionHandler) {
            val barList = apiService.loadBars().barLists
            Log.d("AAA", "Size: ${barList.size} body: ${barList.toString()}")
            _state.value = TerminalScreenState.Content(barList = barList)
        }
    }

}