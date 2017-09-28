package certification.chapter1.equals_hashcode_tostring;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Serhii K. on 2/1/2016.
 */
public class Card {

    private String rank;
    private String suit;

    public Card(String r, String s) {
        if (r == null || s == null) throw new IllegalArgumentException();
        rank = r;
        suit = s;
    }

    // auto generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        if (!rank.equals(card.rank)) return false;
        return suit.equals(card.suit);
    }

    //    public boolean equals(Object obj) {
//        if (!(obj instanceof Card)) return false;
//        Card c = (Card) obj;
//        return rank.equals(c.rank) && suit.equals(c.suit);
//    }

//    public int hashCode() {
//        //return rank.hashCode();
//        return HashCodeBuilder.reflectionHashCode(this);
//        /*return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
//                // if deriving: appendSuper(super.hashCode()).
//                append(rank).
//                append(suit).
//                toHashCode();*/
//    }

    @Override
    public int hashCode() {
        int result = rank.hashCode();
        result = 31 * result + suit.hashCode();
        return result;
    }

    public static void main(String[] args) {
        Card card1 = new Card("rank1", "suit1");
        System.out.println(card1.hashCode());
    }
}
