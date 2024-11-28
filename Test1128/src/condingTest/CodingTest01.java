package condingTest;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CodingTest01 {
	// 암호문 해독
	// 암호문과 해독하기위한 문자정보 존재
	// 해독한 문자 출력

	// 1. 매칭되는 문자 존재 시, 해당 문자로 변환
	// 2. 무한 반복 매칭 문자 존재 시, ? 처리
	// 3. 매칭되는 문자 없을 시, 기존 문자로 유지

	/*	입력값 
	 	xpyyaq mtjtX 
	 	10 
	 	x H 
	 	a o 
	 	p e 
	 	y z 
	 	z l 
	 	q r 
	 	r q
	 	b o
	 	X n 
	 	t i
	 	
	 	출력값 
	 	hello? mijin
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1. 공백 포함해서 알파벳 1개당 넣기 배열 1칸에 넣기
		String inputPW = br.readLine().trim(); 	// 공백 포함 문자열 읽기(앞 뒤 공백 있을 경우 제거(가운데 공백만 살리기))
		char[] inputEn = inputPW.toCharArray(); // 문자열의 각 알파벳을 배열 인덱스마다 넣기

		// 2. 치환 규칙 알파벳 입력
		int n = Integer.parseInt(br.readLine().trim());

		// 3. 매핑 규칙 입력
		Map<Character, Character> englishMap = new HashMap<>();		//기존 알파벳, 치환할 알파벳 map 형태로 구현
		for (int i = 0; i < n; i++) {					//입력한 n 값만큼 매핑 규칙 입력하기
			String[] alpavets = br.readLine().trim().split(" ");	//공백 기준으로 문자열 나누기(ex. 'a b' => [0]=a [1]=b)
			char en = alpavets[0].charAt(0);			//기존 알파벳 왼쪽 문자열 	=>	[0]의 값 char타입으로 추출
			char newEn = alpavets[1].charAt(0);			//치환 알파벳 오른쪽 문자열 	=>	[1]의 값 char타입으로 추출
			englishMap.put(en, newEn);				//추출한 알파벳 한쌍의 매핑 데이터로 넣기 (기존 데이터, 치환 데이터)
		}

		// 4. 치환 작업 수행
		StringBuilder result = new StringBuilder();			//가변 객체 활용해 출력할 문자열 형성
		for (char c : inputEn) { 					// 문자 배열 순회
			
			// 1) 암호문 배열 내 특정 인덱스의 값이 공백이라면, 공백 그대로 문자열 붙이기
			if (c == ' ') {
				result.append(' ');
				continue;
			}
			
			// 2) 암호문 배열 내 특정 인덱스 값이 문자열이라면, 이하 진행
			char original = c; 	// 현재 확인한 문자열 original 변수로 선언
			int depth = 0; 		// 무한 루프 탐지용
			
			while (englishMap.containsKey(c)) {			// 키값이 c인 map이 있다면 if문 진행
				if (depth++ > inputEn.length) { 		// 무한루프라서 치환할 수 있는 경우의 수를 초과하면 ?로 처리
					c = '?';
					break;
				}
				c = englishMap.get(c);				// 키값 c에 해당하는 그 데이터의 value값을 key값으로 전환하기(해독 종료될 때까지 확인하기 위함)
			}

			// 무한 루프가 아니면 치환된 문자를 결과에 추가
			result.append(c);
		}

		// 5. 결과 출력
		System.out.println(result.toString());
	}
}
