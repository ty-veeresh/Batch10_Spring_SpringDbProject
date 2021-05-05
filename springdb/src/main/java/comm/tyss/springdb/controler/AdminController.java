package comm.tyss.springdb.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import comm.tyss.springdb.beans.AdminInfoBean;
import comm.tyss.springdb.beans.ItemBean;
import comm.tyss.springdb.service.AdminServiceimpl;

@Controller
public class AdminController {
	@Autowired
	AdminServiceimpl service;

	@GetMapping("/aLogin")
	public String getLoginPage() {
		return "LoginPage";
	}

	@PostMapping("/aLogin")
	public String authenticate(Integer aId, String aname, ModelMap map, HttpServletRequest request) {
		AdminInfoBean bean = service.authenticate(aId, aname);
		if (bean != null) {
			System.out.println(" success login");
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedInfo", bean);
//			session.setMaxInactiveInterval(60);
			return "HomePage";
		} else {
			System.out.println(" login failure");
			map.addAttribute("msg", " User Details Not Found");
			return "LoginPage";
		}
	}//
	
	
	
	@GetMapping("/add")
	public String getAddPage(@SessionAttribute(name = "loggedInfo", required = false) AdminInfoBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			return "addItem";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "LoginPage";
		}
	}// end of getaddpage

	@PostMapping("/add")
	public String addItemDetails(@SessionAttribute(name = "loggedInfo", required = false) AdminInfoBean infoBean,
			ItemBean itemBean, ModelMap map) {
		if (infoBean != null) {
			if (service.addItem( itemBean)) {
				map.addAttribute("msg", "Item Added");
			} else {
				map.addAttribute("errMsg", "Item already exists or Admin is not Authenticate");
			}
			return "addItem";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "LoginPage";
		}

	}//
	
	

	@GetMapping("/searchPage")
	public String getSearchPage(HttpSession session, ModelMap map) {

		if (session.getAttribute("loggedInfo") != null) {
			return "searchPage";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "empLogin";
		}

	}

	@GetMapping("/search")
	public String getItemData(Integer id,Integer iid, ModelMap map,
			@SessionAttribute(name = "loggedInfo", required = false) AdminInfoBean infoBean) {
		if (infoBean != null) {
			ItemBean itemInfoBean = service.getItemData(iid);

			if (itemInfoBean != null) {
				map.addAttribute("data", itemInfoBean);
			} else {
				map.addAttribute("msg", "Details Not Found");
			}

			return "searchPage";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "LoginPage";
		}

	}
	
	
	
	@GetMapping("/logout")
	public String handleLogout(HttpSession httpSession, ModelMap map) {
		httpSession.invalidate();
		map.addAttribute("msg", "logged out Successfully");
		return "LoginPage";
	}
	
	
	
	@GetMapping("/getAll")
	public String getAllData(@SessionAttribute(name = "loggedInfo", required = false) AdminInfoBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			List<ItemBean> beans = service.getAllItemDetails();
			if (beans != null) {
				map.addAttribute("infobeans", beans);
			} else {
				map.addAttribute("msg", "No records Found");
			}
			return "searchPage";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "LoginPage";
		}
	}
	

	@GetMapping("/delete")
	public String getDeleteForm(@SessionAttribute(name = "loggedInfo", required = false) AdminInfoBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			return "deletePage";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "LoginPage";
		}
	}

	@GetMapping("/deleteEmp")
	public String deletItemData(Integer iId,
			@SessionAttribute(name = "loggedInfo", required = false) AdminInfoBean infoBean, ModelMap map) {
		if (infoBean != null) {
			if (service.deleteItem(iId)) {
				map.addAttribute("msg", "Data Deleted Successfully");
			}

			return "deletePage";
		} else {
			map.addAttribute("msg", " Please Login First ");
			return "LoginPage";
		}
	}
}
