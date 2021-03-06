# 배낭 문제

가장 유명한 종류의 np문제이자 다이나믹 프로그래밍 문제이다.

가방의 용량이 k이고 n개의 물건이 있을 때, 가장 가치있는 물건을 넣는 방법을 구하는 문제이다.

----

입력 값 :

````
v1 w1
v2 w2
....
vn wn
````

목표 :

````
weigh의 합이 k를 넘지 않는 한에서 선택한 item 의 value의 합을 최대화
````

----

## 예

```yaml
# 물건의 무게와 가치
v1=20		w1=10
v2=19		w2=10
v3=40		w3=15
# 가방의 욜량
k = 20
```

라면 v3 한개가 v1 + v2보다 크다.
즉, 주머니를 꽉 채우는 것보다 w3만 채워서 나가는 것이 낫다.

## 풀이 방법

- 물건 하나를 기준으로 선택해서 나머지 물건으로 **부분 문제**를 푸는 것이라고 생각하는 것이 낫다.
  - 용량이 가득 찬 경우에는 물건이 있더라도 가치는 0과 같다.
    -> 물건이 줄었을 때 부분 문제, 용량이 줄었을 때의 부분 문제를 동시에 생각한다.
  - 즉, item1,2 .... i 중에서 선택하여 capicity는 jdls 경우 얻을 수 있는 value의 최대치.
    => 즉, 쉽게 생각하기 위해 i,j가 0인 작은 값부터 생각한다.
  - `A[i][j]` : 얻을 수 있는 이득이 i일 때 무게가 j일 때
    - `i=0` : 고를 수 있는 물건이 없을 때
    - `j=0` : 자루가 꽉 차거나, 물건이 없을 때

## 점화식

#### Basecase

1. 가방의 용량이 남아 있지 않을 때

   ```pseudocode
   for i ... n :
   	dp[i][0] = 0
   ```

2. 더 이상 물건이 없을 때

   ```pseudocode
   for j ... k :
   	dp[0][j] = 0
   ```

#### 점화식

이제 경우의 수는 2가지가 있다.

1. 가방에 해당 물건을 넣을 수 있을 정도의 용량이 남아 있을 때,

   1. 물건을 넣는다.

      ```pseudocode
      dp[i - 1][j - item[i]의 무게] + item[i]의 가치
      ```

   2. 물건을 넣지 않는다.

      ```pseudocode
      dp[i][j] = dp[i - 1][j]
      ```

2. 가방에 해당 물건을 넣을 수 있을 정도의 용량이 없을 때

   ```pseudocode
   dp[i][j] = dp[i - 1][j]
   ```

즉, 점화식은 이렇게 된다.

```pseudocode
if 가방의 용량 > item[i]의 무게 : 
    dp[i][j] = Max(dp[i - 1][j], dp[i - 1][j - item[i]의 무게] + item[i]의 가치
else :
    dp[i][j] = dp[i - 1][j]
```

그래서 `dp[1][0~n]` 을 생각해 보자 첫번째 물건이 입력 받은 후에 w1까지는 0이 그대로 쭉 들어간다. 이유는 용량이 n만큼 남았는데 w1까지는 전부 0으로 초기화 된다. 그 위부터는 다시 v1으로 초기화 되고, 그 다음 `dp[2][0~n]`까지는 역시 똑같이 0으로 초기화 되다 물건 하나만 넣었을때 가치 그리고 쭉 물건 한개만 넣었을 때의 가치로 초기화 되고 w1+w2부터는 물건 둘다 넣었을 때의 가치로만 채워지는 방식이다.



## 코드

```python
import sys
input = sys.stdin.readline

if __name__ == "__main__" :
    (n,k) = map(int,input().strip().split())

    item = [[0,0]]

    for _ in range(n) :
        (m, v) = map(int,input().strip().split())
        item.append([m, v])

    dp = [[0] * (k+1) for _ in range(n+1)]

    for i in range(1,n + 1) :
        for j in range(1,k + 1):
            if j >= item[i][0]:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - item[i][0]] + item[i][1])
            else:
                dp[i][j] = dp[i - 1][j]

    print(dp[n][k])
```

