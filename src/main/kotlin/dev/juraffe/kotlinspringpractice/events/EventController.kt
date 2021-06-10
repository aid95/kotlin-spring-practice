package dev.juraffe.kotlinspringpractice.events

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.MediaTypes
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller()
@RequestMapping(value = ["/api/events"], produces = [MediaTypes.HAL_JSON_VALUE])
class EventController @Autowired constructor(private val eventRepository: EventRepository) {

    @PostMapping()
    fun createEvent(@RequestBody event: Event): ResponseEntity<Event> {
        val newEvent = this.eventRepository.save(event)
        return ResponseEntity(newEvent, HttpStatus.CREATED)
    }
}
