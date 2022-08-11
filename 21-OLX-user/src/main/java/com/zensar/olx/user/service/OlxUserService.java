package com.zensar.olx.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigData.Option;
import org.springframework.stereotype.Service;

import com.zensar.olx.user.bean.OlxUser;
import com.zensar.olx.user.db.OlxUserDAO;

@Service
public class OlxUserService {
	@Autowired
	OlxUserDAO dao;

	public OlxUser addOlxUser(OlxUser olxuser) {
		return this.dao.save(olxuser);
	}
	public OlxUser findOlxUserById(int id) {
		Optional<OlxUser> optional=this.dao.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	public OlxUser findOlxUserByName(String name) {
		OlxUser olxUser=this.dao.findByUsername(name);
		return olxUser;
	}
}
