package com.intimetec.lms.main;

import java.util.Scanner;

import com.intimetec.lms.authenticate.UserAuthentication;

public class Main {

	Scanner scan = new Scanner(System.in);
	
	public void login(){		
		while(true){			
		System.out.println("1.Login\n"
				+ "2.Exit");
		int choice = scan.nextInt();
		scan.nextLine();
		if(choice == 1 ){
			String username ;
			String password ;			
			
			System.out.print("Enter Username: ");
			username = scan.nextLine();
			
			System.out.print("Enter password: ");				
			password = scan.nextLine();
			
			new UserAuthentication().userValidation(username, password);
			}
			
		else if(choice == 2){
			System.exit(0);
		}
		else{
			login();
		}
		}
			
	}
	
	public static void main(String[] args) {		
		new Main().login();
	}	
}

