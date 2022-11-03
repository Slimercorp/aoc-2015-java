package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day1\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found");
			return;
		}
		
		String str = scan.nextLine();
		scan.close();
		
		System.out.println(getFloor(str));
		
	}

	public static int getFloor(String strSep) {
		int floor = 0;
		for (int i=0; i<strSep.length(); i++) {
			switch (strSep.charAt(i)) {
				case '(':
					floor++;
					break;
				case ')':
					floor--;
					break;
				default:
					System.out.println("Error1!");
					return 0;
			}
		}
		
		return floor;
	}
}
