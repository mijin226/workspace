package test;

public class Test01 {

	public static void main(String[] args) {
		// i번째와 i+1번째 비교
		// 이때, 인덱스는 length-1
		// 비교기준은 pivot 변수로 설정
		// pivot보다 작으면 왼쪽으로 변경. pivot보다 크면 현 상태 유지
		// pivot은 왼쪽 0번 인덱스부터 1씩 증가

		// Integer [] student = new Test01[5];
		Integer[] student = { 27, 35, 92, 75, 42, 53, 29, 87 };

		// 비교기준은 pivot 변수로 설정
		int pivot;

		// i번째와 i+1번째 비교 이때, 인덱스는 length-1
		for (int i = 0; i < student.length - 1; i++) {
			for (int j = i + 1; j < student.length; j++) {
				// 오른쪽 수가 pivot보다 작으면 왼쪽으로 변경. pivot보다 크면 현 상태 유지
				if (student[i] > student[j]) {
					pivot=student[i];// pivot은 왼쪽 0번 인덱스부터 1씩 증가
					student[i]=student[j];
					student[j]=pivot;
				}

			}
		}
		int max = student[student.length-1];//최대값
		int min = student[0];//최솟값

		System.out.println("점수차이(최댓값-최솟값) : " + (max-min));
	}
}
