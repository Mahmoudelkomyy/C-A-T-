import java.util.Scanner;
public class StudentGradeTracker {
	public static void addStudentGrade(double[] arr){
		Scanner x = new Scanner(System.in);
		for(int i = 0; i < arr.length; i++){
			System.out.println("Enter Student " + (i+1) + " Grade:"); //(i+1) so if i=0, then it's student number 1
			arr[i] = x.nextDouble();
		}
		x.close(); //not necessary
	}
	public static double average(double[] arr){
		double sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum += arr[i];
		double average = sum/arr.length;
		return average;
	}
	public static double highest(double[] arr){
		double highest = Double.MIN_VALUE; //to get double smallest number, no other number could be smaller
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > highest)
				highest = arr[i];
		}
		return highest;
	}
	public static double lowest(double[] arr){
		double lowest = Double.MAX_VALUE; //to get double largest number, no other number could be larger
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < lowest)
				lowest = arr[i];
		}
		return lowest;
	}
	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		System.out.println("Specifiy The Number Of Students:");
		int students = s.nextInt();
		if(students <= 0)
			System.out.println("The Students Number Is Invalid" + "\n" + "Run Again Using A Positive Number");
		else{
			double[] arr = new double[students];
			addStudentGrade(arr);
			System.out.println("Average Grade:" + average(arr));
			System.out.println("Highest Grade:" + highest(arr));
			System.out.println("Lowest Grade:" + lowest(arr));
		}
		s.close(); //not necessary
	}
} //of course the code could have been written in a much shorter form, but I chose to write methods to make it clear.
