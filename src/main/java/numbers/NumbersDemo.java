package numbers;


import numbers.service.NumberService;
import numbers.service.NumberServiceProxy;
import numbers.dao.NumberDao;

import java.io.IOException;


public class NumbersDemo {
    public static void main(String[] args) throws IOException {
        NumberService numberService = new NumberServiceProxy(new NumberDao());
        
        for (int i = 0; i < 5; i++) {
            System.out.println(numberService.getRandomFact(1));
            System.out.println();
            System.out.println(numberService.getRandomFact(2));
            System.out.println();
        }
    }
}
