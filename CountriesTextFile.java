import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {
	
	public static ArrayList<Country> readFromFile(String fileName){
		ArrayList<Country> worldList = new ArrayList<>();
		
		Path filePath = Paths.get(fileName);
		File f = filePath.toFile();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			
			while (line != null) {
				String[] words = line.split(",");
				String name = words[0];
				int pop = 0;
				Country country = new Country(name, pop);
				worldList.add(country);
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found...");
		} catch (IOException e) {
			System.out.println("Something crazy happened");
		}
		return worldList;
	}
	
	public static void readFromFile() {
		String file = "countries.txt";
		Path filePath = Paths.get(file);
		
		File f = filePath.toFile();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File was not found....");
		} catch (IOException e) {
			System.out.println("Something crazy happened...");
		}
	}
	
	public static void writeToFile(ArrayList<Country> countries1) {
		String fileName = "countries.txt";
		Path path = Paths.get(fileName);
		
		File file = path.toFile();
		PrintWriter output = null;
		
		try {
			output = new PrintWriter(new FileOutputStream(file, false));
			for (Country c : countries1) {
				output.println(c);
			}
		} catch (FileNotFoundException e) {
			System.out.println("yooo");
		} finally {
			output.close();
		}
	}
	public static void writeToFile() {
		String fileName = "countries.txt";
		Path path = Paths.get(fileName);
		
		File file = path.toFile();
		PrintWriter output = null;
		
		try {
			output = new PrintWriter(new FileOutputStream(file, false));
			output.println("");
		} catch (FileNotFoundException e) {
			System.out.println("f");
		} finally {
			output.close();
		}
	}
	

	public static void createCountriesTextFile(String filename) {
		Path path = Paths.get(filename);

		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("The file Countries Text File was created successfully!");
			} catch (IOException e) {
				System.out.println("Something went wrong!");
			}
		} else {
			System.out.println("File already exists");
		}
	}
	
	public static void createDir(String path) {
		String dirPath = path;
		Path worldFolder = Paths.get(dirPath);
		
		if (Files.notExists(worldFolder)) {
			try {
				Files.createDirectories(worldFolder);
				System.out.println("The folder of countries was created!");
			} catch (IOException e) {
				System.out.println("Something went wrong");
			}
		} else {
			System.out.println("The folder of countries");
		}
	}
	


	

}
