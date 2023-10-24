/**
 *
 * N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
 * 두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
 * 둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
 **/

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int n;
    static boolean flag = false;
    static int[] arr;

    static int total = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        DFS(0, 0);
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
    // 문제에서 부분 집합끼리 값이 같기 때문에 전체 집합의 절반을 가지는 원소가 있기 때문에
    // total / 2 == sum이 가능한 이유가 됨.
    private static void DFS(int l, int sum) { // DFS(레벨, 부분 집합의 합)
        if(flag) return; //돌아가는 재귀를 끝내는 기능
        if(l == n) {
            if((total - sum) == sum) {
                flag = true;
            }
        }else {
            DFS(l +1, sum + arr[l]);
            DFS(l +1, sum);
        }

    }
    //인덱스 두 개만 계산 가능한 DFS
    public static void DFS_fail(int index) {

        int set1 = 0;
        int set2 = 0;

        if(index < arr.length - 1){
            for (int i = index + 1; i < arr.length; i++) {
                set2 = 0;
                set1 = arr[index] + arr[i];
                for (int j = 0; j < arr.length; j++) {
                    if(j == index || j == i) continue;
                    set2 += arr[j];
                }
                if(set1 == set2) {
                    flag = true;
                    return;
                }
            }
        }
    }
}
