package com.phonebook.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.phonebook.contact.dto.Contact;
import com.phonebook.contact.entity.ContactEntity;
import com.phonebook.contact.service.ContactService;

@Controller
@RequestMapping("/phonebook")
public class ViewContactsController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/editContact")
	public String editContact(@RequestParam ("cid") Integer contactId, Model model){
		Contact c = contactService.getContactById(contactId);
		model.addAttribute("contact", c);
		return "contactInfo";
	}
	
	/*@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateContact(@ModelAttribute ContactEntity c, Model model){
		
		return null;
	}*/
	
	@RequestMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid")Integer contactId, Model model){
		boolean isDeleted = contactService.deleteContact(contactId);
		if(isDeleted)
		{
			return "redirect:viewContacts";
		}
		return null;
	}

}
