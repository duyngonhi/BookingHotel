package vn.framgia.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCondition {
	public static boolean isEmailValid(String email){
		boolean isValid = false;
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputEmail = email;
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputEmail);
		if(matcher.matches()){
			isValid = true;
		}
		return isValid;
	}
	
	public static boolean isPhoneNumberValid(String phone){
		boolean isValid = false;
		String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
		CharSequence inputPhone = phone;
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(inputPhone);
		if(matcher.matches()){
			isValid = true;
		}
		return isValid;
	}
}
