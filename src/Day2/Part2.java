package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day2\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found");
			return;
		}
		
		ArrayList<String> list = new ArrayList<>();
		while (scan.hasNextLine()) {
			list.add(scan.nextLine());
		}
		
		scan.close();
		
		System.out.println(getLengthRibbon(list));
		
	}

	public static int getLengthRibbon(ArrayList<String> list) {
		int length = 0;
		for (int i=0; i<list.size(); i++) {
			String str = list.get(i);
			
			String[] strSplitted = str.split("x");
			
			int l = Integer.parseInt(strSplitted[0]);
			int w = Integer.parseInt(strSplitted[1]);
			int h = Integer.parseInt(strSplitted[2]);
			
			int bow = l*w*h;
			int ribbon = Math.min(2*(l+w), Math.min(2*(w+h), 2*(l+h)));
						
			length += bow;
			length += ribbon;
		}
		
		return length;
	}
}
