package condingTest;

import java.io.*;

public class CodingTest02 {
	// 	N개의 산 일렬로 나열된 산맥 존재
	// 	N번째의 산의 높이 H
	/* 	하늘 다리 설치 조건
	   	두 개의 산 높이 일치
	   	일치하는 두 개 '사이의 산'들은 설치하려는 산보다 낮아야 함
	   	하늘 다리 설치할 수 있는 가짓 수 구하기
	   
	 	입력값
	 	5
	 	5 2 3 2 5
	 	출력값
	 	1
	 	
	 	입력값
	 	9
	 	5 4 3 2 1 2 3 4 5
	 	출력값
	 	4
	  
	  	입력값
	  	4
	  	2 2 2 2
	  	출력값
	  	3
	 */
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1. 인풋값 입력
		int inputNumberCount = Integer.parseInt(br.readLine()); // 입력값 : 정수 개수
		String[] inputNumbers = br.readLine().split(" "); 		// 공백 기준으로 문자열 분리

		// 2. 문자 형태 정수 형태로 전환
		int[] numbers = new int[inputNumberCount]; 				// count 크기의 배열 생성
		for (int i = 0; i < inputNumberCount; i++) {
			numbers[i] = Integer.parseInt(inputNumbers[i]);
		}

		// 3. 설치 가능한 하늘다리 개수 세기
		// 하늘 다리 설치하려면 두 산의 높이 일치
		// 두 산 사이 있는 모든 산들의 높이가 작아야 함
		// 기준점 산과 같다면 count +1, break;
		// 기준점 산보다 높다면 break;
		// 기준점 산보다 작다면 continue;

		// 설치 가능한 하늘다리 개수
		int count = 0;

		for (int pivot = 0; pivot < numbers.length - 1; pivot++) { 				// 비교 기준의 산
			for (int mountin = pivot + 1; mountin < numbers.length; mountin++) {// 기준 산과 비교할 산
				if (numbers[pivot] == numbers[mountin]) { 						// 기준점 산과 같다면 count +1, break;
					count++;
					break;

				} else if (numbers[pivot] < numbers[mountin]) { 				// 기준점 산보다 높다면 break;
					break;
				} // 기준점 산보다 작다면 continue; numbers[pivot]>numbers[mountin]
			}
		}
		// 4. count 결과 출력
		System.out.println(count);
	}
}