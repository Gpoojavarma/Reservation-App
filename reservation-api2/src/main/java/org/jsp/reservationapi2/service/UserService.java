package org.jsp.reservationapi2.service;

import java.util.Optional;

import org.jsp.reservationapi2.dao.AdminDao;
import org.jsp.reservationapi2.dao.UserDao;
import org.jsp.reservationapi2.dto.ResponseStructure;
import org.jsp.reservationapi2.exception.AdminNotFoundException;
import org.jsp.reservationapi2.exception.UserNotFoundException;
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
		
		
		public ResponseEntity<ResponseStructure<User>> update(User user){
			Optional<User> recUser = userDao.findById(user.getId());
			ResponseStructure<User> structure = new ResponseStructure<>();
			if(recUser.isPresent()) {
				User dbUser = recUser.get();
				dbUser.setName(user.getName());
				dbUser.setEmail(user.getEmail());
				dbUser.setPhone(user.getPhone());
				dbUser.setGender(user.getGender());
				dbUser.setAge(user.getAge());
				dbUser.setPassword(user.getPassword());
				structure.setData(userDao.saveUser(user));
				structure.setMessage("User Updated");
				structure.setStatusCode(HttpStatus.CREATED.value());
				return ResponseEntity.status(HttpStatus.CREATED).body(structure);
			}
			throw new UserNotFoundException("Cannot Update User as Id Is Invalid");
					
		}
		
		
		public ResponseEntity<ResponseStructure<User>> findById(int id) {
			ResponseStructure<User> structure = new ResponseStructure<>();
			Optional<User> dbUser = userDao.findById(id);
			if (dbUser.isPresent()) {
				structure.setData(dbUser.get());
				structure.setMessage("User Found");
				structure.setStatusCode(HttpStatus.OK.value());
				return ResponseEntity.status(HttpStatus.OK).body(structure);
			}
			throw new UserNotFoundException("Invalid Admin Id");
		}

		public ResponseEntity<ResponseStructure<User>> verify(long phone, String password) {
			ResponseStructure<User> structure = new ResponseStructure<>();
			Optional<User> dbUser = userDao.verify(phone, password);
			if (dbUser.isPresent()) {
				structure.setData(dbUser.get());
				structure.setMessage("Verification Succesfull");
				structure.setStatusCode(HttpStatus.OK.value());
				return ResponseEntity.status(HttpStatus.OK).body(structure);
			}
			throw new UserNotFoundException("Invalid Email Id or Password");
		}
			public ResponseEntity<ResponseStructure<User>> verify(String email, String password) {
				ResponseStructure<User> structure = new ResponseStructure<>();
				Optional<User> dbUser = userDao.verify(email, password);
				if (dbUser.isPresent()) {
					structure.setData(dbUser.get());
					structure.setMessage("Verification Succesfull");
					structure.setStatusCode(HttpStatus.OK.value());
					return ResponseEntity.status(HttpStatus.OK).body(structure);
				}
				throw new UserNotFoundException("Invalid Email Id or Password");
			}

			public ResponseEntity<ResponseStructure<String>> delete(int id) {
				ResponseStructure<String> structure = new ResponseStructure<>();
				Optional<User> dbUser = userDao.findById(id);
				if (dbUser.isPresent()) {
					userDao.delete(id);
					structure.setData("User Found");
					structure.setMessage("User deleted");
					structure.setStatusCode(HttpStatus.OK.value());
					return ResponseEntity.status(HttpStatus.OK).body(structure);
				}
			throw new UserNotFoundException("Invalid id");
		}
}
