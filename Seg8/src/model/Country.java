package model;

public class Country implements Comparable<Country>{
	private int mGold, mSilver, mBronze, fGold, fSilver, fBronze;
	private String name;
	
	public Country(String name, int mGold, int mSilver, int mBronze, int fGold, int fSilver, int fBronze)
	{
		this.name=name;
		this.mGold=mGold;
		this.mSilver=mSilver;
		this.mBronze=mBronze;
		this.fGold=fGold;
		this.fSilver=fSilver;
		this.fBronze=fBronze;
	}
	
	public int getmGold() {
		return mGold;
	}

	public void setmGold(int mGold) {
		this.mGold = mGold;
	}

	public int getmSilver() {
		return mSilver;
	}

	public void setmSilver(int mSilver) {
		this.mSilver = mSilver;
	}

	public int getmBronze() {
		return mBronze;
	}

	public void setmBronze(int mBronze) {
		this.mBronze = mBronze;
	}

	public int getfGold() {
		return fGold;
	}

	public void setfGold(int fGold) {
		this.fGold = fGold;
	}

	public int getfSilver() {
		return fSilver;
	}

	public void setfSilver(int fSilver) {
		this.fSilver = fSilver;
	}

	public int getfBronze() {
		return fBronze;
	}

	public void setfBronze(int fBronze) {
		this.fBronze = fBronze;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String mToString()
	{
		String out=name + " " + mGold + " " + mSilver + " " + mBronze+"\n";
		return out;
	}
	
	public String fToString()
	{
		String out=name + " " + fGold + " " + fSilver + " " + fBronze+"\n";
		return out;
	}
	
	public String toString()
	{
		String out=name + " " + (mGold+fGold) + " " + (mSilver+fSilver) + " " + (mBronze+fBronze)+"\n";
		return out;
	}

	@Override
	public int compareTo(Country c2) {
		int sol=0;
		if(this.getfGold()-c2.getfGold()<0)
		{
			sol=1;
		}else if(this.getfGold()-c2.getfGold()>0){
			sol=-1;
		}else {
			sol=0;
		}
		if(sol==0)
		{
			if(this.getfSilver()-c2.getfSilver()<0)
			{
				sol=1;
			}else if(this.getfSilver()-c2.getfSilver()>0){
				sol=-1;
			}else {
				sol=0;
			}
		}
		if(sol==0)
		{
			if(this.getfBronze()-c2.getfBronze()<0)
			{
				sol=1;
			}else if(this.getfBronze()-c2.getfBronze()>0){
				sol=-1;
			}else {
				sol=0;
			}
		}
		if(sol==0)
		{
			sol=this.getName().compareTo(c2.getName());
		}
		return sol;
	}
}
