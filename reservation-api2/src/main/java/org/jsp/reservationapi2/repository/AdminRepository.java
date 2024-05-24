package org.jsp.reservationapi2.repository;

import java.util.Optional;

import org.jsp.reservationapi2.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Optional<Admin> findByPhoneAndPassword(long phone, String password);
	Optional<Admin> findByEmailAndPassword(String email, String password);
}
