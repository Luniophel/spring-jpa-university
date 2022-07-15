package jana60.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jana60.model.Department;
import jana60.repository.DepartmentRepository;

@Controller
@RequestMapping("/")
public class MainController 
{
	
	@Autowired
	private DepartmentRepository repo;
	
	@GetMapping("/dipartimenti")
	public String departments(Model model)
	{
		List<Department> DepartmentsList =(List<Department>)repo.findAllByOrderByName();
		model.addAttribute("DepartmentsList" ,DepartmentsList);
		return "departments";
	}

}
