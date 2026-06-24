package com.yasinmoridi.daneshjooyarFake.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CompletedItem(
    @PrimaryKey
    val id:Int=0,
    val image:String="",
    val title:String=""
)
