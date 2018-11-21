package br.ufsc.FasutopOlympics.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.ufsc.FasutopOlympics.model.Question;

public class QuestionGenerator {
	
	private static final QuestionGenerator instance = new QuestionGenerator();
	ArrayList<Question> questionBuffer;
	
	public QuestionGenerator() {
		questionBuffer = new ArrayList<>();
		store();
	}
	
	public static QuestionGenerator getInstance(){
		return instance;
	}
	
	public Question generate() {
		 Random rand = new Random();
		 int i = rand.nextInt(((questionBuffer.size() -1)) + 1);
		 Question chosen = questionBuffer.get(i);
		 questionBuffer.remove(chosen);
		 return chosen;
	}
	
	private void store() {
		JSONParser parser = new JSONParser();
		try {
			JSONArray questions = (JSONArray) parser.parse(new FileReader("resources\\questions.json"));
			
			for (Object question: questions) {
				questionBuffer.add((Question) question);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}



