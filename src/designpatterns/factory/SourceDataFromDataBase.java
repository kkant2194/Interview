package designpatterns.factory;

public class SourceDataFromDataBase implements IngestToDataBase{
    @Override
    public void ingestData() {
        System.out.println("read data from database and ingest");
    }
}
