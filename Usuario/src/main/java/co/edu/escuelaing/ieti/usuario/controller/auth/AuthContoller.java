package co.edu.escuelaing.ieti.usuario.controller.auth;

import co.edu.escuelaing.ieti.usuario.data.User;
import co.edu.escuelaing.ieti.usuario.dto.LoginDto;
import co.edu.escuelaing.ieti.usuario.dto.TokenDto;
import co.edu.escuelaing.ieti.usuario.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.escuelaing.ieti.usuario.exception.InvalidCredentialsException;


import java.util.Calendar;
import java.util.Date;

import static co.edu.escuelaing.ieti.usuario.utils.Constants.CLAIMS_ROLES_KEY;
import static co.edu.escuelaing.ieti.usuario.utils.Constants.TOKEN_DURATION_MINUTES;

@RestController
@RequestMapping("v1/auth")
public class AuthContoller {

    @Value("${app.secret}")
    String secret;

    private final UserService userService;

    public AuthContoller(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public TokenDto login(@RequestBody LoginDto loginDto){
        User user = userService.findByEmail(loginDto.getEmail());
        if (BCrypt.checkpw(loginDto.getPassword(),user.getPasswordHash())){
            return generateTokenDto(user);
        }else{
            throw new InvalidCredentialsException();
        }
    }

    private String generateToken(User user, Date expirationDate){
        return Jwts.builder()
                .setSubject(user.getId())
                .claim(CLAIMS_ROLES_KEY,user.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    private TokenDto generateTokenDto(User user){
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE,TOKEN_DURATION_MINUTES);
        String token = generateToken(user,expirationDate.getTime());
        return new TokenDto(token,expirationDate.getTime());
    }
}
