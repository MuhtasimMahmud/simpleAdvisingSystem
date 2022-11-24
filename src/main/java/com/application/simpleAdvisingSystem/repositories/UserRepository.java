package com.application.simpleAdvisingSystem.repositories;

import com.application.simpleAdvisingSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);

    @Query("select U from User U where U.role = :role")
    public User findByRole(String role);

}
