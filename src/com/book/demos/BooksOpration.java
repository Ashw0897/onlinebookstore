package com.book.demos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;




public class BooksOpration {
	

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    System.out.println("===================================================================================================================");
		System.out.println("====================================== WELCOME BOOK SHOP  =========================================================");
		System.out.println("===================================================================================================================");
		System.out.println("\n 1 : Customer");
		System.out.println("\n 2 : Admin");
		
		System.out.println("Enter your Choice");
		int choice = Integer.parseInt(br.readLine());
		if(choice==1)
		{
				 System.out.println("===================================================================================================================");
				 System.out.println("====================================== Login Details  =========================================================");
				 System.out.println("===================================================================================================================");
				System.out.print("\t\tUser Name : ");
				String userName = br.readLine();
				System.out.println();
				System.out.print("\t\tPassword  : ");
				String userPassword = br.readLine();
				
				try {
					Connection con=ConnectionBook.getConnection();
		            PreparedStatement ps=con.prepareStatement("select cust_Password from Customer where cust_UserName=?");
		            ps.setString(1, userName);
		            ResultSet result=ps.executeQuery();
		            String password=null;
		            
		            while(result.next())
		            {
		                password=result.getString("cust_Password");
		            }
					if(password.equals(userPassword))
					{
						 System.out.println("==============================================================================");
			             System.out.println("===========================   Login successful ================================");
			             System.out.println("==============================================================================");
			             System.out.println("===========================   Welcome "+ userName.toUpperCase() + " ================================");
			             
			             String status = "Y";
			             boolean login = true;
			             
			             do
			             {
			            	 
		            		   System.out.println("\n==================================================================================================================================================================");
			            	System.out.println("\t\t\t1. View All Books");
			            	System.out.println("\t\t\t2. Search Books");
			            	System.out.println("\t\t\t3. Add to Cart");
			            	System.out.println("\t\t\t4. View Cart");
			            	System.out.println("\t\t\t5. Buy Book");
			            	System.out.println("\t\t\t6. Reset Password");
			            	
		            		   System.out.println("\n==================================================================================================================================================================");
			            	
			            	
			            	System.out.println("Enter your Choice");
			            	int urChoice= Integer.parseInt(br.readLine());
			            	
			            	switch(urChoice)
			            	{
			            	   case 1:
			            	   {
			            		   System.out.println("===================================================================== All Books ===================================================================================");
			            		   System.out.println("");
			            		   ps= con.prepareStatement("select * from book");
			            		   ResultSet rs =ps.executeQuery();

			            		   System.out.printf("\t\t\t %-10s %-20s %-25s %-20s %-10s %-20s %-10s \n ","Book_No","Book_Name","Book_Author","Book_Publication","Year","Book_Category","Price");			            		   System.out.println("\n==================================================================================================================================================================");
			            		   if(rs.next())
			            		   { 
			           				do{
			           				System.out.printf("\t\t\t %-10s %-20s %-25s %-20s %-10s %-20s %-10s \n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7));
			           				System.out.println("");
			           			       
			           				}while(rs.next());
			           				System.out.println("==============================================================================================================================================================");
			           			   }
			           			else
			           			{
			           				System.out.println("Record Not Found...");
			           			}
			            		   break;
			            	   }
			            	  
			            	   case 2:
			            	   {
			            		   int chSearch;
			            		   boolean search = true;
			            		   String st = "Y";
					            	
				            	do {
				            		
				            		
				            		System.out.println("\t\t\t 1.Search By Book_Id ");
				            		System.out.println("\t\t\t 2.Search By Book_Name");
				                    System.out.println("\t\t\t 3.Search By Book_Price");
				            		
				            		System.out.println("Enter your Choice");
					            	chSearch= Integer.parseInt(br.readLine());
				            	
				            		switch(chSearch)
				            		{
				            		case 1:
				            		  {
				            			  
				            		      System.out.println("\n\t\t Enter Book ID for search : ");
				            		      int bid = Integer.parseInt(br.readLine()) ;
				            			  System.out.println("===================================================================== Search Books By Id ===================================================================================");
					            		   System.out.println("");
					       
					            		   ps= con.prepareStatement("select * from Book where book_id = ?");
					            		   ps.setInt(1, bid);
					            		   //ps.executeUpdate();
					            		   ResultSet rs =ps.executeQuery();
                                        
					            		 
					            		   while(rs.next())
					            		   
					            			 
		                                         {
					            				   System.out.printf("\t\t\t %-10s %-20s %-25s %-20s %-10s %-20s %-10s \n ","Book_No","Book_Name","Book_Author","Book_Publication","Year","Book_Category","Price");			            		   
							            		   System.out.println("\n==================================================================================================================================================================");
					           				        System.out.printf("\t\t\t %-10s %-20s %-25s %-20s %-10s %-20s %-10s \n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7));
					           				       System.out.println("");
					           			       
					           				
					           				   System.out.println("==============================================================================================================================================================");
				            		        }
					            			   
                                         }
				            		   break;
					            		   
					            		   case 2:
					            		   {
					            			   System.out.println("\n\t\t Enter Book Name for search : ");
						            		      String bname = br.readLine();
						            			  System.out.println("===================================================================== Search Books By Name ===================================================================================");
							            		   System.out.println("");
							       
					            			   
					            			   System.out.println("===================================================================== All Books ===================================================================================");
						            		   System.out.println("");
						            		   ps= con.prepareStatement("select * from book where book_name = ?");
						            		   ps.setString(1, bname);
						            		 
						            		   ResultSet rs =ps.executeQuery();

						            		   
						            		   while(rs.next())
						            		   { 
						            			   System.out.printf("\t\t\t %-10s %-20s %-25s %-20s %-10s %-20s %-10s \n ","Book_No","Book_Name","Book_Author","Book_Publication","Year","Book_Category","Price");			            		
							            		   System.out.println("\n==================================================================================================================================================================");
						           				System.out.printf("\t\t\t %-10s %-20s %-25s %-20s %-10s %-20s %-10s \n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7));
						           				System.out.println("");
						           			       
						           				}
						           				System.out.println("==============================================================================================================================================================");
					            		      
					            	      }
					            		   break;
					            		   
					            		   case 3:
					            		   {
					            			   System.out.println("\t\t\t 1. Price below 500 ");
					            			   System.out.println("\t\t\t 2. Price above 500 ");
					            			   System.out.println("\n\t\t Enter Your Choice ");
					            			   int ch = Integer.parseInt(br.readLine());
					            			   if(ch==1)
					            			   {
					            			   System.out.println("===================================================================== All Books ===================================================================================");
						            		   System.out.println("");
						            		   ps= con.prepareStatement("select * from book where book_Price <=500");
						            		   ResultSet rs =ps.executeQuery();

						            		   System.out.printf("\t\t\t %-10s %-20s %-25s %-20s %-10s %-20s %-10s \n ","Book_No","Book_Name","Book_Author","Book_Publication","Year","Book_Category","Price");			            		   System.out.println("\n==================================================================================================================================================================");
						            		   if(rs.next())
						            		   { 
						           				do{
						           				System.out.printf("\t\t\t %-10s %-20s %-25s %-20s %-10s %-20s %-10s \n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7));
						           				System.out.println("");
						           			       
						           				}while(rs.next());
						           				System.out.println("==============================================================================================================================================================");
						           			   }
						           			
					            		 }
					            			   else
					            			   {
					            				   System.out.println("===================================================================== All Books ===================================================================================");
							            		   System.out.println("");
							            		   ps= con.prepareStatement("select * from book where book_Price >500");
							            		   ResultSet rs =ps.executeQuery();

							            		   System.out.printf("\t\t\t %-10s %-20s %-25s %-20s %-10s %-20s %-10s \n ","Book_No","Book_Name","Book_Author","Book_Publication","Year","Book_Category","Price");			            		   System.out.println("\n==================================================================================================================================================================");
							            		   if(rs.next())
							            		   { 
							           				do{
							           				System.out.printf("\t\t\t %-10s %-20s %-25s %-20s %-10s %-20s %-10s \n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7));
							           				System.out.println("");
							           			       
							           				}while(rs.next());
							           				System.out.println("==============================================================================================================================================================");
							           			   }
					            			   }
						            		  
					            		   }
					            		   break;
					            		   }
				            		 System.out.println("Do you want continue Searching Y/N");
				            		   st = br.readLine();
				            		   
				            		   if(st.equals("n")||st.equals("N"))
				            		   {
				            			   search = false;
				            		   }
				            		
				              }while(search);	   
			            	}
			             
			            	 
			            	   case 3:
			            	   {
			            		   
			            		   System.out.println("Enter Book Id to Add to cart");
			            	   int bid =Integer.parseInt(br.readLine());
			            	   int id = 0;
			            	   String bname = null;
			            	    int bquantity = 0;
			            	    int bprice =0;
			            	    int totalPrice = 0;
			            	   
			            	    ps = con.prepareStatement("Select * from Book where book_id = ?");
			            	    ps.setInt(1, bid);
			                    ResultSet rs = ps.executeQuery();
			                    while (rs.next()) 
			                    {
			                        bname = rs.getString("book_Name");
			                        bprice = rs.getInt("book_Price");
			                  
			                        System.out.println("Book Name : "+bname);
			                        System.out.println("Book Price : "+bprice);
			                        
			                        System.out.println("Enter Quantity : ");
			                        bquantity = Integer.parseInt(br.readLine());
			                         
			                        totalPrice = bquantity *(rs.getInt("book_Price"));
			                        
			                        
			                    }
			                   
			                    
			                        ps=con.prepareStatement("insert into Addtocart values( ?, ?, ?, ?, ?)");
			                        ps.setInt(1, id);
									ps.setString(2, bname);
									ps.setInt(3, bquantity);
									ps.setInt(4, bprice);
									ps.setInt(5, totalPrice);
									

			                        ps.executeUpdate();
			                    
			            	  
							        System.out.println("==============================================================================");
									System.out.println("Book added successfully!!");
									System.out.println("==============================================================================");
									}
			            	   break;
			            	   
			            	   case 4:
			            	   {
			            		   int total_amt =0;
			            		   System.out.println("===================================================================== Your Cart ===================================================================================");
			            		   System.out.println("");
			            		   ps= con.prepareStatement("select * from Addtocart");
			            		   ResultSet rs =ps.executeQuery();

			            		   System.out.printf("\t\t\t %-10s %-20s %-20s %-20s %-20s \n ","ID","Book_Name","Quantity","Book_Price","Total_Amount");			            		   System.out.println("\n==================================================================================================================================================================");
			            		   if(rs.next())
			            		   { 
			           				do{
			           				System.out.printf("\t\t\t %-10s %-20s %-20s %-20s %-20s \n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
			           				System.out.println("");
			           			      
			           				    total_amt = total_amt + (rs.getInt("Total_amount"));
			           				}while(rs.next());
			           				System.out.println("==============================================================================================================================================================");
			           			     System.out.println("\n\t\t\t\t\t\t\t Total Amount = "+total_amt);
			           			     
			           			     
			           			    System.out.println("\n\t\tDo you to continue Order");
			           			    String chOrder =br.readLine();
			           			    
			           			    
			           			    if(chOrder.equals("y")||chOrder.equals("Y"))
			           			    {
			           			    
			           			     String bname = null;
					            	    int bquantity = 0;
					            	    int bprice =0;
					            	    int totalPrice = 0;
			           			    	
			           			      
					                    ps = con.prepareStatement("Select * from Addtocart");
					                    ResultSet rs1 = ps.executeQuery();
					                    while (rs1.next()) 
					                    {
					                        bname = rs1.getString("book_Name");
					                        bprice = rs1.getInt("book_Price");
					                        bquantity = rs1.getInt("book_qunanty");
					                        totalPrice = rs1.getInt("Total_amount");
					                        System.out.println("Book Name : "+bname);
					                        System.out.println("Book Price : "+bprice);
					                        System.out.println("Book Quantity : "+bquantity);
					                        System.out.println("Total Amount : "+totalPrice);
					                        
					                        
					                     }
					                    
					                    
					                    
			           			    }
			            		   
			            		   }
			           			else
			           			{
			           				System.out.println("Record Not Found...");
			           			}
			            		  
			            	   }
			            	   
			            	   break;
			            	   
			            	   case 5:
			            	   {
			            		   String chPayment =null;
			            		   int Amount =0;
			            		   int id =0;
			            		   String cname = null;
			            		   ps = con.prepareStatement("Select * from Customer where cust_UserName = ?");
				            	    ps.setString(1, userName);
				                    ResultSet rs = ps.executeQuery();
				                    while (rs.next()) 
				                    {
				                        cname = rs.getString("cust_Name");
				                      
				                        System.out.println("Customer Name : "+cname);
				                    }  
				                    
				                    ps = con.prepareStatement("select sum(Total_amount) from Addtocart");
				            	    //ps.setString(1, id);
				                    ResultSet res = ps.executeQuery();
				                    while (res.next()) 
				                    {
				                         Amount = res.getInt(1);
				                        System.out.println("\n\t Total Amount : "+Amount);
					                    
				                    }   
				                    
				                    
				                    System.out.println("\n\tEnter Card No : ");
				                    int cardNo = Integer.parseInt(br.readLine());
				                    
				                    System.out.println("\n\tEnter CVV No : ");
				                    int cvvNo = Integer.parseInt(br.readLine());
				                    
				                    System.out.println("\n\t\t Do you want to Make Payment? Y/N");
				                    chPayment = br.readLine();
				                    
				                    if(chPayment.equals("Y")|| chPayment.equals("y"))
				                    {	
				                    ps=con.prepareStatement("insert into Payment values( ?, ?, ?, ?, ?)");
			                        ps.setInt(1, id);
									ps.setString(2, cname);
									ps.setInt(3, cardNo);
									ps.setInt(4, cvvNo);
									ps.setInt(5, Amount);

			                        ps.executeUpdate();
			                    
			            	  
							        System.out.println("==============================================================================");
									System.out.println("Payment Done Sucessfully");
									System.out.println("==============================================================================");
									
									
					
				                    int oid =0;
									String cname1 = null;
	                                String caddr = null;
	                                String email = null;
	                                String bname =null;
	                                long mobileNo =0;
	                                int book_Price =0;
	                                int book_qty =0;
	                                //int Amount =0;
	                                
	                                System.out.println("\n\n");
				                    System.out.println("\t\t Your Order Details");
				                    System.out.println("\n==================================================================================================");
				            	   ps = con.prepareStatement("Select * from Customer where cust_UserName = ?");
				            	    ps.setString(1, userName);
				                    ResultSet rs1 = ps.executeQuery();
				                    while (rs1.next()) 
				                    {
				                        cname1 = rs1.getString("cust_Name");
				                        caddr = rs1.getString("cust_Addr");
				                        email = rs1.getString("cust_Email");
				                        mobileNo = rs1.getLong("cust_Mobile");
				                        
				                        System.out.println("\tCustomer Name : "+cname1);
				                        System.out.println("\tCustomer Mobile No : "+mobileNo);
				                        System.out.println("\tCustomer Email : "+email);
				                        System.out.println("\tCustomer Address : "+caddr);
				                    }  
				                    
				                   
				                    ps = con.prepareStatement("Select * from Addtocart");
				            	   
				                    ResultSet rs11 = ps.executeQuery();
				                    while (rs11.next()) 
				                    {
				                        bname = rs11.getString("book_name");
				                        book_qty = rs11.getInt("book_qunanty");
				                        book_Price = rs11.getInt("book_price");
				                       Amount = rs11.getInt("Total_amount");
				                        
				                        System.out.println("\tBook Name : "+bname);
				                        System.out.println("\tBook Price : "+book_qty);
				                        System.out.println("\tBook Quantity : "+book_Price);
				                        System.out.println("\tTotal Amount : "+Amount);
				                    }  
				                    
		           				       ps = con.prepareStatement("insert into orders values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		           				       
		           				       ps.setInt(1,oid);
		           				       ps.setString(2,cname);
		           				       ps.setLong(3, mobileNo);
		           				       ps.setString(4, email);
		           				       ps.setString(5, caddr);
		           				       ps.setString(6, bname);
		           				       ps.setInt(7, book_qty);
		           				       ps.setInt(8, book_Price);
		           				       ps.setInt(9, Amount);
		           				       ps.setDate(10,new Date(System.currentTimeMillis()));
		           				       
		           				       ps.executeUpdate();
		           				       
		           				       
				                   
				                    }
				                    else if(chPayment.equals("n")||chPayment.equals("N"))
				                    {
				                    	System.out.println("==============================================================================");
										System.out.println("Cancle Payment....");
										System.out.println("==============================================================================");
				                    }
				                    else
				                    {
				                    	System.out.println("==============================================================================");
										System.out.println("Enter valid choice..");
										System.out.println("==============================================================================");
				                    }
			            	   
			            	   
			            	     
			            	   }
			            	   break;
			            	   
			            	   case 6:
			            	   {
			            		   System.out.println("Enter old Password");
	                            	  String oldPassword = br.readLine();
	                            	  
	                            	  System.out.println("Enter new Password");
	                            	  String newPassword = br.readLine();
	                            	  
	                            	  System.out.println("Re-enter new Password");
	                            	  String rePassword = br.readLine();
	                            	 
	                            	  ps= con.prepareStatement("select * from Customer where cust_UserName = ?");
	                                  ps.setString(1,userName);
	                                  
	                                  ResultSet rs =ps.executeQuery(); 
	                                		  String existingPassword=null;
	                                  while(rs.next())
	                                  {
	                                      existingPassword=rs.getString("cust_Password");
	                                  
	                                  }
	                                  
	                                  if(existingPassword.equals(oldPassword))
	                                  {                    
	                                      if(newPassword.equals(rePassword))
	                                      {
	                                           ps=con.prepareStatement("update Customer set password=? where cust_UserName=?");
	                                           ps.setString(1, newPassword);
	                                           ps.setString(2, userName);
	                                           
	                                           if(ps.executeUpdate()>0)
	                                           {
	                                               System.out.println("==============================================================================");
	                                               System.out.println("Password changed successfully!");
	                                               System.out.println("=========================================================================");

	                                           }
	                                           else
	                                           {
	                                              System.out.println("==============================================================================");
	                                              System.out.println("Problem in password changed!!");
	                                              System.out.println("==============================================================================");

	                                           }
	                                           
	                                          
	                                      }
	                                      else
	                                      {
	                                          System.out.println("==============================================================================");
	                                          System.out.println("New password and retype password must be same!!");
	                                          System.out.println("==============================================================================");

	                                      }
	                                  }
	                                  else
	                                  {
	                                      System.out.println("==============================================================================");
	                                      System.out.println("Old password is wrong!!");
	                                      System.out.println("==============================================================================");

	                                  }
	                                  
	                              
			            	   }
			            	   break;
			            	   
			            	  }
			            	System.out.println("Do you want to continue?(Y/N)");
                            status=br.readLine();
                            
                            if(status.equals("n") || status.equals("N") )
                            {
                                login=false;
                            }
			            	
			             }while(login);
			             
			             System.out.println("=============================================================================");
			                System.out.println("====================== Thank You ...Have a Nice Day ==========================");
			                System.out.println("=============================================================================");
			           
					}
					
			            else
			            {
			                System.out.println("==============================================================================");
			                System.out.println("===========================  Wrong username/password  ========================");
			                System.out.println("==============================================================================");
			                
			            }
			            
		               }
						
						catch(Exception e)
			            {
			                System.out.println(e);
			                System.out.println("===========================  Wrong username/password  ========================");
			             }

					}
			             
			       else if(choice==2)
			        {
                         
						System.out.println("==============================================================================");
						System.out.println("===========================    LOGIN DETAILS  ================================");
						System.out.println("==============================================================================");
						
						System.out.print("\t Enter your username:");
						String userName=br.readLine();
						System.out.print("\t Enter your password:");
						String userPassword=br.readLine();
					
						try 
			            {
						Connection con=ConnectionBook.getConnection();
						PreparedStatement ps=con.prepareStatement("select * from admin where username=?");
						ps.setString(1, userName);
						ResultSet result=ps.executeQuery();
						String password=null;
						boolean login=false;
						while(result.next())
						{
							password=result.getString("password");
							login=true;
						}
						
						if(password.equals(userPassword))
						{
								
						String status="y";
						System.out.println("==============================================================================");
						System.out.println("=============================   WELCOME ADMIN    =============================");
						System.out.println("==============================================================================");
						do
						{
			            System.out.println("==============================================================================");
			            System.out.println("\t\t  1 : Add New Books");
			            System.out.println("\t\t  2 : View all Books");
			            System.out.println("\t\t  3 : Remove Books");
			            System.out.println("\t\t  4 : View Orders");
			            System.out.println("\t\t  5 : Change Password");
			            System.out.println("==============================================================================");
			            
			            System.out.println("Enter your Choice");
			            int ch = Integer.parseInt(br.readLine());
			            
			            switch(ch)
			            {
			               case 1:
			               {
			            	   
			            	   
			            	   System.out.println("Enter Book Id");
			            	   int bid =Integer.parseInt(br.readLine());
			           
			            	   System.out.println("Enter Book Name");
			            	   String bname = br.readLine();
			            	   
			            	   System.out.println("Enter Book author");
			            	   String bauthor= br.readLine();
			            	   
			            	   System.out.println("Enter Book Publisher");
			            	   String bpublisher= br.readLine();
			            	   
			            	   System.out.println("Enter Book Publish Year");
			            	   int byear=Integer.parseInt(br.readLine());
			            	   
			            	   System.out.println("Enter Book Category");
			            	   String bcategory = br.readLine();
			            	   
			            	   System.out.println("Enter Book Price");
								int bprice=Integer.parseInt(br.readLine());
								            	   
			            	   System.out.println("Enter Book Stock");
			            	   int bstock=Integer.parseInt(br.readLine());
			            	   
			            	   
			            	   
			            	   ps=con.prepareStatement("insert into Book values(?,?,?,?,?,?,?,?)");
								ps.setLong(1, bid);
								ps.setString(2, bname);
								ps.setString(3, bauthor);
								ps.setString(4, bpublisher);
								ps.setInt(5, byear);
								ps.setString(6, bcategory);
								ps.setInt(7, bprice);
								ps.setInt(8, bstock);
								
				
								
								
								if(ps.executeUpdate()>0)
								{
									System.out.println("==============================================================================");
									System.out.println("Book added successfully!!");
									System.out.println("==============================================================================");
									
								}
								
								System.out.println("Do you want to continue?(Y/N)");
						 		status=br.readLine();
						 		
						 		if(status.equals("n") || status.equals("N") )
						 		{
						 			login=false;
						 		}
			               
	                        break;
			               }
			               
			               case 2:
			               {
			            	   System.out.println("===================================================================== All Books ===================================================================================");
		            		   System.out.println("");
		            		    ps= con.prepareStatement("select * from book");
		            		   ResultSet rs =ps.executeQuery();

		            		   System.out.printf("\t\t\t %-10s %-20s %-25s %-20s %-10s %-20s %-10s \n ","Book_No","Book_Name","Book_Author","Book_Publication","Year","Book_Category","Price");			            		   System.out.println("\n==================================================================================================================================================================");
		            		   if(rs.next())
		            		   { 
		           				do{
		           				System.out.printf("\t\t\t %-10s %-20s %-25s %-20s %-10s %-20s %-10s \n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7));
		           				System.out.println("");
		           			       
		           				}while(rs.next());
		           				System.out.println("==============================================================================================================================================================");
		           			   }
		           			else
		           			{
		           				System.out.println("Record Not Found...");
		           			}
		            		   break;
		            	     }
			                 
			               case 3:
			               {
			            	   System.out.println("\t\t Enter Book Id for delete");
			            	   int bid =Integer.parseInt(br.readLine());
			            	  try
			            	  {
			            	  
			            	   ps = con.prepareStatement("delete from Book where book_id = ?");
			            	   ps.setInt(1, bid);
			            	   
			            	   if(ps.executeUpdate()>0)
			            	   {
			            		  System.out.println("Delete Suceessfully !!!"); 
			            	   }
			            	   
			            	   else
			            	   {
			            		   System.out.println("Deletion Failed");
			            	   }
				           			
			            	         System.out.println("==============================================================================================================================================================");
			            	  
			            	  ps= con.prepareStatement("select * from book");
		            		   ResultSet rs =ps.executeQuery();

		            		   System.out.printf("\t\t\t %-10s %-20s %-25s %-20s %-10s %-20s %-10s \n ","Book_No","Book_Name","Book_Author","Book_Publication","Year","Book_Category","Price");			            		   System.out.println("\n==================================================================================================================================================================");
		            		 
		            		   while(rs.next()){
		           				System.out.printf("\t\t\t %-10s %-20s %-25s %-20s %-10s %-20s %-10s \n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7));
		           				System.out.println("");
		           			       
		           				}
		           				System.out.println("==============================================================================================================================================================");
		           				
			               }
			            	  catch(Exception e)
			            	  {
			            		  System.out.println(e);
			            	  }
			               }
			               
			               break;
			               
			               case 4:
			               {
			              
			            	   System.out.println("===================================================================== Book Orders ================================================================================================================================");
		            		   System.out.println("");
		            		    ps= con.prepareStatement("select * from orders");
		            		   ResultSet rs =ps.executeQuery();

		            		   System.out.printf("\t %-10s %-25s %-20s %-20s %-15s %-20s %-10s %-15s %-15s %-20s \n ","Id","Cust_Name","Cust_MobileNO","Cust_Email","Cust_Address","Book_Name","Book_Qty","Book_Price","Total_Amount","Order_Date");			            		   System.out.println("\n=================================================================================================================================================================================================");
		            		   if(rs.next())
		            		   { 
		           				do{
		           				System.out.printf("\t %-10s %-25s %-20s %-20s %-15s %-20s %-10s %-15s %-15s %-20s \n",rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9), rs.getDate(10));
		           				System.out.println("");
		           			       
		           				}while(rs.next());
		           				System.out.println("==============================================================================================================================================================================================================================");
		           			   }
		           			else
		           			{
		           				System.out.println("Record Not Found...");
		           			}
		            		  
			                 
			               }
			               
			               break;
			               
			               case 5:
			               {
			            	   System.out.println("Enter old Password");
                         	  String oldPassword = br.readLine();
                         	  
                         	  System.out.println("Enter new Password");
                         	  String newPassword = br.readLine();
                         	  
                         	  System.out.println("Re-enter new Password");
                         	  String rePassword = br.readLine();
                         	 
                         	  ps= con.prepareStatement("select * from admin where username = ?");
                               ps.setString(1,userName);
                               
                               ResultSet rs =ps.executeQuery(); 
                             		  String existingPassword=null;
                               while(rs.next())
                               {
                                   existingPassword=rs.getString("password");
                               
                               }
                               
                               if(existingPassword.equals(oldPassword))
                               {                    
                                   if(newPassword.equals(rePassword))
                                   {
                                        ps=con.prepareStatement("update admin set password=? where username=?");
                                        ps.setString(1, newPassword);
                                        ps.setString(2, userName);
                                        
                                        if(ps.executeUpdate()>0)
                                        {
                                            System.out.println("==============================================================================");
                                            System.out.println("Password changed successfully!");
                                            System.out.println("=========================================================================");

                                        }
                                        else
                                        {
                                           System.out.println("==============================================================================");
                                           System.out.println("Problem in password changed!!");
                                           System.out.println("==============================================================================");

                                        }
                                        
                                       
                                   }
                                   else
                                   {
                                       System.out.println("==============================================================================");
                                       System.out.println("New password and retype password must be same!!");
                                       System.out.println("==============================================================================");

                                   }
                               }
                               else
                               {
                                   System.out.println("==============================================================================");
                                   System.out.println("Old password is wrong!!");
                                   System.out.println("==============================================================================");

                               }
                               System.out.println("Do you want to continue?(Y/N)");
                               status=br.readLine();
                               
                               if(status.equals("n") || status.equals("N") )
                               {
                                   login=false;
                               }
                            
			               }
			               break;
			            }
			             
			            }while(login);
						
	                    System.out.println("=============================================================================");
		                System.out.println("====================== Thank You ...Have a Nice Day ==========================");
		                System.out.println("=============================================================================");
						}
		            else
		            {
		                System.out.println("==============================================================================");
		                System.out.println("===========================  Wrong username/password  ========================");
		                System.out.println("==============================================================================");
		                
		            }
		            
				}
					
					catch(Exception e)
		            {
		                System.out.println(e);
		                System.out.println("===========================  Wrong username/password  ========================");
		             }

						
			        }
	}
}


