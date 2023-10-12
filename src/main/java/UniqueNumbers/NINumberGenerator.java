package UniqueNumbers;


import java.util.Random;

public class NINumberGenerator {

    public static void main(String[] args) {
        String firstName = "John";
        String lastName = "Doe";
        int yearOfBirth = 1985;
        String randomCode = generateRandomCode();
        String countryOfBirth = "E"; // England

        String niNumber = generateNationalInsuranceNumber(firstName, lastName, yearOfBirth, randomCode, countryOfBirth);
        System.out.println("Generated National Insurance Number: " + niNumber);
    }

    // Generate a 4-digit random code
    public static String generateRandomCode() {
        Random rand = new Random();
        int randomNum = rand.nextInt(10000);
        return String.format("%04d", randomNum);
    }

    // Generate the National Insurance Number
    public static String generateNationalInsuranceNumber(String firstName, String lastName, int yearOfBirth, String randomCode, String countryOfBirth) {
        String niNumber = String.format("%s%s%02d%s%s", firstName.charAt(0), lastName.charAt(0), yearOfBirth % 100, randomCode, countryOfBirth);
        return niNumber;
    }
}

