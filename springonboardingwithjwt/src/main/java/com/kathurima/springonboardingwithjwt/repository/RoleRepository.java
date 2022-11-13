package com.kathurima.springonboardingwithjwt.repository;

import java.util.Optional;

import com.kathurima.springonboardingwithjwt.models.ERole;
import com.kathurima.springonboardingwithjwt.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional <Role> findByName(ERole name);
}
