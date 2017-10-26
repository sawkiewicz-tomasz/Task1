package sawkiewicz.task1;

public interface Repository <K,V>{

    V findById(K id);
}
