
/**
 * 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
 * 어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때,
 * 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int count = 0;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int n;
    static int v;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        v = sc.nextInt();

        //리스트 인덱스는 0부터 시작해서 정점까지 포함
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        //실제 데이터를 저장할 때는 1부터 시작해서 간선까지 포함
        for (int i = 1; i <= v; i++) {
            int ln = sc.nextInt();
            int rn = sc.nextInt();

            list.get(ln).add(rn);
            list.get(rn).add(ln);
        }

        //정점까지 만들어서 넣고 인덱스 0번은 사용하지 않음
        //만약 문제에서 마지막 정점까지 간선이 연결되면 방문 인덱스가 n일 때,
        //n + 1해줘야 인덱스 n이 접근할 수 있게 됨. n + 1 안하면 런타임 에러 발생
        visit = new boolean[n+1];
        DFS(1);
        System.out.println(count);
    }

    private static void DFS(int index) {

        visit[index] = true;
        for (int i = 0; i < list.get(index).size(); i++) {
            Integer node = list.get(index).get(i);
            if(!visit[node]) {
                count++;
                DFS(node);
            }
        }
    }
}
