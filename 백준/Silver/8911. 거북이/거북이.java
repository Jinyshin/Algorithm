/*
거북이 문제를 풀어보자!
- 거북이는 F, B, L, R의 움직임이 가능하다.
    - L, R 명령을 내리면 -> 이 거북이는 이동하지 않고, 방향만 바꾼다.
- 거북이가 지나간 영역을 모두 포함할 수 있는 가장 작은 직사각형의 넓이를 구해보자

<필요한 것>
- currX, currY, direction: 거북이의 위치와 방향을 기록하는 변수
- minX, minY, maxX, maxY: '최소', '최대' 좌표를 기록하는 변수
- 입력값에 따라 명령을 처리하는 함수 -> 굳이 함수로 빼지 않았음. 대신 각 명령별 동작 처리하는 함수 작성
    - 의 경우에 움직이고, 은 방향을 바꾼다.
    - F, B: moveForward, moveBackward
    - L, R: turnLeft, turnRight
- updateBounds: 최대최소좌표값을 갱신하는 함수
    - 거북이가 이동하고 나면 호출한다.
    - 어떤 X 또는 Y 좌표가 최소이면 -> '최소 좌표'의 X 또는 Y 좌표를 갱신한다.
    - 어떤 X 또는 Y 좌표가 최대이면 -> '최대 좌표'의 X 또는 Y 좌표를 갱신한다.
- getArea: '최소 좌표', '최대 좌표'를 대각선 좌표로 정하고 직사각형의 넓이를 구하는 함수
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            String commands = sc.nextLine();
            Turtle turtle = new Turtle();

            for (char c : commands.toCharArray()) {
                switch (c) {
                    case 'F':
                        turtle.moveForward();
                        break;
                    case 'B':
                        turtle.moveBackward();
                        break;
                    case 'L':
                        turtle.turnLeft();
                        break;
                    case 'R':
                        turtle.turnRight();
                        break;
                }
            }

            System.out.println(turtle.getArea());
        }
        sc.close();
    }
}

class Turtle {
    private int currX, currY;
    private int minX, minY, maxX, maxY;
    private int direction = 0;  // 0: 북, 1: 동, 2: 남, 3: 서
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public Turtle() {
        this.currX = 0;
        this.currY = 0;
        this.minX = this.minY = this.maxX = this.maxY = 0;
    }

    public void turnLeft() {
        direction = (direction + 3) % 4;  // 왼쪽 회전
    }

    public void turnRight() {
        direction = (direction + 1) % 4;  // 오른쪽 회전
    }

    public void moveForward() {
        currX += directions[direction][0];
        currY += directions[direction][1];
        updateBounds();
    }

    public void moveBackward() {
        currX -= directions[direction][0];
        currY -= directions[direction][1];
        updateBounds();
    }

    private void updateBounds() {
        minX = Math.min(minX, currX);
        minY = Math.min(minY, currY);
        maxX = Math.max(maxX, currX);
        maxY = Math.max(maxY, currY);
    }

    public int getArea() {
        return (maxX - minX) * (maxY - minY);
    }
}
