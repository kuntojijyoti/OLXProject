package com.zensar.olx.user.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.olx.user.bean.OlxUser;
@Repository
public interface OlxUserDAO extends JpaRepository<OlxUser, Integer> {
  OlxUser findByUsername(String userName);
}
