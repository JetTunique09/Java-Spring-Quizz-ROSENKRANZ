package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    protected Integer id;

    @NotBlank
    @Email
    @Column(unique = true, nullable = false)
    protected String email;

    @NotBlank
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String password;

    @OneToMany(mappedBy = "createur", fetch = FetchType.EAGER)
    protected List<Quizz> listeQuizz;

//    @OneToMany(mappedBy = "reponse-p", fetch = FetchType.EAGER)
//    protected List<ReponsePossible> reponsePossibles;

//    @OneToMany(mappedBy = "repondeur", fetch = FetchType.EAGER)
//    protected List<ReponseUtilisateur> reponseUtilisateur;

    protected  boolean administrateur;
}