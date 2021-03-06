# Apache Kafka

- 아파치 카프카는 Linkedin 에서 개발된 분산 메세징 시스템이다.
- 대용량의 실시간 로그처리에 특화된 아키텍처 설계를 통해 후수한 TPS

## Kafka의 기본 구성 요소와 동작

- Kafka는 발행-구독 모델을 기반으로 동작하며 크게 producer, consumer, broker로 구성된다.
- 확장성(scale-out)과 고가용성(high availability)을 위하여 broker들이 클러스터로 구성되어 동작하도록 설계되어있다.

### broker

- topic을 기준으로 메세지를 관리한다.
- topic별로 분류하여 쌓아둔다.

### Producer

- 특정 topic의 메시지를 생성한 뒤 해당 메세지를 broker에 전달한다.

### consumer

- broker가 쌓아둔 메세지를 comsumer가 메세지를 가져가서 처리하게 된다.

## 장점

- 대용량의 실시간 로그 처리에 특화 -> 시스템대비 TPS가 우수하다.
- 분산 시스템을 기본으로 설계되었기 때문에, 기존 메시징 시스템에 비해 분산 및 복제구성을 쉽게 할 수 있다.
- AMQP 프로토콜이나 JMS API를 사용하지 않고 단순한 메시지 헤더를 지닌 TCP기반의 프로토콜을 사용하여 오버에드 감소
- 메시지를 파일 시스템에 저장한다.
  - 데이터의 영속성 보장
  - 많은 메세지를 처리하더라도 성능 감소가 없다.
  - 메세지를 바로 삭제하지 않기 때문에 추후 문제가 생길 수 수정하기 좋다.
  - 메세지 관리 캐시를 OS에 위임하여 빠르게 처리할 수 있게 했다.
- comsumer는 자신의 처리능력만큼의 메시지만 broker로부터 가져오기 때문에 최적의 성능을 낼 수 있다.
  - 기존의 시스템은 broker가 메세지를 처리해야되는지 트래킹 했는데, Kafka에서는 comsumer가 직접 pull받기 때문에 broker의 부담이 경감되었다.
  - 메시지를 pull 방식으로 가져오므로, 메세지를 쌓아두었다가 주기적으로 처리하는 것이 가능하다.

