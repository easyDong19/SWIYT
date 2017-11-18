/**
 * 
 */
package org.func.service;

import java.sql.Connection;

import org.func.dao.UserDao;
import org.func.uservo.UserVo;



/**
* <pre>
* org.func.service
*	|_ UserService
* 
* 1. 개요 : 
* 2. 작성일 : 2017. 11. 18.
*<pre>
*
*@author         : USER
*@version        : 1.0
*/
public class UserService extends AbstractService{
	public UserVo login(UserVo user) throws Exception{
			
			Connection conn = null;
			try {
				conn = getConnection();
				
				UserDao dao = new UserDao(conn);
				UserVo result = dao.searchUser(user);
				
				
				if(result == null)
					throw new Exception("Invalid username or password");
				
				return result;
			} finally{
				if(conn != null) conn.close();
			}
	
	}
}