package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Part1 {

	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day3\\data.txt";
		
		final char[] input = Files.readString(Path.of(path)).toCharArray();
		Map<String, Integer> map = new HashMap<>();
		int x = 0;
		int y = 0;
		String coord = x + ";" + y;
		map.put(coord, 1);
		for (char ch : input) {
			switch (ch) {
				case '^' -> y++;
				case 'v' -> y--;
				case '<' -> x--;
				case '>' -> x++;
				default -> System.out.println("Error!");
			}
			
			coord = x + ";" + y;
			if (!map.containsKey(coord)) {
				map.put(coord, 1);
			} else {
				map.put(coord, map.get(coord) + 1);
			}
		}

		System.out.println(map.keySet().size());
	}

}
