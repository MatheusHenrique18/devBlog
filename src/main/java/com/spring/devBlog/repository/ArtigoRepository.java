package com.spring.devBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.devBlog.model.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Long>{

}
