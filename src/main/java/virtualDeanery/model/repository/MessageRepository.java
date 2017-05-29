package virtualDeanery.model.repository;

import java.util.List;

import virtualDeanery.model.Message;
import virtualDeanery.model.Msg_recipient;

public interface MessageRepository {

	List<Message> getAllMessagesByNiu(int niu,List<Msg_recipient> msgGetRecipientList);
	public void sendMessage(int senderNiu, int receiverNiu, String messageText);
}
