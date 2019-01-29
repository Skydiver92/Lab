package com.labskeleton.kuzmenko.repository;

import com.labskeleton.kuzmenko.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
