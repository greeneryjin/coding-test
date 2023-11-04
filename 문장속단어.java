import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        int count = Integer.MIN_VALUE;
        String data = "";

        for(int i = 0; i < arr.length; i++) {
            int len = arr[i].length();
            if(len > count) {
                count =  arr[i].length();
                data = arr[i];
            }
        }
        System.out.println(data);
    }
}
