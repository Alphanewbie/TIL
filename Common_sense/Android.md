# 안드로이드



### 안드로이드의 실행 환경

안드로이드는 크게 4개의 실행 환경으로 구성되어 있다.

- 어플리케이션
  - 실제로 동작하는 앱이 설치 되는 환경
- 어플리케이션 프레임워크
  - 애플리케이션을 개발하기 위해 필요한 다양한 API제공하는 영역, 예를 들면 API를 사용하면 버튼이나 텍스트를 표현하거나 주소록같은 다른 애플리케이션 데이터를 사용할 수도 있다. 애플리케이션 생명 주기도 여기서 관리된다.
- 라이브러리
  - 안드로이드에 있는 다양한 기능(UI 처리, 미디어 프레임워크, 데이터 베이스, 그래픽 처리, 웹 킷 등)을 소프트웨어 적으로 구현해 놓은 환경 뿐만 아니라 안드로이드 앱을 구동하는 dalvik 가상머신과 코어 라이브러리까지 포함하는 영역 -> 여기서 있는 기능을 애플리케이션 프레임 워크를 이용하여 개발자가 사용할 수 있게 한다.
- 리눅스 커널
  - 가장 하단의 환경으로써 OS로 안드로이드 스마트폰의 다양한 하드웨어(화면, 카메라, 블루투스, 메모리 등)를 관리한다. 

### 안드로이드의 장점

1. 안드로이드를 구성하는 모든 소스가 오픈 소스로 개방되어 있어 비용적인 부담이 없다.
   1. 전 세계의 개발자로부터 피드백을 받아 수정되기 때문에 안정성과 버그 수정이 빠르다.
   2. 원한다면 소스를 다운받아 수정해서 쓰기 편리
2. 자바를 주 언어로 사용하고 있기 때문에 가장 점유률이 높은 자바 개발자들이 쉽게 개발 가능
3. 리눅스 커널을 OS로 채택했기 때문에 다양한 하드웨어에 대한 드라이브 소스가 풍부.
4. 구글의 다양한 앱과 연동이 편하며, 다른 플랫폼에 비해 앱간 연동이 너그러운편



### 안드로이드 프로젝트 구성 요소

- lib : 
  - 프로젝트에서 사용하는 다양한 라이브러리 소스가 저장되는 공간

- androidTest : 
  - 앱의 일부 코드를 테스트 하기 위한 소스를 저장하는 공간
- java : 
  - 자바 코드를 저장하는 공간. 표준 자바와 동일하게 패키지를 이용한 하위 디렉토리 생성 방식을 사용
- res : 
  - 리소스(이미지, XML, 레이아웃, 메뉴, 값)을 저장하는 공간
- AndroidManifest.xml
  - 앱에 대한 전체적인 정보를 담고 있는 파일. 앱의 구성 요소와 실행 권한 정보가 정의되어 있다.
- project > build.gradle : 
  - 프로그래머가 직정 작성한 그래들 빌드 스크립트 파일
- gradle > build.gradle : 
  - 앱에 대한 컴파일 버전 정보, 의존성 프로젝트에 대한 정의가 되어있는 파일

### 안드로이드 매니페스트(android manifest) 파일

안드로이드 매니페스트 파일은 앱의 이름, 버전, 구성요소, 권한 등 앱의 실행에 있어서 필요한 각정 정보가 저장되어 있는 파일입니다. 반드시 존재해야 하는 xml형식의 파일로 안드로이드 프로젝트의 최상위에 위치하고 있습니다.

위에서 부터 최상위 태그

1. manifest 태그
   1. 태그에는 패키지명, 앱 버전 코드, 앱 버전 이름을 정의한다.

2. application 태그
   1. 앱 아이콘, 앱 이름 을 정의한다.

3. activity 태그 

   - 액티비티의 믈래스 명과 액티비디 이름을 정의한다.

   1. intent-filter 태그를 이용하여 액티비티에 대한 인텐트 작업시 필요한 action과 category를 정의한다.

4. service, receiver, provider 태그에는 각각 서비스, 리시버, 프로바이더에 대한 내용을 정의

5. permission 태그에는 앱에서 필요한 권한에 내용을 정의합니다.

그 밖에 최소 안드로이드 SDK 버전을 지정하는 uses-sdk와 다른 패키지를 등록할 수 있는 uses-library 태그 등이 존재합니다.



## 안드로이드 애플리케이션 구조

### 안드로이드 애플리케이션 구조

MVC 모델

-  뷰 : 화면 구성을 담당하는 영역이며, 이 영역은 View 클래스를 상속하는 클래스를 사용해서 구성할 수 있다.
- 컨트롤러 : View와 Model을 서로 연결하고 제어하는 영역이며, 이 영역에는 액티비디, 서비스, 브로드 캐스트 리시버가 포함되고, 3.0부터는 프래그먼트도 포함된다.
- 모델 : 애플리케이션의 데이터를 저장하는 역활을 담당하며, 안드로이드에 내장된 데이터베이스인 SQLite와 File 그리고 애플리케이션 간의 데이터 공유를 위해 사용할 수 있는 콘텐트 프로바이더가 이 영역에 속한다.



### 안드로이드의 4대 컴포넌트

1. 액티비티
   - 안드로이드에서 화면을 관리하고 사용자의 다양한 이벤트 처리
2. 서비스
   - 화면에서 보이지 않지만 백그라운트 처리
3. 브로드캐스트 리시버
   - 안드로이드에서 발생하는 특정 브로드캐스트 메세지를 처리하기 위한 컴포넌트
4. 콘텐트 프로바이더
   - 앱 사이의 데이터의 공유를 위한 인터페이스를 제공하는 컴포넌트



### 액티비티란?

안드로이드 화면을 관리하며 사용자가 발생시키는 다양한 이벤트를 처리하는 컴포넌트

부모 액티비티에서 새로운 자식 액티비티를 실행하고자 한다면 먼저 매니페스트 파일에 해당 자식 액티비티를 추가해줘야합니다. 다음으로 부모 액티비에서 startActivity 메소드에 인텐트를 파라미터로 넘겨 실행하거나 startActivities 메소드를 이용하여 여러개의 액티비티를 한꺼번에 실행할 수 있습니다.

#### 액티비티의 실행과정

1. 부모 액티비티에서 자식 액티비티를 생성 및 호출
2. 액티비티 매니저 서비스가 해당 앱 프로세스에서 인텐트를 복사해온 후 매니페스트 파일에서 해당 인텐트에 명시되어 있는 액티비티를 찾고 어떻게 실행시켜야할지 결정한다.
3. 세 번째로 찾아낸 액티비티를 실행하고 다시 해당 앱 프로세스에 인텐트를 복사하여 넘겨줍니다. 그
4. 자식 액티비티 내의 onCreate 매소드에서 setContentView 메소드에 레이아웃의 아이디를 파라미터로 넘겨 해당 액티비의 화면을 구성한다.

#### 액티비티의 상태

- 실행(running) 상태
  - 액티비티 스택의 최상위에 있으며 포커스를 가지고 있어 사용자에게 보이는 상태
- 일시 중지(paused) 상태
  - 사용자에게 보이기는 하지만 다른 액티비티가 위에 있어 포커스를 받지 못하는 상태(예 fragment나 대화 상자가 위에 있는 상태)
- 중지(stopped) 상태
  - 다른 액티비티에 가려진 상태, 즉, 다른 액티비티기 스택 위에 있다.



### 액티비티의 생명 주기

액티비티의 생명 주기는 onCreate() -> onStart() -> onResume() -> onPause() -> onStop() -> oDestroy() 순으로 실행된다, 경우에 따라서 onRestart매서드가 호출되기도한다.

- onCreate()
  - 액티비티가 생성될 때 호출되며 사용자 인터페이스 초기화에 사용됨 -> 레이아웃을 구성한다
- onStart()
  - 액티비티가 사용자에게 보여지기 직전에 호출된다.
- onResume()
  - 사용자 상호작용(화면이 포커스를 얻었을 때) 하기 바로 전에 호출된다.
- onRestart()
  - 액티비티가 멈췄다가 다시 시작되기 바로 전에 호출된다
- onPause()
  - 다른 액티비티가 보여질 때 호출됨. 데이터 저장, 스레드 중지 등의 처리를 하기 적당한 매소드
- onStop()
  - 액티비티가 더이상 사용자에게 보여지지 않을때 호출된다. 메모리가 부족한 경우에는 호출되지 않을 수도 있다.
- onDestroy()
  - 액티비티가 소멸될때 호출됨. finish()매소드가 호출되거나 시스템 메모리 확보를 위해 액티비를 제거할때 호출된다.



### Looper

Looper는 스레드간의 신호이므로 handler에 보낸다고 해서 곧바로 처리 되는 것이 아닙니다. 동시 다발적으로 메세지가 발생할 수 있기 때문에 메세지 큐에 쌓였다가 처리합니다. 큐에 들어 있는 내용을 하나하나 꺼내 처리하는 놈이 바로 루퍼. 메인 쓰레드가 Looper를 가지고 있으며 무한 루프를 돌며 큐의 내용을 처리합니다.



### Intent란?

앱 컴포넌트가 무엇을 할 것인지를 담는 메세지 객체. 메세지 객체는 의사소통을 하기 위해 보내고 받는다. 메시지를 사용하는 가장 큰 목적은 다른 액티비티, 서비스, 브로드캐스트 리시버, 컨텐트 프로바이더 등을 실행하는 것입니다. 인텐트는 그들 사이에 데이터를 주고 받기 위한 용도로 쓰인다

즉, 인텐트는 컴포넌트에 액션, 데이터 등을 전달하는 메세지 객체.

#### 구성요소

- Action : 수행할 액션의 이름
- Data : 수행할 데이터의 URL
- Catergory : 수행알 액션에 대한 추가적인 정보
- Type : 수행할 인텐트 데이터의 명시적인 타입
- Component name : 대상 컴포넌트의 완전한 클래스 이름
- Extras : 인텐트를 다루는 컴포넌트에 추가적으로 전달할 한쌍의 키/값

#### **API** Intent의 주요 액티비티 액션

| Action            | 설명                                                         |
| ----------------- | ------------------------------------------------------------ |
| ACTION_MAIN       | 시작 액티비티를 지정하기 위한 액션                           |
| ACTION_VIEW       | 데이터의 URL로 가장 적절한 액티비티를 호출하는 액션 content://contacts/people/1 |
| ACTION_DEFAULT    | ACTION_VIEW와 동일                                           |
| ACTION_EDIT       | 수정하기 위해 호출하는 액션                                  |
| ACTION_DELETE     | 삭제하기 위해 호출하는 액션                                  |
| ACTION_DIAL       | 전화 다이얼 액티비티를 호출하는 액션 content://contacts/people/1 tel:0101235678 |
| ACTION_CALL       | 전화 액티비티를 호출하는 액션 tel:0101235678                 |
| ACTION_WEB_SEARCH | 웹 검색 액티비티를 호출하는 액션                             |
| ACTION_SEARCH     | 검색 액티비티를 호출하는 액션                                |
| ACTION_SENDTO     | 이메일 등의 메시지 전송을 지정하는 액션                      |
| ACTION_ANSWER     | 전화 착신을 위한 액션                                        |



### 인텐트 필터

인텐트 필터는 특정 인텐트를 받을지 말지를 정의하는 역활을 수행하며, 이를 통해 컴포넌트의 특징이 정해진다. 예를 들어, 인턴트 필터에 android.intent.action.MAIN을 선언하고, android.intent.category.HOME을 선언하면, 해당 컴포넌트는 홈 애플리케이션이 되어 디바이스가 시작될 때 자동으로 시작될 수 있는 애플리케이션이 된다.

AndroidManifest.xml에 정의할 수 있다.



### RxJava란?

**Reactive Programming**을 기반으로 한 언어

즉, Reactive Extention의 JVM버전입니다.

비동기 데이터 처리를 효율적으로 할 수 있는 장점이 있습니다.



### Realm이란?

SQLite, Realm은 안드로이드 단말에서 사용하는 관계형 데이터베이스

SQLite는 오픈소스 데이터 베이스로 OS와 상호작용하기 위해 SQLiteOpenHelper인터페이스를 이용합니다. SQLite는 C언어로 되어 있고 경량 데이터베이스이며 하나의 디스크 파일에 모든 데이터를 저장할 수 있습니다.

Realm은 크로스 플랫폼 기반의 모바일 데이터베이스입니다. IOS와 안드로이드 모두 사용이 가능하며 성능 및 효율성이 우수. 설치도 간편하여 쿼리 응답 속도도 빠르다. 크로스플랫폼이기 때문에 협업에도 유용하다.

특징으로는 데이터 객체 자체에 그대로 작업이 가능하다. OS를 가리지 않는다.



### Restful API

웹 상에서 존재하는 모든 자원에 URL을 부여하여 사용하는 방법

HTTP 웹 표준을 이용하여 http캐싱을 활용할 수 있다는 장점이 있다. 구조가 명확하여 클라이언트와 서버에서 개발해야할 부분이 명확해지고 URI만 봐도 요청을 알 수 있게 직관적