import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++) {
            fileList.add(new File(files[i], i));
        }
        
        Collections.sort(fileList);
        
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = fileList.get(i).origin;
        }
        return answer;
    }
    
    static class File implements Comparable<File> {
        String origin;
        String head;
        int number;
        int index;
        
        public File(String file, int index) {
            this.origin = file;
            this.index = index;
            parse(file);
        }
        
        private void parse(String file) {
            int i = 0;
            int len = file.length();
            
            // HEAD 추출
            StringBuilder sb = new StringBuilder();
            while (i < len && !Character.isDigit(file.charAt(i))) {
                sb.append(file.charAt(i));
                i++;
            }
            this.head = sb.toString().toLowerCase();
            // NUMBER 추출
            sb = new StringBuilder();
            while (i < len && Character.isDigit(file.charAt(i)) && sb.length() < 5) {
                sb.append(file.charAt(i));
                i++;
            }
            this.number = Integer.parseInt(sb.toString());
        }
        
        @Override
        public int compareTo(File other) {
            int headCompare = this.head.compareTo(other.head);
            if (headCompare != 0) return headCompare;
            
            int numberCompare = Integer.compare(this.number, other.number);
            if (numberCompare != 0) return numberCompare;
            return Integer.compare(this.index, other.index);
        }
    }
}

/*
파일명에 포함된 숫자를 반영한 정렬 기능 구현
- 파일명 <= 100글자, 숫자 하나이상 포함
- 파일명 파싱: head, number, tail

String[] files->파싱&영문자면 소문자화하기
    파싱로직이 복잡하고, 구조가 나뉘어있으니, 별도 File 클래스 정의
        - head, number, tail
        - 원본origin, 초기index
static class File implements Comparable<File> {}
override compareTo:
    - head 사전순, head는 전부 소문자화하기
    - head 정렬순서 같으면 umber 숫자 오름차순 정렬. 숫자앞0은 무시.
    - head,number순서 모두 같으면 입력상 들어온 순서 유지
*/