package com.java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.Model.userAccount;


@Repository
public interface UserRepository extends JpaRepository<userAccount, String>{

}
