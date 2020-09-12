package yamahawk.biker.service;

public interface MailService {
	
	public void send(String fromAddress, String toAddress, String subject, String message) throws Exception;

}
