package cn.edu.tju.rico.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.tju.rico.model.entity.User;

  
/**        
 * Title: User PO����SQL��ӳ���ϵ   
 * Description: ���������ķ�ʽ��PO��User�Ĳ���ӳ���Ϊ��Ӧ�ĳ־û�����
 * @author rico       
 * @created 2017��6��12�� ����12:09:34    
 */      
public interface UserMapper {

	  
	/**     
	 * @description ����ָ����uname��passwd��ѯ�û�
	 * @author rico       
	 * @created 2017��6��12�� ����12:18:31     
	 * @param uname
	 * @param passwd
	 * @return     
	 */
	@Select("select * from user_inf where uname = #{uname} and passwd = #{passwd}")
	public User findUserByUnameAndPasswd(@Param("uname") String uname,
			@Param("passwd") String passwd);

	  
	/**     
	 * @description �־û��û��������ݿ����һ���û���¼
	 * @author rico       
	 * @created 2017��6��12�� ����12:19:01     
	 * @param user     
	 */
	@Insert("insert into user_inf(uname, passwd, gentle, email, city) values (#{uname},#{passwd},#{gentle},#{email},#{city})")
	@Options(useGeneratedKeys = true, keyProperty="id")
	public void saveUser(User user);
	
	  
	/**     
	 * @description ����ָ����uname��ѯ�û�
	 * @author rico       
	 * @created 2017��6��12�� ����12:19:24     
	 * @param uname
	 * @return     
	 */
	@Select("select * from user_inf where uname = #{uname}")
	public User findUserByUname(@Param("uname") String uname);
	
	  
	/**     
	 * @description ����ָ����id��ѯ�û�
	 * @author rico       
	 * @created 2017��6��12�� ����12:19:40     
	 * @param id
	 * @return     
	 */
	@Select("select * from user_inf where id = #{id}")
	public User findUserById(@Param("id") int id);
}
