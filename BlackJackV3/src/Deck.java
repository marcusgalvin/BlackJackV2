import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> cards;
	
	//deck const
	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	
	public void buildDeck() {
		//generate cards
		for(Suit cardSuit : Suit.values()) {
			for(Value cardValue : Value.values()) {
				//add a new card to the deck
				this.cards.add(new Card(cardSuit, cardValue));
			}
		}
	}
	
	
	//awesome built in shuffle method
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public int deckSize() {
		return this.cards.size();
	}
	
	public String toString() {
		String allCards = "";
		//counter
		for(Card aCard : this.cards) {
			allCards += "\n" + aCard.toString();
		}
		return allCards;
	}
	
	public void addCard(Card addCard) {
		this.cards.add(addCard);
	}
	
	public void removeCard(int i) {
		this.cards.remove(i);
	}
	
	public Card getCard(int i) {
		return this.cards.get(i);
	}
	//pull from deck
	public void draw(Deck currentGameDeck) {
		//pull top card
		this.cards.add(currentGameDeck.getCard(0));
		currentGameDeck.removeCard(0);
	}
	
	
	
	//empty deck by moving all cards into tempDeck
	public void dealerCollectCards(Deck dealerCollect) {
		int tempDeck = this.cards.size();
		
		//put cards into temp deck
		for(int i = 0; i < tempDeck; i++) {
			dealerCollect.addCard(this.getCard(i));
		}
		//remove all from temp deck
		for(int i = 0; i < tempDeck; i++) {
			this.removeCard(0);
		}
	}
	
	//return total value cards in deck to get ace value
	public int cardsValue() {
		int totalValue = 0;
		int aces = 0;
		
		for(Card aCard : this.cards) {
			switch(aCard.getValue()) {
			case TWO: totalValue +=2; break;
			case THREE: totalValue += 3; break;
			case FOUR: totalValue += 4; break;
			case FIVE: totalValue += 5; break;
			case SIX: totalValue += 6; break;
			case SEVEN: totalValue += 7; break;
			case EIGHT: totalValue += 8; break;
			case NINE: totalValue += 9; break;
			case TEN: totalValue += 10; break;
			case JACK: totalValue += 10; break;
			case QUEEN: totalValue +=10; break;
			case KING: totalValue += 10; break;
			case ACE: aces += 1; break;
			}
		}
		
		//ace value formatting
		for(int i = 0; i < aces; i++) {
			if(totalValue > 10) {
				totalValue += 1;
			} else {
				totalValue += 11;
			}
		}
		return totalValue;
	}

}
