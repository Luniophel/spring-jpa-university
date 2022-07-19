package jana60.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.model.Department;
import jana60.repository.DepartmentRepository;

@Controller
@RequestMapping("/dipartimenti")
public class DepartmentsController 
{
	@Autowired
	private DepartmentRepository repo;
	
	@GetMapping
	public String departmentsList(Model model)
	{
		//List<Department> DepartmentsList =(List<Department>)repo.findAll();
		//model.addAttribute("DepartmentsList" , DepartmentsList);
		
		model.addAttribute("DepartmentsList" , repo.findAll());
		return "departments";
	}
	
	@GetMapping("/{departmentId}")
	public String departmentsDetail(Model model,
			@PathVariable(name = "departmentId") Integer departmentsPrimaryKey)
	{
		Department curDep = repo.findById(departmentsPrimaryKey).get();
		model.addAttribute("department", curDep);
		return "departmentsDetail";
	}
}
