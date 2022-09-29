package com.declare.table;

import com.declare.card.Card;
import com.declare.card.CardSuits;
import com.declare.card.CardValues;
import java.util.ArrayList;


/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 4/21/13
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Deck {
    public ArrayList<Card> cards;

    public Deck(){
          cards = new ArrayList<Card>();
         fillCompleteDeck();
    }

    public void fillCompleteDeck(){
        for (CardSuits suit : CardSuits.values()){
              for (CardValues value: CardValues.values()){
                  this.cards.add(new Card(suit, value));
              }
        }

    }

    public Card removeCard(){
       return cards.remove(0);
    }
}
