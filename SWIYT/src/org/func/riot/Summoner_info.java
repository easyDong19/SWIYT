/**
 * 
 */
package org.func.riot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import org.func.uservo.SummonerVo;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
* <pre>
* org.func.riot
*	|_ Summoner_info
* 
* 1. 개요 : 
* 2. 작성일 : 2017. 11. 27.
*<pre>
*
*@author         : USER
*@version        : 1.0
*/
public class Summoner_info {
	

	
	/**
	 * 
	 */
	public Summoner_info() {
		// TODO Auto-generated constructor stub
	}

	public SummonerVo Summoner_in(String nickname) throws Exception{
		try{

			String urlstr = "https://kr.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+nickname+"?api_key=RGAPI-418e6753-3bec-4b9a-92eb-2a11036b6e5a";
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
            JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
            
            System.out.println("이름 : " + jsonObj.get("name"));
            System.out.println("ID : " + jsonObj.get("id"));
            System.out.println("ACCOUNT ID : " + jsonObj.get("accountId"));
            System.out.println("소환사 레벨 : " + jsonObj.get("summonerLevel"));
            
            SummonerVo summoner =  null;
            
            
            summoner = new SummonerVo();
            summoner.setName(jsonObj.get("name").toString());
            summoner.setId(jsonObj.get("id").toString());
            summoner.setAccountId(jsonObj.get("accountId").toString());
            summoner.setLevel(jsonObj.get("summonerLevel").toString());


            
            return summoner;
            
               
		}catch(Exception e){
			e.printStackTrace();
	         throw new Exception("사용자 조회시 오류가 발생했습니다.");
		}
		
	}
	

}
