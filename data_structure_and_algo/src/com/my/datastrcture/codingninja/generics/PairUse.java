package com.my.datastrcture.codingninja.generics;

public class PairUse {
    public static void main(String[] args){
        Pair<Integer,String> pSI= new Pair<>(1, "bb");
        System.out.println(pSI.getFirst()+ " " +pSI.getSecond());

        Pair<Pair<Integer, String>, String> pairs = new Pair<>(new Pair<Integer, String>(5, "Java"), "Generic");
        System.out.println(pairs.getFirst()+" "+pairs.getSecond());
        System.out.println(pairs.getFirst().getFirst()+" "+pairs.getFirst().getSecond()+" "+pairs.getSecond());

        /*Pair<Integer> p= new Pair<>();
        System.out.println(p.getFirst()+ " " +p.getSecond());

        Pair<Integer> pi= new Pair<>(10,20);
        System.out.println(pi.getFirst()+ " " +pi.getSecond());

        Pair<String> pS= new Pair<>("aa", "bb");
        System.out.println(pS.getFirst()+ " " +pS.getSecond());

        Pair<Double> pd= new Pair<>(3.1, 7.2);
        System.out.println(pd.getFirst()+ " " +pd.getSecond());*/
    }
}
