# 정렬

## 1. 버블 정렬

첫 번째 원소부터 인접한 원소끼리 자리를 계속 교환하면서, 정렬이 끝날 때까지 반복하는 방식을 말한다

특 : 가장 간단한 형태의 정렬

시간 복잡도 : O(N^2)

## 2. 삽입 정렬

배열의 앞에서 부터 정렬하는 방법으로 지금 선택 된 요소를 이미 정렬된 부분 사이에 끼워 넣는 정렬

특 : 버블 정렬보다 빠르고, 크기가 작은 데이터 집합을 정렬하기 좋다.

시간 복잡도 : 평균 - O(N^2), 최선 - O(N), 최악 O(N^2)

## 3. 선택 정렬

배열을 앞에서 부터 차례로 정렬해가는 방법. 먼저 주어진 리스트 중에서 최소값을 찾고 그 배열의 가장 앞 부분과 교환하는 방싯으로 정렬하는 코드

특 : 비교 횟수는 많지만, 교환 횟수는 가장 적은 정렬.

시간 복잡도 : 항상 O(N^2)

## 3. 병합 정렬

하나의 큰 문제를 분할하여 계산한 다음에, 나중에 합치는 방법인 분할 정복을 사용한다. 즉, 배열을 작게 쪼개서, 그 쪼개진 배열들을 먼저 정렬한 다음에, 그것들을 합치는 방법을 말한다.

특 : 알고리즘 중에 가장 간단하고, 안정적인 성능을 가진다. 단, 데이터 전체 크기만한 메모리 추가적으로 필요.

시간 복잡도 : 항상 O(NlogN), 메모리는 정렬할려는 배열 만큼 추가로 필요하다.

## 4. 퀵 정렬

하나의 피벗을 정하고, 그 피벗을 기준으로 작은 수는 왼쪽, 큰 수는 오른쪽으로 정렬하는 방식을 말한다.

특 : 속도가 가장 빠름. 

시간 복잡도 : 빠르면 O(N), 평균 O(nlogN), 느리면 O(n^2)



## 퀵 정렬이 빠름에도 다른 정렬을 배우는 이유

배열이 들어오는 상황이 전부 다르기 때문,

예를 들면 짧은 배열인 경우에는 그냥 버블 정렬을 사용하는게 간편하고 빠르게 정렬할 수 있다.

중복되는 값이 있는 경우에는 병합 정렬이 안전하게 정렬 할 수 있다.

배열의 길이도 어느 정도 길고, 메모리가 부족한 경우 삽입정렬이 답이 될 수 있다.