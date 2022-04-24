/*Algo Problem 3 - PayTM IPO*/
import java.util.*;
class Problem3
{
    static Scanner sc=new Scanner(System.in);
    public static void main (String[] args) 
    {
		int testCases=sc.nextInt();
		sc.nextLine();
		while(testCases-->0)    //Calling maxProfit() and printing result
		{
		      int[] stockPrice=convert(sc.nextLine());
		      System.out.println(Arrays.toString(maxProfit(stockPrice)));
		}
    }
    
    static int[] convert(String string) 
	{
        String[] partition = string.replace(", ",",").replace(",",", ").replace("[", "").replace("]", "").split(", ");
        int result[] = new int[partition.length],next=0;
        for (String part : partition) {                         //Conversion into Array
            try { result[next++] = Integer.parseInt(part); } 
            catch (NumberFormatException e) {   e.printStackTrace();    }
        }
        return result;
    }
    
    public static String[] maxProfit(int[] prices) {        // Calculating Maximum Profit at Time in hh:mm format
        int least = Integer.MAX_VALUE,maxProfit = 0,profit = 0;
        int hour=9,minute=3,lastHour=9,lastMinute=3;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < least){
                least = prices[i];
            }
            profit = prices[i] - least;
            if(maxProfit < profit){
                maxProfit = profit;
                lastHour=hour;
                lastMinute=minute;
            }
            minute=(minute+1)%6;
            if(minute==0)
                hour=(hour+1)%13;
            if(hour==0)
                hour++;
        }
        String time=Integer.toString(lastHour)+"."+Integer.toString(lastMinute)+"0";
        return (new String[] {Integer.toString(maxProfit),time});
    }
}