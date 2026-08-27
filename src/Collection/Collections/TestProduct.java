package Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class TestProduct {
    public static void main(String[] args) {
         Product product1=new Product("iPhone",879,90000);
        Product product2=new Product("TV",989,90000);
        Product product3=new Product("Fridge",7888,90000);
        Product product4=new Product("Washing machine",875,90000);
        Product product5=new Product("Pizza",101,90000);
        Product product6=new Product("T-shirt",107,90000);
        Product product7=new Product("LG",832,90000);

        List<Product> productList=new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        //Sorting
        Collections.sort(productList);
        System.out.println(productList);

  for (int i=0;i< productList.size();i++){
      Product p=productList.get(i);
      System.out.println("Product is id"+p.productId+"Product name is :"+p.productName);
  }

        }
    }


