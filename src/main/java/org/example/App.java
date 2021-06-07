/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 abdel nabut
 */

package org.example;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        String state, county;
        BigDecimal orderAmount, tax, total, taxPercent;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Scanner input = new Scanner(System.in);
        System.out.print("What is the order amount? ");
        orderAmount = input.nextBigDecimal();
        System.out.print("What state do you live in? ");
        state = input.next();
        if(state.toLowerCase(Locale.ROOT).equals("wisconsin"))
        {
            taxPercent = BigDecimal.valueOf(0.05);
            System.out.print("What county do you live in? ");
            county = input.next();
            if(county.toLowerCase(Locale.ROOT).equals("eau claire")) {
                taxPercent.add(BigDecimal.valueOf(0.005));
            }
            if(county.toLowerCase(Locale.ROOT).equals("dunn")) {
                taxPercent.add(BigDecimal.valueOf(0.004));
            }
        }
        else if(state.toLowerCase(Locale.ROOT).equals("illinois"))
            taxPercent = BigDecimal.valueOf(0.05);
        else
            taxPercent = BigDecimal.valueOf(0);
        tax = orderAmount.multiply(taxPercent);
        total = orderAmount.multiply(BigDecimal.valueOf(1).add(taxPercent));
        System.out.println("The tax is " + formatter.format(tax) + "\nThe total is " + formatter.format(total));
    }
}
