package li.kazu.java.audio.id3;

/**
 * helps with byte operations
 * 
 * @author kazu
 *
 */
class ByteHelper {

	
	/** search for the first occurence of "data" in "arr" */
	public static int indexOf(byte[] arr, String data) {
		
		byte[] search = data.getBytes();
		boolean found = false;
		
		for (int i = 0; i < arr.length - search.length; ++i) {
			found = true;
			for (int j = 0; j < search.length; ++j) {
				if (arr[i+j] != search[j]) {found = false; continue;}
			}
			if (found) {return i;}
		}
		
		return -1;
		
	}
	
}
