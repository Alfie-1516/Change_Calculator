//Name: Alfred Okorocha
//Class: CSCI 208 Semester Year
//Date: 7/ November/ 2023
//This class controls everything that would be seen by the user and when to receive inputs and give out results

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class UserInterface_Okorocha {

    public static void driver() {
        int[] user_coins = select_sort(get_user_coins());
        int user_change = get_user_change();
        int[] number_of_coins = calculate_change(user_coins, user_change);
        display_coins(user_coins, number_of_coins, user_change);


    }
    public static void display_coins(int[] new_coins, int[] num_coins, int total_change){
        for (int dex =0; dex < new_coins.length ; dex++){
            System.out.println("Coin: "+ new_coins[dex] + " Number: "+ num_coins[dex]);
        }
        System.out.println("Total Change is: "+ total_change);
    }
    public static int[] calculate_change(int[] coins, int change){
        int temp_change = 0;
        int counter = coins.length-1;
        int[] number_of_coins = new int[5];
        while(temp_change != change){

            temp_change += coins[counter];
            if (temp_change <= change){
                number_of_coins[counter]++;
            }
            else if(temp_change > change){
                temp_change -= coins[counter];
                counter--;
            }
        }
        return number_of_coins;
    }


    public static int[] get_user_coins(){
        Scanner in_scan = new Scanner(System.in);
        int[] user_input = new int[5];
        System.out.println("You are to first enter 5 different coin types: ");
        for (int dex = 0; dex < user_input.length; dex++){
            int count = dex +1;
            System.out.println("Enter Coin type  "  +count +" :");
            try{
                user_input[dex] = Integer.parseInt(in_scan.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Could not convert " + in_scan.nextLine() + " to a integer");
            }

        }
        return user_input;
    }
    public static int get_user_change(){
        Scanner in_scan = new Scanner(System.in);
        int user_input = 0;
        System.out.println("Now enter the amount of change needed that is less than 100: \n");
        try{
            user_input = Integer.parseInt(in_scan.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println("Could not convert " + in_scan.nextLine() + " to a integer");
        }
        return user_input;
    }
    public static int[] select_sort(int[] list){
        int[] temp_list = new int[list.length];
        for(int dex = 0; dex < list.length; dex++){
            temp_list[dex] = list[dex];
        }
        int counter = 0;
        while(counter < temp_list.length){
            int less_than = 0;
            for (int dex = 0; dex < temp_list.length; dex++){
                if(temp_list[counter] > temp_list[dex])
                    less_than++;
            }
            list[less_than] = temp_list[counter];
            counter++;
        }
        return list;
    }
}
