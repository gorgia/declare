/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.declare.hand;

import com.declare.card.Card;
import com.declare.card.CardSuits;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author andrea
 */
public class Hand {
    private ArrayList<Card> cards;
    

    public Hand(){
        cards = new ArrayList<Card>();
    }


    public Card removeCard(Card card){
        if (cards.remove(card)){
            return card;
        }
        return null;
    }

    public void addCard(Card card){
        cards.add(card);
    }
    
    public Hand(ArrayList<Card> cards){
       this.cards = cards;
    }

    public ArrayList<Card> getCards(){return cards;}

    public String toString(){
       String outPutString = null;
       for (Card card : cards){
           outPutString = outPutString + card.toString() + ", ";
       }
       return  outPutString;
    }

    public void sortHand(){
        Collections.sort(cards);
    }

    public ArrayList<Card> getCardsOfASuit(CardSuits suit){
        ArrayList<Card> cardsOfSuit = new ArrayList<>();
        for (Card  card: cards){
            if (card.getSuit() == suit){
                cardsOfSuit.add(card);
            }
        }
        return cardsOfSuit;
    }
}
