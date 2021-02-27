package login;
import java.io.Serializable;

public class User implements Serializable{
	private String username;
	private String pass;


	public User() {}
	public User(String username,String pass) {
		this.username = username;
		this.pass = pass;
	}
	public String getName() {return username;}
	public void setName(String username) {this.username = username;}
	public String getPass(){return pass;}
	public void setPass(String pass) {this.pass = pass;}

}
