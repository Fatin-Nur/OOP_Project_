import java.util.ArrayList;

public class Score {
	
	// declare attributes
	protected ArrayList<Integer> score = new ArrayList<Integer>();
	
	// To add the score
	public void addScore(int marks) {
		score.add(marks);
	}
	
	// To edit the score
	public void editScore(int pos, int marks) {
		score.set(pos, marks);
	}
	
	// To delete the score
	public void deleteScore(int pos) {
		score.remove(pos);
	}
	
	// To display the score along with student id and course
	public void displayScore() {
		for (Integer element: score) {
			System.out.println(element+"%");
		}
	}
	
}