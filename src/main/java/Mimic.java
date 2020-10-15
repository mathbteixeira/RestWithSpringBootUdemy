import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Mimic {
	
	ArrayList<String> permutationList;
	String originalString;
	Map<Character,Integer> charMap;
	
	public static void main(String[] args) {
		combos("ABC");
	}

	private static void combos(String word) {
		Mimic mimic = new Mimic(word);
		mimic.populatePermutationsList();
		mimic.printAllPermutations(word.length());
	}

	public Mimic(String anyString) {
		permutationList = new ArrayList<String>();
		originalString = anyString;
		charMap = new TreeMap<Character, Integer>();
		for (char c : originalString.toCharArray())			
			charMap.put(c, countCharRepetitions(originalString, c));
	}
	
	private int countCharRepetitions(String string, char charToBeCounted) {
		int charCount = 0;
		for (char c : string.toCharArray()) {
			if (c == charToBeCounted)
				charCount++;
		}
		return charCount;
	}
	
	private void populatePermutationsList() {
		for (char c : originalString.toCharArray()) {	
			if (charMap.get(c) == 1 || (charMap.get(c) > 1 && !permutationList.contains(String.valueOf(c))))				
				permutationList.add(String.valueOf(c));
		}
		recursiveGeneratePermutations(permutationList);
	}

	private void recursiveGeneratePermutations(ArrayList<String> basePermutations) {
		ArrayList<String> newPermutations = new ArrayList<String>();
		
		for (String s : basePermutations) {
			if (s.length() < originalString.length()) {
				for (char c : originalString.toCharArray()) {
					if (countCharRepetitions(s, c) < charMap.get(c))
						newPermutations.add(s + String.valueOf(c));
				}
			}
		}
		if (newPermutations.size() > 0) {
			permutationList.addAll(newPermutations);
			recursiveGeneratePermutations(newPermutations);
		}
	}
	
	private void printAllPermutations(int columns) {
		for (String p : permutationList) {
			System.out.println(p);
		}
		System.out.println("\nTotal combinations: " + permutationList.size());
	}
	
}
