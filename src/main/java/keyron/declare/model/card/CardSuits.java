/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package keyron.declare.model.card;

/**
 *
 * @author andrea
 */
public enum CardSuits{
    CLUBS('C'), DIAMONDS('D'), HEARTS('H'), SPADES('S');
    private char suit;
    
    CardSuits (char suit){
        this.suit = suit;
    }

    
    public char getSuit() {
        return suit;
    }
}
