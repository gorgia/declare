package com.declare.declaration;

import com.declare.card.Card;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 4/22/13
 * Time: 10:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class BridgeHandDescription{
    public ArrayList<Card> keyCardsList = new ArrayList<>();
    public Integer HCPoints = 0;
    public Float distributionPoints = 0f;
    public Float totalPoints = 0f;

    public Integer numberOfCardsInSpades = 0;
    public Integer numberOfCardsInClubs = 0;
    public Integer numberOfCardsInDiamonds = 0;
    public Integer numberOfCardsInHearts = 0;
    public Integer numberOfLoosers = 13;

}
