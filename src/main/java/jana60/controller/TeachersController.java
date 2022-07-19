package jana60.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import jana60.model.Teacher;
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

	@GetMapping("/{teacherId}")
	public String teachersDetail(Model model,
			@PathVariable(name = "teacherId") Integer teachersPrimaryKey)
	{
		Optional<Teacher> queryResult = repo.findById(teachersPrimaryKey);
		if (queryResult.isPresent())
		{
			Teacher curDep = repo.findById(teachersPrimaryKey).get();
			model.addAttribute("teacher", curDep);
			return "teachersDetail";

		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found");
		}
	}
}
