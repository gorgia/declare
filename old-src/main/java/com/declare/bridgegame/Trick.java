/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.declare.bridgegame;

import com.declare.card.Card;
import com.declare.card.CardSuits;
import java.util.ArrayList;

/**
 *
 * @author andrea
 */
public class Trick {

    private ArrayList<Card> cards;
    private CardSuits trump;

    public Trick(Card card1, Card card2, Card card3, Card card4, CardSuits trump) {
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        this.trump = trump;
    }

    public Trick(ArrayList<Card> cards, CardSuits trump) {
        this.cards = cards;
        this.trump = trump;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void setTrump(CardSuits trump) {
        this.trump = trump;
    }

    public Card returnWinningCarg(){
         return returnWinningCard(this.cards, this.trump);
    }
    
    public Card returnWinningCard(CardSuits trump) {
        return returnWinningCard(this.cards, trump);
    }

    public static Card returnWinningCard(ArrayList<Card> cards, CardSuits trump) {
        Card winningCard = cards.iterator().next();
        while (cards.iterator().hasNext()) {
            Card cardToCompare = cards.iterator().next();
            if (cardToCompare.getSuit() == winningCard.getSuit()) {
                if (cardToCompare.getValue().getIntValue() > winningCard.getValue().getIntValue()) {
                    winningCard = cardToCompare;
                }
            } else if (cardToCompare.getSuit() == trump) {
                winningCard = cardToCompare;
            }
        }
        return winningCard;

    }
}
