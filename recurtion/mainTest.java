package recurtion;

public class mainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(isStrNum("235425"));
			
	
}
//rev num
public static void reversNum(int num) {
	if(num < 10 )
		System.out.println(num);	
	else
	{
		System.out.print(num%10);
		 reversNum(num/10);
	}	
}

// n*n-1
public static int countSteps(int a, int b) {
	if(a<b)
		return 0;
	else
		return (1 + countSteps((a-b),b));
}

// return max diggit in num
public static int maxDigit(int n) {
	if(n < 10)
		return n;
	else
	{
		int x = n%10;
		int y = maxDigit(n/10);
		if(x>y)
			return x;
		return y;
	}
}

// return x^y
public static int sec2(int x,int y) {
	if(y == 0)
		return 1;
	if(y == 1)
		return x;
	return x* sec2(x, y-1);
}

// revers number
public static int sec3(int n) {
	if(n <10)
		return n;
	else
	{
		int i=10;
		while(n% i !=n)
			i *= 10;
		return((n%10) * i/10) + sec3(n/10);
	}
}

//fibonuchy
// in: index of steps
// out: sum
public static int fibonuchy(int i)
{
	if( i == 1)
		return 0;
	if(i == 2)
		return 1;
	return (fibonuchy(i-1) + fibonuchy(i-2));
	
}

//reveres string
public static void reversString(String st) 
{
	if (st.length() !=0)
	{
		reversString( st.substring(1));
		System.out.print(st.charAt(0));
	}
}

//ArrMod3
public static void arrMod3(int []arr, int i)
{
	if( i >= arr.length)
		return;
	else
	{
			System.out.println(arr[i]);
			arrMod3(arr , i+3);
			
	}
	
}

//all string numbers
public static boolean isStrNum(String s)
{
	if (s.length() ==0)
		return true;
	
	if (s.charAt(0) < '0' || s.charAt(0) > '9')
			return false;
	
	return isStrNum(s.substring(1));
}


//count avg all nums before N index
public static double getAvgN(int [] arr,int i, int n)
{
	if (i == n-1)
		return arr[i];
	if (i == 0)
		return((arr[i] + getAvgN(arr, i+1, n))-n);
	return (arr[i] + getAvgN(arr, i+1, n));

}
}



