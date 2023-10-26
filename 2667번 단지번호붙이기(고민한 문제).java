import java.util.Scanner;
import java.util.Stack;

/**
 * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
 * 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
 * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다.
 * <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고,
 * 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 * */

public class Main {

    static int [] rs = {0, 1, 0, -1};
    static int[] ls = {1, 0, -1, 0};
    static int n;
    static int count = 1;
    static int[][] maze;
    static int[][] mazeCount;
    static Stack<Step> stack = new Stack<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        maze = new int[n][n];
        mazeCount = new int[n][n];

        //전체 사각형 입력 받기
        for(int i=0; i<n; i++){
            String input = sc.next();
            for(int j=0; j<n; j++){
                //next는 한 줄을 읽는데 공백을 포함하지 않는다.
                //nextLine은 할 줄을 읽는데 공백을 포함해서 읽는다.
                maze[i][j] = input.charAt(j)-'0';
            }
        }
        DFS();
    }

    //1. 다시 되돌아가는 방법 찾기
    //2. 하나의 단지를 완성했을 때 다른 방향으로 이동하는 방법 찾기
    private static void DFS() {

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                for (int z = 0; z < rs.length; z++) {
                    int nextR = i - rs[z];
                    int nextL = j - ls[z];

                    //배열 범위
                    if(0 < nextR && nextR < n && 0 < nextL && nextL < n) {
                        if(maze[nextR][nextL] == 1) {
                            Step step = new Step(nextR, nextL);
                            stack.push(step);
                            maze[nextR][nextL] = 0;
                            mazeCount[nextR][nextL] = count;
                        }
                    }
                }

                if (!stack.empty()) {
                    Step pop = stack.pop();
                    int beforeR = pop.r;
                    int beforeL = pop.l;
                }
            }
        }
    }

    public static class Step {
        int r;
        int l;

        public Step(int r, int l) {
            this.r = r;
            this.l = l;
        }
    }
}

