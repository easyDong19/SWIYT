/**
 * 
 */
package org.func.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* <pre>
* org.func.action
*	|_ LogoutAction
* 
* 1. 개요 : 
* 2. 작성일 : 2017. 11. 18.
*<pre>
*
*@author         : USER
*@version        : 1.0
*/
public class LogoutAction implements IAction {

	/* (non-Javadoc)
	 * @see org.func.action.IAction#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 세션 삭제
		HttpSession session = request.getSession();
		//session.removeAttribute("user");
		session.invalidate(); //세션 삭제
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/main.jsp");
	    rd.forward(request, response);
		
	}

}
