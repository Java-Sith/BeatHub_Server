package Json;
import java.io.Serializable;

public class Song implements Serializable {
	//Attributes
	private String title;
	private String author;
	private String album;
	//Getters and Setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String gender) {
		this.album = gender;
	}
}