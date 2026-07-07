# SWIYT (SO What Is Your Tier?)

리그 오브 레전드(LoL) 소환사의 **티어·랭크·전적 정보**를 조회하는 Java 웹 애플리케이션입니다.
회원가입 시 등록한 소환사 닉네임으로 로그인하면, [Riot Games API](https://developer.riotgames.com/)를 통해
해당 소환사의 솔로랭크/자유랭크 정보와 최근 게임 목록을 가져와 보여줍니다.

> **SWIYT** = **S**o **W**hat **I**s **Y**our **T**ier?

---

## 📅 개발 기간

**2017. 11. 18. ~ 2017. 11. 28. (약 10일)** — 커밋 내역 기준

| 날짜 | 커밋 | 내용 |
|------|------|------|
| 2017-11-18 | `faebbfe` | 첫 커밋 (프로젝트 기본 구조) |
| 2017-11-19 | `b286a54` | 로그인 / 로그아웃 기능 구현 |
| 2017-11-21 | `be73152` | 회원가입 기능 추가 |
| 2017-11-28 | `02c92aa` | Riot API 연동(소환사 정보·전적 조회) 및 백업 |

---

## 🧩 주요 기능

- **회원가입** — 이메일 / 비밀번호 / 소환사 닉네임 등록 (중복 이메일 검증)
- **로그인 / 로그아웃** — 세션 기반 인증, 로그아웃 시 세션 무효화
- **소환사 정보 조회** — 로그인한 계정의 닉네임으로 Riot API 호출
  - 소환사 기본 정보(이름, 레벨, accountId)
  - 솔로랭크 / 자유랭크 티어·등급·승패·리그 포인트
  - 최근 게임 5건의 gameId 및 참가자 정보

---

## 🛠 사용 기술 (Tech Stack)

### Backend
- **Java 1.8**
- **Servlet 3.0** / **JSP** (JSTL core 태그 사용)
- **MySQL** — JDBC (`mysql-connector-java 5.1.44`)
- **JNDI DataSource** — 톰캣 커넥션 풀 (`jdbc/mysql`)로 DB 연결 관리

### 외부 API & 라이브러리
- **Riot Games API** — 소환사 / 리그 / 매치 정보 조회 (`kr.api.riotgames.com`)
- **json-simple 1.1.1** — API 응답 JSON 파싱
- **gson 2.8.0** — JSON 처리
- **riot-api-java** — Riot API 자바 래퍼

### Frontend
- **JSP + JSTL**
- **Materialize CSS** — UI 프레임워크
- **jQuery 3.2.1**
- **Roboto** 웹폰트

### 개발 환경
- **Eclipse** (Dynamic Web Project, `jst.web` 3.0 facet)
- **Apache Tomcat** (서블릿 컨테이너)

---

## 🗂 프로젝트 구조

```
SWIYT/
├── src/org/func/                  # Java 소스
│   ├── servlet/
│   │   └── ActionServlet.java     # Front Controller (*.do 요청 처리, Command 패턴)
│   ├── action/                    # Command 패턴 — 요청별 액션
│   │   ├── IAction.java           #   액션 공통 인터페이스
│   │   ├── LoginAction.java       #   로그인 + Riot API 조회
│   │   ├── LogoutAction.java      #   로그아웃(세션 무효화)
│   │   └── SignupAction.java      #   회원가입
│   ├── service/                   # 비즈니스 로직
│   │   ├── AbstractService.java   #   JNDI DataSource 커넥션 획득
│   │   └── UserService.java       #   로그인/회원가입 서비스
│   ├── dao/
│   │   └── UserDao.java           # DB 접근 (USER 테이블 조회/삽입, PreparedStatement)
│   ├── riot/                      # Riot Games API 연동
│   │   ├── Summoner_info.java     #   소환사 기본 정보 조회
│   │   ├── Summoner_position.java #   솔로/자유랭크 티어 조회
│   │   └── GameMatchList.java     #   최근 매치·참가자 정보 조회
│   ├── uservo/                    # VO (Value Object)
│   │   ├── UserVo.java            #   회원 정보
│   │   ├── SummonerVo.java        #   소환사/랭크 정보
│   │   ├── MatchVo.java           #   매치 정보
│   │   └── gameVo.java
│   └── util/
│       └── CommonUtil.java        # 공통 유틸(빈 값 검증 등)
│
└── WebContent/
    ├── index.jsp                  # 진입점 → jsp/main.jsp 포워드
    ├── jsp/                       # 화면
    │   ├── main.jsp               #   메인(로그인/회원가입 모달)
    │   ├── profile.jsp            #   소환사 프로필
    │   ├── diary_list.jsp
    │   └── error.jsp              #   에러 페이지
    ├── public/                    # 정적 리소스 (css/js/image/fonts)
    │   └── image/                 #   티어별 엠블럼(BRONZE~CHALLENGER)
    └── WEB-INF/lib/               # 의존 JAR (gson, json-simple, mysql-connector 등)
```

### 아키텍처 흐름

```
브라우저 요청 (*.do)
      │
      ▼
ActionServlet (Front Controller)
      │  URI에서 actionName 추출 → 해당 IAction 실행
      ▼
LoginAction / SignupAction / LogoutAction
      │
      ├─► UserService ──► UserDao ──► MySQL (USER 테이블)
      │
      └─► Riot API 클래스 ──► Riot Games API (티어/전적)
      │
      ▼
JSP (main.jsp / profile.jsp) 로 forward → 화면 렌더링
```

- **Front Controller + Command 패턴**: `*.do` 요청을 `ActionServlet` 하나가 받아 URI에 매핑된 `IAction` 구현체로 위임합니다.
- **계층 분리**: `Action → Service → DAO` 3계층으로 나뉘어 요청 처리 / 비즈니스 로직 / DB 접근이 분리되어 있습니다.

---

## ▶️ 실행 방법

### 1. 사전 준비
- JDK 1.8
- Apache Tomcat (Servlet 3.0 지원 버전)
- MySQL 서버
- Eclipse (Dynamic Web Project로 임포트할 경우)

### 2. 데이터베이스 설정
MySQL에 `USER` 테이블을 생성합니다. (코드상 `INSERT INTO USER VALUES(?,?,?)`, 컬럼 순서: email, pwd, nickname)

```sql
CREATE TABLE USER (
  EMAIL    VARCHAR(100) PRIMARY KEY,
  PWD      VARCHAR(100) NOT NULL,
  NICKNAME VARCHAR(100) NOT NULL
);
```

### 3. 톰캣 JNDI DataSource 설정
애플리케이션은 JNDI 이름 `jdbc/mysql` 로 DB 커넥션을 조회합니다
(`AbstractService.getConnection()`). 톰캣의 `context.xml` 등에 DataSource를 등록하세요.

```xml
<Resource name="jdbc/mysql"
          auth="Container"
          type="javax.sql.DataSource"
          driverClassName="com.mysql.jdbc.Driver"
          url="jdbc:mysql://localhost:3306/DB이름?useUnicode=true&amp;characterEncoding=utf8"
          username="DB사용자"
          password="DB비밀번호"
          maxActive="20" maxIdle="10" maxWait="-1"/>
```

### 4. Riot API 키 설정
`org.func.riot` 패키지의 클래스들(`Summoner_info`, `Summoner_position`, `GameMatchList`)은
URL에 Riot API 키를 하드코딩해 사용합니다. 코드에 포함된 키는 **만료된 개발용 키**이므로,
[Riot Developer 포털](https://developer.riotgames.com/)에서 발급받은 키로 교체해야 정상 동작합니다.

```java
// 예시 — 각 클래스의 urlstr 에 있는 api_key 값을 교체
String urlstr = "https://kr.api.riotgames.com/lol/summoner/v3/summoners/by-name/"
                + nickname + "?api_key=RGAPI-발급받은-키";
```

> ⚠️ 사용된 Riot API는 v3 엔드포인트(`summoner/v3`, `league/v3`, `match/v3`)로,
> 현재 Riot 정책상 v3는 지원 종료(deprecated)되었습니다. 최신 실행을 위해서는
> v4/v5 엔드포인트로의 마이그레이션이 필요합니다.

### 5. 배포 및 접속
1. Eclipse에서 `Run As → Run on Server` (또는 WAR로 빌드해 톰캣에 배포)
2. 브라우저에서 `http://localhost:8080/SWIYT/` 접속
3. 회원가입(이메일·비밀번호·소환사 닉네임) → 로그인 → 소환사 정보 확인

---

## ⚠️ 참고 / 알려진 이슈

- 코드에 **Riot API 키가 평문으로 하드코딩**되어 있으며, 현재 키는 만료 상태입니다.
- 비밀번호가 **평문으로 저장/조회**됩니다(해싱 없음) — 학습용 프로젝트 특성.
- Riot **API v3 엔드포인트**는 현재 지원 종료되었습니다.
- 개인/토이 프로젝트로, 프로덕션 사용을 위해서는 보안·API 버전 등의 보완이 필요합니다.
