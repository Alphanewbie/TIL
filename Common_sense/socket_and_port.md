# Socket and Port
## 전제
- 네트워크에서 데이터를 주고 받는다는 것은, 호스트의 프로세스까지 데이터가 오고 간다는 뜻이다.

## Port
- 네트워크를 통해 데이터를 주고 받는 프로세스를 식별하기 위해 호스트 내부적으로 프로세스가 할당받는 고유한 값.
- 클라이언트와 서버 둘 다 데이터를 교환하기 위해서는 포트 번호가 필요하다.

## Socket
- 컴퓨터 네트워크에서 발생하는 양방향 통신의 끝점.
- 소켓은 통신 채널을 통해 들어오는 데이터 패킷을 올바른 응용 프로그램으로 배포한다. 즉, 소통 창구 같은 역활

- 소켓을 열기 위해서는 **IP 주소, 포트 넘버, 프로토콜** 이 3개가 소켓을 정의한다.

