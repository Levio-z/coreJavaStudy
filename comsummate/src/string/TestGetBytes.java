package string;

import java.util.ArrayList;
import java.util.List;

public class TestGetBytes {
    public static void main(String[] args) {
        // 3*3数组 初始化
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        byte[] bytes = s.getBytes();


        byte[] vowel = new byte[123];
        int l =0;
        int ans =0;
        for(int r =0;r<n;r++){
            vowel[bytes[r]]++;
            System.out.println("1vowel:"+vowel[bytes[r]]);
            while(l!=r && vowel[bytes[r]]>1){
                vowel[bytes[l]]--;
                l++;
            }
            System.out.println("l:"+l);
            System.out.println("r:"+r);
            System.out.println("2vowel:"+vowel[bytes[r]]);
            ans = Math.max(r-l+1,ans);
        }
        return ans;

    }
    public static int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1;

        while (num <= n * n) {
            for (int i = l; i <= r; i++) mat[t][i] = num++; // left to right
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++; // right to left
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top
            l++;
        }
        return mat;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l=0,r=n-1,t=0,b=m-1;
        List<Integer> list = new ArrayList();
        int num = m*n;
        while(list.size()<num){
            for(int i=l;i<=r;i++) list.add(matrix[t][i]);
            t++;
            for(int i=t;i<=b;i++) list.add(matrix[i][r]);
            r--;
            for(int i=r;i>=l;i--) list.add(matrix[b][i]);
            b--;
            for(int i=b;i>=t;i--) list.add(matrix[i][l]);
            l++;
        }
        return list;
    }


}
