package com.spacejanitor.comparativegame;


import java.util.Random;

public class RandomBoolQuestion {

    private int num1, num2;
    private Random gen = new Random();
    private boolean finalResults = false;

    private String printResults = "";


    public void genRandomNumbers(){
        // random generate some numbers (0 to 100)
        num1 = 	gen.nextInt(101);
        num2 = gen.nextInt(101);
    }


    public boolean compileRandomQuestion(){
        // call all methods and compare to print the results
        // also determine the results

        boolean results = false;
        boolean c1 = false, c2 = false, conjunction, r1, r2 = true;

        // reset printResults
        printResults = "";

        genRandomNumbers();
        r1 = (randomNot() == false? c1!=randomCompare() : c1 == randomCompare());
        genRandomNumbers(); // generate new numbers for seconds set
        conjunction = randomBooleanOp();
        r2 = (randomNot() == false? c2!=randomCompare() : c2 == randomCompare());

        if (conjunction){
            results = r1 && r2;
        } else
            results = r1 || r2;

        return results;
    }


    public boolean randomCompare(){
        // choose from <, >, <=, >=

        int ran = gen.nextInt(4)+1;

        boolean r = false;

        switch (ran){
            case 1:
                r = num1 < num2;
                //System.out.print("(" +num1+ " < " +num2+ ") ");
                printResults += "(" +num1+ " < " +num2+ ") ";
                break;
            case 2:
                r = num1 > num2;
                //System.out.print("(" +num1+ " > " +num2+ ") ");
                printResults += "(" +num1+ " > " +num2+ ") ";
                break;
            case 3:
                r = num1 <= num2;
                //System.out.print("(" +num1+ " <= " +num2+ ") ");
                printResults += "(" +num1+ " <= " +num2+ ") ";
                break;
            case 4:
                r = num1 >= num2;
                //System.out.print("(" +num1+ " >= " +num2+ ") ");
                printResults += "(" +num1+ " >= " +num2+ ") ";
                break;
        }

        return r;
    }

    public boolean randomBooleanOp(){
        // generate randomBooleanOp &&/||
        boolean r = false;
        if (Math.random() < 0.5){
            //System.out.print(" && ");
            printResults += " && ";
            r = true;

        } else {
            //System.out.print(" || ");
            printResults += " || ";
            r = false;
        }

        return r;

    }

    public boolean randomNot(){
        // 60/40 chance to generate a !

        if (Math.random() < 0.4){
            //System.out.print("!");
            printResults += "!";
            return true;
        }
        return false;
    }


    public String getPrintResults() {
        return printResults;
    }
}
