package com.ftech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ftech.model.Musica;
import com.ftech.repository.MusicaMongoRepository;
import com.ftech.repository.MusicaSearchRepository;



@Controller
public class MusicaController {
	
	
	@Autowired
	MusicaMongoRepository musicaRepository;
	
	@Autowired
	MusicaSearchRepository musicaSearchRepository;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("listaMusicas", musicaRepository.findAll());
		return "home";
	}
	
	@RequestMapping(value = "/addMusica", method = RequestMethod.POST)
	public String addMusica(@ModelAttribute Musica musica) {
		musicaRepository.save(musica);
		return "redirect:home";
	}
	
	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam String search) {
		model.addAttribute("listaMusicas", musicaSearchRepository.buscaMusicas(search));
		model.addAttribute("search", search);
		return "home";
	}

}
