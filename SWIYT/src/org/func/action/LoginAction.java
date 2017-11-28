/**
 * 
 */
package org.func.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.func.riot.GameMatchList;
import org.func.riot.Summoner_info;
import org.func.riot.Summoner_position;
import org.func.service.UserService;
import org.func.uservo.UserVo;
import org.func.uservo.SummonerVo;
import org.func.util.CommonUtil;

/**
* <pre>
* org.func.action
*	|_ LoginAction
* 
* 1. 개요 : 
* 2. 작성일 : 2017. 11. 18.
*<pre>
*
*@author         : USER
*@version        : 1.0
*/
public class LoginAction implements IAction{

	// 입력값 검증
		private void validate(String id, String pwd) throws Exception{
			if(CommonUtil.isEmpty(id)) throw new Exception("아이디를 입력하세요.");
			if(CommonUtil.isEmpty(pwd)) throw new Exception("비밀번호를 입력하세요.");
		}
		
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try{
			response.setContentType("text/html;charset=utf-8");
		    request.setCharacterEncoding("utf-8");
		    
		    // 입력값 추출
		      String email = request.getParameter("email");
		      String pwd = request.getParameter("pwd");
		      System.out.printf("email : %s, pwd : %s", email, pwd);
		      
		      // 입력값 검증
		      validate(email, pwd);
		      
		      // service 호출
		      UserVo user = new UserVo();
		      user.setEmail(email);
		      user.setPwd(pwd);
		   

		      UserService service = new UserService();
		      UserVo result = service.login(user);
		      
		  
		     
		   
		   // 라이엇 api 사용 단
		      String nickname = result.getNickname();
		      
		   // 솔로 랭크
		      Summoner_info summoner = new Summoner_info();
		      Summoner_position Solo_position = new Summoner_position();
		      
		      SummonerVo Solo_summonervo = Solo_position.pos_in(summoner.Summoner_in(nickname),1);
		   // 자유 랭크
		      Summoner_position Free_position = new Summoner_position();
		      
		      SummonerVo Free_summonervo = Free_position.pos_in(summoner.Summoner_in(nickname),0);
		   
		   // match 게임 정보 
		      String accountId = Solo_summonervo.getAccountId();
		      GameMatchList game = new GameMatchList();
		      String gameId[] = new String[5];
		      gameId = game.GetGameId(accountId);
		      
		      
		      
		      
		      
		
		      	
		      
		      
		      
		   // 세션에 사용자 생성
		      HttpSession session = request.getSession();
		      session.setAttribute("user", result);
		      session.setAttribute("summoner", Solo_summonervo);
		      session.setAttribute("team", Free_summonervo);
		         
		      RequestDispatcher rd = request.getRequestDispatcher("jsp/main.jsp");
		      rd.forward(request, response);
		      
		      
		      
		} catch(Exception e){
			e.printStackTrace();
	    	request.setAttribute("error", e.getMessage());
	    	RequestDispatcher rd = request.getRequestDispatcher("jsp/main.jsp");
	        rd.forward(request, response);
		}
		
	}

	/**
	 * @return
	 */
	

}
