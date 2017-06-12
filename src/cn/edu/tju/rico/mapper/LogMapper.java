package cn.edu.tju.rico.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import cn.edu.tju.rico.model.entity.Log;

  
/**        
 * Title: Log PO����SQL��ӳ���ϵ   
 * Description: ���������ķ�ʽ��PO��Log�Ĳ���ӳ���Ϊ��Ӧ�ĳ־û�����
 * @author rico       
 * @created 2017��6��12�� ����12:09:34    
 */      
public interface LogMapper {
	  
	/**     
	 * @description ����־�־û������ݿ���
	 * @author rico       
	 * @created 2017��6��12�� ����12:15:33     
	 * @param log     
	 */
	@Insert("insert into log_inf(date,msg) values (#{date,jdbcType=TIMESTAMP},#{msg})")
	@Options(useGeneratedKeys=true, keyProperty="id")  // �Զ���������
	public void saveLog(Log log);
}
