package com.claus.Design;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
    // 1352. Product of the Last K Numbers

    // 列表每个元素存储该元素与之前面元素的乘积
    private List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            // 如果新插入值为0，则前面的数字都失效
            products = new ArrayList<>();
            products.add(1);
        } else {
            products.add(products.get(products.size()-1) * num);
        }
    }

    public int getProduct(int k) {
        if (products.size() <= k) {
            return 0;
        }
        return products.get(products.size()-1) / products.get(products.size()-1-k);
    }

    public static void main(String[] args) {
        ProductOfNumbers test = new ProductOfNumbers();
        test.add(3);        // [3]
        test.add(0);        // [3,0]
        test.add(2);        // [3,0,2]
        test.add(5);        // [3,0,2,5]
        test.add(4);        // [3,0,2,5,4]
        test.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
        test.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
        test.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
        test.add(8);        // [3,0,2,5,4,8]
        test.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
    }
}
