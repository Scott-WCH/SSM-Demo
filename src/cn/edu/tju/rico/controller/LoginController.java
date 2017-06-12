package cn.edu.tju.rico.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.edu.tju.rico.service.UserService;

/**        
 * Title: LoginController    
 * Description: �����¼����
 * @author rico       
 * @created 2017��6��12�� ����12:05:46    
 */      
@Controller
@SessionAttributes("uname")  // ��uname�ŵ�HttpSession����
public class LoginController {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(@RequestParam("uname") String uname,
			@RequestParam("passwd") String passwd, Model model) {
		boolean flag = userService.login(uname, passwd);
		if (flag) {      // ����¼��֤�ɹ�����uname����HttpSession��,��ת��"��ӭҳ"
			model.addAttribute("uname", uname);
			return "welcome";   // �߼���ͼ��ת��ӭҳ��
		}
		return "login";   // �߼���ͼ����Ȼת���¼ҳ��
	}
}
