package com.alex.addressbook.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.alex.addressbook.R;
import com.alex.addressbook.domain.Contact;
import com.alex.addressbook.repository.DBAdapter;
import com.alex.addressbook.repository.DatasourceDAO;
import com.alex.addressbook.repository.Impl.DatasourceDAOImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 2014/08/19.
 */
public class ViewContacts extends Activity {

    private EditText getContact;
    private String getCount;
    private List<Contact> contactList = new ArrayList<Contact>();
    int count = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contacts);
        final DatasourceDAO dao = new DatasourceDAOImpl(this);
        contactList = dao.viewContact();

        Intent getMsg = getIntent();
        getCount = getMsg.getStringExtra("listView");

        final EditText lname = (EditText) findViewById(R.id.editTextLastNameView);
        final EditText cellPhoneNum = (EditText) findViewById(R.id.editTextCellPhoneNumberView);
        final EditText emailAddress = (EditText) findViewById(R.id.editTextEmailAddressView);
        final EditText homeAddress = (EditText) findViewById(R.id.editTextHomeAddressView);
        final EditText fname = (EditText) findViewById(R.id.editTextFnameView);



        for (Contact con : contactList) {
            if (con.getLastName().equalsIgnoreCase(getCount)) {
                System.out.println("Record Found");
                break;
            }
            count++;
        }

        lname.setText(contactList.get(count).getLastName());
        cellPhoneNum.setText(contactList.get(count).getCellPhoneNumber());
        fname.setText(contactList.get(count).getFirstName());
        emailAddress.setText(contactList.get(count).getEmailAddress());
        homeAddress.setText(contactList.get(count).getHomeAddress());


                /*final String count = dao.searchLastName(getContact.getText().toString());
                contactList = dao.viewContact();
                if(count!= null){

                    lname.setText(contactList.get(count).getLastName());
                    cellPhoneNum.setText(contactList.get(getCount).getCellPhoneNumber());

                    fname.setText("");
                    emailAddress.setText("");
                    homeAddress.setText("");



                            fname.setText(contactList.get(getCount).getFirstName());
                            emailAddress.setText(contactList.get(getCount).getEmailAddress());
                            homeAddress.setText(contactList.get(getCount).getHomeAddress());
                        }else

                {
                    lname.setText("");
                    cellPhoneNum.setText("");
                    fname.setText("");
                    emailAddress.setText("");
                    homeAddress.setText("");
                    Toast.makeText(getApplicationContext(), "No Record found of the contact searched for. Please try again or add a contact.", Toast.LENGTH_LONG);
                }*/
    }
}