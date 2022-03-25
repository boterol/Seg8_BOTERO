package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CountryData {
	public static ArrayList<Country> data=new ArrayList<>();
	
	public void importData(String path) throws IOException
	{
		int c=0;
		File file = new File(path); 
		FileReader fr = new FileReader(file);
		BufferedReader input = new BufferedReader(fr);
		input.readLine();
		while (input.ready()) { 
			String line = input.readLine();
			String [] objInfo = line.split(";");
			if(c>0 && !line.equals(""))
			{
				int mGold=Integer.parseInt(objInfo[1]);
				int mSilver=Integer.parseInt(objInfo[2]);
				int mBronze=Integer.parseInt(objInfo[3]);
				int fGold=Integer.parseInt(objInfo[4]);
				int fSilver=Integer.parseInt(objInfo[5]);
				int fBronze=Integer.parseInt(objInfo[6]);
				Country country=new Country(objInfo[0], mGold, mSilver, mBronze, fGold, fSilver, fBronze);
				data.add(country);
			}
			c++;
		}
		input.close();
		fr.close();
	}
	
	
	public void mSorting()
	{
		Comparator<Country> com=new Comparator<Country>()
		{
			public int compare(Country c1, Country c2)
			{
				int sol=0;
				if(c1.getmGold()-c2.getmGold()<0)
				{
					sol=1;
				}else if(c1.getmGold()-c2.getmGold()>0){
					sol=-1;
				}else {
					sol=0;
				}
				if(sol==0)
				{
					if(c1.getmSilver()-c2.getmSilver()<0)
					{
						sol=1;
					}else if(c1.getmSilver()-c2.getmSilver()>0){
						sol=-1;
					}else {
						sol=0;
					}
				}
				if(sol==0)
				{
					if(c1.getmBronze()-c2.getmBronze()<0)
					{
						sol=1;
					}else if(c1.getmBronze()-c2.getmBronze()>0){
						sol=-1;
					}else {
						sol=0;
					}
				}
				if(sol==0)
				{
					sol=c1.getName().compareTo(c2.getName());
				}
				return sol;
			}
		};
		Collections.sort(data, com);
	}
	
	public void fSorting()
	{
		Collections.sort(data);
	}
	
	public void generalSorting()
	{
		for(int i=0; i<data.size(); i++)
		{
			Country inter=data.get(i);
			for(int j=i; j<data.size(); j++)
			{
				if((inter.getmGold()+inter.getfGold())<(data.get(j).getmGold()+data.get(j).getfGold()))
				{
					swap(i, j);
				} else if((inter.getmGold()+inter.getfGold())==(data.get(j).getmGold()+data.get(j).getfGold()))
				{
					if((inter.getmSilver()+inter.getfSilver())<(data.get(j).getmSilver()+data.get(j).getfSilver()))
					{
						swap(i, j);
					} else if((inter.getmSilver()+inter.getfSilver())==(data.get(j).getmSilver()+data.get(j).getfSilver()))
					{
						if((inter.getmBronze()+inter.getfBronze())<(data.get(j).getmBronze()+data.get(j).getfBronze()))
						{
							swap(i, j);
						} else if((inter.getmBronze()+inter.getfBronze())==(data.get(j).getmBronze()+data.get(j).getfBronze()))
						{
							int s=inter.getName().compareTo(data.get(j).getName());
							if(s>0)
							{
								swap(i, j);
							}
						}
					}
				}
			} 
		}
	}
	
	public void swap( int i, int j)
	{
		Country c=data.get(i);
		data.set(i, data.get(j));
		data.set(j, c);
		
	}
	
	
	public String toString()
	{
		String out="";
		mSorting();
		for(Country c: data)
		{
			out+=c.mToString();
		}
		out+="----------\n";
		fSorting();
		for(Country c: data)
		{
			out+=c.fToString();
		}
		out+="----------\n";
		generalSorting();
		generalSorting();
		generalSorting();
		for(Country c: data)
		{
			out+=c.toString();
		}
		return out;
	}
}
