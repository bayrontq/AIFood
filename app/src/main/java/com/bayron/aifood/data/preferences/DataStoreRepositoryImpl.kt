package com.bayron.aifood.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

private val Context.dataStore by preferencesDataStore(
    name = "preferences_data_store"
)

class DataStoreRepositoryImpl(
    private val context: Context
) : DataStoreRepository {

    override suspend fun putBoolean(key: String, value: Boolean) {
        val preferencesKey = booleanPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        val preferencesKey = booleanPreferencesKey(key)
        val preferences = context.dataStore.data.first()

        preferences[preferencesKey]?.let {
            return it
        } ?: run {
            return defaultValue
        }
    }
}