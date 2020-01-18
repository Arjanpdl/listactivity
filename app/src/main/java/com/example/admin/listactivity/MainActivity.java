package com.example.admin.listactivity;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
String[] students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        students = getResources().getStringArray(R.array.students_array);
        ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setTextFilterEnabled(true);

        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,students));
    }

    public void onListItemClick (ListView listView, View view,int position,long id){
        if(listView.isItemChecked(position)){
            Toast.makeText(this,"You have Selected: "+listView.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"You have Unselected: "+listView.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view){
        ListView listView = getListView();
        String itemSelected = "Selected item: \n";
        int numOfSelectedItems = 0;

        for(int i =0 ;i<listView.getCount();i++){
            if (listView.isItemChecked(i)){
                itemSelected += listView.getItemAtPosition(i)+"\n";
                numOfSelectedItems++;
            }
        }

        if (numOfSelectedItems>0){
            Toast.makeText(this,itemSelected,Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this,"NO item Selected ",Toast.LENGTH_SHORT).show();
        }

    }
}
