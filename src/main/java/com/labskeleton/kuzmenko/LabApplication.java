package com.labskeleton.kuzmenko;

import com.labskeleton.kuzmenko.model.User;
import com.labskeleton.kuzmenko.repository.RoleRepository;
import com.labskeleton.kuzmenko.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LabApplication {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(LabApplication.class, args);





    }
//    public void run(String... args) throws Exception {
//        User user = new User();
//        user.setFirstName("Anton");
//        User user2 = new User();
//        user2.setFirstName("Sergey");
//    }


}

