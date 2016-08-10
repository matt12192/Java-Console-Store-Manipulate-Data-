//This section is used imports extra functionality from external Java Class Libraries (Packages)
//The follow is required to run this program

import java.util.Scanner;




public class MainProgram {
	
	//This is were Variables and Array Declaration begins
	
	//Public String type variable is created to capture User Input 
        
    static String userInput;
    
    static String customerName;
	static String customerAddress;
	static String customerPostCode;
	static String customerAge;
	static String customerPriority;
    
    //totalcustomerAge will be used to calculate average Customer age
            
    static int rowIndex = 1;
    
    static String allocatedZone;
    
	static int belfastRows = 0;
	static int northRows = 0;
	static int eastRows = 0;
	static int westRows = 0;
	static int southRows = 0;
     
          
    //dataArray is required to store information as the program is running
    //It starts as 1 row deep and 7 columns wide
	
    static String [][] dataArray = new String [1][7];
    
    //Beginning Method Declaration
 
    //Method to receive input from keyboard
	public static void GetInput() {

        System.out.println("");
                    
        System.out.print("Enter your text: ");

        Scanner scanner = new Scanner(System.in);
        
        String keyboardInput = scanner.nextLine();
        
        if (keyboardInput.trim().equals("")) 
        
        {
            
            System.out.println("You didn't type anything!");
        
        }
        
        else
            
        {
                           
           userInput = keyboardInput;             
                                           
         }
        
        System.out.println("\n");
        
    }
 
  //Method used to display a Main Menu on the Console Screen
    
    public static void DisplayMenu() {
            
            //Separate line spacing between each heading
                   
                   System.out.println("");
                   System.out.println("Menu");
                   System.out.println("");                                                                       
                   System.out.println("Press '1' to Add New Customer Data");
                   System.out.println("Press '2' to Display All Data");
                   System.out.println("Press '3' to Display Zone Data");
                   System.out.println("Type 'Exit' or 'exit' to Exit Program");
                   System.out.println("");
                              
                   GetInput();
                   
                   System.out.print("You typed: " + userInput);
                   
                                                             
                  
            switch (userInput){
            
            case "1": System.out.println("\nAdd New Customer Data"); AddCustomerData(); break; //exits switch statement
                                   
            case "2": System.out.println("\nDisplay All Data"); DisplayAllData(); break;
            
            case "3": System.out.println("\nDisplay Zone Data"); DisplayFilteredData(); break;
                                    
            case "Exit": System.out.println("\nExit Application");System.exit(0); break;
            
            case "exit": System.out.println("\nExit Application");System.exit(0); break;
            
            default: System.out.println("\nReturning to Menu"); 
            
            }
                           
            
            DisplayMenu();
                                 
    }
    
    //Code to output add customer questions
    public static void AddCustomerData(){
    	
    	System.out.println("\nCustomer Name");	
    	GetInput(); 
    	customerName = userInput;
    	
    	System.out.println("\nCustomer Address");
    	GetInput(); 
    	customerAddress = userInput;
    	
    	System.out.println("\nCustomer Post Code");
    	GetInput(); 
    	customerPostCode = userInput;
    	
    	System.out.println("\nCustomer Age");
    	GetInput(); 
    	customerAge = userInput;
    	
    	    	
    	//Code used to determine Zone based on Post Code entered
    	
    	switch(customerPostCode.substring(0, 4)) 
    	{
        
    	//Belfast
    	
    	case "BT1 ": case "BT2 ": case "BT3 ": case "BT4 ": case "BT5 ": case "BT6 ": case "BT7 ": case "BT8 ":
        case "BT9 ": case "BT10": case "BT11": case "BT12": case "BT13": case "BT14": case "BT15":
        allocatedZone = "Belfast"; 
        belfastRows ++;
        break;
        
        //North
        
        case "BT39": case "BT40": case "BT41": case "BT42": case "BT43": case "BT44": case "BT45": case "BT46": 
        case "BT51": case "BT52": case "BT53": case "BT54": case "BT55": case "BT56": case "BT57":
        allocatedZone = "North";
        northRows ++;
        break;
        
        //South
        
        case "BT25": case "BT26": case "BT32": case "BT35": case "BT60": case "BT61": case "BT62": case "BT63": 
        case "BT64": case "BT65": case "BT66": case "BT67": case "BT68": case "BT69": case "BT70": case "BT71": 
        case "BT80":
        allocatedZone = "South";
        southRows ++;
        break;
        
        //East  
        
        case "BT16": case "BT17": case "BT18": case "BT19": case "BT20": case "BT21": case "BT22": case "BT23": 
        case "BT24": case "BT27": case "BT28": case "BT29": case "BT30": case "BT31": case "BT33": case "BT34": 
        case "BT36": case "BT37": case "BT38":
        allocatedZone = "East";
        eastRows ++;
        break;
        
        //West       
        
        case "BT47": case "BT48": case "BT49": case "BT74": case "BT75": case "BT76": case "BT77": case "BT78": 
        case "BT79": case "BT81": case "BT82": case "BT92": case "BT93": case "BT94":
        allocatedZone = "West";
        westRows ++;
        break;
         
        //UNALLOCATED

        
        
    }
     	 
    	customerPriority = "";
    	    	
    	System.out.println("This Customer has been allocated to Zone : " + allocatedZone) ;
    	
    	
    	AddDataToRow();
    	
    	//DisplayAllData();
    	
    	
    	
    	//System.out.println("Belfast");
    	
    	AllocatePriorities();
    	    	
    	//DisplayAllData();
        	
    }
    
    public static void AddDataToRow(){
    	
    	 	
    	dataArray[dataArray.length - 1][0] = ConvertIntToString(rowIndex);
		dataArray[dataArray.length - 1][1] = customerName; 
		dataArray[dataArray.length - 1][2] = customerAddress;
		dataArray[dataArray.length - 1][3] = customerPostCode;
		dataArray[dataArray.length - 1][4] = customerAge;
		dataArray[dataArray.length - 1][5] = allocatedZone;
		dataArray[dataArray.length - 1][6] = customerPriority;
    	
		//System.out.print("Pre expand rows " + dataArray.length);
    	
    	dataArray = Expand(dataArray, dataArray.length + 1);
    	
    	//System.out.print("Post expand rows " + dataArray.length);
    	
    	rowIndex +=1;
    	        	
    	//rowIndex = arrayLength;
    }
           
    public static void AllocatePriorities(){
    	
    	//Create individual String Arrays allocated to each zone
    	
    	int belfast[][] = new int [belfastRows][7];
    	int belfastCounter = 0;
    	    	   		
    	int north[][] = new int [northRows][7];
    	int northCounter = 0;
    	
    	int south[][] = new int [southRows][7];
    	int southCounter = 0;
    	
    	int east[][] = new int [eastRows][7];
    	int eastCounter = 0;
    	
    	int west[][] = new int [westRows][7];
    	int westCounter = 0;
    	
    	//Collects data for each zone
    	
    	for(int loopCounter=0; loopCounter<dataArray.length - 1; loopCounter++)
    	{
    		if(dataArray[loopCounter][5]=="Belfast")
    		
    		{
    			belfast[belfastCounter][0] = ConvertStringToInt(dataArray[loopCounter][4]);
    			
    			System.out.println(belfast[belfastCounter][0]+ " " + belfast[belfastCounter][1]);
    			
    			belfastCounter ++;
    			 			
    		}
    		
    		else if(dataArray[loopCounter][5]=="North")
    		
    		{
    			north[northCounter][0]= ConvertStringToInt(dataArray[loopCounter][4]);
    			
    			System.out.println(north[northCounter][0]+ " " + north[northCounter][1]);
    			
    			northCounter ++;
    		}
    		
    		else if(dataArray[loopCounter][5]=="South")
    		
    		{
    			south[southCounter][0]= ConvertStringToInt(dataArray[loopCounter][4]);
    			
    			System.out.println(south[southCounter][0]+ " " + south[southCounter][1]);
    			
    			southCounter ++;
    		}
    		
    		else if(dataArray[loopCounter][5]=="East")
    		
    		{
    			east[eastCounter][0]= ConvertStringToInt(dataArray[loopCounter][4]);
    			
    			System.out.println(east[eastCounter][0]+ " " + east[eastCounter][1]);
    			
    			eastCounter ++;
    		}
    		
    		else if(dataArray[loopCounter][5]=="West")
    		
    		{
    			west[westCounter][0]= ConvertStringToInt(dataArray[loopCounter][4]);
    			
    			System.out.println(west[westCounter][0]+ " " + west[westCounter][1]);    			
    			
    			westCounter ++;
    		}
    		
    		
    	}	
    	
    	//Pass Extracted Zone Arrays to get sorted into Priority by Age	 using bubblesort method   
		
		belfast = BubbleSort(belfast);
		north = BubbleSort(north);
		south = BubbleSort(south);
		east = BubbleSort(east);
		west = BubbleSort(west);
		
		//Allocated Priorities are assigned based on Age
		
		for(int outerloopCounter=0; outerloopCounter<dataArray.length - 1; outerloopCounter++)
    	
		{
			
			//Belfast Zone Priorities to any 'Belfast' Customers
			
    		if(dataArray[outerloopCounter][5]=="Belfast")
    		
    		{
    			for(int innerloopCounter = belfastRows -1; innerloopCounter >= 0 ;innerloopCounter--)
    			
    			{
    				//Priority Customer is assigned in Main Array - "dataArray"
    				
    				if(ConvertStringToInt(dataArray[outerloopCounter][4]) == belfast[innerloopCounter][0])
    					
    				{
    					dataArray[outerloopCounter][6] = ConvertIntToString(belfast[innerloopCounter][1]);
    					
    				}	
    				    				
    			}
    			 			
    		}
    		
    		//North Zone Priorities to any 'North' Customers
    		
    		if(dataArray[outerloopCounter][5]=="North")
        		
    		{
    			for(int innerloopCounter = northRows -1; innerloopCounter >= 0 ;innerloopCounter--)
    			
    			{
    				//Priority Customer in Main Array - "dataArray"
    				
    				if(ConvertStringToInt(dataArray[outerloopCounter][4]) == north[innerloopCounter][0])
    					
    				{
    					dataArray[outerloopCounter][6] = ConvertIntToString(north[innerloopCounter][1]);
    					
    				}	
    				    				
    			}
    			 			
    		}
    		
    		//South Zone Priorities to any 'North' Customers
    		
    		if(dataArray[outerloopCounter][5]=="South")
        		
    		{
    			for(int innerloopCounter = southRows -1; innerloopCounter >= 0 ;innerloopCounter--)
    			
    			{
    				//Priority Customer in Main Array - "dataArray"
    				
    				if(ConvertStringToInt(dataArray[outerloopCounter][4]) == south[innerloopCounter][0])
    					
    				{
    					dataArray[outerloopCounter][6] = ConvertIntToString(south[innerloopCounter][1]);
    					
    				}	
    				    				
    			}
    			 			
    		}
    		
    		//East Zone Priorities to any 'East' Customers
    		
    		if(dataArray[outerloopCounter][5]=="East")
        		
    		{
    			for(int innerloopCounter = eastRows -1; innerloopCounter >= 0 ;innerloopCounter--)
    			
    			{
    				//Priority Customer in Main Array - "dataArray"
    				
    				if(ConvertStringToInt(dataArray[outerloopCounter][4]) == east[innerloopCounter][0])
    					
    				{
    					dataArray[outerloopCounter][6] = ConvertIntToString(east[innerloopCounter][1]);
    					
    				}	
    				    				
    			}
    			 			
    		}
    		
    		//West Zone Priorities to any 'West' Customers
    		
    		if(dataArray[outerloopCounter][5]=="West")
        		
    		{
    			for(int innerloopCounter = northRows -1; innerloopCounter >= 0 ;innerloopCounter--)
    			
    			{
    				//Priority Customer in Main Array - "dataArray"
    				
    				if(ConvertStringToInt(dataArray[outerloopCounter][4]) == west[innerloopCounter][0])
    					
    				{
    					dataArray[outerloopCounter][6] = ConvertIntToString(west[innerloopCounter][1]);
    					
    				}	
    				    				
    			}
    			 			
    		}
    		
    		//Code for Priority Allocation to Zones is finished running
    		
    	    	}
    	
    }
        
    public static void DisplayFilteredData(){
    	
    	//Filter to output correct customer information and count
    	String filterValue;
    	
    	System.out.println("Please enter Zone");
    	
    	GetInput();
    	
    	filterValue = userInput;
    	
    	   	    	      
        int loopCounter = 0;
        
        for (loopCounter=0; loopCounter<dataArray.length -1; loopCounter++)
        	if  ((dataArray [loopCounter][5]).equals (filterValue))
        	
        	{
        		
        		System.out.println(" Row: " + loopCounter + 
        						   " Customer ID " + dataArray[loopCounter][0] +
        	   					   " Customer Name " + dataArray[loopCounter][1] +
        	   					   " Customer Address " + dataArray[loopCounter][2] +
        	   					   " Customer Post Code " + dataArray[loopCounter][3] +
        	   					   " Customer Age " + dataArray[loopCounter][4] +
        	   					   " Customer Zone " + dataArray[loopCounter][5] +
        	   					   " Customer Priority " + dataArray[loopCounter][6]);
        
        	}
               
        switch (filterValue){
        
        case "Belfast": System.out.println("\nCustomer in " + filterValue + " " + belfastRows); break;
                               
        case "North": System.out.println("\nCustomer in " + filterValue + " " + northRows); break;
        
        case "South": System.out.println("\nCustomer in " + filterValue + " " + southRows); break;
                                
        case "East": System.out.println("\nCustomer in " + filterValue + " " + eastRows); break;
        
        case "West": System.out.println("\nCustomer in " + filterValue + " " + westRows); break;
        
        default: System.out.println("\nReturning to Menu"); 
        
        
        
        }
    }
            
    public static void DisplayAllData(){
    	
    	System.out.println("Array Size: " + dataArray.length);
        
        int loopCounter = 0;
        
        for (loopCounter=0; loopCounter<dataArray.length -1; loopCounter++)
               System.out.println("Row: " + loopCounter 
            		                      + " Customer ID " + dataArray[loopCounter][0] 
            		                      + " Customer Name " + dataArray[loopCounter][1] 
            		                      + " Customer Address " + dataArray[loopCounter][2] 
            		                      + " Customer Post Code " + dataArray[loopCounter][3] 
            		                      + " Customer Age " + dataArray[loopCounter][4]
            		                      + " Customer Zone " + dataArray[loopCounter][5] 
            		                      + " Customer Priority " + dataArray[loopCounter][6]);
        }
    
       
    //Method used to accommodate new rows of data as the string array expands
    
              
    public static String[][] Expand(String[][] array, int size)  {
            
            String[][] temp = new String[size][7];
            
            int rows = temp.length -1;
            
            int loop = 0;
            
            while(loop<rows){
                   temp [loop][0]= (array [loop][0]).toString();
                   temp [loop][1]= (array [loop][1]).toString();
                   temp [loop][2]= (array [loop][2]).toString();
                   temp [loop][3]= (array [loop][3]).toString();
                   temp [loop][4]= (array [loop][4]).toString();
                   temp [loop][5]= (array [loop][5]).toString();
                   temp [loop][6]= (array [loop][6]).toString();
                   loop++;
            }
            
            temp [rows][0] = "*";
            temp [rows][1] = "*";
            temp [rows][2] = "*";
            temp [rows][3] = "*";
            temp [rows][4] = "*";
            temp [rows][5] = "*";
            temp [rows][6] = "*";
            
            
            return temp;
    }

    public static int ConvertStringToInt(String aString){
        
        int aInt = Integer.parseInt(aString);

        return aInt;
                        
}
  
    public static double ConvertStringToDouble(String aString){
     
     double aDouble = Double.parseDouble(aString);

     return aDouble;
                     
}
     
    public static String ConvertIntToString(int aInt){

     
     String aString = Integer.toString(aInt);
     
     return aString;
     
}
     
    public static String ConvertDoubleToString(Double aDouble){
     
     String aString = Double.toString(aDouble);
     
     return aString;
     
}
  
    public static int[][] BubbleSort(int [][] arr){     
    	
    	//arr.Length counts the number of rows in the passed in Zone array
    	
    	//Cycles through the rows in the Zone array arr.length many times
		 
		 for(int outerCounter=0; outerCounter<arr.length; outerCounter++)
		 {        
			 
		
			 for(int innerCounter=1; innerCounter<arr.length; innerCounter++)
			 {            
				 if(arr[innerCounter][0]> arr[innerCounter-1][0] )
				 {                
					 //Changes positions if the second number is greater than the first number
					
					 //Temporary swap variable used to capture the value of the second number
					 int swap = arr[innerCounter][0];        
					 
					 //Makes the value to the second number the same as the first number
					 arr[innerCounter][0] = arr[innerCounter-1][0];  
					 
					 //Makes the value of the first number the same as the second/swap number
					 arr[innerCounter-1][0] = swap;                        
				 }        
			 }     
		 }      
		 
		 //Cycles through a list of numbers prioritise customers depending on age
		 
		 for(int outerCounter=0; outerCounter<arr.length; outerCounter++)     
		 {         
			arr[outerCounter][1]= outerCounter + 1; 
			System.out.println(arr[outerCounter][0] + "  " + arr[outerCounter][1]); 
		 }
		 
		 return arr;
		 
	 }
 
    //program's main routine which controls the flow of activity
 
 public static void main(String[] args) {
	 
	       
              
        DisplayMenu();
        
        
 }

     
}

