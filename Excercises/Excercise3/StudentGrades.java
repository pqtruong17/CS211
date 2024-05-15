import java.util.*;
/*
 * This class represents all of the grades for an individual student. 
 * It contains fields for storing these grades, 
 * methods for adding or modifying grades for individual assessments, 
 * logic for applying the grading rules as described by the syllabus, display methods, 
 * and useful helper methods to achieve these goals. 
 */
public class StudentGrades {
	
	/* 
	 * Per the syllabus, there are seven grading categories, participation, readings, labs, exercises, projects, the midterm exam, and the final exam.
	 */
	private double participation;
	private double midterm;
	private double finalExam; 
	private List<Double> readings = new ArrayList<Double>();
	private Collection<Double> labs = new ArrayList<Double>();
	private Collection<Double> exercises = new ArrayList<Double>();
	private Collection <Double> projects = new ArrayList<Double>();
	
	/*
	 * Each grading category has it's own weighting in the final grade calculation
	 */
	private double participationWeight;
	private double readingsWeight;
	private double labsWeight;
	private double exercisesWeight;
	private double projectsWeight;
	private double midtermWeight;
	private double finalExamWeight;
	
	/*
	 * And for display purposes, include String fields for the students name and G#
	 */
	private String studentName;
	private String gNumber;
	/**********************************************************************************************************************/
	
	/*
	 * A single constructor which pass the arguments: a student name, a student G#, and an array of doubles for the category weights
	 * to setters for the student name, G#, and weight array. 
	 */
	public StudentGrades(String name, String gNumber, double[] weights) {
		setStudentName(name);
		setGNumber(gNumber);
		setWeights(weights);
	}
	
	/**********************************************************************************************************************/
	/*
	 * Setter for student participation grade
	 */
	public void setParticipation(double participation) {
		this.participation = participation;
	}
	
	/*
	 * Setter for student midterm grade 
	 */
	public void setMidterm(double midterm) {
		this.midterm = midterm;
	}
	
	/*
	 * Setter for student finalExam grade
	 */
	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}
	
	/*
	 * Setter for student name
	 * @param name student input name
	 */
	public void setStudentName(String name) {
		this.studentName = name; 
		
	}
	
	/*
	 * Setter for student ID gNumber
	 */
	public void setGNumber(String gNumber) {
		this.gNumber = gNumber;
	}
	
	/*
	 * Assume that the weights are provided in the order given above 
	 * (participation, reading, labs, exercises, projects, midterm, final), 
	 * that they are between 0 and 1 and sum to 1.0.
	 * @param double[] the category weights from an array of doubles
	 */
	public void setWeights(double[] weights) {
		participationWeight = weights[0];
		readingsWeight = weights[1];
		labsWeight = weights[2];
		exercisesWeight = weights[3];
		projectsWeight = weights[4];
		midtermWeight = weights[5];
		finalExamWeight = weights[6];
		
	}
	/**********************************************************************************************************************/
	
	/*
	 * Getter for student participation grade
	 */
	public double getParticipation() {
		return this.participation;
	}
	/*
	 * Getter for student participation grade
	 */
	public double getMidterm() {
		return this.midterm;
	}
	/*
	 * @return student final exam grade
	 */
	public double getFinalExam() {
		return this.finalExam;
	}
	/*
	 * @return String student name
	 */
	public String getStudentName() {
		return this.studentName; 
		
	}
	/*
	 * Getter for student ID gNumber
	 * @return String student ID
	 */
	public String getGNumber() {
		return this.gNumber;
	}
	
	/**********************************************************************************************************************/
	/*
	 * Add reading score to readings List of double
	 * @param d reading score'
	 */
	public void addReading(double d) {
		readings.add(d); 
	}
	
	/*
	 * Add reading score to labs List of double
	 * @param d lab score
	 */
	public void addLab(double d) {
		labs.add(d); 
	}
	
	/*
	 * Add reading score to excercises List of double
	 * @param d excercise score
	 */
	public void addExercise(double d) {
		exercises.add(d); 
	}
	
	/*
	 * Add reading score to projects List of double
	 * @param d project score
	 */
	public void addProject (double d) {
		projects.add(d); 
	}
	/**********************************************************************************************************************/	
		
	/*
	 * Assume that scores are provided per subsection, therefore to calculate the score for the reading category, 
	 * you should add together all the scores - excluding the lowest 15 - 
	 * and then divide the result by the total number of scores minus 15.
	 * @return Double readings grades excluding the lowest 15 sections
	 */
	public double unweightedReadingsScore() {
		if (readings.size() < 16) {
			return 100.0;
		}
		readings.sort((a, b) -> Double.compare(a, b));
		List<Double> sublist = readings.subList(15, readings.size());
		double sums = 0;
		for(Double item:sublist) {
			sums += item;
		}
		return  sums/sublist.size();
	}
	/*
	 * Methods for calculating the score for the lab
	 * @return Double the average score of labs
	 */
	public double unweightedLabsScore() {
		if(labs.isEmpty()) {
			return 100.0;
		}
		double sums = 0;
		for(Double item: labs) {
			sums += item;
		}
		return sums/labs.size();
	}
	/*
	 * Methods for calculating the score for the excercises
	 * @return Double the average score of excercises
	 */
	public double unweightedExercisesScore() {
		if(exercises.isEmpty()) {
			return 100.0;
		}
		double sums = 0;
		for(Double item: exercises) {
			sums += item;
		}
		return sums/exercises.size();
	}
	/*
	 * Methods for calculating the score for the projects
	 * @return Double the average score of projects
	 */
	public double unweightedProjectsScore() {
		if(projects.isEmpty()) {
			return 100.0;
		}
		double sums = 0;
		for(Double item: projects) {
			sums += item;
		}
		return sums/projects.size();
	}
	/**********************************************************************************************************************/
	
	/*
	 * A method which returns true if the finalExam score is higher than the midterm score, 
	 * and false otherwise
	 * @return boolean whether or not final exam is greater than mid term grade. 
	 */
	public boolean finalReplacesMidterm() {
		return this.getFinalExam() > this.getMidterm();
	}
	/*
	 * A method which returns true if the finalExam score is passing 
	 * (greater than or equal to 60.0), and false otherwise. 
	 * @return boolean whether or not final is greater than 60
	 */
	public boolean finalIsPassing() {
		return this.getFinalExam() >= 60;
	}
	/* 
	 * A method which computes the total score by combining the weighted scores from each category.
	 * @return double total student grades
	 */
	public double totalScore() {
		double sums = 0;
		sums += this.getParticipation()*participationWeight;
		sums += this.unweightedReadingsScore()*readingsWeight;
		sums += this.unweightedLabsScore()* labsWeight;
		sums += this.unweightedExercisesScore()*exercisesWeight;
		sums += this.unweightedProjectsScore()*projectsWeight;
		sums += finalReplacesMidterm() ? this.getFinalExam()*midtermWeight:this.getMidterm()*midtermWeight;
		sums += this.getFinalExam()*finalExamWeight;
		return sums;
	}
	/*
	 * A method which returns the letter grade corresponding to the current totalScore()
	 * @return F-A+ gradewise 
	 */
	public String letterGrade() {
		if(!finalIsPassing()) {
			return "F";
		}
		double score = this.totalScore();
		if (score > 100) {
			return "Not Possible";
		} else if (score >= 98){
			return "A+";
		} else if (score >= 92) {
			return "A";
		} else if (score >= 90) {
			return "A-";
		} else if (score >= 88) {
			return "B+";
		} else if (score >= 82) {
			return "B"; 
		} else if (score >= 80) {
			return "B-";
		} else if (score >= 78) {
			return "C+";
		} else if (score >= 72) {
			return "C";
		} else if (score >= 70) {
			return "C-";
		} else if (score >= 60) {
			return "D";
		} else {
			return "F";
		}
	}
	/**********************************************************************************************************************/
	
	@Override
	public String toString(){
		String rv = "Name: "+getStudentName()+"\n";
		rv += "G#: "+getGNumber()+"\n";
		rv += "Participation: "+getParticipation()+"\n";
		rv += "Readings: "+unweightedReadingsScore()+", "+readings+"\n";
		rv += "Labs: "+unweightedLabsScore()+", "+labs+"\n";
		rv += "Exercises: "+unweightedExercisesScore()+", "+exercises+"\n";
		rv += "Projects: "+unweightedProjectsScore()+", "+projects+"\n";
		rv += "Midterm: "+getMidterm()+"\n";
		rv += "Final Exam: "+getFinalExam()+"\n";
		rv += totalScore()+", "+letterGrade()+"\n";
		return rv;
	}
}

