package kz.iitu.itse1902.var1_nurkhan.service;

import kz.iitu.itse1902.var1_nurkhan.model.User;
import kz.iitu.itse1902.var1_nurkhan.model.Warning;
import kz.iitu.itse1902.var1_nurkhan.repository.UserRepository;
import kz.iitu.itse1902.var1_nurkhan.repository.WarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarningService {
    @Autowired
    private WarningRepository warningRepository;
    @Autowired
    private UserRepository userRepository;

    public Warning createWarning(Warning warning, Long userId){
        //User user = userRepository.findById(userId).get();
        warning.setUserWarning(userRepository.getById(userId));
        return warningRepository.save(warning);
    }
    public Warning complete(Long id){
        Warning warning = warningRepository.findById(id).get();
        warning.setCompleted(!warning.getCompleted());
        return warningRepository.save(warning);
    }
}
