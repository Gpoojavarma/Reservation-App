package org.jsp.reservationapi2.repository;

import org.jsp.reservationapi2.model.Admin;
import org.jsp.reservationapi2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> { 

}
