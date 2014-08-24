package com.alex.addressbook.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.alex.addressbook.R;
import com.alex.addressbook.domain.Contact;
import com.alex.addressbook.repository.DatasourceDAO;
import com.alex.addressbook.repository.Impl.DatasourceDAOImpl;

/**
 * Created by alex on 2014/08/19.
 */
public class CreateContact extends Activity {
    private EditText firstName;
    private EditText lastName;
    private EditText emailAddress;
    private EditText cellPhoneNum;
    private EditText homeAddress;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_contact);
        final DatasourceDAO dao = new DatasourceDAOImpl(this);
        Button saveButton = (Button) findViewById(R.id.saveBtn);
        Button backButton = (Button) findViewById(R.id.backBtn);

        firstName = (EditText) findViewById(R.id.editTextFirstName);
        lastName = (EditText) findViewById(R.id.editTextLastName);
        emailAddress = (EditText) findViewById(R.id.editTextEmailAddress);
        cellPhoneNum = (EditText) findViewById(R.id.editTextCellPhoneNumber);
        homeAddress = (EditText) findViewById(R.id.editTextHomeAddress);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact = new Contact.ContactBuilder()
                        .firstName(firstName.getText().toString())
                        .lastName(lastName.getText().toString())
                        .emailAddress(emailAddress.getText().toString())
                        .cellPhoneNumber(cellPhoneNum.getText().toString())
                        .homeAddress(homeAddress.getText().toString())
                        .build();
                dao.createContact(contact);
                System.out.println("Inserted################################################################################################");

                startActivity(new Intent(CreateContact.this, MainMenu.class));
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateContact.this, MainMenu.class));
            }
        });

    }
}