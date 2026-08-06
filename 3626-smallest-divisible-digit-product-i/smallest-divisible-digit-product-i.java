class Solution {
    public int smallestNumber(int n, int t) {
        int prod=1;
        int inc=n-1;
        do{
            prod=1;
            int temp=++inc;
            while(temp!=0){
                prod *= temp%10;
                temp /= 10;
            }
        }while(prod%t != 0);
        return inc;
    }
}