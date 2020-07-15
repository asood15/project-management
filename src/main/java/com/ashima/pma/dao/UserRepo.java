package com.ashima.pma.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ashima.pma.entities.UserAccount;

public interface UserRepo extends PagingAndSortingRepository<UserAccount, Long>{

}
