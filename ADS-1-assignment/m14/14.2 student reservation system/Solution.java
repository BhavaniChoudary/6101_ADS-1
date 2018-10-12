import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * item_description.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * Main function_description.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int vacancies = Integer.parseInt(scan.nextLine());
        int noCategry = Integer.parseInt(scan.nextLine());
        int noofBC = Integer.parseInt(scan.nextLine());
        int noofSC = Integer.parseInt(scan.nextLine());
        int noofST = Integer.parseInt(scan.nextLine());
        Student[] students = new Student[n];
        for (int k = 0; k < n; k++) {
            String[] tokens = scan.nextLine().split(",");
            students[k] = new Student(
                tokens[0], tokens[1], Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[2 + 1]),
                Integer.parseInt(tokens[2 + 2]),
                Integer.parseInt(tokens[2 + 2 + 1]),
                tokens[2 + 2 + 2]);
        }
        Insertion.sort(students);
        print(students);

        allototmarksent(students, vacancies, noCategry, noofBC,
                  noofSC, noofST);
	}
	/**
	 * To print the input.
	 *
	 * @param      students  The students
	 */
	public static void print(final Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
    /**
     * To allot seats.
     *
     * @param      students    The students
     * @param      vacancies1  The vacancies 1
     * @param      noCategry1  No categry 1
     * @param      noBC1       No bc 1
     * @param      noSC1       No sc 1
     * @param      noST1       No st 1
     */
    public static void allototmarksent(final Student[] students,
                                 final int vacancies1,
                                 final int noCategry1,
                                 final int noBC1,
                                 final int noSC1,
                                 final int noST1) {
        int vacancies = vacancies1;
        int noCategry = noCategry1;
        int noBC = noBC1;
        int noSC = noSC1;
        int noST = noST1;
        int i = 0;
        int k = 0;
        int n = students.length;
        Student[] alloted = new Student[vacancies];

        for (i = 0; i < n; i++) {
            if (vacancies == 0) {
                break;
            }
            if (noCategry > 0) {
                noCategry--;
                students[i].setAlloted(true);
                alloted[k++] = students[i];
                vacancies--;
            }

            if (noBC > 0) {
                if (students[i].getRc().equals("BC")
                    && !students[i].getAlloted()) {
                    noBC--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }
            if (noSC > 0) {
                if (students[i].getRc().equals("SC")
                    && !students[i].getAlloted()) {
                    noSC--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }

            if (noST > 0) {
                if (students[i].getRc().equals("ST")
                    && !students[i].getAlloted()) {
                    noST--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (vacancies > 0 && students[i].getRc().equals("Open")
                && !students[i].getAlloted()) {
                students[i].setAlloted(true);
                alloted[k++] = students[i];
                vacancies--;
            }
        }
        Insertion.sort(alloted);
        print(alloted);
    }
}
/**
 * Class for student.
 */
class Student implements Comparable<Student> {
	private String studentName;
	/**
	 * dob var_description.
	 */
	private Date dob;
	/**
	 * marks1 var_description.
	 */
	private int marks1;
	/**
	 * marks2 var_description.
	 */
	private int marks2;
	/**
	 * marks3 var_description.
	 */
	private int marks3;
	/**
	 * total marks var_description.
	 */
	private int totmarks;
	/**
	 * reservation category var_description.
	 */
	private String rc;
	/**
	 * alloted var_description.
	 */
	private boolean alloted;
	/**
	 * Gets the alloted.
	 *
	 * @return     The alloted.
	 */
	public boolean getAlloted() {
        return alloted;
    }
    /**
     * Sets the alloted.
     *
     * @param      allot  The allot
     */
    public void setAlloted(final boolean allot) {
        this.alloted = allot;
    }
    /**
     * function_description.
     *
     * @return     { description_of_the_return_value }
     */
    public Date getdob() {
        return dob;
    }
    /**
     * function_description.
     *
     * @param      b     { parameter_description }
     */
    public void setdob(final Date b) {
        this.dob = b;
    }
    /**
     * Gets the category.
     *
     * @return     The reservation category.
     */
    public String getRc() {
        return rc;
    }
    /**
     * Sets the category.
     *
     * @param      r     { parameter_description }
     */
    public void setRc(final String r) {
        this.rc = r;
    }
    /**
     * get total marks function_description.
     *
     * @return     { description_of_the_return_value }
     */
    public int gettotmarks() {
        return totmarks;
    }
    /**
     * set total marks function_description.
     *
     * @param      m     { parameter_description }
     */
    public void settotmarks(final int m) {
        this.totmarks = m;
    }
    /**
     * Constructs the object.
     *
     * @param      studentName1   The student name 1
     * @param      dateOfBirth    The date of birth
     * @param      marks11        The marks 11
     * @param      marks21        The marks 21
     * @param      marks31        The marks 31
     * @param      totmarksarks1  The totmarksarks 1
     * @param      rc1            The rectangle 1
     */
    Student(final String studentName1, final String dateOfBirth,
                   final int marks11, final int marks21, final int marks31, final int totmarksarks1,
                   final String rc1) {
        this.studentName = studentName1;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.dob = sdf.parse(dateOfBirth);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.marks1 = marks11;
        this.marks2 = marks21;
        this.marks3 = marks31;
        this.totmarks = totmarksarks1;
        this.rc = rc1;
        this.alloted = false;
    }
    /**
     * get marks3 function_description.
     *
     * @return     { description_of_the_return_value }
     */
    public int getotmarksarks3() {
        return marks3;
    }
    /**
     * set marks3 function_description.
     *
     * @param      m     { parameter_description }
     */
    public void setotmarksarks3(final int m) {
        this.marks3 = m;
    }
    /**
     * get marks2 function_description.
     *
     * @return     { description_of_the_return_value }
     */
    public int getotmarksarks2() {
        return marks2;
    }
    /**
     * set marks2 function_description.
     *
     * @param      m     { parameter_description }
     */
    public void setotmarksarks2(final int m) {
        this.marks2 = m;
    }
    /**
     * get marks1 function_description.
     *
     * @return     { description_of_the_return_value }
     */
    public int getotmarksarks1() {
        return marks1;
    }
    /**
     * set marks1 function_description.
     *
     * @param      m     { parameter_description }
     */
    public void setotmarksarks1(final int m) {
        this.marks1 = m;
    }
    /**
     * Gets the student name.
     *
     * @return     The student name.
     */
    public String getStudentName() {
        return studentName;
    }
    /**
     * Sets the student name.
     *
     * @param      student  The student
     */
    public void setStudentName(final String student) {
        this.studentName = student;
    }
    /**
     * compareTofunction_description.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Student that) {
        if (this.gettotmarks() > that.gettotmarks()) {
            return -1;
        }
        if (this.gettotmarks() < that.gettotmarks()) {
            return 1;
        }
        if (this.getotmarksarks3() > that.getotmarksarks3()) {
            return -1;
        }
        if (this.getotmarksarks3() < that.getotmarksarks3()) {
            return 1;
        }
        if (this.getotmarksarks2() > that.getotmarksarks2()) {
            return -1;
        }
        if (this.getotmarksarks2() < that.getotmarksarks2()) {
            return 1;
        }
        if (this.getdob().compareTo(that.getdob()) < 0) {
            return 1;
        }
        if (this.getdob().compareTo(that.getdob()) > 0) {
            return -1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getStudentName() + ",");
        sb.append(this.gettotmarks() + ",");
        sb.append(this.getRc());
        return sb.toString();
    }
}
/**
 * item_description.
 */
final class Insertion {
	/**
	 * Constructs the object.
	 */
	private Insertion() {

	}
	/**
	 * less function_description.
	 *
	 * @param      v     { parameter_description }
	 * @param      w     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	private static boolean less(final Comparable v, final Comparable w) {
		return v.compareTo(w) < 0;
	}
	/**
	 * function_description.
	 *
	 * @param      array      The array
	 * @param      itemarks1  The itemarks 1
	 * @param      itemarks2  The itemarks 2
	 */
	private static void exch(final Comparable[] array,
    final int itemarks1, final int itemarks2) {
    Comparable swap = array[itemarks1];
    array[itemarks1] = array[itemarks2];
    array[itemarks2] = swap;
    }
    /**
     * sorting function_description.
     *
     * @param      array  The array
     */
    public static void sort(final Comparable[] array) {
    int n = array.length;
    for (int i = 0; i < n; i++) {
      for (int j = i; j > 0; j--) {
        if (less(array[j], array[j - 1])) {
          exch(array, j, j - 1);
        } else {
          break;
        }
      }
    }
  }
}
