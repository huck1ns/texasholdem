package texasholdem;

public class Player  {
	
	public boolean fold = false;
	//static Pot Money = new Pot();
	public int balance = 1000;
	public Hand hand;
	public static int prevBet;
	public int[] currentBest;
	private final Game game;
	public final String name = "Player";
	
	
	Player(Game game){
		this.game=game;
	}
	
	public void standHand() {
		fold = true;
	}
	public void foldHand(boolean fold) {
		
	}
	
	//Will run all methods required for the player to play the round
	
	public String play(int n) {
		//Add code so that everytime a round starts, other than the start of the round, the player has an option to just checks
		/*if(Game.miniRound == 1) {
			if(buyIn() == 0) {
				Game.remove = true;
			}
		}else {
			if(wantToContinue() == true) {
			Game.remove = true;
			
			code is able to have it so buyIn only occurs in first mini round and every other round will ask if the player wants to fold
			
			ABOVE CODE WORKS BUT CONFLICTS WITH CURRENT GAME
			WILL MAKE IT BOTS AFTER CANNOT BET/PLAY THE GAME
			*/
				if (game.miniRound>1) {
					
					hand.combineHand();
					setCurrentBest();
				}
				return makeBet(n);
			}
	

	private void setCurrentBest() {
		this.currentBest=Bot.findHand(Bot.findBest(hand.combinedHand));

	}
	
	public String makeBet(int betAmount) {
		if (betAmount==0) return "You check! \n";
		balance = balance - betAmount;
		game.pot.addBet(betAmount);
		prevBet = betAmount;
		
		return ("You bet "+betAmount+" chips!\n");
	}
	
	public void makeHand() {
		this.hand=new Hand(game);
	}
	
	public int buyIn() {
		return 0;
	}

	public void check() {
		makeBet(0);
	}

	public String call() {
		int high = game.pot.highestBet(); //idk why this doesnt work
		return makeBet(high);
	}

	//Asks player if they want to call

}

