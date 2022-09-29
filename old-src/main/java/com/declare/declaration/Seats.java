package com.declare.declaration;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 4/25/13
 * Time: 8:25 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Seats {
    SEAT1(1),SEAT2(2),SEAT3(3), SEAT4(4);

    int position;

    Seats(int position){
       this.position = position;
    }

    public int getSeatPosition(){
        return position;
    }
}
