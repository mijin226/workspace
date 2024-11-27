package test02;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력할 정수 총 개수
        int countNumber = Integer.parseInt(br.readLine()); // 정수 개수

        // 2. 각 정수 입력(문자열)
        String[] numberLine = br.readLine().split(" "); // 공백 기준으로 분리

        // 3. 정수 배열로 변환
        int[] numbers = new int[countNumber];
        for (int i = 0; i < countNumber; i++) {
            numbers[i] = Integer.parseInt(numberLine[i]); // 문자열을 정수로 변환
        }
        
        // 4. 중복된 숫자를 확인할 ArrayList 생성
        ArrayList<Integer> doubleNumbers = new ArrayList<>();

        /* 	인덱스 모두 돌면서 같은 값이 있는지 확인 있다면 해당 값 배열에 저장
  		 	인덱스 모두 돌았다면 새 배열에 저장한 수 몇개인지 for문 돌려서 재확인 ex. a or b가 들어간 데이터 모두 찾기
  		 	배열에 들어간 데이터 총 개수를 전체 정수 개수에서 빼기
        */
        
        // 5. 중복 숫자 찾기
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j] && !doubleNumbers.contains(numbers[i])) {
                    doubleNumbers.add(numbers[i]); // 중복된 숫자만 추가
                }
            }
        }

        // 6. 중복된 숫자의 개수
        int doubleCount = 0;
        for (int i = 0; i < doubleNumbers.size(); i++) {
            int num = doubleNumbers.get(i);
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] == num) {
                    doubleCount++; // 중복된 숫자의 개수
                }
            }
        }

        // 7. 결과 출력: 전체 숫자 개수에서 중복된 숫자의 개수 빼기
        System.out.println(countNumber - doubleCount);
    }
}
