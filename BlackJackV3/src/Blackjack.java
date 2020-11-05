import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		
		//init game deck and shuffle
		Deck gameDeck = new Deck();
		gameDeck.buildDeck();
		gameDeck.shuffle();
		
				
		//player hand
		Deck playerHand = new Deck();
		//dealer hand
		Deck dealerHand = new Deck();
		
		User userOne = new User("Marcus", 500, playerHand);	
		Dealer dealerOne = new Dealer("Dealer Jim", dealerHand);
		
		int playerBalance = userOne.getBalance();
		
		Scanner userInput = new Scanner(System.in);
		
		//game loop as long as player has cash in acc
		while(playerBalance > 0) {
			System.out.println("Balance " + playerBalance + "\n" + "Enter bet amount: ");
			
			int playerBet = userInput.nextInt();
			if(playerBet > playerBalance) {
				System.out.println("Insufficient Funds!");
				break;
			}
			
			boolean endCurrentRound = false;
			
			//deal
			//player gets two cards
			playerHand.draw(gameDeck);
			playerHand.draw(gameDeck);

			//dealer two cards
			dealerHand.draw(gameDeck);
			dealerHand.draw(gameDeck);
			
			while(true) {
				System.out.println(userOne.getName() + "'s hand: " + playerHand.toString());
				System.out.println("Your hand's Value: " + userOne.getHandValue());
				
				//dealer
				System.out.println(dealerOne.getName() + "'s Hand: " + dealerHand.getCard(0).toString() + " and " +  "[UpsideDown Card]");
				
				//player actions
				System.out.println("Press 1 to hit, Press 2 to stay");
				int playerResponse = userInput.nextInt();
				if(playerResponse == 1) {
					playerHand.draw(gameDeck);
					System.out.println("You drew a: " + playerHand.getCard(playerHand.deckSize() - 1).toString());
					//if over 21, bust
					
					if(playerHand.cardsValue() > 21) {
						System.out.println("You busted! Your hand is over 21!");
						playerBalance -= playerBet;
						endCurrentRound = true;
						break;
					}
				}
				
				if(playerResponse == 2) {
					break;
				}
			}
			
			
			if(dealerHand.cardsValue() > playerHand.cardsValue() && endCurrentRound == false) {
				System.out.println("Dealer Wins");
				playerBalance -= playerBet;
				endCurrentRound = true;
			}
			//dealer will stand at 17 or over
			while(dealerHand.cardsValue() < 17 && endCurrentRound == false) {
				dealerHand.draw(gameDeck);
				System.out.println("Dealer draws: " + dealerHand.getCard(dealerHand.deckSize()-1).toString());
			}
			//display dealer total
			System.out.println("Dealers hand value: " + dealerHand.cardsValue());
			
			//did dealer bust
			if(dealerHand.cardsValue() > 21 && endCurrentRound == false) {
				System.out.println("Dealer busts! and You Win");
				playerBalance += playerBet;
				endCurrentRound = true;
			}
			
			//tie(push)
			if(playerHand.cardsValue() == dealerHand.cardsValue() && endCurrentRound == false) {
				System.out.println("Tie (push, everyone gets their money back)");
				endCurrentRound = true;
			}
			
			//player blackjack
			if(playerHand.cardsValue() == 21) {
				System.out.println("BLACKJACK! You Win");
				playerBet += playerBalance;
				endCurrentRound = true;
			}
			
			if(playerHand.cardsValue() > dealerHand.cardsValue() && endCurrentRound == false) {
				System.out.println("You win, you beat the dealer!");
				playerBalance += playerBet;
				endCurrentRound = true;
			}
			
			//dealer blackjack
			if(dealerHand.cardsValue() == 21 && endCurrentRound == false) {
				System.out.println("Dealer hit BlackJack, You Lose!");
				playerBalance -= playerBet;
				endCurrentRound = true;
			}
			
			//move cards back into deck
			playerHand.dealerCollectCards(gameDeck);
			dealerHand.dealerCollectCards(gameDeck);
			System.out.println("Round Complete");

			
		}
		System.out.println("GAME OVER: You got Cleaned!");
		
		
//		System.out.println(playingDeck);


	}

}
