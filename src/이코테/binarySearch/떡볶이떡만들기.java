package 이코테.binarySearch;

import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * 이진 탐색 + 파라메트릭 서치(최적화 문제를 결정 문제로 바꾸어 해결) 유형
 * 적절한 높이를 찾을 때까지 절단기의 높이 H를 반복해서 조정하는 것.
 * 범위 좁힐 때는 이진 탐색으로 좁히면 됨.
 * [ 19, 14, 10, 17 ], 높이 H = 15
 * [ 4, 0, 0, 2 ], 손님이 가져가는 양 = 6
 */
public class 떡볶이떡만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 떡의 개수(N)와 요청한 떡의 길이(M)
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 각 떡의 개별 높이 정보
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색을 위한 시작점과 끝점 설정
        int start = 0;
        int end = (int) 1e9;
        // 이진 탐색 수행 (반복적)
        int result = 0;
        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < n; i++) {
                // 잘랐을 때의 떡의 양 계산
                if (arr[i] > mid) total += arr[i] - mid;
            }
            if (total < m) { // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
                end = mid - 1;
            }
            else { // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
                result = mid; // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
