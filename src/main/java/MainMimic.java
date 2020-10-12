import java.util.ArrayList;

public class MainMimic {
	
	public static void main(String[] args) {
		combos("WORD");
	}

	private static void combos(String word) {
		ArrayList<String> permutationsList = permute("WORD"); 
		for (String combination : permutationsList) { 
			System.out.println(combination);
		}
		System.out.println("Number of combinations: " + permutationsList.size());
	}

	private static ArrayList<String> permute(String word) {
		ArrayList<String> result = new ArrayList<String>();
		if (word == null || word.isBlank() || word.isEmpty()) {
			throw new RuntimeException("The word cannot be null or blank");
		}
		else if (word.length() == 1) {
			result.add(word);
		}
		else if (word.length() > 1) {
			int lastPosition = word.length() - 1;
			String lastChar = word.substring(lastPosition);
			String restOfChars = word.substring(0, lastPosition);
			result = combineWordChars(permute(restOfChars), lastChar);
		}
		return result;
	}

	private static ArrayList<String> combineWordChars(ArrayList<String> combinationsList, String lastChar) {
		ArrayList<String> permutations = new ArrayList<String>();
		for (String combination : combinationsList) {
			for (int i = 0; i <= combination.length(); i++) {
				String permutationString = new StringBuffer(combination).insert(i, lastChar).toString();
				permutations.add(permutationString);
			}
		}
		return permutations;
	}
	
}
