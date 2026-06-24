package com.yasinmoridi.daneshjooyarFake.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.yasinmoridi.daneshjooyarFake.data.model.CompletedItem
import com.yasinmoridi.daneshjooyarFake.repository.CompletedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompletedViewModel @Inject constructor(
    private val repository: CompletedRepository
) : ViewModel() {


    private val _allCompletedItem = MutableStateFlow<List<CompletedItem>>(emptyList())
    val allCompletedItem = _allCompletedItem.asStateFlow()

    fun upsertCompletedItem(item: CompletedItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.upsertCompletedItem(item)
        }
    }

    fun getAllCourse(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllCompletedItem().collectLatest{
                _allCompletedItem.value = it
            }
        }
    }

}

