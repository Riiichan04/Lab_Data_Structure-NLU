package Lab2;

// Task 1.4
public class HanoiTower {
	
	static int count = 0;
	
	public static void MoveTower(int disk, String source, String dest, String spare) {
		if (disk == 1) {
			System.out.println("Move disk from " + source + " to " + dest);
		}
		else {
			MoveTower(disk-1, source, spare, dest);
			System.out.println("Move disk from " + source + " to " + dest);
			MoveTower(disk-1, spare, dest, source);
		}
		count++;
	}
	
	public static void main(String[] args) {
		MoveTower(2, "A", "C", "B");
		System.out.println(count);
	}
}
