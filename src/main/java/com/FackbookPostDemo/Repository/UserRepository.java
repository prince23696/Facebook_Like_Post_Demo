package com.FackbookPostDemo.Repository;

import com.FackbookPostDemo.Entity.UserRegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRegistrationForm, Integer> {
}
