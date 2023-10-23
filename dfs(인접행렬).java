import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int n , m , v; // 정점, 간선, 시작 정점
    static int[][] graph; //인접 행렬
    static boolean Visit[]; // 방문 확인
    static Stack<Integer> stack = new Stack<>(); //DFS

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        graph = new int[n+1][n+1]; // 행렬로 그래프 표현
        Visit = new boolean[n+1]; // false 초기화

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        for(int i = 1 ; i <= m ; i++) {
            int tmp1 = sc.nextInt();
            int tmp2 = sc.nextInt();
            graph[tmp1][tmp2] = 1;
            graph[tmp2][tmp1] = 1;
        }

        DFS(v);
    }

    public static void DFS(int v) { // 재귀함수를 활용해서
        stack.push(v);
        Visit[v] = true;
        while (!stack.empty()) {
            int pt = stack.pop();
            System.out.print(pt + " ");
            for (int i = 1; i <= n; i++) {
                if (graph[pt][i] == 1 && !Visit[i]) {
                    DFS(i);
                }
            }
        }
    }
}