package kz.iitu.itse1902.var1_nurkhan.repository;

import kz.iitu.itse1902.var1_nurkhan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
