package com.kata.poker.domain

import org.assertj.core.api.Assertions.*
import org.junit.Test


class PokerhandTest {

    @Test
    fun `the highest card should win`() {
        val winningHand = PokerHand.parse("AC 4D 5D 3H 7S");
        val losingHand = PokerHand.parse("KC 4S 5S JH 6D");
        assertThat(winningHand).isGreaterThan(losingHand);
    }

    @Test
    fun `the hand with pair should win over no specific hand`() {
        val winningHand = PokerHand.parse("2C 2D 5D 3H 7S");
        val losingHand = PokerHand.parse("AC 4S 5S JH 6D");
        assertThat(winningHand).isGreaterThan(losingHand);
    }

    @Test
    fun `the hand with two pair should win over no specific hand`() {
        val winningHand = PokerHand.parse("2C 2D 5D 5H 7S");
        val losingHand = PokerHand.parse("AC 4S 5S JH 6D");
        assertThat(winningHand).isGreaterThan(losingHand);
    }

    @Test
    fun `the hand with two pair should win over the hand with one pair`() {
        val winningHand = PokerHand.parse("2C 2D 5D 5H 7S");
        val losingHand = PokerHand.parse("AC 4S 4C JH 6D");
        assertThat(winningHand).isGreaterThan(losingHand);
    }

    @Test
    fun `the hand with the highest pair should win`() {
        val winningHand = PokerHand.parse("6C 6D 3D 5H 7S");
        val losingHand = PokerHand.parse("AC 4S 4C JH 6H");
        assertThat(winningHand).isGreaterThan(losingHand);
    }

    @Test
    fun `should have a draw game`() {
        val hand = PokerHand.parse("KC KD 3D 4H 7S");
        val otherHand = PokerHand.parse("KH KS 3C 4C 7H");
        assertThat(hand).isEqualByComparingTo(otherHand);
    }

    @Test
    fun `should compare other cards if same pair`() {
        val winningHand = PokerHand.parse("KC KD AD 4H 7S");
        val losingHand = PokerHand.parse("KH KS 3C 4C 7H");
        assertThat(winningHand).isGreaterThan(losingHand);
    }

    @Test
    fun `the hand with straight wins over pair`() {
        val winningHand = PokerHand.parse("4H 3C 2S 5D 6S");
        val losingHand = PokerHand.parse("KH KS JC QC 7H");
        assertThat(winningHand).isGreaterThan(losingHand);
    }

}

