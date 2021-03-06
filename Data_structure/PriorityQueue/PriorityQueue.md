# PriorityQueue

## 우선순위 큐란

- 보통의 큐는 데이터를 입력한 대로 나오는 선입 선출(FIFO)을 가진 일반적인 큐의 자료구조와는 다르게 데이터 추가의 순서는 상관 없이 제거될때는 가장 작은 순서대로 나오는 자료구조.

- 우선순위 큐를 구현하는 방법 -> 최소 힙을 이용한다.



## Heap

### 힙이란?

- 최대값과 최소값을 찾아내는 연산을 빠르게 하기 위해 고안된 완전 이진트리(Complete binary tree)를 기반으로 한 자료 구조이다.
- 최대힙
  - 데이터 중 가장 큰 값이 부모 노드에 위치
- 최소힙
  - 데이터 중 가장 작은 값이 부모 노드에 위치



### 힙의 장점

- 최대값 최소값을 찾는데 최대 O(logN)에 찾을 수 있다.
  - 배열의 경우엔 최대 O(N)
- 최악이여도 완전 이진트리이므로 시간 복잡도는 O(logN)
- 최소값이라는 원리를 이용하면 최단거리를 구하거나 최소 스패닝 트리를 등등에 유용하게 사용 가능



### 최소 힙

- 임의의 서브 트리의 각각의 root 노드는 항상 그 서브트리에서 최소값을 유지한다.

<img src="./그림1.png" alt="그림1" style="zoom:60%;" />

일단 모든 트리의 루트 노드는 1이다. 그리고 서브트리인 5,10,25,50,100의 서브트리의 루트 노드도 5로 최소이다

그 밑의 서브 트리인 10 50 100의 루트 노드도 10으로 최소값이다.



최대 힙의 경우에는 똑같은 방식으로 -1를 곱해서 넣어주면 된다.



#### 최소 힙의 구조

일단 LinkedList를 이용한다면 구현이 가능하긴 하지만 더 메모리를 더 적게 먹기 위하여 배열로 만든다고 생각해보자

<img src="./그림2.png" alt="그림2" style="zoom:60%;" />

이렇게 각자 노드의 번호를 매긴다면 이런 순서로 매긴다면, 1번 노드의 자식 노드의 번호는 2번, 3번

2번 노드의 자식 노드느 4번 5번...

`k번 노드의 자식 노드`는

- 왼쪽 자식 노드 : `2k`
- 오른쪽 자식 노드 : `2k+1`

가 된다.

그렇게 위의 힙의 구조를 배열로 만든다면

<img src="./그림3.png" alt="그림3" style="zoom:60%;" />

가 된다.



#### 최소 힙의 삽입 (push)

위의 트리에서 0의 값을 집어 넣는다고 생각해보자.

일단 트리의 가장 마지막 자리에 0을 집어 넣는다.(배열로 생각하면 arr[10]의 위치이다.)

<img src="./그림4.png" alt="그림4" style="zoom:70%;" />

하지만 이렇게 했을때는 이제 최소 힙의 조건이 안 된다.

root노드인 1이 최소 힙도 아니고

subtree인 {5,10,25,50,100,0}도 루트가 5로 최소힙의 조건이 만족되지 않는다.

고로 바로 위의 노드와 부모 바꾼다

<img src="./그림5.png" alt="그림5" style="zoom:70%;" />

이런식으로 다시 최소힙의 조건이 만족 될때까지 바꿔준다.

<img src="./그림6.png" alt="그림6" style="zoom:70%;" />



```python
def heappush(n) :		# this : n = 0
	queue.append(n)
    size = len(queue) -1
    while(size!=1) :
        if queue[int(size/2)] > queue[size] :
	        swap(queue[int(size/2)],queue[size])
	    else :
	        break
```



#### 최소 힙의 삭제 (pop)

일단 힙의 루트 노드를 pop하고, 해당 트리의 가장 마지막 노드의 값을 루트 노드에 대입한다.

<img src="./그림7.png" alt="그림7" style="zoom:70%;" />

하지만 이럴 경우 루트 노드가 25로 최소 힙의 규칙이 무너졌다.

<img src="./그림8.png" alt="그림8" style="zoom:70%;" />

그럼 루트 노드의 두 자식 노드 중 더 작은 쪽을 선택한다.

25의 자식 노드증 1과 6 중 1이 더 작으므로 1을 선택하고 교환한다. 반복해서 1의 자식 노드증 5와 10 중에서 5를 선택하고 교환한다.



<img src="./그림9.png" alt="그림9" style="zoom:70%;" />



그럼 다시 최소 힙의 조건을 만족하는 트리가 완성 되었다.

```python
def heappop():
    size = len(queue) -1
    out = queue[1]
    queue[1] = queue[size]
    queue.pop()

    k = 1
    while (2*k < size):
       	if(2*k+1>size) :
            i = (2*k if queue[2*k] < queue[2*k + 1] else 2*k + 1)
        else :
            i = 2 * k
        if (queue[k] > queue[i]):
            swap(queue[k], queue[i])
            k=i
        else:
            break
    return out;
```





## 최대 힙 C++ 코드

```c++
// MaxHeap
template<typename T> class Heap
{
private:
	T	*arr;			// heap array
	int	maxsize;		// heap max size
	int	len;			// heap current size
public:
	// heap init
	Heap()
	{
		maxsize = HEAPMAXSIZE;
		len = 0;
		arr = new T[HEAPMAXSIZE];
	}

	//heap delete
	~Heap()
	{
		len = 0;
		delete arr;
	}

	// item push
	void push(T item)
	{
		int i;
		i = ++len;			
		// put the value in the last position of heap

		// exchange it with prants to find a location for item to enter
		while ((i != 1) && (item > arr[i / 2]))
		{
			arr[i] = arr[i / 2];
			i /= 2;
		}

		// put item in the location you find it
		arr[i] = item;
	}

	// pop the maximum value in the current heap
	T pop()
	{
		int parent, child;		
		// position for exploration
		T item, temp;			
		// item : output value
		// temp : value kept to fill a location that has disappered from the heap

		item = arr[1];
		temp = arr[len--];
		parent = 1;
		child = 2;

		while (child <= len)
		{
			if ((child < len) && (arr[child] < arr[child + 1]))
			// whidh of the child is the lower value
				child++;
			if (temp >= arr[child])
			// if you find the place you want, break
				break;
			// exchange the two value of parent and child
			arr[parent] = arr[child];
			// reset each position
			parent = child;
			child *= 2;
		}
		// put the stored values in the location
		arr[parent] = temp;
		return item;
	}

	void printAll()
	{
		for (int i = 0; i < len; i++)
		{
			cout << arr[i + 1] << " ";
		}
		cout << "\n";
	}

	int getLength()
	{
		return len;
	}
};
```

