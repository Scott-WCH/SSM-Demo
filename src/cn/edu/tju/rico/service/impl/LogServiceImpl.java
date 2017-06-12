package cn.edu.tju.rico.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.edu.tju.rico.mapper.LogMapper;
import cn.edu.tju.rico.model.entity.Log;
import cn.edu.tju.rico.service.LogService;
  
/**        
 * Title: LogServiceImpl.java    
 * Description: LogService ���߼�ʵ����
 * @author rico       
 * @created 2017��4��24�� ����9:30:33    
 */      
@Component("logService")
public class LogServiceImpl implements LogService{
	
	/**  ��Spring��������   (@author: rico) */      
	private LogMapper logMapper;
	
	public LogMapper getLogMapper() {
		return logMapper;
	}

	@Resource
	public void setLogMapper(LogMapper logMapper) {
		this.logMapper = logMapper;
	}



	/** 
	 * @description ��־����
	 * @author rico       
	 * @created 2017��4��24�� ����9:31:19      
	 * @param log     
	 * @see cn.edu.tju.rico.service.LogService#add(cn.edu.tju.rico.model.entity.Log)     
	 */  
	public void addLog(Log log) {
		// TODO Auto-generated method stub
		logMapper.saveLog(log);
	}
}
