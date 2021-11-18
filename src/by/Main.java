package by;

import java.util.ArrayList;

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




    }

    public static void addSmile(ArrayList<String> x, SorStr ss) {
        for (int i=0; i<x.size();i++) {
            x.set(i,x.get(i)+" :)");}
        ss.sortstring(x);



    }


}
