package br.com.restlabs;

public class Gretting {
	public long id;
	public String content;
	
	public Gretting() {}
	
	public Gretting(long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	

}
