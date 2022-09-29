package keyron.declare.model.bid;

class Bid{

    public enum BiddingType {
        C1 (1, "C"),D1 (1, "D"),H1(1, "H"), S1(1, "S"), NT1 (1 , "NT"),
        C2 (2, "C"),D2 (2, "D"),H2(2, "H"), S2(2, "S"), NT2 (2 , "NT"),
        C3 (3, "C"),D3 (3, "D"),H3(3, "H"), S3(3, "S"), NT3 (3 , "NT"),
        C4 (4, "C"),D4 (4, "D"),H4(4, "H"), S4(4, "S"), NT4 (4 , "NT"),
        C5 (5, "C"),D5 (5, "D"),H5(5, "H"), S5(5, "S"), NT5 (5 , "NT"),
        C6 (6, "C"),D6 (6, "D"),H6(6, "H"), S6(6, "S"), NT6 (6 , "NT"),
        C7 (7, "C"),D7 (7, "D"),H7(7, "H"), S7(7, "S"), NT7 (7 , "NT"),
        PASS("P"), DOUBLE ("X");

        int rank = 0;
        String suit;


        BiddingType(int rank, String suit) {
            this.rank = rank;
            this.suit = suit;
        }

        BiddingType (String passordouble){
            this.suit= passordouble;
        }
    }

    BiddingType bid;

    public Bid(BiddingType bid){
        this.bid = bid;
    }






}




