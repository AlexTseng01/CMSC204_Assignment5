import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Third-level class that converts morse code to english
 * @author Alex Tseng
 * */
public class MorseCodeConverter {
	
	private static MorseCodeTree tree = new MorseCodeTree();
	/*
	 * Turns the tree into a String representation
	 * @return String representation of the tree
	 * */
	public static String printTree() {
		ArrayList<String> list = tree.toArrayList();
		String returnValue = "";
		
		for (int i = 0; i < list.size(); i++) {
			returnValue += list.get(i) + " ";
		}
		
		returnValue = returnValue.substring(0, list.size() * 2 - 2);
		
		return returnValue;
	}
	/*
	 * Converts some morse code into english
	 * @param code is a morse code
	 * @return A String containing the decoded words/letter
	 * */
	public static String convertToEnglish(String code) {
		String words = "";
		String[] codeSplit = code.split(" ");
		
		// for every pair of 4 code in the list
		for (int i = 0; i < codeSplit.length; i++) {
			if (codeSplit[i].equals("/")) {
				words += " ";
				continue;
			}
			words += tree.fetch(codeSplit[i]);
		}
		return words;
	}
	/*
	 * Converts some morse code into english
	 * @param codeFile is a File containing morse code
	 * @throws FileNotFoundException
	 * @return A String containing the decoded words/letter
	 * */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		String words = "";
		
		try {
			Scanner scan = new Scanner(codeFile);
			while (scan.hasNextLine()) {
				String code = scan.nextLine();
				//String words = "";
				String[] codeSplit = code.split(" ");
				
				// for every pair of 4 code in the list
				for (int i = 0; i < codeSplit.length; i++) {
					if (codeSplit[i].equals("/")) {
						words += " ";
						continue;
					}
					words += tree.fetch(codeSplit[i]);
				}
				return words;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return words;
	}
	
	
	
}