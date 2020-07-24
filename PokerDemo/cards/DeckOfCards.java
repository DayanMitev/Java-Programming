package cards;// Fig. 7.10: cards.DeckOfCards.java
// cards.DeckOfCards class represents a deck of playing cards.
import java.util.Arrays;
import java.util.Random;

public class DeckOfCards {
   private Card[] deck; // object of Card to make a deck
   private int currentCard; //shows the index of the next card
   private final int NUMBER_OF_CARDS = 52; //the total number of cards
   private Random randomNumbers; // will help with having the random deals


   //помощни масиви от конструктора
   private String faces[] = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
           "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
   private String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};


   // constructor fills deck of Cards
   public DeckOfCards() {
      deck = new Card[NUMBER_OF_CARDS];
      currentCard = 0;
      randomNumbers = new Random();

      for(int counter = 0; counter < deck.length; counter++)
      {
         deck[counter]
                 = new Card(faces[counter%13], suits[counter / 13]);
      }
   } // end cards.DeckOfCards constructor

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle() {
      // after shuffling, dealing should start at deck[ 0 ] again
      currentCard = 0; // reinitialize currentCard

      // for each cards.Card, pick another random cards.Card and swap them
      for (int first = 0; first < deck.length; first++) {
         // select a random number between 0 and 51 
         int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

         // swap current cards.Card with randomly selected cards.Card
         Card temp = deck[first];
         deck[first] = deck[second];
         deck[second] = temp;
      } // end for
   } // end method shuffle

   // deal one cards.Card
   public Card dealCard() {
      // determine whether Cards remain to be dealt
      if (currentCard < deck.length)
         return deck[currentCard++]; // return current cards.Card in array
      else
         return null; // return null to indicate that all Cards were dealt
   } // end method dealCard

   //раздаване на 5 карти
   public Card[] dealHand() {
      Card[] hand = new Card[5];

      for (int i = 0; i < 5; i++) {
         hand[i] = dealCard();
      }
      return hand;
   }

   //помощен метод, който връща масив от 13 елемента, всеки от които е броя
   // на картите със съответна сила
   //в дадено раздаване Card hand[] - например, първият елемент на този
   // масив ще дава броя на асата в раздаването,
   //десетият елемент ще е броят на десетките в раздаването и т.н.
   private int[] totalHand(Card hand[]) {
      int numbers[] = new int[faces.length];

      for (int i = 0; i < hand.length; i++) {
         for (int j = 0; j < 13; j++) {
            if (hand[i].getFace().equals(faces[j])) {
               ++numbers[j];
            }
         }
      }

      return numbers;
   }

   // метод за определяне на брой чифтове
   public int pairs(Card hand[]) {
      int couples = 0;
      int numbers[] = totalHand(hand);

      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] == 2) {
            ++couples;
         }
      }

      return couples;
   }

   // метод за определяне на чифт
   public boolean pair(int couples) {
      if (couples == 1) {
         //System.out.println("Чифт\n");
         return true;
      }
      return false;
   }

   //метод за определяне на два чифта
   public boolean twoPairs(int couples) {
      if (couples == 2) {
         //System.out.println("Два чифта\n");
         return true;
      }
      return false;
   }

   // метод за определяне на терца
   public int three(Card hand[]) {
      int numbers[] = totalHand(hand);

      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] == 3) {
            return 1;
            // може директно да върнем 1, тъй като няма да срещнем повече от една тройка.
         }
      }

      return 0;
   }

   // метод за определяне на терца
   public boolean triple(int triples) {
      if (triples == 1) {
         //System.out.println("Три карти\n");
         return true;
      }
      return false;
   }

   // четири карти с еднаква сила
   public boolean four(Card hand[]) {
      int numbers[] = totalHand(hand);

      for (int i = 0; i < faces.length; i++) {
         if (numbers[i] == 4) {
            //System.out.printf("Четири карти %s\n", faces[i]);
            return true;
         }
      }
      return false;
   }

   //карти с еднаква боя
   public boolean flush(Card hand[]) {
      String suit = hand[0].getSuit();

      for (int i = 1; i < hand.length; i++) {
         if (!hand[i].getSuit().equals(suit)) {
            return false;
         }
      }

      //System.out.printf("Карти с еднаква боя %s\n", suit);
      return true;
   }

   // пет последователни карти
   public boolean straight(Card hand[]) {
      int locations[] = new int[5]; //индексите на картите,
      // които се срещат веднъж А=0, 2=1, т.н.
      int l = 0;
      int numbers[] = totalHand(hand);

      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] == 1) {
            locations[l++] = i;
         }
         if (numbers[i] > 1) return false;
      }

      //System.out.println(Arrays.toString(locations));

      // Проверка за случай 0, 9, 10, 11, 12 -> А, 10, J, Q, K
      if (locations[0] + 4 == locations[4] ||
              (locations[0] == 0 && locations[4] == 12 &&
                      locations[1] + 3 == locations[4]))
         return true;
      return false;

   }

   // пълна къща
   public boolean fullHouse(int couples, int triples) {
      if (couples == 1 && triples == 1) {
         //System.out.println("Пълна къща\n");
         return true;
      }
      return false;
   }

   public static int getCard() {
      return (int) (Math.random() * 52);
   }

   public  String revealCard(int cardNum) {
      int suitNum = cardNum / 13;
      int faceNum = cardNum % 13;

      return faces[faceNum] + " of " + suits[suitNum];
   }




   public void collectorProblem() {
      boolean spades = false;
      boolean hearts = false;
      boolean diamonds = false;
      boolean clubs = false;
      int numberOfPicks = 0;//total number of card collected
      String[] cardSequence = new String[4];

      while (!spades || !hearts || !diamonds || !clubs) {
         String card = revealCard(getCard());
         numberOfPicks++;

         if (card.contains("Spades") && !spades) {
            cardSequence[currentCard++] = card;
            spades = true;
         } else if (card.contains("Hearts") && !hearts) {
            cardSequence[currentCard++] = card;
            hearts = true;
         } else if (card.contains("Diamond") && !diamonds) {
            cardSequence[currentCard++] = card;
            diamonds = true;
         } else if (card.contains("Clubs") && !clubs) {
            cardSequence[currentCard++] = card;
            clubs = true;
         }
      }
         for (int i = 0; i < cardSequence.length; i++) {
            System.out.println(cardSequence[i]);
         }
         System.out.println("Number Of Pick: " + numberOfPicks);
      System.out.println();
   }
} // end class cards.DeckOfCards


