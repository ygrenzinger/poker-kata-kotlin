package com.kata.poker.domain

interface PokerRule {
    fun evaluate(pokerHand: PokerHand, other: PokerHand): Int
    fun isApplicable(pokerHand: PokerHand, other: PokerHand) : Boolean
}

class HighestHandWins : PokerRule {
    override fun isApplicable(pokerHand: PokerHand, other: PokerHand): Boolean = true

    override fun evaluate(pokerHand: PokerHand, other: PokerHand) =
            pokerHand.cards.max()!!.compareTo(other.cards.max()!!)
}

class HandWithMorePairsShouldWins : PokerRule {
    override fun isApplicable(pokerHand: PokerHand, other: PokerHand): Boolean {
        return pokerHand.pairs().isNotEmpty() || other.pairs().isNotEmpty()
    }

    override fun evaluate(pokerHand: PokerHand, other: PokerHand)
            = pokerHand.pairs().size.compareTo(other.pairs().size)
}

class HandWithHighestPairsShouldWins : PokerRule {
    override fun isApplicable(pokerHand: PokerHand, other: PokerHand): Boolean {
        return pokerHand.pairs().isNotEmpty() && other.pairs().isNotEmpty()
    }

    override fun evaluate(pokerHand: PokerHand, other: PokerHand) : Int {
        return pokerHand.pairs().max()!!.compareTo(other.pairs().max()!!)
    }
}

class HandWithStraightWins: PokerRule {
    override fun isApplicable(pokerHand: PokerHand, other: PokerHand): Boolean {
        return pokerHand.hasStraight() || other.hasStraight()
    }

    override fun evaluate(pokerHand: PokerHand, other: PokerHand): Int {
        if (pokerHand.hasStraight() && other.hasStraight())
            return  pokerHand.cards.max()!!.compareTo(other.cards.max()!!)
        if (pokerHand.hasStraight()) return 1
        if (other.hasStraight()) return -1
        return 0
    }

}