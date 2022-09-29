/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.declare.card;


import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author andrea
 */
@Slf4j
public enum CardValues {


    ACE(14), KING(13), QUEEN (12), JACK(11), TEN (10), NINE(9),
    EIGHT (8), SEVEN (7), SIX(6), FIVE(5), FOUR (4), THREE (3), TWO(2);

    private int value;

    public int getIntValue() {
        return value;
    }
    
    CardValues(int value){
        this.value=value;
    }
    
    CardValues(String value){
       this.value=convertStringValueInIntegerValue(value);       
    }
    
    private static int convertStringValueInIntegerValue(String cardValue){
         cardValue = cardValue.toUpperCase();
        switch (cardValue){
            case "ACE":
                return 14;
            case "KING":
                return 13;
            case "QUEEN":
                return 12;
            case "JACK":
                return 11;
            case "TEN":
                return 10;
            case "NINE":
                return 9;
            case "EIGHT" :
                return 8;
            case "SEVEN":
                return 7;
            case "SIX":
                return 6;
            case "FIVE":
                return 5;
            case "FOUR":
                return 4;
            case "THREE":
                return 3;
            case "TWO":
                return 2;
            default:
                log.error(cardValue +" is not a card value");
                return 0;                                  
        }
    }
    
}
