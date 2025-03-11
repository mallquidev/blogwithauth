package com.mallqui.blogwithcli.repositories;

import com.mallqui.blogwithcli.entities.Role;
import com.mallqui.blogwithcli.enums.RoleList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleList name);
}
