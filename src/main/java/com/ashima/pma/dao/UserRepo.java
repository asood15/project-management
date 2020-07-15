package com.ashima.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.ashima.pma.entities.UserAccount;

public interface UserRepo extends CrudRepository<UserAccount, Long>{

}
