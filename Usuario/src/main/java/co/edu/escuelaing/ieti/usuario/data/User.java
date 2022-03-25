package co.edu.escuelaing.ieti.usuario.data;

import co.edu.escuelaing.ieti.usuario.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.*;

enum userRoles{
    ADMIN, USER
}

@Document
public class User {

    @Id
    private String id;
    private String mane;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private String passwordHash;
    private List<userRoles> roles;
    private Date createdAt;

    public User(){

    }

    public User(UserDto userDto) {
        this.mane = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.createdAt = new Date();
        roles = new ArrayList<>(Collections.singleton(userRoles.USER));
        passwordHash = BCrypt.hashpw(userDto.getPassword(),BCrypt.gensalt());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMane(){
        return mane;
    }

    public void setMane(String mane) {
        this.mane = mane;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public List<userRoles> getRoles() {
        return roles;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
