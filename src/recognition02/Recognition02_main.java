package recognition02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

public class Recognition02_main {
	public static void main(String[] args){
		VisualRecognition service = new VisualRecognition("2018-03-19");
		service.setApiKey("J16019");

		InputStream imagesStream = null;

		try {
			imagesStream = new FileInputStream("img/fruitbowl.jpg");
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
		  .imagesFile(imagesStream)
		  .imagesFilename("fruitbowl.jpg")
		  .threshold((float) 0.6)
		  .owners(Arrays.asList("IBM"))
		  .build();
		ClassifiedImages result = service.classify(classifyOptions).execute();
		System.out.println(result);

		String s = String.valueOf(result);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		try {
			node = mapper.readTree(s);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		String classes_0_class = node.get("images").get(0).get("classifiers").get(0).get("classes").get(0).get("class").asText();
        System.out.println("classes_0_class : " + classes_0_class);
		Double classes_0_score = node.get("images").get(0).get("classifiers").get(0).get("classes").get(0).get("score").asDouble();
        System.out.println("classes_0_score : " + classes_0_score);
		String classes_1_class = node.get("images").get(0).get("classifiers").get(0).get("classes").get(1).get("class").asText();
        System.out.println("classes_0_class : " + classes_1_class);
		Double classes_1_score = node.get("images").get(0).get("classifiers").get(0).get("classes").get(1).get("score").asDouble();
        System.out.println("classes_0_score : " + classes_1_score);
		String classes_2_class = node.get("images").get(0).get("classifiers").get(0).get("classes").get(2).get("class").asText();
        System.out.println("classes_0_class : " + classes_2_class);
		Double classes_2_score = node.get("images").get(0).get("classifiers").get(0).get("classes").get(2).get("score").asDouble();
        System.out.println("classes_0_score : " + classes_2_score);
	}
}
