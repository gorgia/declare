package com.declare.table;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 4/21/13
 * Time: 5:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Seat {
    Directions direction;
    Player player = null;

    public Seat(Directions direction){
        this.direction = direction;
    }

    public Player getPlayer(){
        return this.player;
    }

    public boolean isEmpty(){
        if (player == null){
            return true;
        }
        return false;
    }
}
