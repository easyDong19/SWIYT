/**
 * 
 */
package org.func.riot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.func.uservo.SummonerVo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
* <pre>
* org.func.riot
*	|_ Summoner_position
* 
* 1. 개요 : 
* 2. 작성일 : 2017. 11. 27.
*<pre>
*
*@author         : USER
*@version        : 1.0
*/
public class Summoner_position {
	
	public SummonerVo pos_in(SummonerVo summoner, int i) throws Exception{
		
		try{
		
		String urlstr = "https://kr.api.riotgames.com/lol/league/v3/positions/by-summoner/"+summoner.getId()+"?api_key=RGAPI-418e6753-3bec-4b9a-92eb-2a11036b6e5a";
		URL url = new URL(urlstr);
		BufferedReader bf;
		String line;
		String result = "";
		
		
		bf = new BufferedReader(new InputStreamReader(url.openStream()));
		
		while((line=bf.readLine())!=null){
			result=result.concat(line);
			//System.out.println(line);
		}
		JSONParser jsonParser = new JSONParser();
        JSONArray jsonObj = (JSONArray) jsonParser.parse(result);
        

        JSONObject tmp = (JSONObject)jsonObj.get(i);
        
        summoner.setTier_name(tmp.get("tier").toString());
        summoner.setWin(tmp.get("wins").toString());
        summoner.setLoss(tmp.get("losses").toString());
        summoner.setRank(tmp.get("rank").toString());
        summoner.setRank_point(tmp.get("leaguePoints").toString());
        summoner.setRank_name(tmp.get("leagueName").toString());
        
        return summoner;
       
		}catch(Exception e){
			e.printStackTrace();
	        throw new Exception("사용자 조회시 오류가 발생했습니다.");
		}
	}
	
	

}
