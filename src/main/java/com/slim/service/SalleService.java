package com.slim.service;

import com.slim.Dto.SalleDTO;

public interface SalleService {

  
    SalleDTO save(SalleDTO salleDTO);

    
    SalleDTO findOne(Long id);


    void delete(Long id);
}
