package com.declare.table;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 4/21/13
 * Time: 5:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Table {
    private static final Logger log = LoggerFactory.getLogger(Table.class);
    private ArrayList<Seat> seats= new ArrayList<Seat>();
    Dealer dealer;
    int numberOfPlayers = 0;
    
    

    public Table(int numberOfPlayers){
        prepareTable();
        dealer = new Dealer();
    }

    public Dealer getDealer(){
       return this.dealer;
    }

    public void startRound(){
        if (this.isTableFull()){
            dealer.shuffleDeck();
            dealer.distributeAllCardsToSeats(seats);
        }
    }

    private void prepareTable(){
        seats.add(new Seat(Directions.SUD));
        seats.add(new Seat(Directions.WEST));
        seats.add(new Seat(Directions.NORTH));
        seats.add(new Seat(Directions.EST));
    }

    public boolean isTableFull(){
        for (Seat seat : seats){
            if (seat.isEmpty())
                return false;
        }
        return true;
    }


    public Seat getSeat(Directions direction){
         for (Seat seat: seats){
             if (seat.direction == direction)
                 return seat;
         }
        log.error("no seats?");
         return null;
    }

    public ArrayList<Seat> getSeats (){
        return seats;
    }


    public void occupySeat(Player player, Directions direction){
         getSeat(direction).player = player;
    }


    public boolean occupyEmptySeat(Player player){
        for (Seat seat: seats){
            if (seat.player == null) {
                seat.player = player;
                return true;
            }
        }
        return false;
    }



}
