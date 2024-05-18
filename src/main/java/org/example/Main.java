package org.example;


import org.example.model.*;
import org.example.model.enums.AccountType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Main {

    static List<Customer> customerList;

    public static void main(String[] args) {
        customerList = new ArrayList<>();

        Customer customer1 = new Customer("Mert", "MURAT", "mert@gmail.com", "123456");
        customerList.add(customer1);
        customer1.setAccountType(AccountType.GOLD);
        Customer customer2 = new Customer("Ali", "Yılmaz", "ali@gmail.com", "123");
        customerList.add(customer2);
        Customer customer3 = new Customer("Veli", "Tuna", "veli@gmail.com", "1234");
        customerList.add(customer3);
        Customer customer4 = new Customer("Ayşe", "Ata", "ayse@gmail.com", "14567");
        customerList.add(customer4);

        customer1.setOrderList(prepareOrderList());
        customer2.setOrderList(prepareOrderList());
        customer3.setOrderList(prepareOrderList());
        customer4.setOrderList(prepareOrderList());

        System.out.println(getOrderByEmail("veli@gmail.com"));
        System.out.println(getOrderByEmail("ali@gmail.com"));
        System.out.println(getOrderByEmail("ayse@gmail.com"));
        System.out.println(getOrderByEmail("mert@gmail.com"));


        System.out.println(generateOrderCode());

    }

    private static List<Order> getOrderByEmail(String email){
        return customerList.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .flatMap(customer -> customer.getOrderList().stream())
                .toList();
    }

    private static List<Order> prepareOrderList() {
        return List.of(prepareOrder());
    }

    private static Order prepareOrder(){
        //Order order new Order(); // tercih etmiyoruz. Çünkü direkt dönüş yapıyoruz.
        return new Order(prapareProductList(), generateOrderCode());
    }

    private static String generateOrderCode(){
        Random random = new Random();
        int number = random.nextInt(100, 999);
        String orderNumber = "KY" + number;

        boolean isExistingNumber = customerList.stream()
                .filter(customer -> customer.getOrderList() != null)
                .flatMap(customer -> customer.getOrderList().stream())
                .anyMatch(order -> Objects.equals(order.getOrderCode(), orderNumber));
        if(isExistingNumber){
            generateOrderCode();
        }

        return orderNumber;
    }

    private static List<Product> prapareProductList(){
        return List.of(prepareBook(),prepareStationery());
    }


//    private static Product prepareProduct() {
//        return new Product("Söyleme Bilmesinnler", new BigDecimal("118.82"), "Yalansızız artık.");
//    }

    private static Book prepareBook() {
        return new Book("Reşat Nuri", 500);
    }

    private static Stationery prepareStationery() {
        return new Stationery("Makas", new BigDecimal(118), "Yalansızız artık.","FaaberCastel","Diğer");
    }

}