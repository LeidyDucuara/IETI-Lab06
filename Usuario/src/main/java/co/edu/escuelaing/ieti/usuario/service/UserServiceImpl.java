package co.edu.escuelaing.ieti.usuario.service;

import co.edu.escuelaing.ieti.usuario.data.User;
import co.edu.escuelaing.ieti.usuario.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final HashMap<String, UserDto> hashMapUsers = new HashMap<>();

    @Override
    public User create(UserDto userDto) {
        //hashMapUsers.put(user.getId(),user);
        return null;
    }

    @Override
    public User findById(String id) {
        //User user = hashMapUsers.get(id);
        return null;
    }

    @Override
    public List<User> getAll() {
        //ArrayList<User> users = new ArrayList<User>(hashMapUsers.values());
        return  null;
    }

    @Override
    public boolean deleteById(String id) {
        boolean exis;
        try{
            hashMapUsers.remove(id);
            exis = true;
        }catch (Exception e){
            exis =false;
        }
        return exis;
    }

    @Override
    public User update(UserDto userDto, String userId) {
        //hashMapUsers.put(userId,userDto);
        return null;
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        return null;
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}
