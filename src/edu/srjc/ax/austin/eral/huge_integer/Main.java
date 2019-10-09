/*
Austin Eral
austineral@ymail.com
3/29/2017
AX_Austin_Eral Huge Integer
CS 17.11

This driver program is designed to test the functionality of the HugeInteger
class. Almost all of its public methods are used. I don't believe Belphegor's
prime factorial works.
 */

package edu.srjc.ax.austin.eral.huge_integer;

import java.util.Scanner;

public class Main
{
    
    public static void main(String[] args)
    {
        try
        {
            HugeInteger firstNumber = new HugeInteger("5", 100);
            HugeInteger secondNumber = new HugeInteger("2", 100);
            
            System.out.println("---------------------Addition---------------------");
            System.out.format("%s + %s = ", firstNumber, secondNumber);
            firstNumber.add(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("-9");
            secondNumber.parse("3");
            
            System.out.format("%s + %s = ", firstNumber, secondNumber);
            firstNumber.add(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("8");
            secondNumber.parse("-28");
            
            System.out.format("%s + %s = ", firstNumber, secondNumber);
            firstNumber.add(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("-20");
            secondNumber.parse("-401");
            
            System.out.format("%s + %s = ", firstNumber, secondNumber);
            firstNumber.add(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("123456789");
            secondNumber.parse("987654321");
            
            System.out.format("%s + %s = ", firstNumber, secondNumber);
            firstNumber.add(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("0");
            secondNumber.parse("0");
            
            System.out.format("%s + %s = ", firstNumber, secondNumber);
            firstNumber.add(secondNumber);
            System.out.println(firstNumber);
            
            System.out.println("-------------------Subtraction--------------------");
            
            firstNumber.parse("5");
            secondNumber.parse("2");
            
            System.out.format("%s - %s = ", firstNumber, secondNumber);
            firstNumber.add(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("-9");
            secondNumber.parse("3");
            
            System.out.format("%s - %s = ", firstNumber, secondNumber);
            firstNumber.subtract(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("8");
            secondNumber.parse("-28");
            
            System.out.format("%s - %s = ", firstNumber, secondNumber);
            firstNumber.subtract(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("-20");
            secondNumber.parse("-401");
            
            System.out.format("%s - %s = ", firstNumber, secondNumber);
            firstNumber.subtract(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("123456789");
            secondNumber.parse("987654321");
            
            System.out.format("%s - %s = ", firstNumber, secondNumber);
            firstNumber.subtract(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("0");
            secondNumber.parse("0");
            
            System.out.format("%s - %s = ", firstNumber, secondNumber);
            firstNumber.subtract(secondNumber);
            System.out.println(firstNumber);
            
            System.out.println("------------------Multiplication------------------");
            
            firstNumber.parse("5");
            secondNumber.parse("2");
            
            System.out.format("%s * %s = ", firstNumber, secondNumber);
            firstNumber.multiply(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("-9");
            secondNumber.parse("3");
            
            System.out.format("%s * %s = ", firstNumber, secondNumber);
            firstNumber.multiply(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("8");
            secondNumber.parse("-28");
            
            System.out.format("%s * %s = ", firstNumber, secondNumber);
            firstNumber.multiply(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("-20");
            secondNumber.parse("-401");
            
            System.out.format("%s * %s = ", firstNumber, secondNumber);
            firstNumber.multiply(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("1000000000");
            secondNumber.parse("9999999999");
            
            System.out.format("%s * %s = ", firstNumber, secondNumber);
            firstNumber.multiply(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("0");
            secondNumber.parse("0");
            
            System.out.format("%s * %s = ", firstNumber, secondNumber);
            firstNumber.subtract(secondNumber);
            System.out.println(firstNumber);
            
            System.out.println("---------------------Division---------------------");
            
            firstNumber.parse("5");
            secondNumber.parse("2");
            
            System.out.format("%s / %s = ", firstNumber, secondNumber);
            firstNumber.divide(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("-9");
            secondNumber.parse("3");
            
            System.out.format("%s / %s = ", firstNumber, secondNumber);
            firstNumber.divide(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("8");
            secondNumber.parse("-28");
            
            System.out.format("%s / %s = ", firstNumber, secondNumber);
            firstNumber.divide(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("-401");
            secondNumber.parse("-20");
            
            System.out.format("%s / %s = ", firstNumber, secondNumber);
            firstNumber.divide(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("1000000000");
            secondNumber.parse("9999999999");
            
            System.out.format("%s / %s = ", firstNumber, secondNumber);
            firstNumber.divide(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("0");
            secondNumber.parse("1");
            
            System.out.format("%s / %s = ", firstNumber, secondNumber);
            firstNumber.divide(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("0");
            secondNumber.parse("0");
            
            try
            {
                System.out.format("%s / %s = ", firstNumber, secondNumber);
                firstNumber.divide(secondNumber);
                System.out.println(firstNumber);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
            
            System.out.println("--------------------Modulation--------------------");
            
            firstNumber.parse("5");
            secondNumber.parse("2");
            
            System.out.format("%s %% %s = ", firstNumber, secondNumber);
            firstNumber.mod(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("-9");
            secondNumber.parse("3");
            
            System.out.format("%s %% %s = ", firstNumber, secondNumber);
            firstNumber.mod(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("8");
            secondNumber.parse("-28");
            
            System.out.format("%s %% %s = ", firstNumber, secondNumber);
            firstNumber.mod(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("-401");
            secondNumber.parse("-20");
            
            System.out.format("%s %% %s = ", firstNumber, secondNumber);
            firstNumber.mod(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("1000000000");
            secondNumber.parse("9999999999");
            
            System.out.format("%s %% %s = ", firstNumber, secondNumber);
            firstNumber.mod(secondNumber);
            System.out.println(firstNumber);
            
            firstNumber.parse("0");
            secondNumber.parse("1");
            
            System.out.format("%s %% %s = ", firstNumber, secondNumber);
            firstNumber.mod(secondNumber);
            System.out.println(firstNumber);
            
            System.out.println("--------------------Factorial---------------------");
            
            firstNumber.parse("5");
            
            System.out.format("%s factorial = ", firstNumber);
            firstNumber.factorial();
            System.out.println(firstNumber);
            
            firstNumber.parse("-9");
            
            try
            {
                System.out.format("%s factorial = ", firstNumber);
                firstNumber.factorial();
                System.out.println(firstNumber);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
            
            firstNumber.parse("8");
            
            System.out.format("%s factorial = ", firstNumber);
            firstNumber.factorial();
            System.out.println(firstNumber);
            
            firstNumber.parse("40");
            
            System.out.format("%s factorial = ", firstNumber);
            firstNumber.factorial();
            System.out.println(firstNumber);
            
            firstNumber.parse("10");
            
            System.out.format("%s factorial = ", firstNumber);
            firstNumber.factorial();
            System.out.println(firstNumber);
            
            firstNumber.parse("0");
            
            System.out.format("%s factorial = ", firstNumber);
            firstNumber.factorial();
            System.out.println(firstNumber);
            
            firstNumber.parse("1");
            
            System.out.format("%s factorial = ", firstNumber);
            firstNumber.factorial();
            System.out.println(firstNumber);
            ;
            
            System.out.println("-------------------Greater Than-------------------");
            
            firstNumber.parse("5");
            secondNumber.parse("2");
            
            System.out.format("%s > %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isGreaterThan(secondNumber));
            
            firstNumber.parse("-9");
            secondNumber.parse("3");
            
            System.out.format("%s > %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isGreaterThan(secondNumber));
            
            firstNumber.parse("8");
            secondNumber.parse("-28");
            
            System.out.format("%s > %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isGreaterThan(secondNumber));
            
            firstNumber.parse("-401");
            secondNumber.parse("-20");
            
            System.out.format("%s > %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isGreaterThan(secondNumber));
            
            firstNumber.parse("1000000000");
            secondNumber.parse("9999999999");
            
            System.out.format("%s > %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isGreaterThan(secondNumber));
            
            firstNumber.parse("0");
            secondNumber.parse("1");
            
            System.out.format("%s > %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isGreaterThan(secondNumber));
            
            firstNumber.parse("0");
            secondNumber.parse("0");
            
            System.out.format("%s > %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isGreaterThan(secondNumber));
            
            System.out.println("-------------Greater Than or Equal To-------------");
            
            firstNumber.parse("5");
            secondNumber.parse("2");
            
            System.out.format("%s >= %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isGreaterThanOrEqualTo(secondNumber));
            
            firstNumber.parse("-9");
            secondNumber.parse("-9");
            
            System.out.format("%s >= %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isGreaterThanOrEqualTo(secondNumber));
            
            firstNumber.parse("-8");
            secondNumber.parse("8");
            
            System.out.format("%s >= %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isGreaterThanOrEqualTo(secondNumber));
            
            firstNumber.parse("-401");
            secondNumber.parse("-4010");
            
            System.out.format("%s >= %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isGreaterThanOrEqualTo(secondNumber));
            
            firstNumber.parse("1000000000");
            secondNumber.parse("9999999999");
            
            System.out.format("%s >= %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isGreaterThanOrEqualTo(secondNumber));
            
            firstNumber.parse("0");
            secondNumber.parse("1");
            
            System.out.format("%s >= %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isGreaterThanOrEqualTo(secondNumber));
            
            firstNumber.parse("0");
            secondNumber.parse("0");
            
            System.out.format("%s >= %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isGreaterThanOrEqualTo(secondNumber));
            
            System.out.println("--------------Less Than or Equal To---------------");
            
            firstNumber.parse("5");
            secondNumber.parse("2");
            
            System.out.format("%s <= %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isLessThanOrEqualTo(secondNumber));
            
            firstNumber.parse("-9");
            secondNumber.parse("-9");
            
            System.out.format("%s <= %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isLessThanOrEqualTo(secondNumber));
            
            firstNumber.parse("-8");
            secondNumber.parse("8");
            
            System.out.format("%s <= %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isLessThanOrEqualTo(secondNumber));
            
            firstNumber.parse("-401");
            secondNumber.parse("-4010");
            
            System.out.format("%s <= %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isLessThanOrEqualTo(secondNumber));
            
            firstNumber.parse("1000000000");
            secondNumber.parse("9999999999");
            
            System.out.format("%s <= %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isLessThanOrEqualTo(secondNumber));
            
            firstNumber.parse("0");
            secondNumber.parse("1");
            
            System.out.format("%s <= %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isLessThanOrEqualTo(secondNumber));
            
            firstNumber.parse("0");
            secondNumber.parse("0");
            
            System.out.format("%s <= %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isLessThanOrEqualTo(secondNumber));
            
            System.out.println("--------------------Less Than---------------------");
            
            firstNumber.parse("5");
            secondNumber.parse("2");
            
            System.out.format("%s < %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isLessThan(secondNumber));
            
            firstNumber.parse("-9");
            secondNumber.parse("-9");
            
            System.out.format("%s < %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isLessThan(secondNumber));
            
            firstNumber.parse("-8");
            secondNumber.parse("8");
            
            System.out.format("%s < %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isLessThan(secondNumber));
            
            firstNumber.parse("-401");
            secondNumber.parse("-4010");
            
            System.out.format("%s < %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isLessThan(secondNumber));
            
            firstNumber.parse("1000000000");
            secondNumber.parse("9999999999");
            
            System.out.format("%s < %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isLessThan(secondNumber));
            
            firstNumber.parse("0");
            secondNumber.parse("1");
            
            System.out.format("%s < %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isLessThan(secondNumber));
            
            firstNumber.parse("0");
            secondNumber.parse("0");
            
            System.out.format("%s < %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isLessThan(secondNumber));
            
            System.out.println("----------------------Equals----------------------");
            
            firstNumber.parse("5");
            secondNumber.parse("2");
            
            System.out.format("%s = %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isEqualTo(secondNumber));
            
            firstNumber.parse("-9");
            secondNumber.parse("-9");
            
            System.out.format("%s = %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isEqualTo(secondNumber));
            
            firstNumber.parse("-8");
            secondNumber.parse("8");
            
            System.out.format("%s = %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isEqualTo(secondNumber));
            
            firstNumber.parse("-401");
            secondNumber.parse("-4010");
            
            System.out.format("%s = %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isEqualTo(secondNumber));
            
            firstNumber.parse("1000000000");
            secondNumber.parse("9999999999");
            
            System.out.format("%s = %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isEqualTo(secondNumber));
            
            firstNumber.parse("0");
            secondNumber.parse("1");
            
            System.out.format("%s = %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isEqualTo(secondNumber));
            
            firstNumber.parse("0");
            secondNumber.parse("0");
            
            System.out.format("%s = %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isEqualTo(secondNumber));
            
            System.out.println("------------------Does Not Equal------------------");
            
            firstNumber.parse("5");
            secondNumber.parse("2");
            
            System.out.format("%s != %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isNotEqualTo(secondNumber));
            
            firstNumber.parse("-9");
            secondNumber.parse("-9");
            
            System.out.format("%s != %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isNotEqualTo(secondNumber));
            
            firstNumber.parse("-8");
            secondNumber.parse("8");
            
            System.out.format("%s != %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isEqualTo(secondNumber));
            
            firstNumber.parse("-401");
            secondNumber.parse("-4010");
            
            System.out.format("%s != %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isNotEqualTo(secondNumber));
            
            firstNumber.parse("1000000000");
            secondNumber.parse("9999999999");
            
            System.out.format("%s != %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isNotEqualTo(secondNumber));
            
            firstNumber.parse("0");
            secondNumber.parse("1");
            
            System.out.format("%s != %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isNotEqualTo(secondNumber));
            
            firstNumber.parse("0");
            secondNumber.parse("0");
            
            System.out.format("%s != %s = ", firstNumber, secondNumber);
            System.out.println(firstNumber.isNotEqualTo(secondNumber));
            
            System.out.println("------------------Special Tests-------------------");
            
            firstNumber.parse("52");
            
            System.out.format("Number of combinations of deck of cards = ", firstNumber, secondNumber);
            firstNumber.factorial();
            System.out.println(firstNumber);
            
            System.out.println("Want to calculate Belphegor's Prime factorial? (Y/N)");
            Scanner input = new Scanner(System.in);
            String answer = input.next();
            
            if (answer.equalsIgnoreCase("Y"))
            {
                HugeInteger belphegorsPrime = new HugeInteger("1000000000000066600000000000001", 10000000);
                
                System.out.println("Belphegor's Prime factorial is calculating...");
                System.out.println("I was unable to wait long enough to see if it works...");
                
                belphegorsPrime.factorial();
                System.out.println(belphegorsPrime);
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
