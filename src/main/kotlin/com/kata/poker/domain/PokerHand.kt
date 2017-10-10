package com.kata.poker.domain

data class PokerHand(val cards: List<Card>) : Comparable<PokerHand> {

    private val pokerRules = listOf(
            HandWithStraightWins(),
            HandWithMorePairsShouldWins(),
            HandWithHighestPairsShouldWins(),
            HighestHandWins()
    )

    init {
        if (cards.size != 5) {
            throw IllegalStateException("Poker hand not valid")
        }
    }

    override fun compareTo(other: PokerHand): Int {
        return pokerRules
                .filter { it.isApplicable(this, other) }
                .map { it.evaluate(this, other) }
                .max()!!
    }

    companion object {
        fun parse(value: String): PokerHand {
            val cards = value.split(" ").toList().map { Card.parse(it) }
            return PokerHand(cards)
        }
    }

    fun pairs(): List<Rank> {
        return cards
                .groupBy { it.rank }
                .filter { it.value.size == 2 }
                .map { it.key }
    }

    fun hasStraight(): Boolean {
        return cards.map { it.rank.ordinal }
                .sorted()
                .zipWithNext { a, b -> b - a }
                .sum() == 4
    }

}