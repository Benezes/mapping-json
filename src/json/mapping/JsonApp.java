package json.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonApp {

	public static void main(String[] args) {

		String json = "{\"browsers\":{\"firefox\":{\"name\":\"Firefox\",\"pref_url\":\"about:config\",\"releases\":{\"1\":{\"release_date\":\"2004-11-09\",\"status\":\"retired\",\"engine\":\"Gecko\",\"engine_version\":\"1.7\"}}}}}";

		ObjectMapper mapper = new ObjectMapper();

		try {
			JsonNode jsonNode = mapper.readTree(json);

			System.out.println("releases: " + jsonNode.findValue("releases"));
			System.out.println("releases.engine: " + jsonNode.findValue("releases").findValue("engine"));

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
