package ui;

import java.io.IOException;
import java.util.Scanner;

import model.CountryData;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		CountryData cd=new CountryData();
		String path;
		System.out.println("SEGUIMIENTO 8, LUIS FERNANDO BOTERO\n\n");	
		System.out.println("pegue acá la ruta del archivo txt.");
		path=sc.nextLine();
		
		cd.importData(path);

		System.out.println("\n\n"+cd.toString());
	}

}
