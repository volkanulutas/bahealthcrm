package com.bahealth.crm.bacrm.repository;

import com.bahealth.crm.bacrm.data.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
}
