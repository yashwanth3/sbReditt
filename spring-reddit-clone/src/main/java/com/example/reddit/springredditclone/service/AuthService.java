package com.example.reddit.springredditclone.service;

import com.example.reddit.springredditclone.dto.RegisterRequest;
import com.example.reddit.springredditclone.model.NotificationEmail;
import com.example.reddit.springredditclone.model.User;
import com.example.reddit.springredditclone.model.VerificationToken;
import com.example.reddit.springredditclone.repository.UserRepository;
import com.example.reddit.springredditclone.repository.VerificationTokenRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private  final PasswordEncoder passwordEncoder;
    private  final UserRepository userRepository;
    private  final VerificationTokenRepository verificationTokenRepository;
    private  final MailService mailService;

    @Transactional
    public void  signup(RegisterRequest registerRequest){
        User user =new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreatedDate(Instant.now());
        user.setEnabled(false);
        userRepository.save(user);

        String token= generateVerificationToken(user);
        mailService.sendMail(new NotificationEmail("Please activate your account", user.getEmail(),
                "Thank you for  signing up . Please click the link to activate:" +
                "http://localhost:8080/api/auth/accountVerification/"+token));

    }

    private String generateVerificationToken(User user) {
       String token= UUID.randomUUID().toString();
        VerificationToken verificationToken=new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepository.save(verificationToken);
        return token;


    }
}
