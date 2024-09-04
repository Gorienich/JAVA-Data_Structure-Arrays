package stack;

public class nextTest {

	public static void main(String[] args) {

		System.out.println(lastNum(0));
		Stack<Integer> fir = new Stack<Integer> ();
		fir.push(122);
		fir.push(251);
		fir.push(565);
		fir.push(12334);
		fir.push(28);
		fir.push(7);
		
	}

	public static boolean isExist(int num, Stack<Integer> stk) {
		Stack<Integer> temp = new Stack<Integer> ();
		boolean flag=false;
		int number=0;
		while(!stk.isEmpty() && !flag) {
			number=stk.pop();
			temp.push(number);
			if (lastNum(number)==num)
				flag = true;		
		}
		while (!temp.isEmpty()) {
			stk.push(temp.pop());
		}
		return flag;
			
	}

	public static int lastNum(int num) {
		if(num>9)
			return num % 10;
		else 
			return num;
		
	}
	
	public static int firstNum(int num) {
		int check = num;
		int first=0;
		if(num>9)
			while(check!=0)
			{
			first=check%10;
			check/=10;
			}
		else 
			first=check;
		return first;
	}
	
	public static boolean allExist(Stack<Integer> fir) {
		Stack<Integer> temp = new Stack<Integer> ();
		Stack<Integer> clone = clone(fir);
		Stack<Boolean> result = new Stack<Boolean>();
		int num =0;     
		int diggit =0;
		int check =0;
		boolean flag=false;     // result check
		boolean flag2=false;	// break of search
			
		while(! clone.isEmpty()) {
			check = clone.pop();       	    // get value
			diggit = firstNum(check);		// first diggit		
			num = lastNum(check);			// last diggit
			
			if(num == diggit) 				// push check stack
			{
				flag = true;
				result.push(flag);
				clone.pop();
			}
			else
			{
				while(! clone.isEmpty() && !flag2) {
					temp.push(check);   	// save clone
					check = clone.pop();
					num = lastNum(check);
					if(diggit == num)
					{
						flag2 = true;
					}
				}
				while(! temp.isEmpty())
				{
					clone.push(temp.pop());
				}
			}
			
			
		}
		return flag2;
		
	}
	public static Stack<Integer> clone (Stack<Integer> s ){
		Stack<Integer> temp = new Stack<Integer> ();
		Stack<Integer> temp1 = new Stack<Integer> ();
		int val=0;
		while (!s.isEmpty()) {
			val=s.pop();
			temp.push(val);
	}
		while (!temp.isEmpty()) {
			val=temp.pop();
			temp1.push(val);
			s.push(val);
	}
		return temp1;
		
			
			
	}
		
}



