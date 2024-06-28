package com.bayron.aifood.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.bayron.aifood.data.preferences.DataStoreRepository
import com.bayron.aifood.data.preferences.IS_FIRST_ACCESS_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    fun isFirstAccess(): Boolean = runBlocking {
        repository.getBoolean(IS_FIRST_ACCESS_KEY, true)
    }
}