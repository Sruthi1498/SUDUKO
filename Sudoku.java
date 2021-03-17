import java.util.Scanner;


public class Sudoku {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)

            {
            arr[i][j] = scan.nextInt();
            }
        }
        int n = arr.length;
        System.out.println("before solving");
        print(arr,n);

       System.out.println(check(arr,n));
        if(solve(arr,n))
        {
            print(arr,n);
        }
        else
        {
            System.out.println("no solution found");
        }
    }

    public static boolean check(int[][] arr, int n)
    {
        int r,c;
        Scanner s = new Scanner(System.in);
        r = s.nextInt();
        c = s.nextInt();
        int val = arr[r][c] ;
        for(int i=0;i<n;i++)
        {
            if(arr[r][i]==val)
                return false;
        }
        for(int j=0;j<n;j++)
        {
            if(arr[j][c]==val)
                return false;
        }
        return true;

    }
    public static boolean solve(int[][] arr,int n)
    {
        int r = -1;
        int c = -1;
        boolean flag = true;

        for(int i =0;i< n;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(arr[i][j]==0)
                {
                    r = i;
                    c = j;

                    flag = false;
                    break;
                }
            }
            if(!flag)
                break;
        }
        if(flag)
            return true;

        for(int a=1;a<=n;a++)
        {
            if(safe(arr,r,c,a))
            {
                arr[r][c] = a;

                if(solve(arr,n))
                {
                    return true;
                }
                else
                    arr[r][c] = 0;
            }

        }
        return false;
    }

    public static void print(int[][] arr,int n)
    {
        for(int i =0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static boolean safe(int[][] arr,int r,int c,int n)
    {
        for(int i=0;i< arr.length;i++)
        {
            if(arr[r][i] == n){
                return false;
            }
        }

        for(int j =0;j< arr.length;j++)
        {
            if(arr[j][c] == n)
                return false;
        }
        int row = r - (r%3);
        int col = c - (c%3);

        for(int i=row;i<row+3;i++)
        {
            for(int j=col;j<col+3;j++)
            {
                if(arr[i][j] == n)
                {
                    return false;
                }
            }
        }
        return true;
    }

}
