package org.acme.qute;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SampleService {

    private static final String[] names = {"James", "Deepak", "Daniel", "Shaaf", "Jeff", "Sally"};

    public List<Sample> get() {
        int count = new Random().nextInt(10);
        List<Sample> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            boolean valid = false;
            if (Math.random() > 0.5) {
                valid = true;
            }
            result.add(new Sample(valid, names[(int)(Math.random() * names.length)], Math.random() + ""));
        }
        return result;
    }
}
