package designpatterns.factory;

public class SourceDataFromFile implements IngestToDataBase{
    @Override
    public void ingestData() {
        System.out.println("Read data from file and ingest");
    }
}
