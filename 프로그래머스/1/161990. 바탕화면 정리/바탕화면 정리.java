class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if (i < lux) lux = i;
                    if (i > rdx) rdx = i;
                    if (j < luy) luy = j;
                    if (j > rdy) rdy = j;
                }
            }
        }

        return new int[] {lux, luy, rdx + 1, rdy + 1};
    }
}

/*
wallpaper && array relationship:
.#
..

0011
0011
0000
0000

pseudo code:

initialize lux, luy, rdx, rdy
search each element
if it's arr[x][y]==1 then compare to lux,luy,rdx,rdy
  if x < lux ->update lux
  if x > rdx ->update rdx
  if y < luy ->update luy
  if y > rdy ->update rdy

return lux, luy, rdx+1, rdy+1
*/