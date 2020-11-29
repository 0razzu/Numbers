package numbers.service;


import numbers.dao.NumberDao;

import java.io.IOException;


public class DefaultNumberService implements NumberService {
    private final NumberDao util;
    
    
    public DefaultNumberService(NumberDao util) {
        this.util = util;
    }
    
    
    @Override
    public String getRandomFact(int number) throws IOException {
        return util.getRandomFact(number);
    }
}
