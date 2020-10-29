
public class Dealer {
	private String name;
	private Deck dealerHand;
	
	public Dealer(String name, Deck dealerHand) {
		this.name = name;
		this.dealerHand = dealerHand;		
	}
	
	private Deck buildHand() {
		Deck dealerHand = new Deck();
		return dealerHand;
	}
	
	public Deck getHand() {
		return this.dealerHand;
	}
	
	public String getName() {
		return this.name;
	}

}
