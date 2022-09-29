package com.declare.Auction;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 4/25/13
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */
public enum BidSuits {

        CLUBS('c'), DIAMONDS('d'), HEARTS('h'), SPADES('s'), NOTRUMP ('t'), DOUBLE('x'), PASS('p') ;

    private char suit;

    BidSuits(char suit){
            this.suit = suit;
        }


        public char Suit() {
            return suit;
        }


}
