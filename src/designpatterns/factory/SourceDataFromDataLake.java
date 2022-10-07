package designpatterns.factory;

public class SourceDataFromDataLake implements IngestToDataBase{
    @Override
    public void ingestData() {
        System.out.println("read data from datalake and ingest");
    }
}
