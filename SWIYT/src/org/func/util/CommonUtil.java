/**
 * 
 */
package org.func.util;

/**
* <pre>
* org.func.util
*	|_ CommonUtil
* 
* 1. 개요 : 
* 2. 작성일 : 2017. 11. 18.
*<pre>
*
*@author         : USER
*@version        : 1.0
*/
public class CommonUtil {
	public static boolean isEmpty(String s){
		return s == null || "".equals(s.trim());
	}

}
