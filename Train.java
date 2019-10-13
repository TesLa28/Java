package com.program.train;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train
{

    public static void main(String[] args)
    {
        System.out.println("Welcome to Train Ltd.");

        Train train = new Train();

        boolean exit = false;

        do
        {
            System.out.println("Enter the data: ");

            int carriageInput = train.getTotalCarriageInput();

            int requiredCarriageLength = train.getRequiredCarriageLength(carriageInput);

            System.out.println("Enter the locomotive couplings: ");
            Scanner locomotiveInput = new Scanner(System.in);
            String couplingInput = locomotiveInput.nextLine();

            List<String> carriageAvailable = train.getAvailableCarriageCouplings(carriageInput, locomotiveInput);

            List<String> finalString = new ArrayList<>();
            
            List<List<String>> finalList = new ArrayList<>();
            
            String finalResult = train.getFinalResult(carriageInput, requiredCarriageLength, carriageInput,
                    carriageAvailable, couplingInput, finalString, finalList);
            System.out.println("Final Result: " + finalResult);
            
            if(finalResult.equals("YES"))
            {
                int totalCount = finalList.size();
                System.out.println(totalCount);
            }
            exit = train.isExit();
        }
        while (exit != true);

        System.out.println("Visit us again!!!");
    }

    private String getFinalResult(int carriageInput, int requiredCarriageLength, int carriageInput2,
            List<String> carriageAvailable, String couplingInput, List<String> finalString, List<List<String>> finalList)
    {
        String finalResult = null;
        int count = 0;
        for (int i = 0; i < requiredCarriageLength; i++)
        {
            String currentCoupling = couplingInput;
            for(String eachCoupling : carriageAvailable)
            {
                if(currentCoupling.charAt(1) == eachCoupling.charAt(0))
                {
                    currentCoupling = eachCoupling;
                    finalString.add(eachCoupling);
                    count++;
                }
            }
            finalList.add(finalString);
        }
        if(count == requiredCarriageLength)
        {
            finalResult = "YES";
        }
        else
        {
            finalResult = "NO";
        }
        return finalResult;
    }

    private List<String> getAvailableCarriageCouplings(int carriageInput, Scanner locomotiveInput)
    {
        List<String> carriageAvailable = new ArrayList<>();
        System.out.println("Enter the carriage couplings available: ");
        for (int i = 0; i < carriageInput; i++)
        {
            carriageAvailable.add(locomotiveInput.nextLine());
        }

        return carriageAvailable;
    }

    public int getTotalCarriageInput()
    {
        System.out.println("Enter the number of carriages company has at its disposal: ");
        Scanner input1 = new Scanner(System.in);
        int n = input1.nextInt();
        if (!(n > 0 && n <= 40))
        {
            System.out.println("Invalid Input");
            n = 0;
        }

        return n;

    }

    public int getRequiredCarriageLength(int carriageInput)
    {

        System.out.println(
                "Enter the number of carriages required and it should be less than the total carriage at disposal: ");
        Scanner input2 = new Scanner(System.in);
        int n = input2.nextInt();
        if (n > carriageInput)
        {
            System.out.println("Invalid number of required Carriage count");
            this.getRequiredCarriageLength(carriageInput);
        }

        return n;
    }

    public boolean isExit()
    {
        boolean exit = false;
        System.out.println("Do want to exit?");
        System.out.print("Press 'Y' to exit: ");
        Scanner decisionInput = new Scanner(System.in);
        String decision = decisionInput.next();
        if (decision.charAt(0) == 'Y' || decision.charAt(0) == 'y')
        {
            exit = true;
        }

        return exit;
    }

}
