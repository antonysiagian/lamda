package co.id.ant;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PlayWithStream {
	
	static Stream<String> streamOfString;
	
	static List<String> listOfStrings;
	
	public static void main(String[] args) {
		
		prepareList();
		
		parseListToStream();
		
		doImidiateOperation();
		
		parseListToStream();
		
		doTerminalOperations();
	}
	
	static void doImidiateOperation(){
		
		Predicate<String> antonyPredicate = (aWord)->{
			return aWord.equals("Antony");
		};
		
		Stream imidiateOperationResult = streamOfString.distinct().filter(antonyPredicate);
		
		Consumer<String> printerAsConsumer = (atextToConsume)-> System.out.println(atextToConsume);
		
		imidiateOperationResult.forEach(printerAsConsumer);
		
	}
	
	static void doTerminalOperations(){
		
		System.out.println(streamOfString.count());
		
	}
	
	static void prepareList(){
		
		listOfStrings = new ArrayList<String>();
		listOfStrings.add("Antony");
		listOfStrings.add("Antony");
		listOfStrings.add("Joko");
		listOfStrings.add("Joko");
		listOfStrings.add("Widodo");
		listOfStrings.add("Widodo");
		listOfStrings.add("Siagian");
		listOfStrings.add("Widodo");
	}
	
	static void parseListToStream(){
		streamOfString = listOfStrings.stream();
	}
}
