package com.yasinmoridi.daneshjooyarFake.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.yasinmoridi.daneshjooyarFake.data.model.NotifResponse
import com.yasinmoridi.daneshjooyarFake.repository.MessageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    private val repository: MessageRepository
):ViewModel() {
    val notifeResponse: MutableStateFlow<NotifResponse> = repository.notifeResponse


    fun senMessage(message: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.senMessage(message)
        }
    }

    fun resetResponse(){
        viewModelScope.launch {
            notifeResponse.emit(NotifResponse())
        }
    }

}