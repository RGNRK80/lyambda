package by;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.*;

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
        //Задание: используя Binary/Unary operator:
        //возвеcти в квадрат массив чисел


         UnaryOperator<Integer> squareVal= x ->
         {
             for (int i = 0; i <x.length ; i++) {
             x[i]=(int)(Math.pow(x[i],2));
             }
             return x;
         };

         squareVal.apply(intArr);
         System.out.println(Arrays.toString(intArr));

         //вывести на экран фразы, состоящие из двух соседних списка строк
        String[] arrStr = new String[5];
        arrStr[0]=" 1 :)  ";
        arrStr[1]=(" 2 :) ");
        arrStr[2]=(" 3 :) ");
        arrStr[3]=(" 4 :) ");
        arrStr[4]=(" 5 :) ");

        UnaryOperator<String> strVal= x -> {
            String[] arrStr2 = new String[4];
            for (int i = 0; i <x.length-1 ; i++) {
                arrStr2[i]=arrStr[i]+arrStr[i+1];

            }

            return arrStr2;
        };
        System.out.println(Arrays.toString(strVal.apply(arrStr)));

        //Задание: используя Function написать метод, который будет принимать в себя строку в формате сумма_валюта
        // (через пробел), а возвращаться только сумму, причем переведенную сразу в доллары.

        Function<String, Double> changer = (x) ->
        {   String[] ss;
            ss=x.trim().split(" ");
            System.out.println(ss.length + "  " + ss[0] + "  " + ss[1]);
            String curr=ss[1];
            return Double.parseDouble(ss[0])/CUR.valueOf(ss[1]).cursVal;

        };
        System.out.println(changer.apply("500 EUR"));

        Consumer<String> changer2 = (x) ->
        {   String[] ss;
            ss=x.trim().split(" ");
            System.out.println(ss.length + "  " + ss[0] + "  " + ss[1]);
            String curr=ss[1];
            System.out.println(Double.parseDouble(ss[0])/CUR.valueOf(ss[1]).cursVal);

        };
        changer2.accept("500 EUR");

        Supplier<String> consol = () ->
        {
            Scanner scanner=new Scanner(System.in);
            StringBuffer rezult= new StringBuffer();
            rezult.append(scanner.nextLine());
            rezult.reverse();

           return rezult.toString();
        };
          String rex = consol.get();
        System.out.println(rex  +"--- working");

        //Задание: при помощи стримов из списка строк вывести только те, которые начинаются с букв ‘аа’
        List<String> listOfStr =new ArrayList<>();
        listOfStr.add("aa1");
        listOfStr.add("aa2");
        listOfStr.add("bb1");
        listOfStr.add("bbaa1");
        listOfStr.add("bb2");
        listOfStr.add("aa3");

        listOfStr.stream().filter(s -> s.startsWith("aa")).forEach(System.out::println);

        List<Tester> tesList=new ArrayList<>();
        tesList.add( new Tester("","Scout"));
        tesList.add( new Tester("John","Smith"));
        tesList.add( new Tester("Ol","Scorch"));
        tesList.add( new Tester("Bill","Murrey"));
        tesList.add( new Tester("James","Kotik"));
        tesList.add( new Tester("Ark","Ork"));
        tesList.add( new Tester("Jude",""));
        tesList.add( new Tester("Matt",""));
         //Задание: при помощи стримов из списка, содержащего объекты Tester, вывести только те, id > 3
        // и name начинается с ‘bb’
        tesList.stream().filter(s->s.name.startsWith("B") && s.id>0).forEach(System.out::println);
        //Задание совместное: при помощи стримов из списка, содержащего объекты Tester, получить список строк,
        // содержащий только имена.
        tesList.stream().filter(s->s.surname.length()==0).forEach(System.out::println);






    } //psvm

    public static void addSmile(ArrayList<String> x, SorStr ss) {
        for (int i=0; i<x.size();i++) {
            x.set(i,x.get(i)+" :)");}
        ss.sortstring(x);
    }
} // Main

interface Predicate<T> {boolean test(Integer[] t);}
interface UnaryOperator<T> {T[] apply(T[] t);}
interface Function<T, R> {R apply(T t);}
interface Consumer<T> {void accept(T t);}
interface Supplier<T> {T get();}





class Tester{
    String name;
    String surname;
    static int i;
    int id;

    public Tester(String name, String surname) {
        this.name = name;
        this.surname = surname;
        i++;
        id=i;
    }

    @Override
    public String toString() {
        return "Tester{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }
}

