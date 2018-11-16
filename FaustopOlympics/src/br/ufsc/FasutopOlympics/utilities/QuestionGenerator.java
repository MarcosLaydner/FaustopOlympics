package br.ufsc.FasutopOlympics.utilities;

import java.util.ArrayList;
import java.util.Random;

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
		
	}
}
