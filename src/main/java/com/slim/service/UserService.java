package com.slim.service;



import java.util.List;

import com.slim.Domain.Utilisateur;


public interface UserService {
    public Utilisateur findById(Long id);
    public Utilisateur findByUsername(String username);
    public List<Utilisateur> findAll ();
}
