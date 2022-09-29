/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package keyron.declare.model.card;




/**
 *
 * @author andrea
 */
public class Card implements Comparable{

    
    private CardSuits suit;
    private CardValues value;
    

    public Card(CardSuits suit, CardValues value) {
        this.suit = suit;
        this.value = value;
    }
    

    public CardSuits getSuit() {
        return suit;
    }

    public void setSuit(CardSuits suit) {
        this.suit = suit;
    }

    public CardValues getValue() {
        return value;
    }

    public void setValue(CardValues value) {
        this.value = value;
    }

    public String toString() {
        return suit.getSuit()+value.toString();
    }

    @Override
    public int compareTo(Object o) {
          if (o instanceof Card){
              if (this.getSuit().getSuit() > ((Card) o).getSuit().getSuit()){
                      return 1;
              }
              else  if (this.getSuit().getSuit() < ((Card) o).getSuit().getSuit()){
                    return -1;
              }
              else if (this.getValue() != ((Card) o).getValue()) {
                 return (this.getValue().getIntValue() > ((Card) o).getValue().getIntValue() ? 1:-1);

              }
          }
        return 0;
    }
}