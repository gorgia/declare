package com.declare.table;

import com.declare.declaration.BridgeHandDescription;
import com.declare.declaration.BridgeHandDescriptor;
import com.declare.hand.Hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 4/21/13
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dealer {
    Deck deck;
    ArrayList<Seat> seatsOfCheaters = null;
    BridgeHandDescription bhdCheaters = null;
    boolean doCheat = false;
    private static final Logger log = LoggerFactory.getLogger(Dealer.class);

    public Dealer() {
        this.deck = new Deck();
    }

    public void doCheat(ArrayList<Seat> seatsOfCheaters, BridgeHandDescription bhdCheaters) {
        if (seatsOfCheaters != null && seatsOfCheaters.size() > 0 && bhdCheaters != null && isCheatPossibile(seatsOfCheaters, bhdCheaters)) {
            this.doCheat = true;
            this.seatsOfCheaters = seatsOfCheaters;
            this.bhdCheaters = bhdCheaters;
        }
    }


    public boolean isCheatPossibile(ArrayList<Seat> seatsOfCheaters, BridgeHandDescription bhdCheaters) {
        if ((bhdCheaters.HCPoints * seatsOfCheaters.size() > 40) ||
                (bhdCheaters.totalPoints * seatsOfCheaters.size() > 40) ||
                (bhdCheaters.numberOfCardsInClubs * seatsOfCheaters.size() > 13) ||
                (bhdCheaters.numberOfCardsInDiamonds * seatsOfCheaters.size() > 13) ||
                (bhdCheaters.numberOfCardsInHearts * seatsOfCheaters.size() > 13) ||
                (bhdCheaters.numberOfCardsInSpades * seatsOfCheaters.size() > 13))
            return false;
        else
            return true;
    }

    public void disableCheat() {
        this.doCheat = false;
    }

    public ArrayList<Seat> getSeatsOfCheaters() {
        return seatsOfCheaters;
    }

    public void setSeatsOfCheaters(ArrayList<Seat> seatsOfCheaters) {
        this.seatsOfCheaters = seatsOfCheaters;
    }

    public BridgeHandDescription getBhdCheaters() {
        return bhdCheaters;
    }

    public void setBhdCheaters(BridgeHandDescription bhdCheaters) {
        this.bhdCheaters = bhdCheaters;
    }

    public void shuffleDeck() {
        long seed = System.nanoTime();
        Collections.shuffle(deck.cards, new Random(seed));
        Collections.shuffle(deck.cards, new Random(seed));
    }

    public void distributeAllCardsToSeats(ArrayList<Seat> seats) {
        int numberOfPlayer = seats.size();
        int numberOfCardsPerHand = deck.cards.size() / numberOfPlayer;
        if (deck.cards.size() % numberOfPlayer != 0) {
            log.error("number of player not compatible with deck size");
            return;
        }

        if (doCheat) {
            for (Seat seat : seatsOfCheaters) {
                Hand hand = new Hand();
                do {
                    shuffleHandInDeck(hand);
                    hand = createHandFromDeck(numberOfCardsPerHand);
                } while (!BridgeHandDescriptor.isBridgeHandDescriptionSuperior(bhdCheaters,
                        BridgeHandDescriptor.getBridgeHandDescription(hand)));
                seat.getPlayer().setHand(hand);
            }
        }

        for (Seat seat : seats) {
            if (!seatsOfCheaters.contains(seat)) {          //cheaters have already received their hands
                Hand hand;
                hand = createHandFromDeck(numberOfCardsPerHand);
                seat.getPlayer().setHand(hand);
            }
        }
    }


    public Hand createHandFromDeck(int numberOfCardsPerHand) {
        Hand hand = new Hand();
        for (int j = 0; j < numberOfCardsPerHand; j++) {
            hand.addCard(deck.removeCard());
        }
        return hand;
    }

    public void shuffleHandInDeck(Hand hand) {
        this.deck.cards.addAll(hand.getCards());
        shuffleDeck();
    }


}
