package com.example.deneme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Constants> datamodel;
    public CustomViewAdapter(Context context, ArrayList<Constants> dataModel) {
        this.context = context;
        this.datamodel = dataModel;
    }

    @Override
    public int getCount() {
        return datamodel.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        TextView entry_id,field1,field2,field3,field4,field5,field6;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = inflater.inflate(R.layout.list_view_item, parent, false);

        entry_id = itemview.findViewById(R.id.entry_id);
        field1 = itemview.findViewById(R.id.field1);
        field2 = itemview.findViewById(R.id.field2);
        field3= itemview.findViewById(R.id.field3);
        field4 = itemview.findViewById(R.id.field4);
        field5 = itemview.findViewById(R.id.field5);
        field6 = itemview.findViewById(R.id.field6);


        entry_id.setText(datamodel.get(position).getRelateds().get(Constants.ENTRY_ID));
        field1.setText(datamodel.get(position).getRelateds().get(Constants.FIELD1));
        field2.setText(datamodel.get(position).getRelateds().get(Constants.FIELD2));
        field3.setText(datamodel.get(position).getRelateds().get(Constants.FIELD3));
        field4.setText(datamodel.get(position).getRelateds().get(Constants.FIELD4));
        field5.setText(datamodel.get(position).getRelateds().get(Constants.FIELD5));
        field6.setText(datamodel.get(position).getRelateds().get(Constants.FIELD6));

        return itemview;
    }
}