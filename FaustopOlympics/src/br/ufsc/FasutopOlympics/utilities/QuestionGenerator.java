package br.ufsc.FasutopOlympics.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
		 if (questionBuffer.size() > 0) {
			 int i = ThreadLocalRandom.current().nextInt(questionBuffer.size());
			 Question chosen = questionBuffer.get(i);
			 questionBuffer.remove(chosen);
			 return chosen;
		 } else {
			 store();
			 return generate();
		 }
	}
	
	private void store() {
		JSONParser parser = new JSONParser();
		try {
			JSONArray questions =  (JSONArray) parser.parse(new FileReader("FaustopOlympics\\resources\\questions.json"));
			
			for (Object question: questions) {
				JSONObject quest = (JSONObject) question;
				Question x = new Question();
				x.setQuestion((String)quest.get("question"));
				x.setOpt1((String)quest.get("opt1"));
				x.setOpt2((String)quest.get("opt2"));
				x.setOpt3((String)quest.get("opt3"));
				x.setOpt4((String)quest.get("opt4"));
				x.setRightopt((String)quest.get("rightopt"));
				questionBuffer.add(x);
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



