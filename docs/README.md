# 🚀 기능 요구 사항 - 우테코 식당 12월 이벤트 플래너

## Model
### Bandge
- [x] 배지의 종류를 나타내는 열거형.
    - [x] 별, 트리, 산타의 세 가지 배지 존재
    - [x] 각 배지에 해당하는 이름을 반환하는 메서드

### BandgeCalculator
- [x] 총 혜택 금액을 받아 배지를 계산하는 클래스.
    - [x] 20,000원 이상: 산타 배지 부여
    - [x] 10,000원 이상: 트리 배지 부여
    - [x] 5,000원 이상: 별 배지 부여
    - [x] 아무런 조건도 만족하지 않을 경우 배지 부여 없음
    - [x] 각 배지에 해당하는 열거형 Badge 반환

### ChristmasDdayDiscount
- [x] 방문 날짜를 받아 크리스마스 디데이 할인을 계산하는 클래스.
    - [x] 12월 1일부터 25일까지 각 날짜에 따라 할인 적용
    - [x] 할인 금액은 1,000원부터 날짜에 따라 100원씩 증가
    - [x] 할인 금액과 "크리스마스 디데이 할인"에 해당하는 Discount 반환

### Discount
- [x] 혜택의 종류와 금액을 나타내는 클래스.
    - [x] 할인 종류와 할인 금액을 초기화하여 생성
    - [x] 할인 종류와 할인 금액을 반환하는 메서드

### GiftEvent
- [x] 총 주문 금액을 받아 증정 이벤트를 계산하는 클래스.
    - [x] 주문 금액이 120,000원 이상일 경우: Menu.샴페인 반환
    - [x] 주문 금액이 120,000원 미만일 경우: null 반환

### Menu
- [x] 식당의 메뉴를 나타내는 열거형.
    - [x] 각 메뉴에는 이름, 가격, 메뉴 타입이 있음
    - [x] MenuType 열거형을 통해 메뉴 타입을 지정
    - [x] 메뉴의 이름, 가격, 메뉴 타입을 반환하는 메서드

### MenuType
- [x] 메뉴의 종류를 나타내는 열거형.
    - [x] APPETIZER, MAIN, DESSERT, DRINK의 네 가지 메뉴 타입 존재

### Order
- [x] 주문 정보를 나타내는 클래스.
    - [x] Menu와 주문 수량을 초기화하여 생성
    - [x] Menu와 주문 수량을 반환하는 메서드

### SpecialDiscount
- [x] 방문 날짜를 받아 특별 할인을 계산하는 클래스.
    - [x] 방문 날짜에 이벤트가 있을 경우 1,000원 할인, 없을 경우 할인 없음
    - [x] 할인 금액과 "특별 할인"에 해당하는 Discount 반환

### WeekdayWeekendDiscount
- [x] 방문 날짜를 받아 주말과 주중에 따른 할인을 계산하는 클래스.
    - [x] 금요일 또는 토요일에 방문할 경우 메인 메뉴 할인, 그 외에는 디저트 메뉴 할인
    - [x] 할인 금액과 "주말 할인" 또는 "평일 할인"에 해당하는 Discount 반환

## View
### InputView
- [x] 사용자로부터 날짜를 입력 받는 메서드
    - [x] 콘솔에서 날짜를 입력받음
    - [x] DateValidator를 사용하여 유효성 검사 후 정수로 반환
- [x] 사용자로부터 메뉴와 개수를 입력 받는 메서드
    - [x] 콘솔에서 메뉴와 개수를 입력받음
    - [x] MenuValidator를 사용하여 유효성 검사 후 List<Order>로 반환

### OutputView
- [x] 사용자에게 정보를 출력하는 클래스.
- [x] 우테코 식당 소개 출력 메서드
    - [x] 고정된 환영 메시지 출력
- [x] 방문 날짜 Request 출력 메서드
    - [x] 방문 날짜 입력을 요청하는 메시지 출력
- [x] 메뉴와 개수 Request 출력 메서드
    - [x] 메뉴와 개수 입력을 요청하는 메시지 출력
- [x] 예약한 날짜와 소개 출력 메서드
    - [x] EventPlannerController로부터 전달받은 방문 날짜를 출력
    - [x] "12월 {visitDate}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!" 메시지 출력
- [x] 주문 메뉴 출력 메서드
    - [x] EventPlannerController로부터 전달받은 주문 목록을 출력
- [x] 할인 전 총 주문 금액 출력 메서드
    - [x] EventPlannerController로부터 전달받은 총 주문 금액을 출력
- [x] 증정 메뉴 출력 메서드
    - [x] EventPlannerController로부터 전달받은 증정 메뉴를 출력
- [x] 혜택 내역 출력 메서드
    - [x] EventPlannerController로부터 전달받은 혜택 목록을 출력
- [x] 총 혜택 금액 출력 메서드
    - [x] EventPlannerController로부터 전달받은 총 혜택 금액을 출력
- [x] 할인 후 예상 결제 금액 출력 메서드
    - [x] EventPlannerController로부터 전달받은 할인 후 예상 결제 금액을 출력
- [x] 12월 이벤트 배지 출력 메서드
    - [x] EventPlannerController로부터 전달받은 배지를 출력

## Controller
### EventController
- [x] 이벤트 플래너를 실행하는 클래스.
    - [x] InputView와 OutputView를 생성하고 EventPlannerController를 통해 이벤트 플래너 실행
    - [x] IllegalArgumentException이 발생할 경우 에러 메시지 출력

### EventPlannerController
- [x] 이벤트 플래너를 제어하는 클래스.
    - [x] 방문 날짜, 주문 목록 등을 초기화하여 생성
    - [x] BadgeCalculator, ChristmasDdayDiscount, WeekdayWeekendDiscount 등을 통해 할인 및 혜택 계산
    - [x] 혜택 및 할인 정보를 OutputView로 전달

## Validator
### DateValidator
- [x] 입력 받은 날짜가 숫자인지 검증하는 메서드
    - [x] 숫자가 아닐 경우 "[ERROR] 유효하지 않은 형식입니다." 에러 메시지 반환
- [x] 입력 받은 날짜가 1에서 31 사이인지 검증하는 메서드
    - [x] 범위를 벗어날 경우 "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." 에러 메시지 반환

### MenuValidator
- [x] 고객이 메뉴판에 없는 메뉴를 입력하는 경우 검증하는 메서드
    - [x] 메뉴가 없을 경우 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 에러 메시지 반환
- [x] 메뉴의 개수가 1 미만 숫자를 입력하는 경우 검증하는 메서드
    - [x] 1 미만일 경우 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 에러 메시지 반환
- [x] 메뉴 형식이 예시와 다른 경우 검증하는 메서드
    - [x] 형식이 다를 경우 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 에러 메시지 반환
- [x] 중복 메뉴를 입력한 경우 검증하는 메서드
    - [x] 중복일 경우 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 에러 메시지 반환
- [x] 음료만 주문한 경우 검증하는 메서드
    - [x] 음료만 주문 시 "[ERROR] 음료만 주문 시, 주문할 수 없습니다." 에러 메시지 반환

## Exception
### Date
- [x] 날짜가 숫자가 아닌 경우
    - [x] "[ERROR] 유효하지 않은 형식입니다."
- [x] 날짜를 공백이나 null 값을 입력하는 경우
    - [x] "[ERROR] 날짜는 null이나 공백이 들어갈 수 없습니다."
- [x] 날짜가 1이상 31 이하의 숫자가 아닌 경우
    - [x] "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."

### Menu
- [x] 고객이 메뉴판에 없는 메뉴를 입력하는 경우
    - [x] "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
- [x] 메뉴의 개수가 1 미만 숫자를 입력하는 경우
    - [x] "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
- [x] 메뉴를 공백이나 null 값을 입력하는 경우
    - [x] "[ERROR] 주문은 null이나 공백이 들어갈 수 없습니다."
- [x] 메뉴 형식이 예시와 다른 경우
    - [x] "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
- [x] 중복 메뉴를 입력한 경우
    - [x] "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
- [x] 음료만 주문한 경우
    - [x] "[ERROR] 유효하지 않은 주문입니다. 음료만 주문 시, 주문할 수 없습니다."

## 프로그래밍 요구 사항
- [x] 프로그램 실행의 시작점으로 main 함수를 포함한다.
- [x] JDK 17에서 정상적으로 동작하도록 구현한다.
- [x] ApplicationTest의 모든 테스트가 성공해야 한다.
- [x] 적절한 패키지 구조를 사용하여 클래스를 나누고, 메서드와 클래스에 적절한 접근 제어자를 사용한다.
- [x] 객체지향 원리를 적용하여 모델, 뷰, 컨트롤러, 밸리데이터 등을 나눈다.
- [x] 각 클래스와 메서드에 주석을 추가하여 기능과 사용 방법을 명확히 설명한다.
- [x] 에러 메시지 및 예외 처리를 효과적으로 활용하여 안정적인 프로그램을 작성한다.
- [x] 테스트 코드를 작성하여 각 기능이 올바르게 동작하는지 확인한다.