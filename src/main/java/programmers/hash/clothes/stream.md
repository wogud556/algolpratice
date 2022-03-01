### 문제에 사용된 기능이 생소한 기능이라면 이런식으로 정리할 예정입니다.

## Stream

- 고를 수 있는 옷의 경우의수를 구하는 문제에서 이런식으로 stream이 사용되었다.

```
 class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }
}
```
- 이게 답인데 어이가 없다 스트림을 모르기 때문 따라서 문제에 대한 해결을 위해 스트림에 대해 알아보고자 한다.

### 스트림API
- java se8부터 추가된 개념
- 자바의 가독성과 데이터베이스의 쿼리와 같은 정형화된 패턴을 사용하기 위해 도입된 개념이다.

### 특징
- 스트림은 외부 반복을 통해 작업하는 컬렉션과 달리 내부 반복을 통해 작업을 수행한다.
- 스트림은 재사용이 가능한 컬랙션과 달리 단 한번만 사용할 수 있다.
- 스트림은 원본 데이터를 변경하지 않는다.
- 스트림의 연산은 필터-맵 기반의 api를 사용하여 지연 연산을 통해 성능을 최적화 한다.

### 스트림 API의 동작 흐름
- 스트림 api는 다음과 같이 세가지 단계에 걸쳐 동작한다

```
1. 스트림 생성
2. 스트림의 중개 연산(스트림의 변환)
3. 스트림의 최종 연산 (스트림의 사용)
```
### 스트림 생성
- 스트림 api는 다음과 같은 다양한 데이터 소스에서 생성할 수 있다.

```
1. 컬렉션
2. 배열
3. 가변 매개변수
4. 지정된 범위의 연속된 정수
5. 특정 타입의 난수들
6. 람다 표현식
7. 파일
8. 빈 스트림
```
### 컬랙션
- 자바에서 제공하는 모든 컬렉션의 최고 상위 조상인 Collection 인터페이스에는 stream()메소드가 정의되어 있다.
- 따라서 Collection 인터페이스를 구현한 모든 list와 set컬렉션 클래스에서도 stream() 메소드로 스트림을 생성할 수 있다.
- 또한 parallelStream()메소드를 사용하면 병렬 처리가 가능한 스트림을 생성할 수 있다.

```
ArrayList<Integer> list = new ArrayList<Integer>();

list.add(4);

list.add(2);

list.add(3);

list.add(1);


// 컬랙션 스트림 생성
Stream<Integer> stream = list.stream();

stream.forEach(System.out::println);
```

### 배열
- 배열에 관한 스트림을 생성하기 위해 Array 클래스에는 다양한 형태의 stream() 메소드가 클래스 메소드로 정의되어 있다.
- 또한 기본 타입인 int, long, double 형을 저장할 수 있는 배열에 관한 스트림이 별도로 정의되어 있다.
- 이러한 스트림은 java.util.stream 패키지의 IntStream, LongStream, DoubleStream인터페이스로 각각 제공된다.
```
String[] arr = new String[]{"넷","둘", "셋", "하나"};

// 배열에서 스트림 생성

Stream<String> stream1 = Arrays.stream(arr);

stream1.forEach(e -> System.out.print(e + " "));

System.out.println();

 

// 배열의 특정 부분만을 이용한 스트림 생성

Stream<String> stream2 = Arrays.stream(arr, 1, 3);

stream2.forEach(e -> System.out.print(e + " "));
```

### 가변 매개변수
- Stream 클래스의 of() 메소드를 사용하면 가변 매개변수(variable parameter)를 전달받아 스트림을 생성할 수 있다.
```
Stream<Double> stream = Stream.of(4.2, 2.5, 3.1, 1.9);

stream.forEach(System.out::println);
```

### 지정된 범위의 연속된 정수
- 지정된 범위의 연속된 정수를 스트림으로 생성하기 위해 IntStream나 LongStream 인터페이스에는 range() 와 rangeClosed() 메소드가 정의되어 있다.
- range() 매소드는 명시된 시작 정수를 포함하지만, 명시된 마지막 정수는 포함하지 않는 스트림을 생성한다.
- rangeClose() 메소드는 명시된 시작 정수 뿐만 아니라 명시된 마지막 정수까지도 포함하는 스트림을 생성한다.
```
// 지정된 범위의 연속된 정수에서 스트림 생성

IntStream stream1 = IntStream.range(1, 4);

stream1.forEach(e -> System.out.print(e + " "));

System.out.println();

 

IntStream stream2 = IntStream.rangeClosed(1, 4);

stream2.forEach(e -> System.out.print(e + " "));
```