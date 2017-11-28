<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>SWIYT</title>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="${ contextPath }/public/css/materialize.min.css" />
  <link rel="stylesheet" href="${ contextPath }/public/css/profile.css">

</head>

<body>

	  <nav>
	    <div class="nav-wrapper top_nav">
	      <a href="${ contextPath }/jsp/main.jsp" class="brand-logo">SWIYT</a>
	    </div>
	  </nav>
	
	  <div class="container Rank_wrapper">
	  
	  	<div class="rank_info">
	  		<h5>랭크 정보</h5>
	  	</div>
	    <div class="row">
	      <div class="soloRank_wrapper col s12 m6 z-depth-1">
	        <div class="SoloRankName">SOLO RANK</div>
	        <div class="tier_img"><img src="${ contextPath }/public/image/${summoner.tier_name}.png"></div>
	        <div class="soloTier_content">
	          리그 : ${ summoner.rank_name}
	          <Br />
	          <Br />
	          등급 : ${ summoner.tier_name}
	          <Br />
	          <Br />
	          리그 포인트 : ${ summoner.rank_point}
	          <Br />
	          <Br />
	          전적 : 승 ${ summoner.win}/ 패${ summoner.loss}
	        </div>
	      </div>
	
	      <div class="freeRank_wrapper col s12 m6 z-depth-1">
	        <div class="FreeRankName">FREE RANK</div>
	        <div class="tier_img"><img src="${ contextPath }/public/image/${team.tier_name}.png"></div>
	        <div class="freeTier_content">
	            리그 : ${ team.rank_name}
	          <Br />
	          <Br />
	          등급 : ${ team.tier_name}
	          <Br />
	          <Br />
	          리그 포인트 : ${ team.rank_point}
	          <Br />
	          <Br />
	          전적 : 승 ${ team.win}/ 패${ team.loss}
	        </div>
	      </div>
	    </div>
	  </div>
		

  

  <!--SCRIPT-->
  <script type="text/javascript" src="${ contextPath }/public/js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="${ contextPath }/public/js/materialize.min.js"></script>
  <script tpye="text/javascript" src="${ contextPath }/public/js/main.js"></script>
  
  
  
</body>

</html>
