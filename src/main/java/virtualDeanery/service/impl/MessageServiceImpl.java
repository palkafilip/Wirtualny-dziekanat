package virtualDeanery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import virtualDeanery.model.Message;
import virtualDeanery.model.Msg_recipient;
import virtualDeanery.model.repository.MessageRepository;
import virtualDeanery.model.repository.Msg_recipientRepository;
import virtualDeanery.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	Msg_recipientRepository msgRecipientRepository;

	public List<Message> getAllMessages(int niu) {
		
		List<Msg_recipient> msgRecipientList = msgRecipientRepository.getMessagesByNiu(niu);
		
		return messageRepository.getAllMessagesByNiu(niu,msgRecipientList);
	}

	public void sendMessage(int senderNiu, int receiverNiu, String messageText) {
		messageRepository.sendMessage(senderNiu, receiverNiu, messageText);
	}

}
