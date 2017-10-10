package com.kata.poker.domain

import org.assertj.core.api.Assertions
import org.junit.Test

class CardTest {

    @Test
    fun `should compare rank of two cards`() {
        val greaterCard = Card.parse("5H")
        val lesserCard = Card.parse("2D")
        Assertions.assertThat(greaterCard).isGreaterThan(lesserCard)
    }

}