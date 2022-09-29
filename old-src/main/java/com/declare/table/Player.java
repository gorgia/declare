package com.declare.table;

import com.declare.card.Card;
import com.declare.hand.Hand;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 4/21/13
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    Directions direction;
    String name;
    private Hand hand;

    public Player(String name){
        this.name = name;
    }

    public void setHand(Hand hand){
         this.hand = hand;
         this.hand.sortHand();
    }

    public Card playCard(Card card){
        return hand.removeCard(card);
    }

    public Hand getHand(){
        return hand;
    }
}
