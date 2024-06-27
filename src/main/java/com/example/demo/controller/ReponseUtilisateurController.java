package com.example.demo.controller;


import com.example.demo.dao.ReponseUtilisateurDao;
import com.example.demo.dao.UtilisateurDao;
import com.example.demo.model.ReponsePossible;
import com.example.demo.model.ReponseUtilisateur;
import com.example.demo.security.AppUserDetails;
import com.example.demo.security.IsUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReponseUtilisateurController {

    @Autowired
    ReponseUtilisateurDao reponseUtilisateurDao;

    @IsUser
    @PostMapping("/reponse-u")
    public ResponseEntity<ReponseUtilisateur> add(@RequestBody @Valid ReponseUtilisateur reponseUtilisateur, @AuthenticationPrincipal AppUserDetails userDetails) {
        reponseUtilisateur.setId(null);

        System.out.println("Authenticated user details: " + userDetails.getUtilisateur());

        reponseUtilisateur.setRepondeur(userDetails.getUtilisateur());
        reponseUtilisateurDao.save(reponseUtilisateur);
        return new ResponseEntity<>(reponseUtilisateur, HttpStatus.CREATED);
    }
}
