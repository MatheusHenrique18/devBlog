package com.spring.devBlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.devBlog.model.Artigo;
import com.spring.devBlog.service.ArtigoService;

@Controller
public class ArtigoController {
	
	@Autowired
	ArtigoService artigoService;
	
	@RequestMapping(value = "/artigos", method = RequestMethod.GET)
	public ModelAndView getArtigos() {
		ModelAndView mv = new ModelAndView("artigos");
		List<Artigo> artigos = artigoService.findAll();
		mv.addObject("artigos", artigos);
		return mv;
	}

}
