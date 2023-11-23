package de.pettypantry.service;

import de.pettypantry.entity.UserEntity;
import de.pettypantry.entity.UserRepository;
import de.pettypantry.web.models.UserModel;
import de.pettypantry.web.api.User;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(UserService.class);
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<UserEntity> users = userRepository.findAll();

        List<User> userList = users.stream().map(this::transformEntity).collect(Collectors.toList());
        logger.info("Users found: " + userList.size());
        return userList;
    }

    public User findByID(int id) {
        var userEntity = userRepository.findById(id);
        return userEntity.map(this::transformEntity).orElse(null);
    }

    public User create(UserModel request) {
        var userEntity = new UserEntity(request.getFirstName(), request.getLastName());
        userEntity = userRepository.save(userEntity);
        return transformEntity(userEntity);
    }

    public User update(int id, UserModel model) {
        var userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isEmpty()) {
            return null;
        }
        var userEntity = userEntityOptional.get();
        userEntity.setFirstName(model.getFirstName());
        userEntity.setLastName(model.getLastName());
        userEntity = userRepository.save(userEntity);
        return transformEntity(userEntity);
    }

    public boolean deleteById(int id) {
        if(!userRepository.existsById(id)) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }

    private User transformEntity(UserEntity userEntity) {
        return new User(userEntity.getUserId(),
                userEntity.getFirstName(),
                userEntity.getLastName()
        );
    }
}
