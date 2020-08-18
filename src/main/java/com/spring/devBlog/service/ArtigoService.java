package com.spring.devBlog.service;

import java.util.List;

import com.spring.devBlog.model.Artigo;

public interface ArtigoService {
	
	List<Artigo> findAll();
	Artigo findById (Long id);
	Artigo save (Artigo artigo);
}
