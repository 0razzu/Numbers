package numbers.service;


import java.io.IOException;


public interface NumberService {
    String getRandomFact(int number) throws IOException;
}
