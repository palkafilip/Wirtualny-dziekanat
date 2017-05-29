package virtualDeanery.service;

import java.util.List;

import virtualDeanery.model.Message;

public interface MessageService {
	
	List<Message> getAllMessages(int niu);
	
	void sendMessage(int senderNiu, int receiverNiu, String messageText);

}
