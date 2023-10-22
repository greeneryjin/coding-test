import java.io.*;
import java.util.*;

public class Main {

<<<<<<< HEAD
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
        while(!stack.empty()) {
            int pt = stack.pop();
            System.out.print(pt + " ");
            for(int i = 1 ; i <= n ; i ++) {
                if(graph[pt][i] == 1 && !Visit[i]) {
                    DFS(i);
                }
            }
        }
=======
    //갈 수 있는 걸음 수
    public static int[] step = {-1, 1, 5};

    // 각 노드의 레벨
    public static int level = 0;

    //계산 결과를 저장하는 자료구조
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 현재 위치
        int m = scan.nextInt();	// 도달 위치
        int bfs = bfs(n, m);
        System.out.println(bfs);
    }

    public static int bfs(int n, int m) {
        queue.offer(n);
        //큐에 노드 값이 없으면 반복문 종료
        while (!queue.isEmpty()) {
            int size = queue.size(); //레벨에서 나온 노드 수(할당 안하면 레벨끼리 노드가 섞임)
            for (int i = 0; i < size; i++) {
                int nowNode = queue.poll();
                if (nowNode == m) {
                    return level;
                }
                for (int j : step) {
                    int nextNode = nowNode + j;
                    queue.add(nextNode);
                }
            }
            level++;
        }
        return 0;
>>>>>>> d985bd63eb81db396db7d42f86d28ebbbdf7803e
    }
}