# 정렬

## 병합 정렬

분할 정복을 이용한 정렬 방법

들어온 배열을 중간을 기준으로 재귀로 반으로 나눠준다.

재귀로 더이상 나눠지지 않을때까지 나눈다음에, 마지막까지 도달하면 그냥 단일 배열 그대로 리턴

리턴된 왼쪽 배열과 오른쪽 배열을 새로운 배열로 선언하고 큐 형식으로 앞쪽부터 더 작은 수로 하나씩 채워 나간다.

만들어진 배열을 리턴



### 장점

데이터의 상태에 별 영향을 받지 않는다

 -> 굉장히 좋은 장점.

### 단점

속도가 퀵 소트 보단 느리다.

메모리를 많이 먹는다.



## 코드

```python
def merge_sort(arr: list) -> list:
    def merge(left: list, right: list) -> list:
        result = []
        l_head = 0
        r_head = 0
        while l_head < len(left) and r_head < len(right):
            if left[l_head] < right[r_head]:
                result.append(left[l_head])
                l_head += 1
            else:
                result.append(right[r_head])
                r_head += 1
        if l_head < len(left):
            result.extend(left[l_head:])
        if r_head < len(right):
            result.extend(right[r_head:])
        return result

    arr_len = len(arr)
    if arr_len <= 1:
        return arr
    mid = arr_len // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    result = merge(left, right)
    return result
```

