package Json;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.File;

public class TestConvert{
	@JsonIgnoreProperties (ignoreUnknown = true)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File ("example.json");
		Song song = new Song();
		song.setAuthor("Metallica");
		song.setTitle("One");
		song.setAlbum("...And Justice for All");
		String jsonSong = Utility.ConvertJavaToJsonString(song);
		System.out.println(jsonSong);
		Utility.ConvertJavaToJsonFile(file, song);
		System.out.println("=================");
		Song son = Utility.ConvertJsonToJava(file, Song.class);
		System.out.println("Song: " + son.getTitle() + ", Author: " + son.getAuthor() + ", Album: " + son.getAlbum());
	}
}
