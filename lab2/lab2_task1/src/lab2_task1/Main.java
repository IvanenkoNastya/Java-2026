package lab2_task1;

public class Main {

	public static void main(String[] args) {
		String correctUsername = "veryImportantAdmin";
		String correctPassword = "admin";

		String username = "veryImportantAdmin";
		String password = "not-admin";
		
		System.out.print("Username: " + username + "\n");
		System.out.print("Password: " + password + "\n");
		
		try {
			checkTheCredentials(username, password, correctUsername, correctPassword);
			System.out.print("Login succeeded.");
		} catch (Exception e) {
			System.out.print("Login failed (" + e.getMessage() + ")");
		}

	}
	
	public static void checkTheCredentials(String uname, String pwd, String correctUname, String correctPwd) throws Exception {
		if (uname != correctUname) {
			throw new InvalidCredentialsException("Username " + uname + " does not exist");
		} else if (pwd != correctPwd) {
			throw new InvalidCredentialsException("Wrong password");
		}
	}

}
