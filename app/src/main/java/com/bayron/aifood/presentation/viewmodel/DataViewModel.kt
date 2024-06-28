package com.bayron.aifood.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bayron.aifood.data.preferences.DataStoreRepositoryImpl
import com.bayron.aifood.data.preferences.IS_FIRST_ACCESS_KEY
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DataViewModel : ViewModel() {

    fun isFirstAccess(repository: DataStoreRepositoryImpl): Boolean = runBlocking {
        repository.getBoolean(IS_FIRST_ACCESS_KEY, true)
    }

    fun saveFirstAccess(repository: DataStoreRepositoryImpl, value: Boolean) {
        viewModelScope.launch {
            repository.putBoolean(IS_FIRST_ACCESS_KEY, value)
        }
    }
}