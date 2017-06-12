package cn.edu.tju.rico.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.tju.rico.dto.UserDTO;
import cn.edu.tju.rico.mapper.LogMapper;
import cn.edu.tju.rico.mapper.UserMapper;
import cn.edu.tju.rico.model.entity.Log;
import cn.edu.tju.rico.model.entity.User;
import cn.edu.tju.rico.service.UserService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Component("userService")
public class UserServiceImpl implements UserService{
	
	private UserMapper userMapper;
	private LogMapper logMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Resource  // Ĭ�ϰ�����(userMapper)ע��,������ƥ��ʧ�ܣ���������ƥ��
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public LogMapper getLogMapper() {
		return logMapper;
	}

	@Resource
	public void setLogMapper(LogMapper logMapper) {
		this.logMapper = logMapper;
	}

	/** 
	 * @description ��¼�߼��ľ���ʵ�֣���Ӧ��������û��Ĳ�ѯ����־�Ĳ���������
	 * @author rico       
	 * @created 2017��4��24�� ����9:34:07      
	 * @param uname
	 * @param passwd
	 * @return �û���������ƥ��ɹ�������true�����򣬷���false;    
	 * @see cn.edu.tju.rico.service.UserService#login(java.lang.String, java.lang.String)     
	 */  
	@Transactional(readOnly = false)
	public boolean login(String uname, String passwd) {
		// TODO Auto-generated method stub
		User user = userMapper.findUserByUnameAndPasswd(uname, passwd);
		
		Log log = new Log();
		log.setDate(new Date());
		if (user == null) {
			log.setMsg(uname + "��¼ʧ��...");
		}else{
			log.setMsg(uname + "��¼�ɹ�...");
		}
		logMapper.saveLog(log);
		return user == null ? false : true;
	}

	  
	/** 
	 * @description �û�ע���߼��ľ���ʵ��
	 * @author rico       
	 * @created 2017��6��12�� ����12:21:45      
	 * @param userDto
	 * @return     
	 * @see cn.edu.tju.rico.service.UserService#regist(cn.edu.tju.rico.dto.UserDTO)     
	 */  
	@Transactional(readOnly = false)
	public boolean regist(UserDTO userDto) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Log log = new Log();
		log.setDate(new Date());
		if (!userDto.getPasswd().equals(userDto.getPasswd1())) {
			log.setMsg("�û� " + userDto.getUname() + " ��ע��ʱ�������������벻һ��...");
		} else if (userMapper.findUserByUname(userDto.getUname()) != null) {
			log.setMsg("�û� " + userDto.getUname() + " ��ע��ʱ�����û����ѱ�ռ��...");
		} else {
			User user = new User(userDto);
			userMapper.saveUser(user);
			log.setMsg("�û� " + userDto.getUname() + " ע��ɹ�...");
			flag = true;
		}
		logMapper.saveLog(log);
		return flag;
	}

	  
	/** 
	 * @description �û���ȡ�߼��ľ���ʵ��
	 * @author rico       
	 * @created 2017��6��12�� ����12:22:00      
	 * @param id
	 * @return     
	 * @see cn.edu.tju.rico.service.UserService#getUser(int)     
	 */  
	    
	@Transactional(readOnly = true)
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userMapper.findUserById(id);
	}
}
