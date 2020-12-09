package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3Main {

    private static List<String> treeLines = new ArrayList<>();
    private static int trees31 = 0;
    private static int trees11 = 0;
    private static int trees51 = 0;
    private static int trees71 = 0;
    private static int trees12 = 0;


    public static void main(String[] args){
        try {
            treeLines =  Files.readAllLines(Paths.get("src\\main\\java\\Day3\\Day3Input"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        prepareTreeLines();
        countTreesInSlope31(0, 0);
        countTreesInSlope11(0,0);
        countTreesInSlope12(0,0);
        countTreesInSlope51(0,0);
        countTreesInSlope71(0,0);
        System.out.println(trees31 * trees11 * trees12 * trees51 * trees71);
    }

    private static void prepareTreeLines(){
        int nrOfLines = treeLines.size();
        int lineSize = treeLines.get(0).length();
        int nrRepeatsNeeded = (nrOfLines * 7)  / lineSize;
        for(int i = 0; i < treeLines.size(); i++){
            treeLines.set(i, treeLines.get(i).repeat(nrRepeatsNeeded+7));
        }
    }

    private static void countTreesInSlope31(int line, int index){
        if(line > treeLines.size()-1){
            return;
        }
        else if(treeLines.get(line).charAt(index) == '#'){
            trees31++;
        }
        countTreesInSlope31(line+1, index+3);
    }

    private static void countTreesInSlope11(int line, int index){
        if(line > treeLines.size()-1){
            return;
        }
        else if(treeLines.get(line).charAt(index) == '#'){
            trees11++;
        }
        countTreesInSlope11(line+1, index+1);
    }

    private static void countTreesInSlope51(int line, int index){
        if(line > treeLines.size()-1){
            return;
        }
        else if(treeLines.get(line).charAt(index) == '#'){
            trees51++;
        }
        countTreesInSlope51(line+1, index+5);
    }

    private static void countTreesInSlope71(int line, int index){
        if(line > treeLines.size()-1){
            return;
        }
        else if(treeLines.get(line).charAt(index) == '#'){
            trees71++;
        }
        countTreesInSlope71(line+1, index+7);
    }

    private static void countTreesInSlope12(int line, int index){
        if(line > treeLines.size()-2){
            return;
        }
        else if(treeLines.get(line).charAt(index) == '#'){
            trees12++;
        }
        countTreesInSlope12(line+2, index+1);
    }
}
