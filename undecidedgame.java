package undecidedgame;

public class undecidedgame {
	
	private int turnsPassed = 1;
	private boolean gameOver = false;
	private player one = new player("one");
	private player two = new player("two");
	private int xRoll; // value holder. determines attack and defense
	private int yRoll; // value holder. determines attack and defense
	private int xAD; // value holder for attack
	private int yAD; // value holder for attack
	
	public undecidedgame(player x, player y) { // void constructor, pretty much useless
		x = one;
		y = two;
	} 
	
	public String playGame(String n1, String n2) { // game method, takes two names for each player
		
		String ending = "";
		
		one.setName(n1);
		two.setName(n2);
		
	//	int oneHP = one.getHP(); // ignore these, i messed up so they are basically useless
	//	int twoHP = two.getHP(); // ignore these, i messed up so they are basically useless
		
		while (gameOver == false && turnsPassed <= 10) {
			// System.out.println("This is turn " + turnsPassed + "! Player one has " + oneHP + " health and two has " + twoHP + " health.");
			gameTurn();
			
			if (one.getHP() <= 0 && two.getHP() <= 0) {
				ending = "The match has ended in a draw. Player one has " + one.getHP() + " health remaining, and Player two has " + two.getHP() + " remaining.";
				gameOver = true;
			}
			
			else if (one.getHP() <= 0) {
				ending = "Player one is victorious. Player one has " + one.getHP() + " health remaining, and Player two has " + two.getHP() + " remaining.";
				gameOver = true;
			}
			
			else if (two.getHP() <= 0) {
				ending = "Player two is victorious. Player one has " + one.getHP() + " health remaining, and Player two has " + two.getHP() + " remaining.";
				gameOver = true;
			}
			
			turnsPassed++;
		}
		
		if (ending.equals("") == true) {
			return "It seems there is no clear winner." + n1 + " is left with " + one.getHP() + " HP, and " + n2 + " is left with " + two.getHP() + " HP.";	
		}
		
		else {
			return ending;
		}
		
	}
	
	private void gameTurn() { // done?
		
		action(one, two);
		
		xAD = one.getAD();
		yAD = two.getAD();
		
		if (diceRoll() > 8) { // determining if it is a critical round
			if (one.getAction() == true) {
				System.out.println(one.getName() + " has critically hit!!");
				two.setHP(two.getHP() - (xAD*2)); // critically reduces HP of two by one's AD if one is attacking
			}
			if (two.getAction() == true) {
				System.out.println(two.getName() + " has critically hit!!");
				one.setHP(one.getHP() - (yAD*2)); // critically reduces HP of one by two's AD if two is attacking 
			}
		}
		else {
			
			if (one.getAction() == true) {
				two.setHP(two.getHP() - xAD); // reduces HP of two by one's AD if one is attacking
			}
		
			if (two.getAction() == true) {
				one.setHP(one.getHP() - yAD); // reduces HP of one by two's AD if two is attacking 
			}
		}
	}
	
	private void action(player x, player y) { // method to determine whether the CPUs will attack or defend and what their numbers are
		
		xRoll = diceRoll();
		yRoll = diceRoll();
		
		if (xRoll > 5) {
			x.setAction(true);
			x.setAD(xRoll);
			System.out.println(turnsPassed + ": It seems " + x.getName() + " is preparing to attack with " + xRoll + " damage!");
		}
		
		if (yRoll > 5) {
			y.setAction(true);
			y.setAD(yRoll);
			System.out.println(turnsPassed + ": It seems " + y.getName() + " is preparing to attack with " + yRoll + " damage!");
		}
		
		if (xRoll <= 5) { // these have to go after, they are based on if the other person is going to attack.
			x.setAction(false);
			System.out.println(turnsPassed + ": It seems " + x.getName() + " is looking to defend.");
			if (y.getAction()) {
				System.out.println(yRoll);
				y.setAD(yRoll/2);
				System.out.println(x.getName() + " sucessfully defends!");
			}
		}
		
		if (yRoll <= 5) {
			y.setAction(false);
			System.out.println(turnsPassed + ": It seems " + y.getName() + " is looking to defend.");
			if (x.getAction()) {
				System.out.println(xRoll);
				x.setAD(xRoll/2);
				System.out.println(y.getName() + " sucessfully defends!");
			}
		}
		
		//x.setAction(false); // fix these, game doesn't work with these here
		//y.setAction(false); //
		
	}
	
	public static int diceRoll() { // done
		int roll = (int) ((Math.random()*10) + 1);
		return roll;
	}
	
	public static void main (String args[]) {
		//System.out.println("Hi hi, I made a game");
		
		player cpu1 = new player("Jack");
		player cpu2 = new player("Jak");
		
		//System.out.println(cpu1.getName());
		//System.out.println(cpu2.getName());
		
		undecidedgame gameOne = new undecidedgame(cpu1, cpu2);
		System.out.println(gameOne.playGame("sand", "rain"));
		
		//System.out.println(cpu1.getAction());
		//System.out.println(cpu2.getAction());
		//System.out.println(cpu1.getAD());
		//System.out.println(cpu2.getAD());
		
		//gameOne.action(cpu1, cpu2);
		
		//System.out.println(cpu1.getAction());
		//System.out.println(cpu2.getAction());
		//System.out.println(cpu1.getAD());
		//System.out.println(cpu2.getAD());
		
		
		//System.out.println(cpu1.getName());
		//System.out.println(cpu2.getName());
		
	}
}

class player {
	
	private String name;
	public int health;
	public int luck; // probably will not be used in this iteration of uG
	private int attack;
	private boolean actions; // true = attack, false = defend
	
	public player () {}
	
	public player (String n) {
		
		name = n;
		health = 25;
		luck = 0;
		attack = 0;
	}
	
	public String getName() {
		return name;
	}

	public int getHP() {
		return health;
	}
	
	public int getLuck() {
		return luck;
	}

	public int getAD() {
		return attack;
	}

	public boolean getAction() {
		return actions;
	}
	
	public void setName(String n) {
		name = n;
	}

	public void setHP(int h) {
		health = h;
	}
	
	public void setLuck(int l) {
		luck = l;
	}

	public void setAD(int a) {
		attack = a;
	}
	
	public void setAction(boolean act) {
		actions = act;
	}
	
}



