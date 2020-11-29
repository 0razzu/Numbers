package numbers.service;


import numbers.dao.NumberDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;


public class NumberServiceProxy implements NumberService {
    private final Logger LOGGER = LoggerFactory.getLogger(NumberServiceProxy.class);
    private final NumberService defaultNumberService;
    private final Map<Integer, List<String>> facts = new HashMap<>();
    private final Random random = new Random();
    
    
    public NumberServiceProxy(NumberDao util) {
        this.defaultNumberService = new DefaultNumberService(util);
    }
    
    
    @Override
    public String getRandomFact(int number) throws IOException {
        List<String> numberFacts = facts.get(number);
        
        if (numberFacts != null && random.nextBoolean()) {
            LOGGER.debug("returning cached fact");
            return numberFacts.get(random.nextInt(numberFacts.size()));
        }
        
        String numberFact = defaultNumberService.getRandomFact(number);
        
        if (numberFacts == null) {
            numberFacts = new ArrayList<>();
            numberFacts.add(numberFact);
            facts.put(number, numberFacts);
        }
        
        else if (!numberFacts.contains(numberFact))
            numberFacts.add(numberFact);
        
        return numberFact;
    }
}
