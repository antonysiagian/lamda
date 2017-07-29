package co.id.ant;

import java.util.ArrayList;
import java.util.List;

public class PlayWithLambda {

	private static List<String> listOfElements;

	public static void main(String[] args) {

		prepareList();
		
		sarchUsingNativeJavaExpression();
		
		searchUsingLambdaExpression();

	}

	
	private static void sarchUsingNativeJavaExpression() {
		Searchable searchable = new Searchable() {
			@Override
			public String search(List<String> elements, String textToSearch) {
				for (int i = 0; i < elements.size(); i++) {
					if (elements.get(i).equals(textToSearch)) {
						return elements.get(i) + " at index " + i;
					}
				}
				return "";
			}
		};

		System.out.println("Using native java code: " + searchable.search(listOfElements, "Antony"));
		System.out.println("Using native java code: " + searchable.search(listOfElements, "Siagian"));
	}

	
	private static void searchUsingLambdaExpression() {

		Searchable lambdaSearchable = (List<String> elements, String textToSearch) -> {
			int i = 0;
			for (String text : elements) {
				if (textToSearch.equals(text)) {
					return text + " at index " + i;
				}
				i++;
			}
			return "";
		};

		System.out.println("Using lambda expression: " + lambdaSearchable.search(listOfElements, "Joko"));
		System.out.println("Using lambda expression: " + lambdaSearchable.search(listOfElements, "Widodo"));
	}

	
	private static void prepareList() {
		listOfElements = new ArrayList<String>();
		listOfElements.add("Antony");
		listOfElements.add("Joko");
		listOfElements.add("Widodo");
		listOfElements.add("Siagian");
	}

}

interface Searchable {
	String search(List<String> elements, String textToSearch);
}
