import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> toppings = new HashSet<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String newTopping = st.nextToken();
            if (newTopping.endsWith("Cheese") && !toppings.contains(newTopping)) {
                toppings.add(newTopping);
            }
        }
        
        System.out.println(toppings.size() >= 4 ? "yummy" : "sad");
    }
}