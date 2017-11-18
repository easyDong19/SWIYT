<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>SWIYT</title>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="../public/css/materialize.min.css" />
  <link rel="stylesheet" href="../public/css/main.css">

</head>

<body>

  <nav>
    <div class="container-wide">
      <div class="row">
        <div class="col s12 m3"><a href="#" class="logo">SO what is your tier?</a></div>
        <div class="col s12 m9">
          <div class="right">
            <ul>
              <li><a href="#">사용자 정보</a></li>
              <li><a href="#">성장 일기</a></li>
              <li><a href="#login_modal" class="waves-effect waves-light btn sign-btn modal-trigger">login/sign in</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </nav>

  <div id="login_modal" class="modal">
    <div class="modal-header row">
      <div class="col s12">
        <ul class="tabs">
          <li class="tab col s6"><a class="active" href="#login">로그인</a></li>
          <li class="tab col s6"><a href="#signin">회원 가입</a></li>
        </ul>



        <div id="login" class="col s12">
          <form action="#">
            <div class="content">
              <div class="inputWrap"><input type="email" class="Input" placeholder="이메일"></div>
              <div class="inputWrap"><input type="password" class="Input" placeHolder="비밀번호"></div>
              <div class="buttonWrap"><button type="submit" class="waves-effect waves-light btn login_button">로그인</button></div>
            </div>
          </form>
        </div>
        <div id="signin" class="col s12">
          <form action="#">
            <div class="content">
              <div class="inputWrap">
                <label for="Email">Email</label>
                <input type="email" class="Input" placeholder="이메일 입력"></div>
              <div class="inputWrap">
                <label for="password">PassWord</label>
                <input type="password" class="Input" placeHolder="비밀 번호 입력"></div>
              <div class="inputWrap">
                <label for="nickname">NickName</label>
                <input type="password" class="Input" placeHolder="닉네임 입력"></div>
            </div>
            <div class="buttonWrap"><button type="submit" class="waves-effect waves-light btn signin_button">회원가입</button>
            </div>
        </div>
        </form>
      </div>
    </div>
  </div>






  </div>


  <div class="main main_landing">
    <div class="large_jumbo_wrapper container-wide">
      <div class="large_jumbo_middle">
        <div class="row">
          <div class="col l5 left_jumbo">
            <h1>여기서 캐리한 건 나야 나</h1>
            <div class="writer_left">
              <p>
                게임이 끝나고 시작되는 입털기 시간<br /> 모두 다 내가 잘했다고 외치는 때 <br /><a class="bold_writing">그님티</a>에서 객관적으로 판단해보자 <br />
              </p>
            </div>

          </div>
          <div class="col l7 right_jumbo">
            <div class="carousel">
              <a class="carousel-item"><img src="../public/image/bronze.png"></a>
              <a class="carousel-item"><img src="../public/image/silver.png"></a>
              <a class="carousel-item"><img src="../public/image/gold.png"></a>
              <a class="carousel-item"><img src="../public/image/platinum.png"></a>
              <a class="carousel-item"><img src="../public/image/diamond.png"></a>
              <a class="carousel-item"><img src="../public/image/challenger.png"></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="copyRight">
    <div class="container">
      © 2017 made by dong
    </div>

  </div>


  <!--SCRIPT-->
  <script type="text/javascript" src="../public/js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="../public/js/materialize.min.js"></script>
  <script tpye="text/javascript" src="../public/js/main.js"></script>
</body>

</html>
