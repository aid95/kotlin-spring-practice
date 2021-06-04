package dev.juraffe.kotlinspringpractice.datasource.mock

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest {

    private val mockDataSource = MockBankDataSource()

    @Test
    fun `should provide a collection of banks`() {
        val banks = mockDataSource.retrieveBanks()

        Assertions.assertThat(banks).isNotEmpty
    }

    @Test
    fun `should provide some mock data`() {
        val banks = mockDataSource.retrieveBanks()

        Assertions.assertThat(banks).allSatisfy { it.accountNumber.isNotBlank() }
        Assertions.assertThat(banks).anyMatch { it.trust != 0.0 }
        Assertions.assertThat(banks).anySatisfy { it.transactionFee != 0 }
    }
}
