package com.phonebook.contact.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.contact.dto.Contact;
import com.phonebook.contact.entity.ContactEntity;
import com.phonebook.contact.repo.ContactDtlsRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDtlsRepository contactDtlsRepository;

	@Override
	public boolean saveContact(Contact c) {
		ContactEntity entity = new ContactEntity();
		
		/*if(c.getContactId()!=null){
			Optional<ContactEntity> findById = contactDtlsRepository.findById(c.getContactId());
			entity = findById.get();
		}*/
		BeanUtils.copyProperties(c, entity);
		ContactEntity savedEntity = contactDtlsRepository.save(entity);
		return savedEntity.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> entities = contactDtlsRepository.findAll();
		//List<Contact> contacts = new ArrayList<>();
		
		//legacy approach
		/*for(ContactEntity entity:entities){
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			contacts.add(contact);
		}*/
		
		//java 8 approach
		return entities.stream().map(entity -> {
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
		
		//return contacts;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactEntity> findById = contactDtlsRepository.findById(cid); 
		if(findById.isPresent()){
			ContactEntity entity = findById.get();
			Contact c = new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact c) {
		
		return false;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		//boolean isDeleted = false;
		contactDtlsRepository.deleteById(cid);
		
		return true;
	}

	

}
