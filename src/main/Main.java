package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static final String VOWEL_REGEX = "[AEIOUaeiou]";
	public static final String FULL_REGEX = VOWEL_REGEX + "[a-zA-Z]" + VOWEL_REGEX + "$";
	public static final String NOT_FOUND = "Nenhum caracter foi encontrado.";
	public static final int NULL = 0;
	
	public static char firstChar(Stream input) {
		char character = NULL, aux = NULL;
		
		StringBuilder stringBuilder = new StringBuilder();
		
		Pattern fullPattern = Pattern.compile(FULL_REGEX);
		
		while(input.hasNext()) {
			character = input.getNext();
			
			stringBuilder.append(character);

	        Matcher fullMatcher = fullPattern.matcher(stringBuilder);

	        if (fullMatcher.find()) {
	        	if(aux == NULL)
					aux = fullMatcher.group().charAt(2);
	        	
	            if(Character.toLowerCase(character) != Character.toLowerCase(aux)) {
	            	return character;
	            }
	            
	        }
		}
		
		return NULL;
	}

	public static void main(String args[]) {
		char result = firstChar(new StreamImpl("aAbBABacafe"));
		switch (result) {
			case NULL:
				System.out.println(NOT_FOUND);
				break;
			default:
				System.out.println(result);
		}
	}
}
