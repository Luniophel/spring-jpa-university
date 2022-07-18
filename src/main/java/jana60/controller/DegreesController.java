package jana60.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.model.Degree;
import jana60.repository.DegreeRepository;

@Controller
@RequestMapping("/corsi")
public class DegreesController 
{
	@Autowired
	private DegreeRepository repo;
	
	@GetMapping
	public String degreesList(Model model) 
	{
		model.addAttribute("DegreesList" , repo.findAll());		
		return "degrees";
	}
}
