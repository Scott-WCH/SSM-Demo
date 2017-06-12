package cn.edu.tju.rico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**        
 * Title:  ChoiceController   
 * Description: ����ȥӦ����ҳ��ȥ��¼��ȥע����������
 * @author rico       
 * @created 2017��6��12�� ����12:02:14    
 */      
@Controller
@RequestMapping("/choice")
public class ChoiceController {
	
	@RequestMapping("/choose")
	public String choose() {
		return "index";  // �߼���ͼ��������ҳ
	}

	@RequestMapping("/tologin")
	public String goLogin() {
		return "login";   // �߼���ͼ����¼ҳ��
	}
	
	@RequestMapping("/toregist")
	public String goRegist() {
		return "regist";    // �߼���ͼ��ע��ҳ��
	}
}
