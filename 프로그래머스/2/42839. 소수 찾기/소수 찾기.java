import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public static Set<Integer> primes = new HashSet<>();
    
    public int solution(String numbers) {
        char[] numChar = numbers.toCharArray();
        int[] numArr = new int[numChar.length];
        
        for (int i = 0; i < numChar.length; i++){
            numArr[i] = Character.getNumericValue(numChar[i]); // [1,2]
        }
        
        getPrimes(0, numArr, numArr.length);
        
        return primes.size();
    }
    
    private void getPrimes(int curr, int[] numbers, int maxDigit) {
        int digitCount = String.valueOf(curr).length();

        // 만약 지금 숫자의 자릿수가 처음 숫자 개수와 같다면 -> isPrime 검사 후 삽입 or not, return
        if (digitCount == maxDigit) {
            if (isPrime(curr)) primes.add(curr);
            return;
        }

        // 보다 작다면 -> isPrime 검사 후 삽입 or not, 다음 getPrimes 호출
        if (isPrime(curr)) primes.add(curr);

        for (int i = 0; i < numbers.length; i++) {
            int next = 10 * curr + numbers[i];

            // i 인덱스를 'final'처럼 사용하기 위해 지역 변수로 저장
            final int indexToRemove = i;

            // i 인덱스의 숫자를 제거한 int[] 만들기
            int[] nextNumbers = IntStream.range(0, numbers.length)
                                         .filter(index -> index != indexToRemove) 
                                         .map(index -> numbers[index]) 
                                         .toArray();

            getPrimes(next, nextNumbers, maxDigit);
        }
    }
    
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

/*
- 만들 수 있는 모든 소수의 개수 찾기

- String numbers -> 어떤 숫자가 있는지 분리
- 각 숫자를 합친 수를 만들고 -> 소수인지 검사, 맞으면 count++
    - 최대 7개숫자, 2^7=128개 수가 존재
    - 소수검사: 최대 수는 9..9(9 7자리)~=10^8 이니까, root n <= 10^4 -> 브루트포스 가능
- 조건: 1a1b, 1b1a 이런건 숫자 하나로 친다. 011, 11은 같은 숫자로 친다. -> 숫자화하고 Set자료구조에 저장
*/