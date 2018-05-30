package Json;
import java.io.Serializable;

public class Student implements Serializable {
	//Attributes
	private String Password;
	private String Name;
	//Getters and Setters
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
}
