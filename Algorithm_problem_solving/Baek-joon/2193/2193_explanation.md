## 백준 2193번 풀이

#https://www.acmicpc.net/problem/2193

### 문제

*0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다. 이친수는 다음의 성질을 만족한다.*

1. *이친수는 0으로 시작하지 않는다.*
2. *이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.*

*예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.*

*N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.*



### 입력

*첫째 줄에 N이 주어진다.*



### 출력

*첫째 줄에 N자리 이친수의 개수를 출력한다.*

***



### 풀이

일단 작은 경우의 수를 고민해 보았다.



- n=1 : 1
  - 1

- n=2 : 1
  - 10
- n=3 : 2
  - 100,101
- n=4 : 3
  - 1000,1001,1010
- n=5 : 5
  - 10010,10001,10000,10101,10100



여기까지 본 이후에 바로 감을 잡았다.

너무 노골적으로 피보나치수열이라서 일단 피보나치를  수열을 만드는 코드를 만든 다음에 제출하니 답이 맞았다.

```python
n = int(input())

dp = [0,1,1]

for i in range(3,n+1) :
    dp.append(dp[i-1]+dp[i-2])

# print(dp)
print(dp[n])
```

이렇게 답은 맞췄지만, 이제 왜 이렇게 나오는지 고민을 해봤다.

그래서 생각해본 경우는 총 4가지였다.



1. 단순하게 n-1과 n-2의 경우를 같이 더하는 경우.

단순하게 생각한 것이니 만큼 당연히 아니였다. 

n != (n-1)+(n-2)가 아니건 당연했고, 숫자가 안 맞는건 당연했다.



2. 뒤에 0이냐 1이냐에 따라 뒤에 붙히는 경우

그럼 이제 끝에 0인지 1인지에 따라 붙히는 것도 고민해 봤지만, n-1의 경우에서 마지막 숫자가 0인지 1인지는 알 수 없는 일이였고, 그리고 이렇게 하면 왜 피보나치 배열이 나오는지도 알 수가 없는 일이라서 일단 이것은 아닌걸로 결론을 냈다.



3. 조건 1을 고려한 맨 앞은 무조건 1이 고정이니 맨 앞을 떼서 생각해 보는 것을 생각했다.

예를 들면 n=4 일 경우에는 1000,1001,1010 에서 맨 앞의 1을 빼서 n=4 : 000, 001, 010 같은 경우를 생각해 보았다. 

언듯 보면 맞는거 같았지만, 이것도 아니였다.



4. 다음은 맨 앞을 10으로 고정 시켜놓고 생각했다.

맨 앞은 1이 고정이고 1이 연속 할 수가 없으니 무조건 앞의 2개는 10이 고정이였다.

그리고 이제 정답이였는데,

예를 들면 n=5일때 10XXX일 경우를 생각해 보자,

X의 첫 숫자를 1이 들어 갈수가 있다. 그럼 앞이 1이고 뒤도 조건이 맞는 경우의 수가 바로 n=3인 경우이다.

그리고 다음으로 X의 첫 숫자가 0인 경우, 이것은 바로 n=4인 경우이다. n=4인 경우는 숫자가 4개지만 맨 앞의 숫자는 무조건 1이고 그 다음 숫자는 무조건 0인 4개의 이진수이다. 고로, 1을 떼버리면 시작이 0인 3자리의 이진수가 된다.



### 전체 코드

```python
n = int(input())

dp = [0,1,1]

for i in range(3,n+1) :
    dp.append(dp[i-1]+dp[i-2])

# print(dp)
print(dp[n])
```
