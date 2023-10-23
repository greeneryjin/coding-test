import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int n , m , v; // 정점, 간선, 시작 정점
    static int[][] graph; //인접 행렬
    static boolean visit[]; // 방문 확인
    static Stack<Integer> stack = new Stack<>(); //DFS

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        graph = new int[n+1][n+1]; // 행렬로 그래프 표현
        visit = new boolean[n+1]; // false 초기화

        for(int i = 1 ; i <= m ; i++) {
            int tmp1 = sc.nextInt();
            int tmp2 = sc.nextInt();
            graph[tmp1][tmp2] = 1;
            graph[tmp2][tmp1] = 1;
        }
        DFS(v);
        for (int i = 1; i < visit.length; i++) {
            if(!visit[i]) {
                System.out.println(0);
            }
        }
    }

    public static void DFS(int v) { // 재귀함수를 활용해서

        stack.push(v);
        visit[v] = true;
        while (!stack.empty()) {
            Integer pop = stack.pop();
            System.out.println(pop);
            for (int i = n - 1; i >= 1; i--) {
                if (graph[i][pop] == 1 && !visit[i]) {
                    DFS(i);
                }
            }
        }
    }
}