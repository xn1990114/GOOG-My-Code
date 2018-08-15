package onsiteTester;

public class TextMessage implements Message{
	String content;
	public TextMessage(String content){
		this.content=content;
	}
	public String getContent(){
		return this.content;
	}
}
