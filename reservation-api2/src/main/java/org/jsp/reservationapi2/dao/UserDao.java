package org.jsp.reservationapi2.dao;

import java.util.Optional;

import org.jsp.reservationapi2.model.Admin;
import org.jsp.reservationapi2.model.User;
import org.jsp.reservationapi2.repository.AdminRepository;
import org.jsp.reservationapi2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
		private UserRepository userrepository;

		public User saveUser(User user) {
		 return userrepository.save(user);
		}
		
		
		public Optional<User> findById(int id) {
			return userrepository.findById(id);
		}

		public Optional<User> verify(long phone, String password) {
			return userrepository.findByPhoneAndPassword(phone, password);
		}
		
		public Optional<User> verify(String email, String password) {
			return userrepository.findByEmailAndPassword(email, password);
		}

		public void delete(int id) {
			userrepository.deleteById(id);
		}
		
		
}

