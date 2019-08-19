package com.ngoctuan.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngoctuan.dao.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findRoleByName(String theRoleName);
}
