package mumtaazstudio.newsapp.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import mumtaazstudio.newsapp.model.SourcesModel;

public class SourcesJsonParser {

    static ArrayList<SourcesModel> sourcesModelArrayList;

    public static ArrayList<SourcesModel> parseData(String content, int code) throws JSONException {
        JSONArray sourcesArray = null;
        SourcesModel sourcesModel = null;

        try {
            sourcesModelArrayList = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(content);
            sourcesArray = jsonObject.getJSONArray("sources");

            for (int i = 0; i < sourcesArray.length(); i++){
                JSONObject itemObject = sourcesArray.getJSONObject(i);
                sourcesModel = new SourcesModel();

                sourcesModel.setId(itemObject.getString(KeyStorage.KEY_SOURCE_ID));
                sourcesModel.setName(itemObject.getString(KeyStorage.KEY_SOURCE_NAME));
                sourcesModel.setDescription(itemObject.getString(KeyStorage.KEY_SOURCE_DESCRIPTION));
                sourcesModel.setUrl(itemObject.getString(KeyStorage.KEY_SOURCE_URL));
                sourcesModel.setCategory(itemObject.getString(KeyStorage.KEY_SOURCE_CATEGORY));
                sourcesModel.setLanguage(itemObject.getString(KeyStorage.KEY_SOURCE_LANGUAGE));
                sourcesModel.setCountry(itemObject.getString(KeyStorage.KEY_SOURCE_COUNTRY));

                sourcesModelArrayList.add(sourcesModel);
            }
            return sourcesModelArrayList;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
