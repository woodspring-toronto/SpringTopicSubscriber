package woodspring.springtopicsubscriber.utilities;

import java.io.IOException;

import org.json.JSONObject;
import org.json.XML;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlJsonTools {
	
	
	public static String xmlToJson(String xml) {
		//String xml = "<?xml version='1.0'?><person><firstName>Homer</firstName><lastName>"
		//           + "Simpson</lastName><address><street>10 Main Street</street><city>"
		//           + "Springfield</city><country>US</country></address></person>";

		String json = null;
		ObjectMapper xmlMapper = new XmlMapper();
		JsonNode node;
		try {
			node = xmlMapper.readTree(xml.getBytes());
			ObjectMapper jsonMapper = new ObjectMapper();
			json = jsonMapper.writeValueAsString(node);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;
	}
	
	public static String json2Xml(String theJson) {
		JSONObject jObject = new JSONObject( theJson);
		String xmlObject = XML.toString( jObject);
		return xmlObject;
	}
	
	public static String xml2Json( String theXml) {
		JSONObject jObject = XML.toJSONObject(theXml);
		return jObject.toString();
	}

}
