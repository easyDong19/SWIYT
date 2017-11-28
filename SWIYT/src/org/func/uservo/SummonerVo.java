/**
 * 
 */
package org.func.uservo;

/**
* <pre>
* org.func.uservo
*	|_ SummonerVo
* 
* 1. 개요 : 
* 2. 작성일 : 2017. 11. 27.
*<pre>
*
*@author         : USER
*@version        : 1.0
*/
public class SummonerVo {
	
	private String name;
	private String id;
	private String level;
	private String accountId;
	private String tier_name;
	private String rank_name;
	private String rank;
	private String rank_point;
	private String win;
	private String loss;
	
	public SummonerVo(){
		
	}
	
	/**
	 * @return the rank_name
	 */
	public String getRank_name() {
		return rank_name;
	}
	/**
	 * @param rank_name the rank_name to set
	 */
	public void setRank_name(String rank_name) {
		this.rank_name = rank_name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * @return the tier_name
	 */
	public String getTier_name() {
		return tier_name;
	}
	/**
	 * @param tier_name the tier_name to set
	 */
	public void setTier_name(String tier_name) {
		this.tier_name = tier_name;
	}
	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	/**
	 * @return the rank_point
	 */
	public String getRank_point() {
		return rank_point;
	}
	/**
	 * @param rank_point the rank_point to set
	 */
	public void setRank_point(String rank_point) {
		this.rank_point = rank_point;
	}
	/**
	 * @return the win
	 */
	public String getWin() {
		return win;
	}
	/**
	 * @param win the win to set
	 */
	public void setWin(String win) {
		this.win = win;
	}
	/**
	 * @return the loss
	 */
	public String getLoss() {
		return loss;
	}
	/**
	 * @param loss the loss to set
	 */
	public void setLoss(String loss) {
		this.loss = loss;
	}
}
