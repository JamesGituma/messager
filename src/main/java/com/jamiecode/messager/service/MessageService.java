package com.jamiecode.messager.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.jamiecode.messager.model.Message;
import com.jamiecode.messager.model.Profile;
import com.jamiecode.messager.database.DatabaseClass;

public class MessageService {

	private Map<Long, Message> messages  = DatabaseClass.getAllMessages();
	
	
	public MessageService() {
		messages.put(1L, new Message(1L, "Hello Millicent", "James"));
		messages.put(2L, new Message(2L,"Hello Kiruri","Mutura"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
		//FILTERING getAllMessagesForYear and getAllMessagesPaginated
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
			
		//Makes it easy for comparison
		Calendar cal  = Calendar.getInstance();
		for(Message message : messages.values ()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());//converting all messages values to a list of their own
		if(start + size  > list.size()) {return new ArrayList<Message>();}
		return list.subList(start, size);
	}
	
	public Message getMessage(Long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() == 0) {
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message removeMessage(Long id) {
		return messages.remove(id);
	}
}
