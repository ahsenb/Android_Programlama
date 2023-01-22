package com.example.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ArrayList<Constants> dataModel = new ArrayList<>();
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.list_view);
        loadJson();
    }

    private void loadJson() {
        HashMap<String, String> map = null;
        try {
            JSONObject object = new JSONObject(readJsonFromAssets());
            JSONArray jarray = object.getJSONArray("feeds");

            for(int i=0; i<jarray.length();i++)
            {
                //create Constants class object to call getter method
                Constants constant = new Constants();
                JSONObject obj = jarray.getJSONObject(i);
                map = new HashMap<>();


                map.put(Constants.ENTRY_ID,obj.getString(Constants.ENTRY_ID));
                map.put(Constants.FIELD1,obj.getString(Constants.FIELD1));
                map.put(Constants.FIELD2,obj.getString(Constants.FIELD2));
                map.put(Constants.FIELD3,obj.getString(Constants.FIELD3));
                map.put(Constants.FIELD4,obj.getString(Constants.FIELD4));
                map.put(Constants.FIELD5,obj.getString(Constants.FIELD5));
                map.put(Constants.FIELD6,obj.getString(Constants.FIELD6));

                //Add json data to setter method of Constants class
                constant.setRelateds(map);

                //Add object to Arraylist
                dataModel.add(constant);
            }
            CustomViewAdapter customAdaptor = new CustomViewAdapter(this, dataModel);

            listview.setAdapter(customAdaptor);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String readJsonFromAssets()
    {
        String json = null;
        try {
            InputStream is = getAssets().open("sample.json");
            int size = is.available();
            byte[] buffer =new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }


}