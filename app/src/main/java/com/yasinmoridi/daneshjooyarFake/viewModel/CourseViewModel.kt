package com.yasinmoridi.daneshjooyarFake.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.yasinmoridi.daneshjooyarFake.data.model.CourseItemDb
import com.yasinmoridi.daneshjooyarFake.repository.CourseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(
    private val repository: CourseRepository
) : ViewModel() {

    fun getCourseItem(id:Int) :Flow<CourseItemDb?> = repository.getCourseItem(id)



    fun getWatchedRanges(id: Int): Flow<List<Pair<Long, Long>>> = repository.getWatchedRanges(id)

    fun upsertCourseItem(id: Int, watchedRanges: List<Pair<Long, Long>>, totalDuration: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val serializedRanges = repository.serializeWatchedRanges(watchedRanges)
            val itemDb = CourseItemDb(id = id, watchedRanges = serializedRanges, totalDuration = totalDuration)
            repository.upsertCourseItem(itemDb)
        }
    }
}
