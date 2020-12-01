package Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Integer> numbers = new ArrayList<Integer>();

    public static void main(String[] args){
        while(scanner.hasNext()){
            int newNumber = scanner.nextInt();
            numbers.add(newNumber);
            checkThreeNumbers();
        }
    }

    private static void checkTwoNumbers(){
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i +1; j < numbers.size(); j++){
                if(numbers.get(i) + numbers.get(j) == 2020){
                    System.out.println(numbers.get(i) * numbers.get(j));
                }
            }
        }
    }

    private static void checkThreeNumbers(){
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i +1; j < numbers.size(); j++){
                for (int k = j + 1; k < numbers.size(); k++){
                    if(numbers.get(i) + numbers.get(j) + numbers.get(k) == 2020){
                        System.out.println(numbers.get(i) * numbers.get(j) * numbers.get(k));
                    }
                }
            }
        }
    }
}
