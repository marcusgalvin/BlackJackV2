import java.util.Scanner;

public class User implements Users{
	
	private String name;
	int playerBet;
	private int balance;
	private Deck playerHand = new Deck();

	
	public User(String name, int balance, Deck playerHand) {
		this.name = name;
		this.balance = balance;
		this.playerHand = playerHand;
	}

	private Deck buildHand(Deck playerHand) {
		playerHand = new Deck();
		return playerHand;		
	}
	
	public Deck getHand() {
		return this.playerHand;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public int getHandValue() {
		return this.playerHand.cardsValue();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int willHit(Scanner userInput) {
		int playerResponse = userInput.nextInt();
		return playerResponse;
	}
	
	public int takeBet(Scanner playerBet) {
		int playerBet1 = playerBet.nextInt();
		return playerBet1;
	}

	@Override
	public Deck buildHand() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
