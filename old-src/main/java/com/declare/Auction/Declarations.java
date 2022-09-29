package com.declare.Auction;



/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 4/24/13
 * Time: 9:37 AM
 * To change this template use File | Settings | File Templates.
 */
public enum Declarations {
   C1 (1, BidSuits.CLUBS),D1 (1, BidSuits.DIAMONDS),H1(1, BidSuits.HEARTS), S1(1, BidSuits.SPADES), NT1 (1 , BidSuits.NOTRUMP),
   C2 (2, BidSuits.CLUBS),D2 (2, BidSuits.DIAMONDS),H2(2, BidSuits.HEARTS), S2(2, BidSuits.SPADES), NT2 (2 , BidSuits.NOTRUMP),
   C3 (3, BidSuits.CLUBS),D3 (3, BidSuits.DIAMONDS),H3(3, BidSuits.HEARTS), S3(3, BidSuits.SPADES), NT3 (3 , BidSuits.NOTRUMP),
   C4 (4, BidSuits.CLUBS),D4 (4, BidSuits.DIAMONDS),H4(4, BidSuits.HEARTS), S4(4, BidSuits.SPADES), NT4 (4 , BidSuits.NOTRUMP),
   C5 (5, BidSuits.CLUBS),D5 (5, BidSuits.DIAMONDS),H5(5, BidSuits.HEARTS), S5(5, BidSuits.SPADES), NT5 (5 , BidSuits.NOTRUMP),
   C6 (6, BidSuits.CLUBS),D6 (6, BidSuits.DIAMONDS),H6(6, BidSuits.HEARTS), S6(6, BidSuits.SPADES), NT6 (6 , BidSuits.NOTRUMP),
   C7 (7, BidSuits.CLUBS),D7 (7, BidSuits.DIAMONDS),H7(7, BidSuits.HEARTS), S7(7, BidSuits.SPADES), NT7 (7 , BidSuits.NOTRUMP),
   PASS(0, BidSuits.PASS), DOUBLE (0, BidSuits.DOUBLE);


    private final int level;
    private final BidSuits suit;
   Declarations (int level, BidSuits suit){
       this.level = level;
       this.suit = suit;

   }

    public int getLevel() {
        return level;
    }

    public BidSuits getSuit() {
        return suit;
    }
}
