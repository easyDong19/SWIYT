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
	
	public void signup(UserVo user) throws Exception{
		Connection conn = null;
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			//사용 중인 아이디인지 체크
			UserVo result = dao.searchUserById(user);
			if(result != null) {
				throw new Exception("이미 사용중인 아이디입니다.");
			}
			//사용자 등록
			dao.insertUser(user);
		
			
		} finally{
			if(conn != null) conn.close();
		}	
	}
}