class Solution {
    public long sumAndMultiply(int n) {
        long newNum=0;
        long sum=0;
        long i=1L;
        while(n!=0){
            long rem = n%10;
            n /= 10;
            if(rem == 0){ 
                continue;
            }
            newNum = newNum + rem*i;
            i *= 10;
            sum += rem;
        }
        return sum*newNum;
    }
}