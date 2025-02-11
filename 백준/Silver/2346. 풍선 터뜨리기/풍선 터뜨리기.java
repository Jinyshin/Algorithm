import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        LinkedList<Balloon> balloons = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int newValue = Integer.parseInt(st.nextToken());
            balloons.add(new Balloon(i + 1, newValue));
        }

        int currIndex = 0;
        while (!balloons.isEmpty()) {
            Balloon target = balloons.remove(currIndex);
            sb.append(target.index).append(" ");

            if (balloons.isEmpty()) break;

            int move = target.value;

            if (move < 0) {
                currIndex = (currIndex + move) % balloons.size();
                if (currIndex < 0) currIndex += balloons.size(); // 음수 보정
            }
            else {
                currIndex = (currIndex + move - 1) % balloons.size();
            }
        }

        System.out.println(sb.toString().trim());
        br.close();
    }
}

class Balloon {
    int index, value;

    public Balloon(int index, int value) {
        this.index = index;
        this.value = value;
    }
}