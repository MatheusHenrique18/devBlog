package com.spring.devBlog.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.devBlog.model.Artigo;
import com.spring.devBlog.repository.ArtigoRepository;

@Component
public class DummyData {

	@Autowired
	ArtigoRepository artigoRepository;

	    //@PostConstruct
		//toda vez que a aplicação é executada o método abaixo também é, por isso deixar a anotação comentada.
	    public void savePosts(){

	        List<Artigo> artigoList = new ArrayList<>();
	        Artigo artigo1 = new Artigo();
	        artigo1.setAutor("Matheus Henrique");
	        artigo1.setData(LocalDate.now());
	        artigo1.setTitulo("Docker");
	        artigo1.setTexto("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

	        Artigo artigo2 = new Artigo();
	        artigo2.setAutor("Matheus Henrique");
	        artigo2.setData(LocalDate.now());
	        artigo2.setTitulo("API REST");
	        artigo2.setTexto("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

	        artigoList.add(artigo1);
	        artigoList.add(artigo2);

	        for(Artigo artigo: artigoList){
	        	Artigo artigoSaved = artigoRepository.save(artigo);
	            System.out.println(artigoSaved.getId());
	        }
	    }
	}
