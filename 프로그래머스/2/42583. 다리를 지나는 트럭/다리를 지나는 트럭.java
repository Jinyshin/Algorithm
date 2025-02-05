import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();
        int totalTime = 0;
        int currbridgeWeight = 0;
        
        for (int truck : truck_weights) {
            trucks.offer(truck);
        }
        
        // 다리 큐 초기화; 길이만큼 0 채우기
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        // 아직 다리에 안올라간 트럭 남았거나, 아직 다리에 트럭 남았을때
        while(!trucks.isEmpty() || currbridgeWeight > 0) {
            // 다리의 맨앞트럭 제거
            currbridgeWeight -= bridge.poll();
            
            // 새 트럭 올릴 수 있으면->올리고 없으면 다시 0추가
            if (!trucks.isEmpty() && currbridgeWeight + trucks.peek() <= weight) {
                int nextTruck = trucks.poll();
                bridge.offer(nextTruck);
                currbridgeWeight += nextTruck;
            } else {
                bridge.offer(0);
            }
            totalTime++;
        }
        
        return totalTime;
    }
}
/*
int totalTime = 0;
대기트럭 큐
다리 큐

현재 다리 총 무게 < weight
다리 한칸이동->1초, 다리 위 트럭 이동, 다리 건너면 제거
*/