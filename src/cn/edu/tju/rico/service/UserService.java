package cn.edu.tju.rico.service;

import cn.edu.tju.rico.dto.UserDTO;
import cn.edu.tju.rico.model.entity.User;

/**        
 * Title: UserService.java    
 * Description: ���û���ص�ҵ���߼��ĳ���(����ӿڱ��)
 * @author rico       
 * @created 2017��4��24�� ����9:28:09    
 */      
public interface UserService {
	
	  
	/**     
	 * @description �û���¼�߼�
	 * @author rico       
	 * @created 2017��4��24�� ����9:29:48     
	 * @param uname
	 * @param passwd
	 * @return     
	 */
	public boolean login(String uname, String passwd);
	
	  
	/**     
	 * @description �û�ע���߼�
	 * @author rico       
	 * @created 2017��4��24�� ����9:30:02     
	 * @param userDto
	 * @return     
	 */
	public boolean regist(UserDTO userDto);
	
	  
	/**     
	 * @description  �û���ȡ�߼�
	 * @author rico       
	 * @created 2017��4��24�� ����9:30:15     
	 * @param id
	 * @return     
	 */
	public User getUser(int id); 
}

