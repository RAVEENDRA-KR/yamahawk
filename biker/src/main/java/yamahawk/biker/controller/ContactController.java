package yamahawk.biker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yamahawk.biker.model.Contact;
import yamahawk.biker.service.MailService;

@Controller
@RequestMapping("contact")
public class ContactController {
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("contact", new Contact());
		return "contact/index";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String send(@ModelAttribute("contact") Contact contact, ModelMap modelMap) throws Exception {
		try {
			String content="Name:" +contact.getName();
			content +="<br>Email:" +contact.getEmail();
			content +="<br>Message:" +contact.getMessage();
			mailService.send(contact.getEmail(), "rkrodakar91@gmail.com", contact.getSubject(), contact.getMessage());
			modelMap.put("msg", "Done!");
			
		} catch (Exception e) {
			modelMap.put("msg", e.getMessage());
		}
		
		return "contact/home";
	}

}
