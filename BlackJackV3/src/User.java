
public class User {
	
	private String name;
	private int balance;
	private Deck playerHand;
	
	public User(String name, int balance, Deck playerHand) {
		this.name = name;
		this.balance = balance;
		this.playerHand = playerHand;
	}

	private Deck buildHand() {
		Deck playerHand = new Deck();
		return playerHand;		
	}
	
	public Deck getHand() {
		return this.playerHand;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public String getName() {
		return this.name;
	}
	
}
