package com.digitalinovationone.gft.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digitalinovationone.gft.dto.JediDto;
import com.digitalinovationone.gft.model.Jedi;
import com.digitalinovationone.gft.service.JediService;

@Controller
public class JediController {
	
	@Autowired
	JediService service;
	
	@GetMapping("/jedi")
	public ModelAndView allJedi() {
		final ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("allJedi", service.getAll());
		
		return modelAndView;
	}
	
	@GetMapping("/new-jedi")
	public ModelAndView newJedi() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("new-jedi");
		modelAndView.addObject("jedi", new Jedi());
		
		return modelAndView;
	}
	
	@PostMapping("/jedi")
	public String createJedi(@Valid @ModelAttribute JediDto jedi, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "new-jedi";
		}
		
		service.add(jedi);
		
		redirectAttributes.addFlashAttribute("message", "Jedi cadastrado com sucesso");
		
		return "redirect:jedi";
	}
	
}
