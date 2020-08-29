package com.spring.devBlog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/artigos/{id}", method = RequestMethod.GET)
	public ModelAndView getArtigoDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("artigoDetails");
		Artigo artigo = artigoService.findById(id);
		mv.addObject("artigo", artigo);
		return mv;
	}
	
	@RequestMapping(value = "/newArtigo", method = RequestMethod.GET)
	public String getArtigoForm() {
		return "/artigoForm";
	}
	
	@RequestMapping(value = "/newArtigo", method = RequestMethod.POST)
	public String saveArtigo(@Valid Artigo artigo, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/newArtigo";
		}
		artigo.setData(LocalDate.now());
		artigoService.save(artigo);
		return "redirect:/artigos";
	}

}
