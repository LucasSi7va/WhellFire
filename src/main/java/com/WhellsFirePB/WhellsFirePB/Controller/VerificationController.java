package com.WhellsFirePB.WhellsFirePB.Controller;

import com.WhellsFirePB.WhellsFirePB.Model.MyAppUser;
import com.WhellsFirePB.WhellsFirePB.Model.MyappUserRepository;
import com.WhellsFirePB.WhellsFirePB.Utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationController {

    @Autowired
    private MyappUserRepository myappUserRepository;

    @Autowired
    private JwtTokenUtil jwtUtil;

    @GetMapping("/cadastro/verify")
    public ResponseEntity verifyEmail(@RequestParam("token") String token) {
        String emailString = jwtUtil.extractEmail(token);
        MyAppUser user = myappUserRepository.findByEmail(emailString);
        if(user == null || user.getVerificationToken() == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("token Expirado!");
        }
            if(!jwtUtil.validateToken(token) || !user.getVerificationToken().equals(token)){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("token Expirado!");
            }

        user.setVerificationToken(null);
        user.setVerified(true);
        myappUserRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("Email sucedido verificado");

    }

}
