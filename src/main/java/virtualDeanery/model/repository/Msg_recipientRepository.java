package virtualDeanery.model.repository;

import java.util.List;

import virtualDeanery.model.Msg_recipient;

public interface Msg_recipientRepository {
	
	List<Msg_recipient> getMessagesByNiu(int niu);

}
