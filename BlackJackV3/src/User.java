
public class User {
	
	private String name;
	private int balance;
	private Deck userHand;
	
	public User(String name, int balance, Deck userHand) {
		this.name = name;
		this.balance = balance;
		this.userHand = userHand;
	}

	private Deck buildUserHand() {
		Deck userHand = new Deck();
		return userHand;		
	}
	
	public Deck getUserHand() {
		return this.userHand;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public String getName() {
		return this.name;
	}
	
}
