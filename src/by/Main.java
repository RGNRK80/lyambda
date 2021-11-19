package by;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    CurrToUSD xx= (x,y)-> x*y.cursVal/CUR.USD.cursVal;
        System.out.println(xx.currtoUsd(100,CUR.EUR));

        ArrayList<String> str = new ArrayList<>();
        str.add("xx1");
        str.add("xx2");
        str.add("xx3");
        str.add("xx4");
        str.add("xy1");
        str.add("xy2");
        str.add("xy3");
        str.add("xy4");

        SorStr metSort = x -> {
            for (int i=0; i<x.size();i++) {
                if (x.get(i).startsWith("xx")) {
                    System.out.println(x.get(i));
                }
            }
        };
     addSmile(str,metSort);

     // Задание: используя Predicate среди массива чисел вывести только те, которые являются положительными

        Integer[] intArr = new Integer[20];
        for (int i = 0; i <intArr.length ; i++) {
            intArr[i]=(int)(Math.random()*100);
        }

        Predicate positArr = x ->
        {int counter=0;
            for (Integer unit:x) {
                if (unit>0) {
                    counter++;
                    System.out.println(unit);
                }
            }
            if (counter>0) return true;
            return false;
        };
        boolean b= positArr.test(intArr);

         UnaryOperator<Integer> squareVal= x ->
         {
             for (int i = 0; i <x.length ; i++) {
             x[i]=(int)(Math.pow(x[i],2));
             }
             return x;
         };

         squareVal.apply(intArr);
         System.out.println(Arrays.toString(intArr));





    } //psvm

    public static void addSmile(ArrayList<String> x, SorStr ss) {
        for (int i=0; i<x.size();i++) {
            x.set(i,x.get(i)+" :)");}
        ss.sortstring(x);
    }
} // Main

interface Predicate<T> {boolean test(Integer[] t);}
interface UnaryOperator<T> {T[] apply(T[] t);}

