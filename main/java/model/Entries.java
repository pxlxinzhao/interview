package model;

public class Entries {
	
	private String sender;
	private String message;
	private String headIcon;
	
	public String getHeadIcon() {
		return headIcon;
	}
	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}
	public Entries(){
	super();
}
	public Entries(String message, String sender){
	this.message = message;
	this.sender = sender;
}
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String toString(){
		
		return "From " + sender + ": " + message;
	}

}
