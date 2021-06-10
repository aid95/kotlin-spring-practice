package dev.juraffe.kotlinspringpractice.events

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class EventTest {

    @Test
    fun builder() {
        val event = Event()
        Assertions.assertThat(event).isNotNull
    }

    @Test
    fun javaBean() {
        val name = "Hello"
        val description = "World"
        val event = Event(name = name, description = description)
        Assertions.assertThat(event.name).isEqualTo(name)
        Assertions.assertThat(event.description).isEqualTo(description)
    }
}
