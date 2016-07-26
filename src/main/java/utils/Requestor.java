package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.City;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nico on 26.07.16.
 */
public class Requestor {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static String url = "http://api.goeuro.com/api/v2/position/suggest/en/";

    public List<City> getObjects(String city) throws IOException {
        List<String> result = new ArrayList<String>();
        HttpGet httpGet = new HttpGet(url + city);
        HttpClient httpclient = HttpClients.createDefault();
        HttpResponse response = httpclient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        InputStreamReader inputStreamReader = new InputStreamReader(entity.getContent());
        List<City> array = gson.fromJson(inputStreamReader, new TypeToken<List<City>>(){}.getType());;
        System.out.println(array);
        return array;
    }
}


