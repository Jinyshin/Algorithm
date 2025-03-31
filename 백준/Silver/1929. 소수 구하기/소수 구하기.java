import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        
        for (int i = M; i <= N; i++) {
            
            if (i > 1) {
                boolean isPrime = true;
                int sqrtNum = (int) Math.sqrt(i);
                
                for (int j = 2; j <= sqrtNum; j++) {  // 수정된 부분: j <= sqrtNum
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                
                if (isPrime) {
                    primeNumbers.add(i);
                }
            }
        }
        
        for (Integer n: primeNumbers) {
            System.out.println(n);
        }
    }
}
