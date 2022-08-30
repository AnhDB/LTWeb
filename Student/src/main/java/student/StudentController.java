package student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import student.Student.Department;

@Controller
public class StudentController {
	private final StudentRepository repo;
	@Autowired
	public StudentController(StudentRepository repo) {
		super();
		this.repo = repo;
	}
	
//	 @RequestMapping(value = { "/", "/add" }, method = RequestMethod.GET)
//	public String home(Model model) {
//		Student s=new Student();
//		model.addAttribute("student", s);
//		return "home";
//	}
//	
//	@PostMapping("/add")
//	public String view(ModelMap model,@ModelAttribute("student") Student student) {
//		
//		model.addAttribute("student", student);
//		return "add";
//	}
	
	@GetMapping("/")
	public String home(ModelMap model, HttpSession session) {
		    Department d  = (Department) session.getAttribute("session");
			Student s= new Student(null, null, null);
			s.setDepartment(d);
			model.addAttribute("student",s);
			return "home";
	}
	
	@PostMapping("/infor")
	public String info(ModelMap model, Student student, HttpServletRequest request) {
		request.getSession().setAttribute("session", student.getDepartment());
		Student s=student;
		String message1 = null,message2 = null,message3 = null;
		if(s.getId().trim() == "") {
			message1 = "Khong duoc de trong id";
			model.addAttribute("message1",message1);
		}else {
		Student s1 = repo.searchById(s.getId());
		if(s1 != null) {
			message1 = "Id da ton tai";
			model.addAttribute("message1",message1);
		}
		}
		if(s.getName().trim() == "") {
			message2 = "Khong duoc de trong ";
			model.addAttribute("message2",message2);
		}
		if(s.getDob().toString().trim()=="") {
		    message3 = "Khong duoc de trong";
			model.addAttribute("message3",message3);
		}
		if(message1 == null && message2 == null  && message3 == null) {
			model.addAttribute("student",s);
			return "add";
		}else {
			model.addAttribute("student",s);
			return "home";
		}
		
	}
	@PostMapping("/add")
	public String add(ModelMap model, Student student, HttpServletRequest request) {
		Student s=student;
		s.setApproved(0);
		
			repo.save(s);
		
		return "redirect:/";
	}
}
