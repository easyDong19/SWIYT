/**
 * 
 */
package org.func.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* <pre>
* org.func.action
*	|_ IAction
* 
* 1. 개요 : 
* 2. 작성일 : 2017. 11. 18.
*<pre>
*
*@author         : USER
*@version        : 1.0
*/
public interface IAction {
	void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
