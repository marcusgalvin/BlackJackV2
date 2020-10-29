
public class Dealer {
	private String name;
	private Deck dealerHand;
	
	public Dealer(String name, Deck dealerHand) {
		this.name = name;
		this.dealerHand = dealerHand;		
	}
	
	private Deck buildDealerHand() {
		Deck dealerHand = new Deck();
		return dealerHand;
	}
	
	public Deck getDealerHand() {
		return this.dealerHand();
	}
	
	public Deck getDealerName() {
		return this.name;
	}

}
