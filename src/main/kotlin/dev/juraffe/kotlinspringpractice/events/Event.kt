package dev.juraffe.kotlinspringpractice.events

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "events")
class Event(
    @Id @GeneratedValue var id: Long? = null,
    var name: String = "",
    var description: String = "",
    var beginEnrollmentDateTime: LocalDateTime = LocalDateTime.now(),
    var closeEnrollmentDateTime: LocalDateTime = LocalDateTime.now(),
    var beginEventDateTime: LocalDateTime = LocalDateTime.now(),
    var endEventDateTime: LocalDateTime = LocalDateTime.now(),
    var location: String = "",
    var basePrice: Int = 0,
    var maxPrice: Int = 0,
    var limitOfEnrollment: Int = 0,
    var offline: Boolean = true,
    var free: Boolean = true,
    @Enumerated(EnumType.STRING) var eventStatus: EventStatus = EventStatus.PUBLISHED
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Event

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
