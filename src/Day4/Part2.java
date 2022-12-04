package Day4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part2 {
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String input = "ckczppom";
		int digits = 0;
		while (true) {
			digits++;
			String password = input + digits;
			
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    md.update(password.getBytes());
		    String myHash = bytesToHex(md.digest());
			if (myHash.substring(0, 6).equals("000000")) {
				break;
			}
		}
		
		System.out.println(digits);
	}

	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	    
}
