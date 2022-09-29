/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.declare.declaration;

import com.declare.card.Card;
import com.declare.card.CardSuits;
import com.declare.card.CardValues;
import com.declare.hand.BridgeHand;
import com.declare.hand.Hand;

import java.lang.reflect.Field;
import java.util.ArrayList;




/**
 *
 * @author andrea
 */
public class BridgeHandDescriptor {

    static private final int _HCPointsConversion = 10;


    public static BridgeHandDescription getBridgeHandDescription(Hand hand){
        BridgeHandDescription bhd = new BridgeHandDescription();
        bhd.keyCardsList = getKeyCards(hand);
        bhd.HCPoints = getHCPPoints(hand);
        bhd.distributionPoints = getDistributionPoints(hand);
        bhd.totalPoints = bhd.HCPoints  +  bhd.distributionPoints;
        bhd.numberOfCardsInClubs = getNumberOfCardsInSuit(hand, CardSuits.CLUBS);
        bhd.numberOfCardsInDiamonds = getNumberOfCardsInSuit(hand, CardSuits.DIAMONDS);
        bhd.numberOfCardsInHearts = getNumberOfCardsInSuit(hand, CardSuits.HEARTS);
        bhd.numberOfCardsInSpades = getNumberOfCardsInSuit(hand, CardSuits.SPADES);
        return bhd;
    }

    public static int getHCPPoints(Hand hand) {
        int HCPPoints = 0;
        for (Card card : hand.getCards()) {
            HCPPoints = HCPPoints + getHcpPointsPerCard(card);
        }
        return HCPPoints;
    }

    private static float getDistributionPoints(Hand hand) {
        float distributionPoints = 0;
        float pointPerSuit = 0;
        for (CardSuits suit : CardSuits.values()) {
            pointPerSuit = 3 - getNumberOfCardsInSuit(hand, suit);
            if (pointPerSuit > 0) {
                distributionPoints = distributionPoints + pointPerSuit;
            }
        }
        return distributionPoints;
    }

    public static int getNumberOfCardsInSuit(Hand hand, CardSuits suit) {
        int numberOfCardsInSuit = 0;
        for (Card card : hand.getCards()) {
            if (card.getSuit() == suit) {
                numberOfCardsInSuit++;
            }
        }
        return numberOfCardsInSuit;
    }

    public static float getHandValue(Hand hand) {
        return getHCPPoints(hand) + getDistributionPoints(hand);
    }

    private static int getHcpPointsPerCard(Card card) {
        CardValues cardValue = card.getValue();
        int cardHCPPoints = cardValue.getIntValue() - _HCPointsConversion;
        if (cardHCPPoints > 0) {
            return cardHCPPoints;
        }
        return 0;
    }

    public static ArrayList<Card> getKeyCards(Hand hand){
        ArrayList<Card> keyCards = new ArrayList<>();
          for (CardSuits suit : CardSuits.values()){
             keyCards.addAll(getKeyCardsPerSuit(hand, suit)); 
          }
        return keyCards;
    }

    public static ArrayList<Card> getKeyCardsPerSuit(Hand hand, CardSuits suit){
        ArrayList<Card> keyCardsPerSuit = new ArrayList<>();
        for (Card card: hand.getCards()){
            if (card.getSuit() == suit)
            if (card.getValue() == CardValues.ACE || card.getValue() == CardValues.KING || card.getValue() == CardValues.QUEEN){
                keyCardsPerSuit.add(card);
            }
        }
        return keyCardsPerSuit;
    }

    public static boolean isBridgeHandDescriptionSuperior (BridgeHandDescription bhdToCompareWith, BridgeHandDescription bhdToBeCompared) {
        try {
            Field[] fields = bhdToCompareWith.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getType() != ArrayList.class){
                    Comparable fieldbhdToCompareWith = (Comparable) field.get(bhdToCompareWith);
                    Comparable fieldbhdToBeCompared = (Comparable) field.get(bhdToBeCompared);
                    if (fieldbhdToBeCompared!=null && fieldbhdToCompareWith!=null)
                    if (fieldbhdToBeCompared.compareTo(fieldbhdToCompareWith) < 0) {
                     return false;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        }
        return true;

    }

    public static boolean gotFirstControlInSuit (CardSuits suit, Hand hand){
        ArrayList<Card> cardsInSuit = hand.getCardsOfASuit(suit);
       if (cardsInSuit.size() == 0 || cardsInSuit.contains(new Card(suit,CardValues.ACE)))
           return true;
       return false;
    }

    public static boolean gotSecondControlInSuit (CardSuits suit, Hand hand){
        ArrayList<Card> cardsInSuit = hand.getCardsOfASuit(suit);
        if (cardsInSuit.size() <= 1 || cardsInSuit.contains(new Card(suit,CardValues.KING)) ||
                cardsInSuit.contains(new Card(suit,CardValues.ACE)))
            return true;
        return false;
    }

    public static boolean gotThirdControlInSuit (CardSuits suit, Hand hand){
        ArrayList<Card> cardsInSuit = hand.getCardsOfASuit(suit);
        if (cardsInSuit.size() <= 2 || cardsInSuit.contains(new Card(suit,CardValues.KING)) ||
                cardsInSuit.contains(new Card(suit,CardValues.ACE)))
            return true;
        return false;
    }

    public static boolean gotStopperInSuit (CardSuits suit, Hand hand){
        if (getKeyCardsPerSuit(hand, suit).size()>0){
            return true;
        }
        return false;
    }


}
