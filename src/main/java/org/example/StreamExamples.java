package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExamples {

    public static void main(String[] args) {


        List<Integer> liste1 = new ArrayList<>();
        liste1.add(2);
        liste1.add(3);
        liste1.add(5);
        liste1.add(7);
        liste1.add(11);
        System.out.println(liste1);
        liste1.remove(4);
        System.out.println(liste1);


        // ArrayList koleksiyonundan yeni bir koleksiyon oluştur
        List<Integer> liste2 = new ArrayList<>(liste1);

        System.out.println(liste2);

        List<Integer> liste3 = new ArrayList<>();
        liste3.add(13);
        liste3.add(17);
        liste3.add(19);
        liste3.add(23);
        liste3.add(29);

        // Bir arraylist i başka bir arrayliste ekleem
        liste3.addAll(liste1);

        System.out.println(liste3);



        List<Integer> numbers = Arrays.asList( 2, 53, 43, 5, 6, 7, 8, 9, 1, 45);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 1)
                .toList();

        System.out.println(evenNumbers);



        List<String> friends= Arrays.asList("Koray", "Yağmur", "Aslı");

        List<Integer> lengthStream = friends.stream()
                .map(String::length)
                .toList();

        System.out.println(lengthStream);



        List<Integer> numbers2 = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(numbers2);



        List<Integer> sayi= Arrays.asList(2,2,7,1,7);

        List<Integer> toplananSayi= sayi.stream()
                .map( i -> i+2)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(toplananSayi);



        // HashMap oluşturma
        Map<String, Integer> ogrenciNotlari = new HashMap<>();

        // Anahtar-değer çifti ekleme
        ogrenciNotlari.put("Ahmet", 90);
        ogrenciNotlari.put("Ayşe", 85);
        ogrenciNotlari.put("Mehmet", 75);

        ogrenciNotlari.get("Ahmet");
//        Set<Map.Entry<String, Integer>> entries = ogrenciNotlari.entrySet();
//        entries.add(Entry<>);


        // Değere anahtar üzerinden erişim
        int ahmetinNotu = ogrenciNotlari.get("Ahmet");
        System.out.println("Ahmet'in Notu: " + ahmetinNotu);

        // Değer güncelleme
        ogrenciNotlari.put("Ayşe", 100);

        // Anahtar-değer çifti silme
        ogrenciNotlari.remove("Mehmet");

        for (Map.Entry<String, Integer> map: ogrenciNotlari.entrySet()) {
            System.out.print(map.getKey()+ " ");
            System.out.println(map.getValue());
        }

        if (ogrenciNotlari.containsKey("Elma")) {
            int value = ogrenciNotlari.remove("Elma"); // Eski anahtarı kaldır ve değerini al
            ogrenciNotlari.put("ElmaYeni", value); // Yeni anahtar ve eski değer ile ekle
        }

        for (Map.Entry<String, Integer> map: ogrenciNotlari.entrySet()) {
            System.out.print(map.getKey()+ " ");
            System.out.println(map.getValue());
        }



    }

}
