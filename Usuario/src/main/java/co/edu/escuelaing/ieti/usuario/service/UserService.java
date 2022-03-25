package co.edu.escuelaing.ieti.usuario.service;

import co.edu.escuelaing.ieti.usuario.data.User;
import co.edu.escuelaing.ieti.usuario.dto.UserDto;

import java.util.Date;
import java.util.List;

public interface UserService {

    User create(UserDto userDto);

    User findById( String id );

    List<User> getAll();

    boolean deleteById( String id );

    User update(UserDto userDto, String userId );

    List<User> findUsersWithNameOrLastNameLike(String queryText);

    List<User> findUsersCreatedAfter(Date startDate);

    User findByEmail(String email);
}
