package Json;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.io.File;

public class Utility {
	//Attributes
	private static ObjectMapper mapper;
	static { 
		mapper = new ObjectMapper();
	}
	//Converts the Java object to JSON String
	public static String ConvertJavaToJsonString(Object object) {
		String jsonResult = "";
		try {
			jsonResult = mapper.writeValueAsString(jsonResult);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		return jsonResult;
	}
	//Converts the JSON file to a Java object
	public static <T> T ConvertJsonToJava (File file, Class<T> cls) {
		T result = null;
		try {
			result = mapper.readValue(file, cls);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		return result;
	}
	//Converts the Java object to a JSON File
	public static void ConvertJavaToJsonFile (File file, Object object){
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(file, object);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
	}
}
