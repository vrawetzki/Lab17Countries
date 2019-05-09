
import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {	
		
		Scanner scan = new Scanner(System.in);
		CountriesTextFile.createDir("");
		Country India = new Country("India", 1339000000);
		Country USA = new Country("The United States", 325700000);
		Country China = new Country("China", 1386000000);
		Country Rwanda = new Country("Rwanda", 12210000);
		Country Brazil = new Country("Brazil", 2093000000);
		ArrayList<Country> list = new ArrayList<>();
		list.add(India);
		list.add(USA);
		list.add(China);
		list.add(Rwanda);
		
		
		CountriesTextFile.writeToFile(list);
		
		ArrayList<Country> listFromFile = CountriesTextFile.readFromFile("countries.txt");
		System.out.println(listFromFile);
	
		for(Country c : listFromFile) {
			System.out.println(c);
		}
		scan.close();
	}

	
}
