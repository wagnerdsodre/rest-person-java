package br.com.restlabs.util;

public class SentencesUtil {
	
	public static double myOperation(String op, String n1, String n2 ) {
		double sentence = 0D;
		switch(op) {
		case "sum":
			sentence = 	NumericConvert.convertDouble(n1) + NumericConvert.convertDouble(n2);
		break;
		case "sub":
			sentence = 	NumericConvert.convertDouble(n1) - NumericConvert.convertDouble(n2);
		break;
		case "mult":
			sentence = 	NumericConvert.convertDouble(n1) * NumericConvert.convertDouble(n2);
		break;
		case "div":
			sentence = 	NumericConvert.convertDouble(n1) / NumericConvert.convertDouble(n2);
		break;
		case "pow":
			sentence = 	Math.pow(NumericConvert.convertDouble(n1),NumericConvert.convertDouble(n2));
		break;
		case "average":
			sentence = 	(NumericConvert.convertDouble(n1)+NumericConvert.convertDouble(n2))/2;
		break;
		default:
			throw new 
			UnsupportedOperationException("operation not allowed"); 
		}
		return sentence ;
	}

}
