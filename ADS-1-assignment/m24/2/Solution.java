import java.util.Scanner;
public class Solution {
	private Solution() {
		//function.
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int studentsData = sc.nextInt();
		sc.nextLine();
	}
}
class Student {
	String name;
	Double marks;
	Student() {

	}
	Student(String n, Double m) {
		this.name = n;
		this.marks = m;
	}
}