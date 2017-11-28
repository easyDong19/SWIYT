/**
 * 
 */
package org.func.uservo;

/**
* <pre>
* org.func.uservo
*	|_ MatchVo
* 
* 1. 개요 : 
* 2. 작성일 : 2017. 11. 28.
*<pre>
*
*@author         : USER
*@version        : 1.0
*/
public class MatchVo {
	private String lane[] = new String[20];
	private String gameId[] = new String[20];
	private String role[] = new String[20];
	private String champion[] = new String[20];
	/**
	 * @return the lane
	 */
	public String[] getLane() {
		return lane;
	}
	/**
	 * @param lane the lane to set
	 */
	public void setLane(String[] lane) {
		this.lane = lane;
	}
	/**
	 * @return the gameId
	 */
	public String[] getGameId() {
		return gameId;
	}
	/**
	 * @param gameId the gameId to set
	 */
	public void setGameId(String[] gameId) {
		this.gameId = gameId;
	}
	/**
	 * @return the role
	 */
	public String[] getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String[] role) {
		this.role = role;
	}
	/**
	 * @return the champion
	 */
	public String[] getChampion() {
		return champion;
	}
	/**
	 * @param champion the champion to set
	 */
	public void setChampion(String[] champion) {
		this.champion = champion;
	}
	
	

}
