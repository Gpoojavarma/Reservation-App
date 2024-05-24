package org.jsp.reservationapi2.repository;

import java.util.Optional;

import org.jsp.reservationapi2.model.Admin;
import org.jsp.reservationapi2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> { 
	Optional<User> findByPhoneAndPassword(long phone, String password);
	Optional<User> findByEmailAndPassword(String email, String password);
}
