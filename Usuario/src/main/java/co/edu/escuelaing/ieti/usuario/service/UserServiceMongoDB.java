package co.edu.escuelaing.ieti.usuario.service;

import co.edu.escuelaing.ieti.usuario.data.User;
import co.edu.escuelaing.ieti.usuario.dto.UserDto;
import co.edu.escuelaing.ieti.usuario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceMongoDB implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(UserDto userDto) {
        return userRepository.save(new User(userDto));
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        boolean exis;
        if( userRepository.existsById(id)){
            userRepository.deleteById(id);
            exis = true;
        }else {
            exis = false;
        }
        return exis;
    }

    @Override
    public User update(UserDto userDto, String userId) {
        User userUp = userRepository.findById(userId).get();
        userUp.setMane(userDto.getName());
        userUp.setLastName(userDto.getLastName());
        userUp.setEmail(userDto.getEmail());
        if(userDto.getPassword() != null){
            userUp.setPasswordHash(BCrypt.hashpw(userDto.getPassword(),BCrypt.gensalt()));
        }
        return userRepository.save(userUp);
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        return userRepository.findUsersWithNameOrLastNameLike(queryText);
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return userRepository.findUsersCreatedAfter(startDate);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
