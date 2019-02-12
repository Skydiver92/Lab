package com.labskeleton.kuzmenko.dao;

import com.labskeleton.kuzmenko.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByEmail(String email);

    User findUserByEmailOrLastName(String email, String lastName);

}
