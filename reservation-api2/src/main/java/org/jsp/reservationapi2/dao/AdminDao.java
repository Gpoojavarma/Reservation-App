package org.jsp.reservationapi2.dao;

import java.util.Optional;

import org.jsp.reservationapi2.model.Admin;
import org.jsp.reservationapi2.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepository adminRepository;

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Optional<Admin> findById(int id) {
		return adminRepository.findById(id);
	}

	public Optional<Admin> verify(long phone, String password) {
		return adminRepository.findByPhoneAndPassword(phone, password);
	}
	
	public Optional<Admin> verify(String email, String password) {
		return adminRepository.findByEmailAndPassword(email, password);
	}

	public void delete(int id) {
		adminRepository.deleteById(id);
	}
}
	