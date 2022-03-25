package ui;

import java.io.IOException;

import model.CountryData;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("SEGUIMIENTO 8, LUIS FERNANDO BOTERO\n\n");	
		
		CountryData cd=new CountryData();
		cd.importData("C:\\Users\\luisb\\eclipse-workspace\\Seg8\\infoOlimpicos.txt");
		
		System.out.println(cd.toString());
		
		//System.out.println(cd.data);
	}

}
