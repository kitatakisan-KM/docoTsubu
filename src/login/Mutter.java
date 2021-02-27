package login;

import java.io.Serializable;

public class Mutter implements Serializable{

	private String username;
	private String mutter;
	private int id;

	public Mutter(){}
	public Mutter(String username,String mutter) {
		this.username = username;
		this.mutter = mutter;
	}
	public Mutter(int id,String username,String mutter) {
		this.username = username;
		this.mutter = mutter;
		this.id = id;
	}
	public int getId() {return id;}
	public String getUserName() {return username;}
	public String getMutter() {return mutter;}


}
