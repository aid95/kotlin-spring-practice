package dev.juraffe.kotlinspringpractice

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringPracticeApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringPracticeApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
