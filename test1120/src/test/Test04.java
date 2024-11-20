package test;

public class Test04 {
	// 1 인덱스가 높은 곳이 pivot, pivot을 기준으로 -1씩 낮은 인덱스와 비교.
	// 2 이때, pivot보다 값이 크다면 해당 인덱스+1의 값 출력
	public static void main(String[] args) {

		int[] top = { 6, 9, 5, 7, 4 };

		// 하드코딩 방지
		int N = 5;// 총 탑의 개수

		// 첫번째 탑은 비교군이 없기에 0 확정
		System.out.print(0);
		System.out.print("   ");

		for (int i = 1; i < N; i++) {//pivot
			for (int j = i - 1; j<i && j>=0; j--) {//pivot 비교군
				if (top[i] < top[j]) {
					System.out.print(j+1);
					System.out.print("    ");
					break;
					
				//pivot 비교군 j 인덱스 번호가 0일 때, 즉 모두 비교를 마쳤음에도 top[i]보다 작다면
				}else if(top[i] >= top[j] && j==0) {
					System.out.print(0);
					System.out.print("   ");
				}
			}
		}
	}
}