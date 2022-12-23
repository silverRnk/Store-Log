package com.example.sari_saristorelog.feature_transaction_log.domain.use_cases

import com.example.sari_saristorelog.feature_transaction_log.domain.model.Items
import com.example.sari_saristorelog.feature_transaction_log.domain.model.Transaction
import com.example.sari_saristorelog.feature_transaction_log.domain.model.TransactionInfo
import com.example.sari_saristorelog.feature_transaction_log.domain.repository.LoggerRepository

class AddTransaction(
    private val repository: LoggerRepository
) {

    /*
    TODO
    1. add TransactionInfo to Db
    2. get TransactionInfo Id
    3. map the id to the item list
    4. add items to db
     */
    suspend operator fun invoke(info: TransactionInfo, items: List<Items>){
        repository.insertTransaction(info, items)


    }
}