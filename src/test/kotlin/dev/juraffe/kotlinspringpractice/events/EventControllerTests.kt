package dev.juraffe.kotlinspringpractice.events

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.hateoas.MediaTypes
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.time.LocalDateTime

@WebMvcTest
internal class EventControllerTests @Autowired constructor(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper,
) {

    @MockBean
    private lateinit var eventRepository: EventRepository

    @Test
    fun createEvent() {
        val event = Event(
            name = "Spring",
            description = "REST API Development with Spring",
            beginEnrollmentDateTime = LocalDateTime.of(2018, 11, 23, 14, 21),
            closeEnrollmentDateTime = LocalDateTime.of(2018, 11, 24, 14, 21),
            beginEventDateTime = LocalDateTime.of(2018, 11, 25, 14, 21),
            endEventDateTime = LocalDateTime.of(2018, 11, 26, 14, 21),
            basePrice = 100,
            maxPrice = 200,
            limitOfEnrollment = 100,
            location = "강남역 D2 스타트업 팩토리",
            free = true,
            offline = true,
            eventStatus = EventStatus.PUBLISHED
        )
        event.id = 10
        Mockito.`when`(eventRepository.save(event)).thenReturn(event)

        mockMvc
            .perform(
                post("/api/events/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaTypes.HAL_JSON)
                    .content(objectMapper.writeValueAsString(event))
            )
            .andDo(print())
            .andExpect(status().isCreated)
            .andExpect(jsonPath("id").exists())
            .andExpect(header().exists(HttpHeaders.LOCATION))
            .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE))
    }
}
