package com.example.userlist.service;

import com.example.userlist.model.User;
import com.example.userlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalUserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void createUserAndDeleteOther(String usernameToCreate, String usernameToDelete) {

        User user = new User(usernameToCreate);
        userRepository.save(user);

        userRepository.deleteByUsername(usernameToDelete);
    }
}

