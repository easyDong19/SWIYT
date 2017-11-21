/**
 * 
 */
package org.func.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.func.uservo.UserVo;

/**
* <pre>
* org.func.dao
*	|_ UserDao
* 
* 1. 개요 : 
* 2. 작성일 : 2017. 11. 18.
*<pre>
*
*@author         : USER
*@version        : 1.0
*/
public class UserDao {
	 private Connection conn = null;
	   
	   public UserDao(Connection conn) {
	      this.conn = conn;
	   }
	   
	   public UserVo searchUser(UserVo vo)throws Exception{
	      
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      String sql = "SELECT * FROM USER WHERE EMAIL=? AND PWD=?";
	      
	      try{
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, vo.getEmail());
	         pstmt.setString(2, vo.getPwd());
	         
	         rs = pstmt.executeQuery();
	         
	         UserVo result = null;
	         if(rs.next()) {
	            result = new UserVo();
	            result.setEmail(rs.getString(1)); // PWD:2
	            result.setNickname(rs.getString(3));
	         }
	         
	         return result;
	         
	      }catch(Exception e){
	         e.printStackTrace();
	         throw new Exception("사용자 조회시 오류가 발생했습니다.");
	      }finally{
	         if(rs != null) rs.close();
	         if(pstmt != null) pstmt.close();
	      }
	   }
	   
	   public UserVo searchUserById(UserVo vo) throws Exception {
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    
		    String sql = "SELECT * FROM USER WHERE EMAIL=?";
		    
		    try{
		       pstmt = conn.prepareStatement(sql);
		       pstmt.setString(1, vo.getEmail());

		       
		       rs = pstmt.executeQuery();
		       
		       UserVo result = null;
		       if(rs.next()) {
		          result = new UserVo();
		          result.setEmail(rs.getString(1)); // PWD:2
		          result.setNickname(rs.getString(3)); 
		       }
		       
		       return result;
		       
		    }catch(Exception e){
		       e.printStackTrace();
		       throw new Exception("사용자 조회시 오류가 발생했습니다.");
		    }finally{
		       if(rs != null) rs.close();
		       if(pstmt != null) pstmt.close();
		    }
		}
	   
	   public void insertUser(UserVo vo) throws Exception {
			PreparedStatement pstmt = null;
		  
		    
		    String sql = "INSERT INTO USER VALUES(?,?,?)";
		    
		    try{
		       pstmt = conn.prepareStatement(sql);
		       pstmt.setString(1, vo.getEmail());
		       pstmt.setString(2, vo.getPwd());
		       pstmt.setString(3, vo.getNickname());
		       

		       // SELECT : executeQuery()
		       // INSERT, UPDATE, DELETE : executeUpDate()
		       int cnt = pstmt.executeUpdate();
		       
		       if(cnt == 0) throw new Exception("사용자 등록에 실패하였습니다.");
		       
		    }catch(Exception e){
		       e.printStackTrace();
		       throw new Exception("사용자 조회시 오류가 발생했습니다.");
		    }finally{
		    	
		       if(pstmt != null) pstmt.close();
		    }
		}

	   
	   
	 
		   
	   
	  
	   

}
