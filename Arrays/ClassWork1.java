package HomeWork_SimpleFoo;
import java.util.Scanner;
import java.util.Random;
   
public class Test {
	public static void main(String[] args) {
/*
 * all function have been checked use by your necessary
 */
		int [] arr = {55,55,55,0,1,5};
		maxChainARR(arr);
		printARR(arr);
}
	

public static int[] getARR() {  // function to create array from user            
	Scanner in = new Scanner(System.in);
	System.out.println("enter a length of array:");
	int length = in.nextInt();	
	int []arr = new int[length];
	return arr;}
  
public static void rndARR(int [] arr) {   //  function to insert random numbers into array between 1-100   
	Random rnd = new Random();
	for(int i =0; i<arr.length; i++)
		arr[i]=rnd.nextInt(100) +1;}
   
public static void printARR(int [] arr) { //function to print array
	for(int i =0; i<arr.length; i++) 
		System.out.print(arr[i] + ", " + "\n");}
    
public static int maxARR(int [] arr ) {   // function to find max in array
	int max = arr[0];
	for(int i =1; i<arr.length; i++) {
		if (arr[i] > max)
			max = arr[i];
	}
return max;}
      
public static int countMinARR(int [] arr) { // function to find min in array
	int min = arr[0];
	for(int i =1; i<arr.length; i++) {
		if(arr[i]<min)
			min =arr[i];}
	return min;}
    
public static void printAbsNumARR(int [] arr,int min,int max) { // function to print abs num in array
	for(int i =0; i<arr.length; i++) 
		if(arr[i]<max && arr[i]>min)
			System.out.println(arr[i]);}

public static void printOdNumARR(int [] arr) { // function to print odd numbers in honest index
	for(int i =1; i<arr.length; i+=2) {
		if(arr[i]%2 != 0)
			System.out.println(arr[i]);}}

public static int maxChainARR(int [] arr)   {  // function to return longest chain of the same numbers in array 
	int [] countArr = new int[arr.length];     // got the worst way we don't know length of array
	int index =0;                              // variable to remove countArr index	
 for (int i =0; i< arr.length-1; i++) 
   {
	   if(arr[i] == arr[i+1])		      
	       countArr[index] += 1;               // add 1 to counter into index [index]
	   else 
		   index++;   	                       // step forward in countArr 	       		   
   }
   int maxChain = maxARR(countArr);            // call foo to know max in array
	   return maxChain+1;            // check in line 81 not return correct numbers of indexes we have to add 1 to get correct num of indexes
	
}

public static int[] replaceIndexARR(int[] arr) { // function to replace numbers in each two indexes in array
	int [] repIndex = new int [arr.length];
	  for(int i=0; i<arr.length-1; i +=2) {
		  repIndex[i] = arr[i+1];
		  repIndex[i+1] = arr[i];
	  }	
	return repIndex;
}
  
public static boolean semethricARR(int [] arr) { // function to check semethric array
 int last = arr.length-1;
		for(int i =0; i<arr.length/2; i++) 
		{
			if(arr[i] != arr[last])
				return false;
			last--;
		}			
	return true;
}
  
public static boolean checkDoubleARR(int [] arr) { // function to check double array expected to get length of array % 2 == 0
	int check = arr.length/2;
	   for(int i=0; i<arr.length/2; i++)
	   {
		   if(arr[i] != arr[check]) 
			   return false;
		   check++;
	   }		   
	return true;
}
   
public static int[] revARR(int []arr) { // function reverse return new reverse array
	int [] revArr = new int[arr.length];
	int index =0;
	for(int i=arr.length-1; i>=0; i--)
	{
		revArr[index] = arr[i];
	    index++;
	}		
	return revArr;
}
   
public static void sortIndexARR(int [] arr, int num) { // function to show correct index for sorting number
	if(arr[0]> num)
		System.out.println("index should be less then 0"); 
	for(int i=1; i<arr.length-2; i++)
		{
			if(arr[i]>num && arr[i+1] < num) 
				System.out.println("index should be beetwen: " + i + " and beetwen: " + (i+1));			
		}
	 if(num > arr[arr.length-1])
		System.out.println("index should be more then last index");
	 else
		 System.out.println("unexpected error");
}
 
public static void sortARR(int [] arr, int num) { // function to insert number in sort array  last value of array = 0
	for(int i =0; i<arr.length; i++) {
		if (arr[i] == num)
		{
			System.out.println("array have this number");
			break;
		}
			
	}
	if(arr[arr.length-2] < num)    // insert num into last index
		arr[arr.length-1] = num;
	
	else if(arr[0] > num)          // insert num into first index
	{
		int Fvalue = arr[0];       // save first value of array
		for(int i = arr.length-1; i>0; i--)
		{
			if(i == 1)             // check index
			{
				arr[i] = arr[i-1];
				arr[i-1] = num;
				break;             // went out of loop to skip arr[i] = arr[i-1]
			}
			arr[i] = arr[i-1];
		}
	}
	else 
	{
		for(int i =1; i < arr.length-2; i++)     // searching place from all array 
		{
			if(arr[i] <num && arr[i+1] >num)     // founded place between numbers to num
			{
				int maxValue = arr[i+1];         // save max i+1
				for(int j = arr.length-1; j > arr.length/2; j--)  // run right half of array  to move right side for empty index
				{
					if(arr[j-1] == maxValue)     // check index
					{
						arr[j] = arr[j-1];
						arr[j-1] = num;
						break;                   // went out of loop to skip arr[i] = arr[i-1]
					}
					arr[j] = arr[j-1];           // remove values
				}
			}
		}
	}
}

public static int[] sortInoneARR(int [] arr1,int[] arr2) { // function to sort two sorted arrays in one
    int[] newArr = new int[arr1.length + arr2.length];        
    int i = 0, j = 0;                           // Variables to check longest index of arr1 or arr2 
    for (int k = 0; k < newArr.length; k++)     // run though array newArr
    {
        if ((i > arr1.length - 1) || (arr1[i] > arr2[j]))    // finished arr1 || value of arr1 more then arr2
        {
        	newArr[k] = arr2[j];   // insert into newArr
            j++;                   // step forward arr2
        } else if ((j > arr2.length - 1) || (arr1[i] < arr2[j]))  // finished arr2 || value of arr2 more then arr1
        {
        	newArr[k] = arr1[i];   // insert into newArr
            i++;                   // step forward arr1 
        } else 
        {
        	newArr[k] = arr2[j];   // get first from arr2 
            j++;                   // step forward arr2
        }
    }
    return newArr;
	
}

public static void devDoubleARR(double [] arr) {  // function create 2 arrays from array type double
	int check = 0;      // variable to save casting number
	int countint =0;    // count integers in array to create length of int arr
	int indexInt =0;    // index
    int indexDoubl =0;  // index
	for(int i =0; i< arr.length; i++)  
	{
		check = (int)arr[i];
		if(arr[i] == check)
			countint++;     // count integers in array
	}
	int [] intNum = new int[countint];    // int array length 'countint'
	double [] doubleNum = new double[arr.length-countint];    //  double array length 'arr.length - countint'
       
	for(int i =0; i< arr.length; i++)  
	{
		check = (int)arr[i];
		if(arr[i] != check)
		{
			doubleNum[indexDoubl] = arr[i];
			indexDoubl++;
		}
		else
		{
			intNum[indexInt] = (int) arr[i];
			indexInt++;
		}
			
	}
	for(int i =0; i<intNum.length; i++)
	{
		System.out.println(intNum[i]);
	}
	for(int i =0; i<doubleNum.length; i++)
	{
		System.out.println(doubleNum[i]);
	}
}

public static void alignment123ARR(int [] arr) { // function to alignment numbers 1,2,3 into 3 arrays
	/*
	 * method can not return 3 arrays at the same time, so we need to use static void for print them 
	 * in necessary to sent them to the main we have to use other methods like pairs, maps, array in array or class etc...
	 */
	int length1 = 0;
	int length2 = 0;  // var to create length of arrays and use them for indexes
	int length3 = 0;
	for (int i=0; i<arr.length; i++)
	{
		if(arr[i] == 1)
			length1++;
		else if (arr[i] == 2)
			length2++;
		else
			length3++;
	}
int [] arr1 = new int[length1];
int [] arr2 = new int[length2];
int [] arr3 = new int[length3];
length1= 0;length2= 0;length3= 0;  // prepair vars for index

for(int i=0; i<arr.length; i++)
{
	if(arr[i] == 1)
	{
		arr1[length1]=arr[i];
		length1++;
	}
		
	else if (arr[i] == 2)
	{
		arr2[length2]=arr[i];
		length2++;
	}
	else
		{
		arr3[length3]=arr[i];
		length3++;
		}
}
System.out.println("arr of 1:");
for(int i =0; i<arr1.length; i++)
{
	System.out.print(arr1[i] + ", ");
}
System.out.println("arr of 2:");
for(int i =0; i<arr2.length; i++)
{
	System.out.print(arr2[i] + ", ");
}
System.out.println("arr of 3:");
for(int i =0; i<arr3.length; i++)
{
	System.out.print(arr3[i] + ", ");
}
}

public static void halfARR(int [] arr) { // function to dev array on to half 
	int[] leftArr = new int[arr.length/2];
	int[] rightArr = new int[arr.length/2];
	int half = arr.length/2;
	for(int i =0; i <arr.length/2; i++)
	{
		leftArr[i]=arr[i];
		rightArr[i] = arr[half];
		half++;
		
	}
	System.out.println("left array:");
	for(int i=0; i<leftArr.length; i++)
		System.out.print(leftArr[i] + ", ");
	System.out.println("\n"+"right array:");
	for(int i=0; i<rightArr.length; i++)
		System.out.print(rightArr[i] + ", ");
}

public static void devOdIndexARR(int [] arr) { // function to create two arrays from one. arr1 have numbers in odd index, arr2 another
	int count1 =0;
	int count2 =0; // var to get length and use for indexes
	for(int i =0; i<arr.length; i++) 
	{
		if(i%2 ==0)
			count1++;
		else
			count2++;		
	}
	int [] arr1 = new int[count1];
	int [] arr2 = new int[count2];
	count1=0;count2=0;
	for(int i =0; i<arr.length; i++) {
		if(i%2 ==0)
			{
				arr1[count1]=arr[i];
				count1++;
			}	
		else
		{
			arr2[count2]=arr[i];
			count2++;
		}
	}
	System.out.println("arr1 index%2 ==0");
	for(int i =0; i<arr1.length; i++)
	{
		System.out.print(arr1[i] + ", ");
	}
	System.out.println("\n" + "arr1 index%2 !=0");
	for(int i =0; i<arr2.length; i++)
	{
		System.out.print(arr2[i] + ", ");
	}
}

}

