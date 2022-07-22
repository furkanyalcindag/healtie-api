package com.comitfy.healtie.util.common;

import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.userModule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelperService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    DoctorRepository doctorRepository;

    public User getUserFromSession(){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        Optional<User> user = userRepository.findByEmail(username);

        return user.orElse(null);

    }

/*    public Doctor getDoctorFromSession(){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        Optional<Doctor> doctor = doctorRepository.findByEmail(username);

        return doctor.orElse(null);

    }*/
}
