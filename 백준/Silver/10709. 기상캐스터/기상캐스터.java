import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        // joi 시의 현재 날씨 상태 입력받기
        char[][] weather = new char[H][W];
        for (int i = 0; i < H; i++) {
            weather[i] = br.readLine().toCharArray();
        }
        
        int[][] cloudTime = new int[H][W];
        for (int i = 0; i< H; i++) {
             for(int j = 0; j < W; j++) {
                 cloudTime[i][j] = -1;
             }
        }
        
        int time = 0;  // 시간 초기화
        
        for (int k = 0; k < W; k++) {
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (weather[i][j] == 'c' && cloudTime[i][j] == -1) {
                        cloudTime[i][j] = time;
                    }
                }
            }
            
            weather = next(weather);  // 1분 후 구름 이동
            time++;
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(cloudTime[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
    public static char[][] next(char[][] weather) {
        int H = weather.length;
        int W = weather[0].length;
        
        char[][] newWeather = new char[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (weather[i][j] == 'c') {
                    if (j + 1 < W) {
                        newWeather[i][j + 1] = 'c';  // 오른쪽으로 이동
                    }
                }
            }
        }
        
        // 기존 구름 자리와 이동하지 못한 자리 초기화
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (newWeather[i][j] != 'c') {
                    newWeather[i][j] = '.';
                }
            }
        }
        
        return newWeather;
    }
}


/*
- 각 구역에 대해 지금부터 몇분뒤 처음으로 하늘에 구름이 오는지 구하기
- char[][] weather, -1로 초기화한 int[][] cloudTime, 시간 기록: time=0 1분씩++

- 초기 상태부터 가로길이 W만큼 반복
    - [i][j] == 'c' -> cloudTime[][] = time
    - weather 원소들 전부 우측으로 이동
- 최종 cloudTime 출력    
*/