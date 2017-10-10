package com.kata.poker

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class PokerApplication

fun main(args: Array<String>) {
    SpringApplication.run(PokerApplication::class.java, *args)
}
