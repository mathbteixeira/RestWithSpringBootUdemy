package br.com.erudio.util.math;

import br.com.erudio.exception.ResourceNotFoundException;

public class MathUtils {
	
	public static final String SUM = "sum";
	public static final String SUB = "sub";
	public static final String MULT = "mult";
	public static final String DIV = "div";
	public static final String MEAN = "mean";
	public static final String SQRT = "sqrt";

	public static void validateNumber(String number) {
		if (!isNumeric(number)) {
			throw new ResourceNotFoundException("Please set a numeric value!");
		}
	}

	public static Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	public static void validateNumbers(String numberOne, String numberTwo) {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new ResourceNotFoundException("Please set a numeric value!");
		}
	}
	
	public static Double performMathOperation(String numberOne, String numberTwo, String operation) {
		Double result = 0D;
		if (operation.equals(SUM)) {
			result = convertToDouble(numberOne) + convertToDouble(numberTwo);
		}
		else if (operation.equals(SUB)) {
			result = convertToDouble(numberOne) - convertToDouble(numberTwo);
		}
		else if (operation.equals(MULT)) {
			result = convertToDouble(numberOne) * convertToDouble(numberTwo);
		}
		else if (operation.equals(DIV)) {
			result = convertToDouble(numberOne) / convertToDouble(numberTwo);
		}
		else if (operation.equals(MEAN)) {
			result = convertToDouble(numberOne) + convertToDouble(numberTwo) / 2;
		}
		else if (operation.equals(SQRT)) {
			result = Math.sqrt(convertToDouble(numberOne)); 
		}
		return result;
	}
}
