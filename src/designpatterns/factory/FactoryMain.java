package designpatterns.factory;

public class FactoryMain {

    public static void main(String[] args) {

        IngestionService ingestionService = new IngestionService();
        ingestionService.ingestDataFromSource("API");
    }
}
