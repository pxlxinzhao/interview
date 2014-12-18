package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="identity_message")
public class Identity_message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int sender;
	private int sender_identity;
	private String sender_type;
	private int recipient;
	private int recipient_identity;
	private String recipient_type;
	private int sent = 0;
	private int _read = 0;
	private int is_request = 0;
	private String message;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getSender_identity() {
		return sender_identity;
	}
	public void setSender_identity(int sender_identity) {
		this.sender_identity = sender_identity;
	}
	public int getRecipient() {
		return recipient;
	}
	public void setRecipient(int recipient) {
		this.recipient = recipient;
	}
	public int getRecipient_identity() {
		return recipient_identity;
	}
	public void setRecipient_identity(int recipient_identity) {
		this.recipient_identity = recipient_identity;
	}
	public String getSender_type() {
		return sender_type;
	}
	public void setSender_type(String sender_type) {
		this.sender_type = sender_type;
	}

	public String getRecipient_type() {
		return recipient_type;
	}
	public void setRecipient_type(String recipient_type) {
		this.recipient_type = recipient_type;
	}
	public int getSent() {
		return sent;
	}
	public void setSent(int sent) {
		this.sent = sent;
	}
 
	public int get_read() {
		return _read;
	}
	public void set_read(int _read) {
		this._read = _read;
	}
	public int getIs_request() {
		return is_request;
	}
	public void setIs_request(int is_request) {
		this.is_request = is_request;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
