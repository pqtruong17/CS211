import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Gradebook implements Comparator<StudentGrades> {
	/*
	 * This class should have a single private field, a Collection parameterized for
	 * StudentGrades instances. You must determine the correct generic syntax for
	 * this field's type. The name of this field must be grades.
	 */
	private Collection<StudentGrades> grades;

	public int compare(StudentGrades left, StudentGrades right) {
		return (int) (left.totalScore() - right.totalScore());
	}

	/*
	 * This class should have a single public constructor which takes no arguments
	 * and initializes the grades field to be a new empty instance of ArrayList with
	 * the appropriate generic type parameter specified (The signature constructor
	 * is public Gradebook())
	 */
	public Gradebook() {
		grades = new ArrayList<StudentGrades>();
	}

	/*
	 * This method, addGrade(...), takes a single StudentGrades parameter and adds
	 * it to the grades field.
	 */
	public void addGrade(StudentGrades grade) {
		grades.add(grade);
	}

	/*
	 * This method, average(), computes the average totalScore() of each
	 * StudentGrades in the grades field.
	 */
	public double average() {
		if (grades.isEmpty()) {
			return 0.0;
		}
		double total = 0.0;
		for (StudentGrades grade : grades) {
			total += grade.totalScore();
		}
		return total / grades.size();
	}

	/*
	 * If no such min then return null, otherwise 
	 * Ultilzed Collections method min to find the lower bound element StudentGrades of Gradebook
	 * @return the minimum element StudentGrades of Gradebook
	 */
	public StudentGrades min() {
		return Collections.min(grades, new Gradebook());

	}
	/*
	 * If no such max then return null, otherwise 
	 * Ultilzed Collections method max to find the upper bound element StudentGrades of Gradebook
	 * @return the maximum element StudentGrades of Gradebook
	 */
	public StudentGrades max() {
		if (grades.isEmpty()) {
			return null;
		}
		return Collections.max(grades, new Gradebook());
	}

	/*
	 * Add a method, median(), which finds the StudentGrades instance in the grades
	 * field corresponding with the median totalScore(). The median is defined to be
	 * the value such that half of values in the collection are above, and half are
	 * below.
	 */
	public StudentGrades median() {
		if (grades.isEmpty()) {
			return null;
		}
		List<StudentGrades> scores = new ArrayList<StudentGrades>(grades);
		scores.sort((a, b) -> compare(a, b));
		return scores.get(scores.size()/ 2);
	}

	// provided
	public String toString() {
		String rv = "Grades: [ ";
		for (StudentGrades sg : grades) {
			rv += "(" + sg.getStudentName() + ": " + sg.letterGrade() + "), ";
		}
		rv += "]\n";
		rv += "Max: " + max() + ", Median: " + median() + ", Average: " + average() + ", Min: " + min();
		return rv;
	}
}