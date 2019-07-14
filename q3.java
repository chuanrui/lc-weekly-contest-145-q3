/**We are given hours, a list of the number of hours worked per day for a given employee.

A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.

A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.

Return the length of the longest well-performing interval.**/
class Solution {
    public int longestWPI(int[] hours) {
        int b = 0;
        int[] balance = new int[hours.length+1];//tricky part, length+1
        for(int i = 0; i < hours.length; i++){
            if(hours[i]>8){
                b++;
            }
            else{
                b--;
            }
            balance[i+1] = b;
        }
        int res = 0;
        for(int i = 0; i < balance.length; i++){
            for(int j = balance.length-1; j>i+res; j--){
                if(balance[i]<balance[j]){
                    res = j-i;
                    break;
                }
            }
        }
        return res;
    }
}