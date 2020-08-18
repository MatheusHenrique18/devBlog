package com.spring.devBlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.devBlog.model.Artigo;
import com.spring.devBlog.repository.ArtigoRepository;

@Service
public class ArtigoServiceImpl implements ArtigoService{

	@Autowired
	ArtigoRepository artigoRepository;
	
	@Override
	public List<Artigo> findAll() {
		return artigoRepository.findAll();
	}

	@Override
	public Artigo findById(Long id) {
		return artigoRepository.findById(id).get();
	}

	@Override
	public Artigo save(Artigo artigo) {
		return artigoRepository.save(artigo);
	}

}
