package web.CRUDboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.CRUDboot.repositories.UserRepository;
import web.CRUDboot.model.User;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService  {


    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }



    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User findOne(int id) {

        Optional<User> foundUser = userRepository.findById(id);

        return foundUser.orElse(null);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update(int id, User updateUser) {
        updateUser.setId(id);
        userRepository.save(updateUser);
    }

    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}

