import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String c = sc.next();
        int count = 0;

        String text = str.toUpperCase();
        String n = c.toUpperCase();

        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == n.charAt(0)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
