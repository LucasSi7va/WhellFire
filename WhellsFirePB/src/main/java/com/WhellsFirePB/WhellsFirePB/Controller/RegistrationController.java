package com.WhellsFirePB.WhellsFirePB.Controller;


import com.WhellsFirePB.WhellsFirePB.Model.MyAppUser;
import com.WhellsFirePB.WhellsFirePB.Model.MyappUserRepository;
import com.WhellsFirePB.WhellsFirePB.ServiceEmail.EmailService;

import com.WhellsFirePB.WhellsFirePB.Utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {


    @Autowired
    private MyappUserRepository myappUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;


@PostMapping(value = "/cadastro" , consumes = "application/json")
    public ResponseEntity<String> createUser(@RequestBody MyAppUser user){

    MyAppUser existingAppUser = myappUserRepository.findByEmail(user.getEmail());

    if(existingAppUser != null){
        if(existingAppUser.getVerified()){
            return new ResponseEntity<>("User Already exist and Verified" , HttpStatus.BAD_REQUEST);

        }else{
            String verificationToken = JwtTokenUtil.generateToken(user.getEmail());
            existingAppUser.setVerificationToken(verificationToken);
            myappUserRepository.save(existingAppUser);

            emailService.sendVerificationEmail(existingAppUser.getEmail(), verificationToken);


            return new ResponseEntity<>("Verification Email resent. Check your inbox" , HttpStatus.OK);
        }
    }


    user.setSenha(passwordEncoder.encode(user.getSenha()));

    String verificationToken = JwtTokenUtil.generateToken(user.getEmail());
    user.setVerificationToken(verificationToken);

     myappUserRepository.save(user);

    emailService.sendVerificationEmail(user.getEmail(), verificationToken);


    return new ResponseEntity<>("Registration successful! Please verify your email.", HttpStatus.OK);

}


}
