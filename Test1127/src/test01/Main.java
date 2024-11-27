package test01;

import java.io.*;

class Main {
    static int count = 0; // 가능한 경우의 수를 저장할 변수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); // 카드 개수
        int S = Integer.parseInt(firstLine[1]); // 목표 합
        int K = Integer.parseInt(firstLine[2]); // 내가 가진 카드 합

        String[] cardLine = br.readLine().split(" ");
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(cardLine[i]);
        }

        // 목표 값
        int target = S - K;

        // 조합 탐색 시작
        findCombinations(cards, 0, 0, target);

        // 결과 출력
        System.out.println(count);
    }

    // 재귀로 모든 조합 탐색
    static void findCombinations(int[] cards, int idx, int currentSum, int target) {
        // 목표값과 일치하면 count 증가
        if (currentSum == target) {
            count++;
            return;  // 한 가지 조합이 완료되면 종료
        }

        // 카드 배열의 끝에 도달했으면 종료
        if (idx == cards.length) {
            return;
        }

        // 현재 카드를 선택하는 경우
        findCombinations(cards, idx + 1, currentSum + cards[idx], target);

        // 현재 카드를 선택하지 않는 경우
        findCombinations(cards, idx + 1, currentSum, target);
    }
}

