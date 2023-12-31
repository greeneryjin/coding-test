import java.io.*;
import java.util.*;

public class Main {

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
    }
}