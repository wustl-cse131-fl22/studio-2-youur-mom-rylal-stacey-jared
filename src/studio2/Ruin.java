package studio2;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double startAmount, winChance, winLimit, amountWins, amountLoss, expRuinRate, actRuinRate, a, attempts, totalWins, totalLoss;
		int totalSimulations;
		startAmount = 2;
		winChance = .7;
		winLimit = 10;
		totalSimulations = 1;
		amountLoss = 0;
		amountWins = 0;
		a = (1- winChance)/winChance;
		expRuinRate = ((Math.pow(a, startAmount))- (Math.pow(a,  winLimit)))/(1- Math.pow(a, winLimit));
		attempts = 0;
		totalWins = 0;
		totalLoss = 0;
		
		
		
	while (totalSimulations<=500) {
		
		
		while(startAmount<=winLimit && startAmount>=0) {
			double random = Math.random();
			boolean chance = (random <= winChance);
			
			//you win
			if(chance && startAmount>0) {
				startAmount++;
				amountWins++;
				attempts++;	
			} 
			else if (!chance && startAmount>=0){
				//you lost
				startAmount = startAmount - 1;
				amountLoss++;
				attempts++;
			}
			
			if (startAmount==winLimit) {
				System.out.println("Simulation: " + totalSimulations + "  SUCCES!! Attempts: " + attempts + " Wins: " + amountWins + " Losses: " + amountLoss);
				totalWins++;
			} else if (startAmount<0) {
				System.out.println("Simulation: " + totalSimulations + "  Damn, you lost broke bitch, ruin. Attempts: " + attempts + " Wins: " + amountWins + " Losses: " + amountLoss);
				totalLoss++;
		}
			
		}
		totalSimulations++;
		amountWins = 0;
		amountLoss = 0;
		attempts = 0;
		startAmount = 2;
	
	}
		//if (startAmount==winLimit) {
		//System.out.println("SUCCESS!!!");
//	} 
	//	else {
	//	System.out.print("Damn, you lost broke bitch, ruin");
	//}
		actRuinRate = totalLoss/500;
		System.out.println();
		System.out.println("Simulations: " + totalSimulations + " Wins: " + (totalSimulations-totalLoss) + " " + "Losses: " + totalLoss); 
		System.out.print("Actual Ruin Rate: " + actRuinRate + " Expected Ruin Rate: " + expRuinRate);
		
		
	} 

}
