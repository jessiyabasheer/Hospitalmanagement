package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class RandomDataUtilityClass {
	
	static Faker faker;
	static String fname;
	static String lName;
	
	public static String getFirstName() {
		faker=new Faker(new Locale("en-IND"));
		fname=faker.name().firstName();
		return fname;
		
	}

	public static String getlastName(){
        faker=new Faker(new Locale("en-IND"));
        lName=faker.name().lastName();
        return lName;
        
    }
}
