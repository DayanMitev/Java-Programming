package cards;// Fig. 7.9: cards.Card.java
// cards.Card class represents a playing card.

public class Card 
{
   private String face;
   private String suit;

   public Card(String cardFace, String cardSuit)
   {
      face = cardFace;
      suit = cardSuit;
   }

   public String getFace()
   {
      return face;
   }

   public String getSuit()
   {
      return suit;
   }

   public String toString() {
      return face + "of" + suit;
   }
}
// end class cards.Card

