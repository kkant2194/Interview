package designpatterns.factory;

public class IngestionService {

    IngestToDataBase ingestToDataBase = null;
    public  void ingestDataFromSource(String medium){
        if(medium.equals("API")){
            ingestToDataBase = new SourceDataFromAPI();
        }
        else if(medium.equals("file")){
            ingestToDataBase = new SourceDataFromFile();
        }
        else if(medium.equals("database")){
            ingestToDataBase = new SourceDataFromDataBase();
        }else{
            ingestToDataBase = new SourceDataFromDataLake();
        }
        ingestToDataBase.ingestData();
    }



}
