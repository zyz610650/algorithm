package zyz.algorithm.hot.top;

import java.util.PriorityQueue;

public class T378_323 {

    public static void main(String[] args) {
        T378_323 t=new T378_323();
        int[][]matrix = {{1,5,9},{10,11,13},{12,12,15}};
        int k = 8;
        System.out.println(t.kthSmallest(matrix,k));
    }
    public int kthSmallest(int[][] matrix, int k) {
        int m=matrix.length;
        int left=matrix[0][0],right=matrix[m-1][m-1];
        while(left<right)
        {
            int mid=left+((right-left)>>1);

            int cnt=check(matrix,mid,m);
            System.out.println(left+" "+right+" "+mid+" "+cnt);
            if(cnt>=k) right=mid;
            else left=mid+1;
        }
        return left;

    }

    int check(int[][] matrix,int tar,int m)
    {
        int x=m-1,y=0;
        int cnt=0;
        while(x>=0&&y<m)
        {
            if(matrix[x][y]<=tar)
            {
                cnt+=(x+1);
                y++;
            }else x--;
        }
        return cnt;
    }


    public int kthSmallest1(int[][] matrix, int k) {
        int m=matrix.length,n=matrix[0].length;
        PriorityQueue<int[]> heap=new PriorityQueue<>((p, q)->{
            return matrix[p[1]][p[2]]==matrix[q[1]][q[2]]?( p[1]-q[1]):(matrix[p[1]][p[2]]-matrix[q[1]][q[2]]);
        });


        for(int i=0;i<m;i++) heap.add(new int[]{matrix[i][0],i,0});
        int index=k-1;
        int[] res =null;
        while(index>0)
        {
            res=heap.poll();
            if(res[2]+1<n)
                heap.add(new int[]{matrix[res[1]][res[2]+1],res[1],res[2]+1});
            index--;
        }
        res=heap.poll();
        return res[0];
    }
}
