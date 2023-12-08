package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TravisWinstonAssignment3 {

	public static void main(String[] args) {
		//Primitive Vars
		int attempts = 5;
		int lineCount = 0;
		int lineOn=0;
		String line;
		
		//Obj Vars
		Scanner sc = new Scanner(System.in);
		BufferedReader lineCounter= null;
		BufferedReader fileReader = null;
		UserService userService = new UserService();
		
		//Array Vars
		String[] userLogin = new String[2];
		User[] userArray;
		
		//Store Data
		try {
			//Count the Lines
			lineCounter = new BufferedReader(new FileReader("data.txt"));
			while ((line = lineCounter.readLine()) != null) {
				lineCount++;
			}
			//Make the array
			userArray = new User[lineCount];
			
			//fill the array
			fileReader = new BufferedReader(new FileReader("data.txt"));
			while ((line = fileReader.readLine()) != null) {
				userArray[lineOn] = userService.createUser(userService.parseText(line)); // Makes Array ["Username", "Password", "Name"], then passes that to create User
				lineOn++;
			}
			
			//Prompt Starts
			while (attempts > 0) {
			System.out.print("Enter your email: ");
			userLogin[0] = sc.nextLine();
			System.out.print("Enter your password: ");
			userLogin[1] = sc.nextLine();
			//test the inputs vs each element in the userArray
				for (User user : userArray) {
					if (userLogin[0].equalsIgnoreCase(user.getUsername()) && userLogin[1].equals(user.getPassword())) {
						System.out.println("Welcome: " + user.getName());
						System.exit(0);
					} 
				}
				attempts--;
				if (attempts != 0) {
					System.out.println("Invalid login, please tray again.");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No 'data.txt' File Found"); 
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("There is an IOException");
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("There is a NullPointer Exception");
		} finally {
			try {
				fileReader.close();
				lineCounter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		System.out.println("Too Many Failed Attempts. You are locked out");
		sc.close();
	}
}
