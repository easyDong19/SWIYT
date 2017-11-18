/**
 * 
 */
package org.func.service;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
* <pre>
* org.func.service
*	|_ AbstractService
* 
* 1. 개요 : 
* 2. 작성일 : 2017. 11. 18.
*<pre>
*
*@author         : USER
*@version        : 1.0
*/
public class AbstractService {
	
	public Connection getConnection() throws Exception{
		try{
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java://comp/env/jdbc/mysql");
			dataSource.getConnection();
			return dataSource.getConnection();
		} catch(Exception e){
			throw new Exception("데이터 베이스 연결에 실패하였습니다.");
		}
	}

}
