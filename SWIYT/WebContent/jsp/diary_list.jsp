<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <!-- Compiled and minified CSS -->

  <link rel="stylesheet" href="${ contextPath }/public/css/materialize.min.css" />
  <link rel="stylesheet" href="${ contextPath }/public/css/diary.css">

</head>

<body>
  <nav>
    <div class="nav-wrapper top_nav">
      <a href="${ contextPath }/jsp/main.jsp" class="brand-logo">SWIYT</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <ul id="nav-mobile" class="right hide-on-med-and-down">
           <li><a href="#writing_modal" class="waves-effect waves-light btn write-btn modal-trigger">글쓰기</a></li>
        </ul>
    </div>
  </nav>
  
  <div id="writing_modal" class="modal">
    <div class="modal-content" >
      <form action="#" method="post">
        <table width="700" border="3" bordercolor="lightgray" align="center">
          <tr>
            <td>
              <input name="board_subject" type="text" size="70" maxlength="100" value="" placeholder="제목"/>
            </td>
          </tr>
          <tr>
            <td>
              <textarea class="content" name="board_content" cols="72" rows="50"  placeholder="내용"></textarea>
            </td>
          </tr>
        </table>
      </form>
    </div>
      <div class="writeButtonWrapper"><button type="submit" class="waves-effect waves-light btn writeButton">글쓰기</button></div>
  </div>

  <article class="main_list">
    <table class="bordered centered">
      <thead>
        <tr>
          <th>제목</th>
          <th>작성 날짜</th>
        </tr>
      </thead>

      <tbody>
      
      </tbody>
    </table>
  </article>


 <!--SCRIPT-->
  <script type="text/javascript" src="${ contextPath }/public/js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="${ contextPath }/public/js/materialize.min.js"></script>
  <script tpye="text/javascript" src="${ contextPath }/public/js/main.js"></script>
</body>

</html>
