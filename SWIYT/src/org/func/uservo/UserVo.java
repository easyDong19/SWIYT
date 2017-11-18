/**
 * 
 */
package org.func.uservo;

/**
* <pre>
* org.func.uservo
*	|_ UserVo
* 
* 1. 개요 : 
* 2. 작성일 : 2017. 11. 18.
*<pre>
*
*@author         : USER
*@version        : 1.0
*/
public class UserVo {
	
	private String email;
	private String pwd;
	private String nickname;
	
	public UserVo(){

	}
	
	public UserVo(String email, String pwd, String nickname){
		this.email = email;
		this.pwd = pwd;
		this.nickname = nickname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
