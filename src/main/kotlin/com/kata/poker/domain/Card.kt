package com.kata.poker.domain

enum class Suit(val symbol: Char) {
    CLUB('C'), SPADE('S'), HEART('H'), DIAMOND('D');
    companion object {
        fun parse(value: Char) = Suit.values().asList().find { it.symbol == value }
    }
}

enum class Rank(val symbol: Char) {
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('T'),
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    ACE('A');

    companion object {
        fun parse(value: Char) = Rank.values().asList().find { it.symbol == value }
    }

}

data class Card(val suit: Suit, val rank: Rank) : Comparable<Card> {

    override fun compareTo(other: Card) = rank.compareTo(other.rank)

    companion object {
        fun parse(value: String): Card {
            val suit = Suit.parse(value[1])!!
            val rank = Rank.parse(value[0])!!
            return Card(suit, rank)
        }
    }
}

