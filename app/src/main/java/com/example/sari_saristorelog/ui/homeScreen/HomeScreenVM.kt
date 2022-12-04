package com.example.sari_saristorelog.ui.homeScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.setValue
import com.example.sari_saristorelog.feature_transaction_log.domain.model.TransactionInfoAndCustomer
import com.example.sari_saristorelog.feature_transaction_log.domain.repository.LoggerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenVM @Inject constructor(
    repository: LoggerRepository
) {

    var transactionList by mutableStateOf(listOf<TransactionInfoAndCustomer>())
    private set

    var searchText by mutableStateOf("")
    private set

    fun onEvent(event: HomeScreenEvent){

    }


}