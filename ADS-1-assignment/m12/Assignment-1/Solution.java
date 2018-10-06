import java.util.Scanner;
class Student {
    private String name;
    private String dob;
    private int sub1;
    private int sub2;
    private int sub3;
    private int totmarks;
    private String reservation;

    public Student(String name, String dob, int sub1, int sub2, int sub3, int totmarks, String reservation) {
        this.name = name;
        this.dob = dob;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.totmarks = totmarks;
        this.reservation = reservation;
    }
    public String getName() {
        return this.name;
    }
    public String getDob() {
        return this.dob;
    }
    public int getSub1() {
        return this.sub1;
    }
    public int getSub2() {
        return this.sub2;
    }
    public int getSub3() {
        return this.sub3;
    }
    public int getTotmarks() {
        return this.totmarks;
    }
    public String getReservation() {
        return this.reservation;
    }
    public String toString() {
        String str;
        str = this.name + "," + this.totmarks+","+this.reservation;
        return str;
    }
}
public final class Solution {
    private Solution() {
    }
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