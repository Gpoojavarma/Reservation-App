package org.jsp.reservationapi2.service;

import org.jsp.reservationapi2.dao.AdminDao;
import org.jsp.reservationapi2.dao.UserDao;
import org.jsp.reservationapi2.dto.ResponseStructure;
import org.jsp.reservationapi2.model.Admin;
import org.jsp.reservationapi2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
	public class UserService
	{
	@Autowired
		
		private UserDao userDao;
		public ResponseEntity<ResponseStructure<User>> saveuser(User user){
			ResponseStructure<User> structure=new ResponseStructure();
			structure.setMessage("user saved");
			structure.setData(userDao.saveUser(user));
			structure.setStatusCode(HttpStatus.CREATED.value());
			return ResponseEntity.status(HttpStatus.CREATED).body(structure);
		}
}
