package dev.juraffe.kotlinspringpractice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/hello")
class HelloWorldController {

    @GetMapping("springboot")
    fun helloWorld(): String = "Hello, this is a REST endpoint!"
}
