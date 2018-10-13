import java.util.Scanner;
class Stock {
	private String name;
	private float change;
	Stock(final String name, final float change) {
		this.name = name;
		this.change = change;
	}
	String getname() {
		return this.name;
	}
	Float getchange() {
		return this.change;
	}
}
final class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] tokens = sc.nextLine().split(",");
		}
	}
}