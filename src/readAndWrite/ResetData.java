package readAndWrite;

import java.util.ArrayList;
import java.util.HashMap;

import Enum.Procedure;
import command.commandSetter.CommandManagerSetter;

public class ResetData {
	
	
	public static void main(String[] args) {
		//loadThemes();
		//loadAuthor();
		//loadBook();
	}

	@SuppressWarnings("unused")
	private static void loadBook() {
		
		ArrayList<HashMap<String,String>> books = new ArrayList<HashMap<String,String>>();
		
		HashMap<String, String> bookSanManuel = new HashMap<String, String>();
		bookSanManuel.put("ISBN", "9789516006140");
		bookSanManuel.put("Tittle", "San Manuel Bueno, martir");
		bookSanManuel.put("Firstname", "Miguel");
		bookSanManuel.put("Lastname", "Unamuno");
		bookSanManuel.put("NumPages", "74");
		bookSanManuel.put("Format", "cantone");
		bookSanManuel.put("State", "reisue");
		bookSanManuel.put("Theme", "novel");
		bookSanManuel.put("Price", "50");
		books.add(bookSanManuel);
		
		HashMap<String, String> bookNiebla = new HashMap<String, String>();
		bookNiebla.put("ISBN", "9781490995960");
		bookNiebla.put("Tittle", "Niebla");
		bookNiebla.put("Firstname", "Miguel");
		bookNiebla.put("Lastname", "Unamuno");
		bookNiebla.put("NumPages", "128");
		bookNiebla.put("Format", "unbound");
		bookNiebla.put("State", "reisue");
		bookNiebla.put("Theme", "fantastic");
		bookNiebla.put("Price", "50");
		books.add(bookNiebla);
		
		HashMap<String, String> bookTheCallOfCthulu = new HashMap<String, String>();
		bookTheCallOfCthulu.put("ISBN", "9780368996467");
		bookTheCallOfCthulu.put("Tittle", "The call of Cthulu");
		bookTheCallOfCthulu.put("Firstname", "Howard-Phillips");
		bookTheCallOfCthulu.put("Lastname", "Lovecraft");
		bookTheCallOfCthulu.put("NumPages", "754");
		bookTheCallOfCthulu.put("Format", "cantone");
		bookTheCallOfCthulu.put("State", "reisue");
		bookTheCallOfCthulu.put("Theme", "horror");
		bookTheCallOfCthulu.put("Price", "20");
		books.add(bookTheCallOfCthulu);
	
		HashMap<String, String> bookTheNecronomicon = new HashMap<String, String>();
		bookTheNecronomicon.put("ISBN", "9788441421110");
		bookTheNecronomicon.put("Tittle", "The Necronomicon");
		bookTheNecronomicon.put("Firstname", "Howard-Phillips");
		bookTheNecronomicon.put("Lastname", "Lovecraft");
		bookTheNecronomicon.put("NumPages", "600");
		bookTheNecronomicon.put("Format", "cantone");
		bookTheNecronomicon.put("State", "reisue");
		bookTheNecronomicon.put("Theme", "horror");
		bookTheNecronomicon.put("Price", "30");
		books.add(bookTheNecronomicon);
		
		HashMap<String, String> bookTheCat = new HashMap<String, String>();
		bookTheCat.put("ISBN", "9788497770170");
		bookTheCat.put("Tittle", "he Cat Who Found God");
		bookTheCat.put("Firstname", "Robert");
		bookTheCat.put("Lastname", "Fisher");
		bookTheCat.put("NumPages", "100");
		bookTheCat.put("Format", "unbound");
		bookTheCat.put("State", "novelty");
		bookTheCat.put("Theme", "fantastic");
		bookTheCat.put("Price", "52");
		books.add(bookTheCat);
		
		HashMap<String, String> bookTheKnight = new HashMap<String, String>();
		bookTheKnight.put("ISBN", "9782940500789");
		bookTheKnight.put("Tittle", "The Knight in Rusty Armor");
		bookTheKnight.put("Firstname", "Robert");
		bookTheKnight.put("Lastname", "Fisher");
		bookTheKnight.put("NumPages", "100");
		bookTheKnight.put("Format", "unbound");
		bookTheKnight.put("State", "reisue");
		bookTheKnight.put("Theme", "children");
		bookTheKnight.put("Price", "25");
		books.add(bookTheKnight);
		
		HashMap<String, String> bookAnimalFarm = new HashMap<String, String>();
		bookAnimalFarm.put("ISBN", "9789630793292");
		bookAnimalFarm.put("Tittle", "Animal Farm");
		bookAnimalFarm.put("Firstname", "George");
		bookAnimalFarm.put("Lastname", "Orwell");
		bookAnimalFarm.put("NumPages", "350");
		bookAnimalFarm.put("Format", "cantone");
		bookAnimalFarm.put("State", "reisue");
		bookAnimalFarm.put("Theme", "dystopic");
		bookAnimalFarm.put("Price", "30");
		books.add(bookAnimalFarm);
		
		HashMap<String, String> book1984 = new HashMap<String, String>();
		book1984.put("ISBN", "9781471331435");
		book1984.put("Tittle", "1984");
		book1984.put("Firstname", "George");
		book1984.put("Lastname", "Orwell");
		book1984.put("NumPages", "200");
		book1984.put("Format", "rustic");
		book1984.put("State", "novelty");
		book1984.put("Theme", "sciFi");
		book1984.put("Price", "42");
		books.add(book1984);
		
		HashMap<String, String> bookTheCastle = new HashMap<String, String>();
		bookTheCastle.put("ISBN", "9788854119635");
		bookTheCastle.put("Tittle", "The Castle");
		bookTheCastle.put("Firstname", "Franz");
		bookTheCastle.put("Lastname", "Kafka");
		bookTheCastle.put("NumPages", "532");
		bookTheCastle.put("Format", "cantone");
		bookTheCastle.put("State", "reisue");
		bookTheCastle.put("Theme", "novel");
		bookTheCastle.put("Price", "40");
		books.add(bookTheCastle);
		
		HashMap<String, String> bookTheMetamorphosis = new HashMap<String, String>();
		bookTheMetamorphosis.put("ISBN", "9781481540193");
		bookTheMetamorphosis.put("Tittle", "The metamorphosis");
		bookTheMetamorphosis.put("Firstname", "Franz");
		bookTheMetamorphosis.put("Lastname", "Kafka");
		bookTheMetamorphosis.put("NumPages", "432");
		bookTheMetamorphosis.put("Format", "unbound");
		bookTheMetamorphosis.put("State", "novelty");
		bookTheMetamorphosis.put("Theme", "horror");
		bookTheMetamorphosis.put("Price", "15");
		books.add(bookTheMetamorphosis);
		
		
		for (HashMap<String, String> bookMap : books) {
			bookMap.put("procedure", Procedure.addBook.getSintax());
			CommandManagerSetter.getIntance().getCommand(Procedure.addBook.getValidateName()).execute(bookMap);
		}
	}

	@SuppressWarnings("unused")
	private static void loadAuthor() {

		ArrayList<HashMap<String,String>> authors = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> authorKafka = new HashMap<String, String>();
		authorKafka.put("Name","Franz");
		authorKafka.put("Surname", "Kafka");
		authorKafka.put("Nationality", "Jewish");
		authorKafka.put("Theme", "horror");
		authors.add(authorKafka);
		
		HashMap<String, String> authorFisher = new HashMap<String, String>();
		authorFisher.put("Name","Robert");
		authorFisher.put("Surname", "Fisher");
		authorFisher.put("Nationality", "American");
		authorFisher.put("Theme", "children");
		authors.add(authorFisher);
		
		HashMap<String, String> authorOrwell = new HashMap<String, String>();
		authorOrwell.put("Name","George");
		authorOrwell.put("Surname", "Orwell");
		authorOrwell.put("Nationality", "Indian");
		authorOrwell.put("Theme", "dystopic");
		authors.add(authorOrwell);
		
		HashMap<String, String> authorLovecraft = new HashMap<String, String>();
		authorLovecraft.put("Name","Howard-Phillips");
		authorLovecraft.put("Surname", "Lovecraft");
		authorLovecraft.put("Nationality", "American");
		authorLovecraft.put("Theme", "horror");
		authors.add(authorLovecraft);
		
		HashMap<String, String> authorUnamuno = new HashMap<String, String>();
		authorUnamuno.put("Name","Miguel");
		authorUnamuno.put("Surname", "Unamuno");
		authorUnamuno.put("Nationality", "Spanish");
		authorUnamuno.put("Theme", "novel");
		authors.add(authorUnamuno);
		
		
		for (HashMap<String, String> authorMap : authors) {
			authorMap.put("procedure", Procedure.addAuthor.getSintax());
			CommandManagerSetter.getIntance().getCommand(Procedure.addAuthor.getValidateName()).execute(authorMap);
		}
	}

	@SuppressWarnings("unused")
	private static void loadThemes() {
		ArrayList<HashMap<String,String>> themes = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> novel = new HashMap<String, String>();
		novel.put("name", "utopico");
		novel.put("procedure", "{call addTheme(?)}");
		themes.add(novel);
		CommandManagerSetter.getIntance().getCommand("SetterAddAtributte").execute(novel);
		
	}

}
