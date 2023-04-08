package model;

public class data {
	private int id;
	private String vocabulary;
	private String mean;
	
	public data(int id, String vocabulary, String mean) {
		this.id = id;
		this.vocabulary = vocabulary;
		this.mean = mean;
	}

	public data() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(String vocabulary) {
		this.vocabulary = vocabulary;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	@Override
	public String toString() {
		return " id=" + id + "| " + vocabulary + " : " + mean + "";
	}
	
	
	
	
}
