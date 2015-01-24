import java.util.*;

public class RGB {
	public static final int RED = 2;
	public static final int GREEN = 3;
	public static final int BLUE = 4;
	int numSolutions;
	public static final int ARY_SIZE = 50;
	
	public RGB() {
		numSolutions = 0;
	}
	
	public static void main(String[] args) {
		RGB rgb = new RGB();
		boolean[] bool = new boolean[ARY_SIZE]; // false initially
		//bool[2] = true;
		//bool[8] = true;
		rgb.solveRGB(BLUE, bool, 0);
		
		bool = new boolean[ARY_SIZE];
		rgb.solveRGB(RED, bool, 0);
		
		bool = new boolean[ARY_SIZE];
		rgb.solveRGB(GREEN, bool, 0);
		
		System.out.println("num solutions: " + rgb.getNumSolutions());
	}
	
	public int getNumSolutions() {
		return numSolutions;
	}
	
	public void solveRGB(int size, boolean[] tiles, int start) {
		// base case
		boolean hasSpace = false;
		boolean good = false;
		for (int i = start; i <= tiles.length - size; i++) {
			//System.out.println("outer loop checking tile " + i);
			if (!tiles[i]) {
				int j = 1;
				good = true;
				for (; j < size; j++) {
					//System.out.println("inner loop checking tile " + (i + j));
					if (tiles[i + j]) {
						good = false;
						//System.out.println("not here");
						break;
					}
				}
				if (good) {
					//System.out.println("we good breh. numSols++");
					numSolutions++;
					// mark the spot and do a recursive call
					boolean[] another = tiles.clone();
					for (int spot = 0; spot < size; spot++) {
						tiles[i + spot] = true;
					}
					// mark the spot and continue through
					//System.out.println("calling solveRGB at index " + (i+1));
					// do recursive call assuming that the found spot was not used
					solveRGB(size, another, i + 1);
					// continue through
					continue;
				}
				i += j; // i know this is bad style
			}
		}
		//System.out.println(good ? "good" : "no good");
		return;
	}
}
