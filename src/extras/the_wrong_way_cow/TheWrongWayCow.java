//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

import java.util.Arrays;

public class TheWrongWayCow {

	public static int[] findWrongWayCow(final char[][] field) {
		// Fill in the code to return the x,y coordinate position of the
		// head (letter 'c') of the wrong way cow!
		int west = 0;
		int south = 0;
		int north = 0;
		int east = 0;
		int[] westtemp = { 0, 0 };
		int[] easttemp = { 0, 0 };
		int[] northtemp = { 0, 0 };
		int[] southtemp = { 0, 0 };

		for (int y = 0; y < field.length; y++) {
			for (int x = 0; x < field[y].length; x++) {
				if (field[y][x] == 'c' && x < field[y].length - 2) {
					if (field[y][x + 1] == 'o' && field[y][x + 2] == 'w') {
						west++;
						westtemp[0] = x;
						westtemp[1] = y;
					}
				}

				if (field[y][x] == 'c' && y > 1) {
					if (field[y - 1][x] == 'o' && field[y - 2][x] == 'w') {
						south++;
						southtemp[0] = x;
						southtemp[1] = y;

					}
				}

				if (field[y][x] == 'c' && y < field.length - 2) {
					if (field[y + 1][x] == 'o' && field[y + 2][x] == 'w') {
						north++;
						northtemp[0] = x;
						northtemp[1] = y;
					}
				}
				if (field[y][x] == 'c' && x > 1) {
					if (field[y][x - 1] == 'o' && field[y][x - 2] == 'w') {
						east++;
						easttemp[0] = x;
						easttemp[1] = y;
					}
				}
			}
			// int[] cow = { y, x };
			// return cow;
		}
		if (west == 1) {
			return westtemp;
		}
		if (east == 1) {
			return easttemp;
		}
		if (south == 1) {
			return southtemp;

		}
		if (north == 1) {
			return northtemp;
		}

		return null;
	}
}
//Check if the search should continue: 2 directions found and at least 3 cows found
// Set i to break out of outer loop

// Found a 'c', find the direction of the cow!
// North
//South
//East
// West

//Which ever direction has only 1 cow, that's the WWC!
