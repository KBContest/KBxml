package com.example.kb

import java.sql.Timestamp

class Question {

    @JvmField
    var content: String? = null
    @JvmField
    var timestamp: Long? = System.currentTimeMillis()
}