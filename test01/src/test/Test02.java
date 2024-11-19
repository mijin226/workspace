package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		/*
		 * 예시 : One, three, five, four, zero, zero, seven, zero, zero, six 규칙1 : zero가
		 * 아닌 숫자 => 현재 비어있는 최대 인덱스 위치에 배치 규칙2 : zero => zero의 횟수만큼 최대 인덱스-N만큼 진행. ex. 2개
		 * 숫자, 2개 zero일 시, 모든 인덱스 제거(length(2)-2=0) 규칙3 : 현존하는 인덱스의 수를 불러와 모두 합산
		 */
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int sum;
		int num = 0;
		System.out.println("외치는 수가 zero일 시, 직전 숫자를 제외 합산하는 프로그램입니다.");
		while (true) {
			// 유효성 검사 진행
			while (true) {
				System.out.println("0~100000 사이의 수를 제시해주세요");
				num = sc.nextInt();

				if (num < 0 || num > 100000) {
					System.out.println("범위 내에서 숫자를 입력해주세요.");
					continue;
				} else if (num >= 1 && num <= 100000) {
					numberList.add(num);
					System.out.println("numberList :" + numberList);
					System.out.println("numberList.size() : " + numberList.size());
					break;
				} else if (num == 0) {
					if (!numberList.isEmpty()) {
						numberList.remove(numberList.size() - 1);
					}
					break;
				} else {
					System.out.println("숫자가 입력되지 않았습니다.");
					continue;
				}
			}
			sum = 0;
			// 남아있는 숫자 모두 합산
			if (num != 0) {
				// for (int i = 0; i < numberList.size(); i++) {
				// sum += numberList.get(i);
				for (int number : numberList) {
					sum += number;
				}
			}
			System.out.println("합산된 수 : " + sum);
		}
	}
}
