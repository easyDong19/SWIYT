package org.func.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.func.action.IAction;
import org.func.action.LoginAction;
import org.func.action.LogoutAction;
import org.func.action.SignupAction;


/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, IAction> actions = new HashMap<>();  
	
	public void init() throws ServletException{
		actions.put("login", new LoginAction());
    	actions.put("logout", new LogoutAction());
    	actions.put("signup", new SignupAction());
	}
       
  
    public ActionServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			// /login.do -> login만 추출
			String uri = request.getRequestURI();
			System.out.println("uri :" + uri); // /login.do
			
			String actionName = uri.substring(uri.lastIndexOf("/")+1);
			actionName = actionName.substring(0, uri.lastIndexOf(".")-1);
			System.out.println("actionName : " + actionName);
			
			// action 객체 가져오기
			IAction action = actions.get(actionName);
			
			if(action == null){
				throw new Exception(actionName + "에 해당하는 Action 클래스가 없습니다.");
			}
			
			
			action.execute(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/error.jsp");
			rd.forward(request, response);
		}
		
	}

}
