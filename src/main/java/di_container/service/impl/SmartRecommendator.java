package di_container.service.impl;

import di_container.service.Recommendator;

public class SmartRecommendator implements Recommendator {
    @Override
    public void recommend() {
        System.out.println("This gift was recommend by Smart recommendation");
    }
}
