package com.alex.addressbook.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.alex.addressbook.R;
import com.alex.addressbook.domain.Contact;
import com.alex.addressbook.repository.DatasourceDAO;
import com.alex.addressbook.repository.Impl.DatasourceDAOImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alex on 2014/08/20.
 */
public class ListViewCon extends Activity {

    //private List<Map<String,String>> contactList = new ArrayList<Map<String,String>>();
    List<Contact> listCon = new ArrayList<Contact>();
    ListView listView;
    DatasourceDAO dao = new DatasourceDAOImpl(this);


    public class CustomList extends ArrayAdapter<String> {
        private final Contact con = new Contact();
        private final Activity context;
        private final String[] surname;
        private final String[] cellPhone;
        public CustomList(Activity context,
                          String[] surname, String[] cellPhone) {
            super(context, R.layout.list_single, surname);
            this.context = context;
            this.surname = surname;
            this.cellPhone = cellPhone;
        }
        @Override
        public View getView(final int position, final View view, final ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View rowView= inflater.inflate(R.layout.list_single, null, true);
            TextView surnamea = (TextView) rowView.findViewById(R.id.surnmeCustom);
            TextView cellPhonea = (TextView) rowView.findViewById(R.id.cellPhneNumCustom);
            Button moreDetails = (Button) rowView.findViewById(R.id.moreDetCustom);
            surnamea.setText(surname[position]);
            cellPhonea.setText(cellPhone[position]);

            moreDetails.setTag(surnamea.getText().toString());

            moreDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent next = new Intent(ListViewCon.this, ViewContacts.class);
                    String value = (String)v.getTag();

                    next.putExtra("listView", value);
                    startActivity(next);

                }
            });
            return rowView;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_contacts);

        listCon = dao.viewContact();


        String[] surname = new String[listCon.size()];
        String[] cellphone = new String[listCon.size()];

        surname(surname);
        cellphone(cellphone);


        CustomList adapter = new
                CustomList(this, surname, cellphone);

        listView = (ListView) findViewById(R.id.listViewContacts);

        listView.setAdapter(adapter);


        registerForContextMenu(listView);
    }

        private void surname(String[] surname){
            int count = 0;
            for (Contact con : listCon){
                surname[count] = con.getLastName();
                count++;
            }

        }

        private void cellphone(String[] cellphone){
            int count = 0;
            for (Contact con : listCon){
                cellphone[count] = con.getCellPhoneNumber();
                count++;
            }

        }
}


