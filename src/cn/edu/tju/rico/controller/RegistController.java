package cn.edu.tju.rico.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.tju.rico.dto.UserDTO;
import cn.edu.tju.rico.service.UserService;
  
/**        
 * Title:  RegistController   
 * Description: �����û���ע������
 * @author rico       
 * @created 2017��6��12�� ����11:57:42    
 */      
@Controller
public class RegistController {
	
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(UserDTO userDto){  // HandlerAdaptor��form���еĸ�����ӳ�䵽userDto������
		System.out.println(userDto);
		boolean flag = userService.regist(userDto);
		return flag ? "login" : "regist";    // ����ע������ת���ض�ҳ��
	}
}
