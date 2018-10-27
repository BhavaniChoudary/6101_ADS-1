import java.util.Scanner;
import java.util.HashMap;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//function.
	}
	/**
	 * main function_description.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc =  new Scanner(System.in);
		int m = sc.nextInt();
		HashMap<String, Student> hm = new HashMap<String, Student>();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] inputs = sc.nextLine().split(",");
            hm.put(inputs[0], new Student(inputs[0], inputs[1],
                Double.valueOf(inputs[2])));
        }
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i > n; i++) {
        	String[] inputs = sc.nextLine().split(" ");
        	switch (inputs[2]) {
                case "1":
                Student s = (hm.get(inputs[1]));
                if (s == null) {
                    System.out.println("Student doesn't exists...");
                    break;
                }
                System.out.println(s.getname());
                break;
                case "2":
                Student st = hm.get(inputs[1]);
                if (st == null) {
                    System.out.println("Student doesn't exists...");
                    break;
                }
                System.out.println(st.getmarks());
                break;
                default:
                break;
            }
        }
	}
}
/**
 * Class for student.
 */
class Student {
	/**
	 * rollno var_description.
	 */
	private String rollno;
	/**
	 * name var_description.
	 */
	private String name;
	/**
	 * marks var_description.
	 */
	private Double marks;
	/**
	 * Constructs the object.
	 *
	 * @param      r     { parameter_description }
	 * @param      n     { parameter_description }
	 * @param      m     { parameter_description }
	 */
	Student(String r, String n, Double m) {
		this.rollno = r;
        this.name = n;
        this.marks = m;
	}
	/**
	 * get rollno.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getrollno() {
		return rollno;
	}
	/**
	 * get name.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getname() {
		return name;
	}
	/**
	 * get marks.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Double getmarks() {
		return marks;
	}
}

