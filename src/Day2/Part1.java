package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part1 {

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
		
		System.out.println(getPaperArea(list));
		
	}

	public static int getPaperArea(ArrayList<String> list) {
		int area = 0;
		for (int i=0; i<list.size(); i++) {
			String str = list.get(i);
			
			String[] strSplitted = str.split("x");
			
			int l = Integer.parseInt(strSplitted[0]);
			int w = Integer.parseInt(strSplitted[1]);
			int h = Integer.parseInt(strSplitted[2]);
			
			int wrapArea = 2*l*w + 2*w*h + 2*h*l + Math.min(l*w, Math.min(w*h, h*l));
			
			area += wrapArea;
		}
		
		return area;
	}
}
