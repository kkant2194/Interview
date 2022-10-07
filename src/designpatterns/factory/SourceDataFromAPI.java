package designpatterns.factory;

public class SourceDataFromAPI implements IngestToDataBase{
    @Override
    public void ingestData() {
        System.out.println("Read data from API and ingest");
    }
}
