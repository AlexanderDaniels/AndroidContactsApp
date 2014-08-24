package com.alex.addressbook.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.alex.addressbook.R;

/**
 * Created by alex on 2014/08/19.
 */
public class MainMenu extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button inputButton = (Button) findViewById(R.id.inputBtn);
        Button viewButton = (Button) findViewById(R.id.viewBtn);

        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreateContact = new Intent(MainMenu.this, CreateContact.class);
                startActivity(intentCreateContact);
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentViewContacts = new Intent(MainMenu.this, ListViewCon.class);
                startActivity(intentViewContacts);
            }
        });
    }
}