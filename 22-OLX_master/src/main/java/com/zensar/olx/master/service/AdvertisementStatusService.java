package com.zensar.olx.master.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olx.master.bean.AdvertisementStatus;
import com.zensar.olx.master.db.AdvertisementStatusDAO;
@Service
public class AdvertisementStatusService {
	@Autowired
	AdvertisementStatusDAO dao;
	
	public AdvertisementStatus addAdvertisementStatus(AdvertisementStatus advertisementStatus) {
		return this.dao.save(advertisementStatus);
	}
	
	public List<AdvertisementStatus> getAllAdvertisementStatus(){
		return this.dao.findAll();
	}
	
	public AdvertisementStatus findAdvertismentStatus(int id) {
		Optional<AdvertisementStatus> optional;
		optional=this.dao.findById(id);
		if(optional.isPresent())
			return optional.get();
		else 
			return null;
	}

}
