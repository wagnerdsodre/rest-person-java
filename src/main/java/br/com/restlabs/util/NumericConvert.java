package br.com.restlabs.util;

public class NumericConvert {
	
	public static double convertDouble(String n1) {
		if(n1 == null) return 0D;
		String numberStr = n1.replace(',', '.') ;
		if(isNumber(numberStr))return Double.parseDouble(n1);
		return 0D;
	}
	
	public static boolean isNumber(String n1) {
		if(n1 == null) return false;
		String numberStr = n1.replace(',', '.') ;
		return numberStr.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
