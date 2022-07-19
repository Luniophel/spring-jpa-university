package jana60.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.repository.TeacherRepository;

@Controller
@RequestMapping("/insegnanti")
public class TeachersController 
{
	@Autowired
	private TeacherRepository repo;
	
	@GetMapping
	public String teachersList(Model model)
	{
		model.addAttribute("TeachersList" , repo.findAll());
		return "teachers";
	}

}
