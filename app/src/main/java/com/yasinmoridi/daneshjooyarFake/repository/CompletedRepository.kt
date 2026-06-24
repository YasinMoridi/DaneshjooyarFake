package com.yasinmoridi.daneshjooyarFake.repository

import com.yasinmoridi.daneshjooyarFake.data.db.CompletedDao
import com.yasinmoridi.daneshjooyarFake.data.model.CompletedItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CompletedRepository @Inject constructor(
    private val dao: CompletedDao
) {
    suspend fun upsertCompletedItem(item: CompletedItem) {
        dao.upsertCompletedItem(item)
    }

    suspend fun getAllCompletedItem(): Flow<List<CompletedItem>> = dao.getAllCompletedItem()


}