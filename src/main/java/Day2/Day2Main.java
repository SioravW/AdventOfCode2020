package Day2;

import java.util.Scanner;

public class Day2Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int validPasswordsSled = 0;
    private static int validPasswordsToboggan = 0;
    private int i;

    public static void main(String[] args){
        while(scanner.hasNext()){
            String password = scanner.nextLine();
            checkIfValidSledPlace(password);
            checkIfValidTobogganPlace(password);
            System.out.println(validPasswordsToboggan);
        }
    }

    private static void checkIfValidSledPlace(String password){
        String[] rulesAndPassword = password.split(": ");
        String realPassword = rulesAndPassword[1];
        String[] minimumAndMaximum = rulesAndPassword[0].split("-");
        int minimum = Integer.parseInt(minimumAndMaximum[0]);
        String[] maximumAndLetter = minimumAndMaximum[1].split(" ");
        int maximum = Integer.parseInt(maximumAndLetter[0]);
        String letter = maximumAndLetter[1];
        int totalLetterAppearance = 0;
        while(realPassword.contains(letter)){
            totalLetterAppearance++;
            realPassword = realPassword.replaceFirst(letter, "-");
        }
        if(totalLetterAppearance <= maximum && totalLetterAppearance >= minimum){
            validPasswordsSled++;
        }
    }

    private static void checkIfValidTobogganPlace(String password){
        String[] rulesAndPassword = password.split(": ");
        String realPassword = rulesAndPassword[1];
        realPassword = realPassword.concat(".");
        String[] positions = rulesAndPassword[0].split("-");
        int firstPosition = Integer.parseInt(positions[0]) - 1;
        String[] secondPositionAndLetter = positions[1].split(" ");
        int secondPosition = Integer.parseInt(secondPositionAndLetter[0]) - 1;
        String letter = secondPositionAndLetter[1];
        boolean first = false;
        boolean second = false;
        String letterAtPosition = realPassword.substring(firstPosition, firstPosition+1);
        if(letterAtPosition.equals(letter)){
            first = true;
        }
        letterAtPosition = realPassword.substring(secondPosition, secondPosition+1);
        if(letterAtPosition.equals(letter)){
            second = true;
        }
        if(first != second){
            validPasswordsToboggan++;
        }
    }
}
