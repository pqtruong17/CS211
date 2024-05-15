import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Gradebook implements Comparator<StudentGrades>{
	public int compare(StudentGrades left, StudentGrades right){
		return (int)(left.totalScore()-right.totalScore());
	}

	//provided
	public String toString(){
		String rv = "Grades: [ ";
		for(StudentGrades sg : grades){
			rv += "("+sg.getStudentName()+": "+sg.letterGrade()+"), ";
		}
		rv += "]\n";
		rv += "Max: "+max()+", Median: "+median()+", Average: "+average()+", Min: "+min();
		return rv;
	}

}