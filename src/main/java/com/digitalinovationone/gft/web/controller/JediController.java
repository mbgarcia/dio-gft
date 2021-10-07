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

import com.digitalinovationone.gft.model.Jedi;
import com.digitalinovationone.gft.repository.JediRepository;

@Controller
public class JediController {
	
	@Autowired
	JediRepository repository;
	
	@GetMapping("/jedi")
	public ModelAndView allJedi() {
		final ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("allJedi", repository.allJedi());
		
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
	public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "new-jedi";
		}
		
		repository.add(jedi);
		
		redirectAttributes.addFlashAttribute("message", "Jedi cadastrado com sucesso");
		
		return "redirect:jedi";
	}
	
}
