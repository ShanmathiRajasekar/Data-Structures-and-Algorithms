/**************************************************************************************************************/
/*Shanmathi Rajasekar*/
/*ID - srajase1@uncc.edu*/
/*800# - 800966697*/
/*Data Structures and Algorithm Programming 1*/
/**************************************************************************************************************/

/*Importing Java Packages*/
import java.util.*; 
import java.io.*;
import java.util.Arrays;
import java.lang.*;
import java.text.NumberFormat;

/*Public class Qsort*/
public class Qsort{
/**************************************************************************************************************/
/*swap_num function swaps two numbers at a time*/
/**************************************************************************************************************/
   public static float[] swap_num(float m,float n){
      float sw1[]=new float[2];
      sw1[0]=n;
      sw1[1]=m;
      return sw1; 
}
 
/**************************************************************************************************************/
/*Quick_Sort funtion:It selects center element as pivot and sorts the lesser values to its left and larger*/
/*values to its right. This continues and the final sorted array is copied to answer.txt file with the quick*/
/*sort performance analysis. The performance analysis table consist of input filename, number of inputs and*/
/*time taken to sort for all the files mentioned in the command prompt as arguments.*/
/**************************************************************************************************************/   
   public static void quick_Sort(float arr[], int array_0, int array_len){
		int val_0 = array_0, val_len = array_len;
		float sw[]=new float[2];
      float temp;
		float center = arr[(array_0 + array_len) / 2];
      while (val_0 <= val_len){
            /*The numbers to the right of the pivat are larger than the pivot value*/ 
			while (arr[val_len] > center)
				val_len--;
            /*The numbers to the left of the pivot are lesser than the pivot value*/
         while (arr[val_0] < center)
				val_0++;			
			if (val_0 <= val_len){
				/** swapping of numbers**/
            sw=swap_num(arr[val_0],arr[val_len]); 
            arr[val_0] = sw[0];
				arr[val_len] = sw[1]; 
				val_0++;
				val_len--;       
			}
		}
      /*array index center to maximum is sorted recursively*/
		if(val_0 < array_len) quick_Sort(arr, val_0, array_len);			
		/*array index 0 to center is sorted recursively*/
		if(array_0 < val_len) quick_Sort(arr, array_0, val_len);					
	}
/**************************************************************************************************************/
/* The main function reads the input file given in the command prompt and sorts the values present in the file*/ 
/*using quick_sort function.The output of the function is a sorted array and performance analysis of quick sort*/ 
/*,which is copied to an output file -answer.txt.*/
/**************************************************************************************************************/
	public static void main(String[] args){
   long startTime;
   long endTime;//for performance analysis
   int l=args.length,num,i;
   String fileName[]=new String[args.length];
   int[] arr_size=new int[args.length];
   long[] time_taken=new long[args.length];
   try{
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("answer.txt"));
      //creates output file-answer.txt for sorted array
      for(num=0;num<l;num++){
         fileName[num]=args[num];
			BufferedReader bufferedReader = new BufferedReader(new FileReader(args[num]));
			String line = null;
			String[] num_val = null;
			float[] input_data = null;//gets values in float
          StringBuffer stringbuffer = new StringBuffer("");
         while ((line = bufferedReader.readLine()) != null)
            stringbuffer.append(line); //when input file is not empty
         num_val = stringbuffer.toString().split(";");
						
			arr_size[num]=num_val.length;//stores values in the array
			try{
			   input_data = new float[num_val.length];
				for (i = 0; i < num_val.length; i++) 
				   input_data[i] = Float.parseFloat(num_val[i]);       
				}
			catch (NumberFormatException ex){
		      ex.printStackTrace();					
				}
			
         startTime=System.currentTimeMillis();//startTime will have current time before Quick sort algorithm 
			quick_Sort(input_data, 0, input_data.length - 1);//calls Quick sort algorithm
			endTime=System.currentTimeMillis();//endTime will have current time after Quick sort algorithm	
         time_taken[num]=(endTime-startTime);//time_taken = time taken by the quicksort algorithm 
			/** writes the sorted input on to the output file called answer.txt **/			
			String outS=Arrays.toString(input_data);//float to string conversion 
			String arr[]=outS.substring(1,outS.length()-1).split(", ");     
         bufferedWriter.write("Sorting Result");   
			
         bufferedWriter.newLine();//newline	
         for (int k = 0; k < arr.length; k++){
			  	 bufferedWriter.write(arr[k]);//writes into output file
				 if(k!=arr.length-1)//writes semicolon after sorted elements except last element
			       bufferedWriter.write("; ");			
		   	} 
            
        // output_write(arr.length,arr);       
         bufferedWriter.newLine();//newline	        
         }         
         bufferedWriter.newLine();//newline         	
         bufferedWriter.write("Performance Analysis:");
         bufferedWriter.newLine();//newline	
         bufferedWriter.write("Input file:\t Size \t Sorting Time(in milliseconds)");
         bufferedWriter.newLine();//newline	
         for(num=0;num<l;num++){
            bufferedWriter.write(fileName[num]+"\t "+arr_size[num]+"\t  "+time_taken[num]);//Display Performance analysis data
            bufferedWriter.newLine();//newline	
            }
         bufferedWriter.flush();//Clear the buffer         
         bufferedWriter.close();//Close the buffer	
		   }  
         catch (Exception exp){
		      exp.printStackTrace();
		   }      
   }
}

/**************************************************************************************************************/
/*READ-ME FILE*/
/*Quick sort algorithm is used to sort a set of numbers in ascending order. The input numbers are given in a */
/*input file of user choice. The file names are given in command prompt. It can compute to many files. The output*/ 
/*is given in answer.txt file which contains sorted array and performance analysis. The performance analysis*/
/*table consist of file name, number of elements present in the file and time taken to execute*/

/*BREAKDOWN OF ALGORITHM*/
/*1. Reads input values (including float) from a file given in the comand prompt (multiple filenames can be*/
/*given as arguments.*/
/*2. The middle number is selected as pivot. */
/*3. In the partition step,the pivot element is in proper place. */
/*4. The numbers present to left of pivot are lesser than the pivot and the numbers present to right of pivot*/
/*are greater than the pivot. */
/*5. steps 2 to 5 are repeated to sort the input numbers.*/

/*COMPILER USED*/
/*jGRASP compiler*/

/*PLATFORM USED*/
/*Windows platform was used*/

/*PROS */
/*Efficient data structure, Array is used*/
/*Sorts decimal values*/

/*CONS*/
/*Efficiency can be improved using advanced data structures*/ 

/*DATA STRUCTURE DESIGN*/
/*The data structure used here is array*/
/*It is efficient in storing and accessing objects*/
/*The inputs from files are accessed, sorted usingquicksort algorithm and the sorted array is written to*/
/*answer.txt file. */ 
/**************************************************************************************************************/


/**************************************************************************************************************/
/*SAMPLE OUTPUT*/
/*The output file contains sorted arrays of all files mentioned in command prompt*/
/*As number inputs are bigger, the sorted array present in answer.txt is not shown here*/ 
/*Performance Analysis:
Input file:	 Size 	 Sorting Time(in milliseconds)
input1.txt	 100	  0
input2.txt	 13164	  16
input3.txt	 1200278	  109 */
/**************************************************************************************************************/
