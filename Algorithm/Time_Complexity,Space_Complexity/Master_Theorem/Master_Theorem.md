# Master Theorem

재귀관계식으로 표현된 알고리즘의 동작 시작을 점근적으로 계산하는 방법이다.



## Master Theorem

<img src="./공식1.png" alt="공식1" style="zoom:80%;" />

일단. 마스터 정리를 쓰기 위한 점화식은 이러한 형태로 나타낼 수 있다.



마스터 정리의 제약 조건은 3가지가 있는데

1. f(n)은 다항식이여야한다. 

2. 재귀를 호출할 때 그 호출 비용이 현재보다 작아야 한다.

3. 현재 문제를 푸는 것보다 부분 문제를 푸는 데에 시간이 적게 들어가야 한다.



이 식에서 시간 복잡도에 영향을 주는 것은 

- a : 자식 노드의 수
- b
- f(n) 

이다.

이 3개로 구해야 될것은
<img src="./공식2.png" alt="공식2" style="zoom:80%;" />
이렇게 구한 C<sub>0</sub>로 θ를 구한다.
<img src="./공식3.png" alt="공식3" style="zoom:80%;" />
여기서 말하는  C<sub>0</sub>는 노드의 갯수로, 즉 재귀를 통해 호출되는 함수의 갯수라고 보면 된다.



### 경우의 수 3가지

각각의 경우의 시간 복잡도는  T(n)이 된다.

1. f(n)이 n<sup>C<sub>0</sub></sup>보다 상대적으로 작을 때
<img src="./공식4.png" alt="공식1" style="zoom:80%;" />

   즉  f(n)이 무시된다.

2. f(n)과 n<sup>C<sub>0</sub></sup>가 상대적으로 비슷할 때
<img src="./공식5.png" alt="공식5" style="zoom:80%;" />

이런 공식이 되는 이유는 그림을 보면 되는데

![그림1](./그림1.jpg)
<img src="./공식6.png" alt="공식6" style="zoom:80%;" />
이런 식이 된다.

각 노드는 하단으로 내려갈 수록  a의 거듭 제곱으로 증가하는데 트리의 깊이는 로그 만큼의 깊이이다.

그리고 가장 마지막의 로그 부분은 로그 법칙에 의해 교환된다.
<img src="./공식7.png" alt="공식7" style="zoom:80%;" />


3. f(n)과 n<sup>C<sub>0</sub></sup>가 상대적으로 클 때

<img src="./공식8.png" alt="공식8" style="zoom:80%;" />

