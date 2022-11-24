package com.example.sari_saristorelog.data


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.sari_saristorelog.Util.Transactions
import com.example.sari_saristorelog.data.repository.ApplicationDao
import com.example.sari_saristorelog.data.repository.ApplicationDataBase
import com.example.sari_saristorelog.data.transaction.Transaction
import com.example.sari_saristorelog.data.transaction.TransactionInfo
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class ApplicationDataBaseTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: ApplicationDao
    private lateinit var db: ApplicationDataBase

    @Before
    fun setup(){
        db = Room
            .inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), ApplicationDataBase::class.java)
            .allowMainThreadQueries()
            .build()
        dao = db.dao()
    }

    @After
    fun closeDB(){
        db.close()
    }


    @Test
    fun insertTransactionInfo() = runTest(UnconfinedTestDispatcher()) {

        val id = dao.insertTransactionInfo(Transactions.transactioninfo1)

        val transaction1 = dao.getTransactionInfoList()
        val transactionInfo = TransactionInfo(transactionId = id, customerId = 1, createdDate = "July", total = 8.00)

        assertThat(transaction1).contains(transactionInfo)
    }

    @Test
    fun insertTransaction() = runTest {

        dao.insertTransactionInfo(Transactions.transactioninfo1)
        dao.insertItems(Transactions.transaction1.items)

        val transaction = dao.getTransaction(Transactions.transactioninfo1.transactionId)

        assertThat(transaction).isEqualTo(Transactions.transaction1)
    }

    @Test
    fun insertCustomer() = runTest {

        dao.insertCustomer(Transactions.customerInfo)

        val customer = dao.getCustomer(Transactions.customerInfo.customerId)

        assertThat(customer).isEqualTo(Transactions.customerInfo)
    }

    @Test
    fun deleteTransactionInfo() = runTest {

        dao.insertTransactionInfo(Transactions.transactioninfo1)
        dao.deleteTransactionInfo(Transactions.transactioninfo1)

        val transactionInfo = dao.getTransactionInfoList()

        assertThat(transactionInfo).isEmpty()
    }

    @Test
    fun deleteItems() = runTest {

        dao.insertTransactionInfo(Transactions.transactioninfo1)
        dao.insertItems(Transactions.transaction1.items)
        dao.deleteItems(Transactions.transaction1.items)

        val transaction = dao.getTransaction(Transactions.transactioninfo1.transactionId)

        assertThat(transaction).isEqualTo(Transaction(transactionInfo = Transactions.transactioninfo1,
        items = listOf()))
    }

    @Test
    fun deleteCustomer() = runTest {

        dao.insertCustomer(Transactions.customerInfo)
        dao.deleteCustomer(Transactions.customerInfo)

        val customer = dao.getCustomer(Transactions.customerInfo.customerId)

        assertThat(customer).isNull()
    }

}
