package onsiteTester;

public class AudioMessage implements Message{
	String content;
	public AudioMessage(String content){
		this.content=content;
	}
	public String getContent(){
		return this.content;
	}
}
