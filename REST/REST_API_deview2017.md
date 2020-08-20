# Day1, 2-2. 그런 REST API로 괜찮은가

발표 영상 <https://tv.naver.com/v/2292653>
- SOAP과 REST의 느낌적인 비교
  - REST가 더 단순하고, 규칙이 적고, 쉽다
  - 2006년 AWS가 자사 API의 사용랴의 85%가 REST임을 밝히고, 2010년 Salesforce.com, REST API 추가 => REST의 승리

사람들이 말하는 REST API와 로이 필딩이 말하는 REST API가 다르다는 이야기가 계속 나오게 됨

- REST : 분산 하이퍼미디어 시스템(예:웹) 아키텍쳐 스타일
- 아키텍쳐 스타일 : 제약조건의 집합
- REST를 구성하는 스타일
  - client-server
  - stateless
  - cache
  - **uniform interface**
  - layered system
  - code-on-demand(optional) : 서버에서 코드를 클라이언트로 보내서 실행할 수 있어야 한다(ex.javascript)

- Uniform Interface의 제약조건
  - identification of resources
    - 리소스가 uri로 식별되면 된다
  - manipulation of resources through representations
    - representation 조작을 통해서 리소스가 조작되어야 한다(리소스 삭제, 업데이트 등에 html 메시지에 표현을 담아서 전송을 해서 달성을 해야 한다)
  - **self-descriptive messages**
    - 메시지는 스스로를 설명해야한다
        ```
        GET / HTTP/1.1
        ```
    - 이 HTTP 요청 메시지는 뭔가 빠져있어서 self-descriptive 하지 못하다.
        ```
        GET / HTTP/1.1
        Host: www.example.org
        ```
    - 목적지를 추가하면 이제 self-descriptive
        ```
        HTTP/1.1 200 OK
        Content-type: application/json //이게 없으면 문법이 어떤 것인지 알 수 없다
        Content-type: application/json-patch+json //op, path의 의미까지 알 수 있으므로 이렇게까지 써주어야 완벽히 해석이 가능해지는 것이라 볼 수 있다.
        [{"op":"remove", "path":"/a/b/c"}]
        ```
    - 보통 json인 것만 알 수 있고, 어떻게 해석해야 하는지는 잘 알 수 없다.
  - **hypermedia as the engine of application state(HATEOAS)**
    - 애플리케이션은 항상 Hyperlink로 전달되어야 한다.

- 독립적 진화
  - 서버와 클라이언트가 각각 독립적으로 진화한다.
  - 서버의 기능이 변경되어도 클라이언트를 업데이트할 필요가 없다.
  - REST를 만들게 된 계기 : "How do I improve HTTP without breaking the Web."

- 웹(Rest Architecture)
  - 웹 페이지를 변경했다고 웹 브라우저를 업데이트할 필요는 없다
  - 웹 브라우저를 업데이트했다고 웹 페이지를 변경할 필요도 없다
  - HTTP 명세가 변경되어도 웹은 잘 동작한다
  - HTML 명세가 변경되어도 웹은 잘 동작한다
  - 물론.... 약간 깨질 수는 있지만 최소한의 기능은 동작한다
    - 상호운용성(interoperability)에 대한 집착
      - Referer 오타지만 안 고침
      - charset 잘못 지은 이름이지만 안 고침
      - HTTP 상태 코드 416 포기함(I'm a teapot) : 만우절 때 HTPCPC에서 416을 만든 것이 있는데, HTTP가 아님에도 불구하고 이를 HTTP로 인식하도록 한 구현체가 있어 웹이 깨질 수 있으므로 코드 포기함 
      - HTTP/0.9 아직도 지원함 (크롬, 파이어폭스) : 크롬에서 빼보았더니 동작을 안하는 것들이 발견되어 포기함

- REST가 웹의 독립적 진화에 도움을 주었나
  - HTTP에 지속적으로 영향을 줌
  - Host 헤더 추가
  - 길이 제한을 다루는 방법 명시(414 URI Too Long 등)
  - URI에서 리소스의 정의가 추상적으로 변경:"문서의 위치"->"식별하고자 하는 무언가"
  - 기타 HTTP와 URI에 많은 영향을 줌
  - HTTP/1.1 명세 최신판에서 REST에 대한 언급이 들어감
  - Reminder:Roy T.Fielding이 HTTP와 URI 명세의 저자 중 한 명

- REST는 성공?
  - REST는 웹의 독립적 진화를 위해 만들어졌다
  - 웹은 독립적으로 성장하였다
  - 성공!!!

- REST API는?
  - REST 아키텍쳐 스타일을 따라야 한다
  - 그러나 REST API라 불리는 것은 이를 잘 따르지 않고 있다
  - REST API는 꼭 제약조건들을 다 지켜야 한다 - 하이퍼텍스트를 포함한 self-descriptive한 메시지의 uniform interface를 통해 리소스에 접근하는 API
  - 시스템 전체를 통제할 수 있다고 생각하거나 진화하는 것에 관심이 없다면 REST에 대해 따지느라 시간 낭비하지 않는 것이 낫다 -> 하지만 오랜 시간에 걸쳐 진화하는 것에 관심이 있다면 REST를 하는 것!
    - REST API를 구현하고 REST API라고 부른다
    - REST API 구현을 포기하고 HTTP API라고 부른다
    - REST API가 아니지만 REST API라고 부른다(현재 상태) -> 제발 제약조건을 따르던지 아니면 다른 단어를 써달라는 이야기를 듣게 됨 from T.Fielding
- Self-descriptive : 확장 가능한 커뮤니케이션
  - 서버나 클라이언트가 변경되더라도 오고가는 메시지는 언제나 self-descriptive 하므로 언제나 해석이 가능하다.
- HATEOAS : 애플리케이션 상태 전이의 late binding
  - 어디서 어디로 전이가 가능한지 미리 결정되지 않는다. 어떤 상태로 전이가 완료되고 나서야 그 다음 전이될 수 있는 상태가 결정된다. -> 하이퍼링크를 따라 간 후에 그 다음 링크를 알 수 있다는 것
  - 쉽게 말해서 링크는 동적으로 변경될 수 있다.

###### Self-descriptive
방법1: Media type
1. 미디어 타입을 하나 정의한다
2. 미디어 타입 문서를 작성한다. 이 문서에 "id"가 뭐고 "title"이 뭔지 의미를 정의한다
3. IANA에 미디어 타입을 등록한다. 이 때 만든 문서를 미디어 타입의 명세로 등록한다.
4. 이제 이 메시지를 보는 사람은 명세를 찾아갈 수 있으므로 이 메시지의 의미를 온전히 해석할 수 있다.
단점: 
1. 매번 media type을 정의해야 한다.

방법2: Profile 정의
1. "id"가 뭐고 "title"이 뭔지 의미를 정의한 명세를 작성한다.
2. Link헤더에 profile relation으로 해당 명세를 링크한다.
3. 이제 메시지를 보는 사람은 명세를 찾아갈 수 있으므로 이 문서의 의미를 온전히 해석할 수 있다.
단점:
1. 클라이언트가 Link헤더(RFC 5988)와 profile(RFC 6906)을 이해해야 한다.
2. Content negotiation을 할 수 없다.

###### HATEOAS
방법1: data로
1. data에 다양한 방법으로 하이퍼링크를 표현한다.
2. JSON으로 하이퍼링크를 표현하는 방법을 정의한 명세들을 활용한다
   
단점:
1. 링크를 표현하는 방법을 직접 정의해야 한다
2. 기존 API를 많이 고쳐야한다.(침투적)

방법2: HTTP 헤더로
1. Link, Location 등의 헤더로 링크를 표현한다.

단점:
1. 정의된 relation만 사용하게 된다


## 정리
- 오늘날 대부분의 "REST API"는 사실 REST를 따르지 않고 있다.
- REST의 제약조건 중에서 특히 Self-descriptive와 HATEOAS를 잘 만족하지 못한다.
- REST는 긴 시간에 걸쳐(수십년) 진화하는 웹 애플리케이션을 위한 것이다.
- REST를 따를 것인지는 API를 설계하는 이들이 스스로 판단하여 결정해야 한다.
- REST를 따르겠다면, Self-descriptive와 HATEOAS를 만족시켜야 한다.
    - Self-descriptive는 custom media type이나 profile link relation 등으로 만족시킬 수 있다.
    - HATEOAS는 HTTP 헤더나 본문에 링크를 담아 만족시킬 수 있다.
- REST를 따르지 않겠다면, "REST를 만족하지 않는 REST API"를 뭐라고 부를지 결정해야 할 것이다.
  - HTTP API라고 부를 수 있고
  - 그냥 이대로 REST API라고 부를 수도 있다.(--roy가 싫어합니다--)