/**
 * 
 */
package org.func.riot;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.func.uservo.MatchVo;
import org.func.uservo.SummonerVo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
* <pre>
* org.func.riot
*	|_ gameMatchList
* 
* 1. 개요 : 
* 2. 작성일 : 2017. 11. 28.
*<pre>
*
*@author         : USER
*@version        : 1.0
*/
public class GameMatchList {
	
	public String parse(String urlstr) throws Exception{
		
		try {
			URL url = new URL(urlstr);
			BufferedReader bf;
			String line;
			String result = "";

			
			bf = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line=bf.readLine())!=null){
				
				result=result.concat(line);
				//System.out.println(line);
			}
			
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			 throw new Exception("사용자 조회시 오류가 발생했습니다.");
		}
	}
	
	public String[] GetGameId(String accountId) throws Exception{
		//5가지 게임 정보를 담은 ID를 담는 과정
		String resentMatch = "https://kr.api.riotgames.com/lol/match/v3/matchlists/by-account/"+accountId+"/recent?api_key=RGAPI-418e6753-3bec-4b9a-92eb-2a11036b6e5a";
		
		String result_AccountID = parse(resentMatch);
		JSONParser jsonParser = new JSONParser();
        JSONObject matches = (JSONObject) jsonParser.parse(result_AccountID);
        
        JSONArray arr = (JSONArray)matches.get("matches");
        
        
    	String gameId[] = new String[5];
    	
        for(int i=0; i<5; i++){
        	 JSONObject tmp = (JSONObject)arr.get(i); 
        	 gameId[i] = tmp.get("gameId").toString();
        }
        
        return gameId;
	}
	
	@SuppressWarnings("rawtypes")
	public List GetParticipantId(String[] gameId) throws Exception {
		
		    JSONParser jsonParser = new JSONParser();
		    String gameIds[] = new String[5];
		    gameIds = gameId;
	        
	        HashMap<String, Integer> participant;
	        List PartList = new ArrayList();
	        

	      
	        for(int i=0; i<5; i++){
	        	
	        	 String match = "https://kr.api.riotgames.com/lol/match/v3/matches/"+gameId[i]+"?api_key=RGAPI-418e6753-3bec-4b9a-92eb-2a11036b6e5a";
	        	 String match_info = parse(match);
	 	         JSONObject matches_info = (JSONObject) jsonParser.parse(match_info);
	 	         
	 	         JSONArray match_arr = (JSONArray)matches_info.get("participantIdentities");
	 	         participant = new HashMap<String, Integer>();
	 	         for(int j=0; j<10; j++){
	 	        	
	 	        	JSONObject tmp = (JSONObject)match_arr.get(j);
		 	        JSONObject player = (JSONObject)tmp.get("player");
		 	        participant.put(player.get("summonerName").toString(), j+1);
	 	         }  
	 	        PartList.add(participant);

	        }
	        
	        System.out.println(PartList);
			return PartList; 
	}
	
	


}

