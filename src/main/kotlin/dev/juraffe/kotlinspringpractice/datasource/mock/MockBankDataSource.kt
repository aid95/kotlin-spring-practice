package dev.juraffe.kotlinspringpractice.datasource.mock

import dev.juraffe.kotlinspringpractice.datasource.BankDataSource
import dev.juraffe.kotlinspringpractice.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {

    val banks = listOf<Bank>(
        Bank("1234", 3.141592, 3030),
        Bank("abcd", 16.0, 203),
        Bank("test", 0.0, 0),
    )

    override fun retrieveBanks(): Collection<Bank> = banks
}
