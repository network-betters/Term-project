package betters;

import java.util.ArrayList;
import java.util.Random;

public class Problem {
	private String topic;
	private String sub_topic;
	private String problem;
	private String answer;
	private ArrayList<String> example = new ArrayList<String>();

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getSub_topic() {
		return sub_topic;
	}

	public void setSub_topic(String sub_topic) {
		this.sub_topic = sub_topic;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public ArrayList<String> getExample() {
		return example;
	}

	public void setExample(String a, String b, String c) {
		example.add(a);
		example.add(b);
		example.add(c);
	}

}
