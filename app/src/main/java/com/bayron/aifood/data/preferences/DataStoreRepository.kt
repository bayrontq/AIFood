package com.bayron.aifood.data.preferences

interface DataStoreRepository {

    suspend fun putBoolean(key: String, value: Boolean)
    suspend fun getBoolean(key: String, defaultValue: Boolean): Boolean
}