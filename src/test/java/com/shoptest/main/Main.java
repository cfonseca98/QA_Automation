package com.shoptest.main;

import org.junit.Test;
import org.junit.runner.JUnitCore;


import com.shoptest.runners.registerShopStore;

public class Main {

    @Test
    public void test() {

        JUnitCore junit = new JUnitCore();
        junit.run(registerShopStore.class);

    }

    public static void main(String[] args) {
        Main main = new Main();
        main.test();
    }

}
