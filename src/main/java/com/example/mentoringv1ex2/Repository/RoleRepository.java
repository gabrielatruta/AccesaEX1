package com.example.mentoringv1ex2.Repository;

import com.example.mentoringv1ex2.model.ERole;
import com.example.mentoringv1ex2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole role);
}
