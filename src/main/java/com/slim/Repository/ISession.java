package com.slim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slim.Domain.Session;



public interface ISession extends JpaRepository<Session,Integer> {

}
