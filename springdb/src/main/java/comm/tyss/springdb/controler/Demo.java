package comm.tyss.springdb.controler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Demo {
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	@PostMapping("/login")
	public String getFormData(HttpServletRequest request, ModelMap map) {
		String username = request.getParameter("user");
		String password = request.getParameter("pwd");

		map.addAttribute("user", username);
		map.addAttribute("pwd", password);
		return "home";
	} 
	
}
