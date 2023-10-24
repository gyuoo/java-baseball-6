# 미션 - 숫자 야구
## 기능 요구 사항
1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임.

**게임 진행**
- 컴퓨터가 먼저 1에서 9까지의 서로 다른 수 3개 선택.
- 사용자는 컴퓨터가 선택한 3개의 숫자를 맞히기 위해 입력.
- 입력에 따라 스트라이크, 볼, 낫싱 힌트 출력.
  - 사용자가 입력한 수 중 컴퓨터가 선택한 수와 같은 수, 같은 자리라면 스트라이크
  - 사용자가 입력한 수 중 컴퓨터가 선택한 수와 같은 수, 다른 자리라면 볼
  - 같은 수가 전혀 없는 경우 낫싱
- 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임 종료.
- 게임 종료 시 게임 다시 시작 혹은 완전히 종료.
  - 1 입력 시 게임 재시작
  - 2 입력 시 게임 완전히 종료

**예외 처리**
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생시킨 후 애플리케이션 종료.

### 입출력 요구 사항
**입력**
- 서로 다른 3자리의 수 입력.
- 게임 종료 후 재시작 또는 완전히 종료를 선택하는 1 또는 2 입력.

**출력**
- 입력한 수에 대한 결과 출력 (볼, 스트라이크 개수)
  ```
  1볼 1스트라이크
  ```
- 볼과 스트라이크가 모두 없는 경우
  ```
  낫싱
  ```
- 수를 모두 맞힐 경우
  ```
  3스트라이크
  3개의 숫자를 모두 맞히셨습니다! 게임 종료
  ```
- 게임 시작 문구 출력
  ```
  숫자 야구 게임을 시작합니다.
  ```

## 구현할 기능 목록
- 시작 화면 출력
   - "숫자 야구 게임을 시작합니다." 출력.
- 데이터 관리
   - 컴퓨터가 선택한 3개의 서로 다른 숫자 생성 및 저장.
   - 사용자가 입력한 숫자 저장.
   - 현재 게임 상태 저장 (게임 중, 종료 등).
- 게임 진행
   - 입력한 숫자와 컴퓨터가 선택한 숫자 비교.
   - 게임 종료 여부 판단.
   - 입력 예외 발생 시, 예외 처리(IllegalArgumentException) 요청.
       - 사용자 입력에서 1에서 9까지의 수가 입력되지 않은 경우
       - 사용자 입력에서 3자리의 자연수가 아닌 경우
       - 사용자 입력에서 수가 중복된 경우
- 결과 출력
   - 볼, 스트라이크 개수 출력.
   - 낫싱일 경우 "낫싱" 출력.
   - 3스트라이크일 경우 "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력.
- 종료 화면 출력
   - 재시작 또는 완전히 종료 여부 입력 안내.
   - 재시작을 선택한 경우, "게임을 다시 시작합니다." 출력.
   - 완전히 종료한 경우, "게임을 종료합니다." 출력.
   - 입력 예외 발생 시, 예외 처리(IllegalArgumentException) 요청.
       - 1, 2 외의 수가 입력된 경우
- 게임 초기화
- 게임 재시작 또는 종료
   - 사용자 입력에 따라 게임을 재시작하거나 완전히 종료.