package kz.iitu.itse1902.var1_nurkhan.service;

import kz.iitu.itse1902.var1_nurkhan.model.User;
import kz.iitu.itse1902.var1_nurkhan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return (List<User>) this.userRepository.findAll();
    }

}
