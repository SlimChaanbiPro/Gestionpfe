package com.slim.file.repository;

//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.slim.file.model.FileModel;
@Transactional
public interface FileRepository extends JpaRepository<FileModel, Long> {

}
