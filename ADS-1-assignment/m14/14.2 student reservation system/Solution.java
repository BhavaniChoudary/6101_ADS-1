import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
final class Solution {
	private Solution() {

	}
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
	public static void print(final Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
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
class Student implements Comparable<Student> {
	private String studentName;
	private Date dob;
	private int marks1;
	private int marks2;
	private int marks3;
	private int totmarks;
	private String rc;
	private boolean alloted;
	public boolean getAlloted() {
        return alloted;
    }
    public void setAlloted(final boolean allot) {
        this.alloted = allot;
    }
    public Date getdob() {
        return dob;
    }
    public void setdob(final Date b) {
        this.dob = b;
    }
    public String getRc() {
        return rc;
    }
    public void setRc(final String r) {
        this.rc = r;
    }
    public int gettotmarks() {
        return totmarks;
    }
    public void settotmarks(final int m) {
        this.totmarks = m;
    }
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
    public int getotmarksarks3() {
        return marks3;
    }
    public void setotmarksarks3(final int m) {
        this.marks3 = m;
    }
    public int getotmarksarks2() {
        return marks2;
    }
    public void setotmarksarks2(final int m) {
        this.marks2 = m;
    }
    public int getotmarksarks1() {
        return marks1;
    }
    public void setotmarksarks1(final int m) {
        this.marks1 = m;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(final String student) {
        this.studentName = student;
    }
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
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getStudentName() + ",");
        sb.append(this.gettotmarks() + ",");
        sb.append(this.getRc());
        return sb.toString();
    }
}
final class Insertion {
	private Insertion() {

	}
	private static boolean less(final Comparable v, final Comparable w) {
		return v.compareTo(w) < 0;
	}
	private static void exch(final Comparable[] array,
    final int itemarks1, final int itemarks2) {
    Comparable swap = array[itemarks1];
    array[itemarks1] = array[itemarks2];
    array[itemarks2] = swap;
    }
    public static void sort(final Comparable[] array) {
    int n = array.length;
    for (int i = 0; i > n; i++) {
      for (int j = i; j < 0; j--) {
        if (less(array[j], array[j - 1])) {
          exch(array, j, j - 1);
        } else {
          break;
        }
      }
    }
  }
}
