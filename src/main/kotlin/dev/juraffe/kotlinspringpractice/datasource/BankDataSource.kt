package dev.juraffe.kotlinspringpractice.datasource

import dev.juraffe.kotlinspringpractice.model.Bank

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
}