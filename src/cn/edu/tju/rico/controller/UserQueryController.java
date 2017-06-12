package cn.edu.tju.rico.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.tju.rico.model.entity.User;
import cn.edu.tju.rico.service.UserService;

/**        
 * Title: UserQueryController  
 * Description: ����鿴ָ���û�ID���û���Ϣ����
 * @author rico       
 * @created 2017��4��24�� ����9:07:29    
 */     
@Controller
public class UserQueryController {

	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/query")
	public ModelAndView showUser(@RequestParam("id") int id){
		ModelAndView mv = new ModelAndView();
		User user = userService.getUser(id);
		if (user != null) {
			mv.addObject("user", user);
		}else{
			mv.addObject("tip", "�����ڴ��û�...");
		}
		mv.setViewName("show");   // �趨�߼���ͼ
		return mv;
	}
}
