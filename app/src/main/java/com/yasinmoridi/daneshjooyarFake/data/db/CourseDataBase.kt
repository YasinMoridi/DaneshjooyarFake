package com.yasinmoridi.daneshjooyarFake.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yasinmoridi.daneshjooyarFake.data.model.CompletedItem
import com.yasinmoridi.daneshjooyarFake.data.model.CourseItemDb

@Database(entities = [CourseItemDb::class,CompletedItem::class], version = 1, exportSchema = false)
abstract class CourseDataBase:RoomDatabase() {
    abstract fun CourseDao(): CourseDao
    abstract fun CompletedDao(): CompletedDao
}