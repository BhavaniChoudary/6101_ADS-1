import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
    /**
     * vstring name description.
     */
    private String name;
    /**
     * string dob variable.
     */
    private String dob;
    /**
     * sub1 var_description.
     */
    private int sub1;
    /**
     * sub2 var_description.
     */
    private int sub2;
    /**
     * var_description.
     */
    private int sub3;
    /**
     * var_description.
     */
    private int totmarks;
    /**
     * var_description.
     */
    private String reservation;
    /**
     * Constructs the object.
     *
     * @param      name         The name
     * @param      dob          The dob
     * @param      sub1         The sub 1
     * @param      sub2         The sub 2
     * @param      sub3         The sub 3
     * @param      totmarks     The totmarks
     * @param      reservation  The reservation
     */
    public Student(String name, String dob, int sub1, int sub2, int sub3, int totmarks, String reservation) {
        this.name = name;
        this.dob = dob;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.totmarks = totmarks;
        this.reservation = reservation;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the dob.
     *
     * @return     The dob.
     */
    public String getDob() {
        return this.dob;
    }
    /**
     * Gets the sub 1.
     *
     * @return     The sub 1.
     */
    public int getSub1() {
        return this.sub1;
    }
    /**
     * Gets the sub 2.
     *
     * @return     The sub 2.
     */
    public int getSub2() {
        return this.sub2;
    }
    /**
     * Gets the sub 3.
     *
     * @return     The sub 3.
     */
    public int getSub3() {
        return this.sub3;
    }
    /**
     * Gets the totmarks.
     *
     * @return     The totmarks.
     */
    public int getTotmarks() {
        return this.totmarks;
    }
    /**
     * Gets the reservation.
     *
     * @return     The reservation.
     */
    public String getReservation() {
        return this.reservation;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str;
        str = this.name + "," + this.totmarks+","+this.reservation;
        return str;
    }
    // public void sort(){
    //     Insertion insertionobj = new Insertion();
    //     insertionobj.sort(students1);
    // }
}
/**
 * item_description.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Main function description.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int N = Integer.parseInt(s.nextLine());
        int vacancies = Integer.parseInt(s.nextLine());
        int open = Integer.parseInt(s.nextLine());
        int bc = Integer.parseInt(s.nextLine());
        int sc = Integer.parseInt(s.nextLine());
        int st = Integer.parseInt(s.nextLine());
        while (s.hasNext()) {
            s.nextLine();
        }
    }
}