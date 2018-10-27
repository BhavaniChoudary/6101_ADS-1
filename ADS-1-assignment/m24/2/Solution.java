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
	String rollno;
	String name;
	Double marks;
	Student() {}
	Student(String r, String n, Double m) {
		this.rollno = r;
		this.name = n;
		this.marks = m;
	}
	public String getrollno() {
		return this.rollno;
	}
	public String getname() {
		return this.name;
	}
	public Double getmarks() {
		return this.marks;
	}
}