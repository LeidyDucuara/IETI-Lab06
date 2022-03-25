package co.edu.escuelaing.ieti.usuario.repository;

import co.edu.escuelaing.ieti.usuario.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

    @Query("select u from User u where u.name like ?1 or u.lastName like ?1")
    List<User> findUsersWithNameOrLastNameLike(String queryText);

    @Query("{'createdAt' > ?1}")
    List<User> findUsersCreatedAfter(Date startDate);

    @Query("{'email':?0}")
    User findByEmail(String email);
}
