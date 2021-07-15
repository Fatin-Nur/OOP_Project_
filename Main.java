//import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Score score1 = new Score();
		score1.addScore(90);
		score1.addScore(100);
		score1.addScore(80);
		score1.displayScore();
		//edit the score from 1000 to 50
		score1.editScore(1, 50);
		System.out.println("Edited score: ");
		score1.displayScore();
		//delete the first score = 90
		score1.deleteScore(0);
		System.out.println("Edited score (After deletion): ");
		score1.displayScore();
	}

}