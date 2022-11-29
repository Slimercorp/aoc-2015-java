package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Part2 {

	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day3\\data.txt";
		
		final char[] input = Files.readString(Path.of(path)).toCharArray();
		Map<String, Integer> map = new HashMap<>();
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		String coord = x1 + ";" + y1;
		map.put(coord, 2);
		int counter = 0;
		for (char ch : input) {
			counter++;
			if ((counter % 2) == 0) {
				switch (ch) {
					case '^' -> y1++;
					case 'v' -> y1--;
					case '<' -> x1--;
					case '>' -> x1++;
					default -> System.out.println("Error!");
				}
				
				coord = x1 + ";" + y1;
			} else {
				switch (ch) {
					case '^' -> y2++;
					case 'v' -> y2--;
					case '<' -> x2--;
					case '>' -> x2++;
					default -> System.out.println("Error!");
				}
				
				coord = x2 + ";" + y2;
			}
			
			if (!map.containsKey(coord)) {
				map.put(coord, 1);
			} else {
				map.put(coord, map.get(coord) + 1);
			}
		}

		System.out.println(map.keySet().size());
	}

}
