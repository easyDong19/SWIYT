/**
 * 
 */
package org.func.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.func.service.UserService;
import org.func.uservo.UserVo;
import org.func.util.CommonUtil;


/**
* <pre>
* org.func.action
*	|_ SignupAction
* 
* 1. 개요 : 
* 2. 작성일 : 2017. 11. 21.
*<pre>
*
*@author         : USER
*@version        : 1.0
*/
public class SignupAction implements IAction{

	/* (non-Javadoc)
	 * @see org.func.action.IAction#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	
	private void validate(UserVo vo) throws Exception{
		
		if(CommonUtil.isEmpty(vo.getEmail())) throw new Exception("이메일를 입력하시오");
		if(CommonUtil.isEmpty(vo.getPwd())) throw new Exception("비밀번호를 입력하시오");
		if(CommonUtil.isEmpty(vo.getNickname())) throw new Exception("닉네임를 입력하시오");
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
try{
			
			response.setContentType("text/html;charset=utf-8");
	        request.setCharacterEncoding("utf-8");
	      
	      // 1.입력값 추출
	      String email = request.getParameter("email");
	      String pwd = request.getParameter("pwd");
	      String nickname = request.getParameter("nickname");
	     	      
	      System.out.printf("email : %s, pwd : %s, nickname : %s", email, pwd, nickname);
	      
	      // 2. 입력값 검증
	      UserVo user = new UserVo(email, pwd, nickname);
	      
	      validate(user);
	      

	      
	      // Service 호출
	      UserService service = new UserService();
	      service.signup(user);
	      
	      request.setAttribute("success", "회원 가입하셨습니다.");
	      
	      RequestDispatcher rd = request.getRequestDispatcher("jsp/main.jsp");
	      rd.forward(request, response);
	      
	
		} catch(Exception e){
			e.printStackTrace();
	    	request.setAttribute("error", e.getMessage());
	    	RequestDispatcher rd = request.getRequestDispatcher("jsp/main.jsp");
	        rd.forward(request, response);
		}
		
	}

}
