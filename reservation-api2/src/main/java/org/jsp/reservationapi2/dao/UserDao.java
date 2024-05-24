package org.jsp.reservationapi2.dao;

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
}

