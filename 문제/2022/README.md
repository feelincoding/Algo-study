# 백준 문제 모음
## JAVA
- LinkedList
    - LinkedList를 Stack, Queue 로 바꿔서 시간 복잡도를 줄여보자
        - why? 
    - 삭제 추가가 빈번하게 일어나는 경우는 LinkedList가 더 빠르지만 ArrayList가 조회는 더 빠르다
        - why? ArrayList는 배열의 형태, LinkedList는 자료의 주소값으로 연결되어 있는 형태
- LinkedList, Stack, Queue 서로 상호적으로 쓰면서 O(n)꼴의 선형이 될 수 있게 이중 for문이 아닌 스택을 두개, 큐를 두개 이런식으로 활용해보자!