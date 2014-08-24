package com.alex.addressbook.repository.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.alex.addressbook.domain.Contact;
import com.alex.addressbook.repository.DBAdapter;
import com.alex.addressbook.repository.DatasourceDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 2014/08/19.
 */
public class DatasourceDAOImpl implements DatasourceDAO {

    private SQLiteDatabase database;
    private DBAdapter dbHelper;

    public DatasourceDAOImpl(Context context) {
        dbHelper = new DBAdapter(context);
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    @Override
    public void createContact(Contact contact) {
        try {
            open();
            Log.d("asdfqwe","opening!!!!!!!!!!!!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBAdapter.COLUMN_FIRST_NAME, contact.getFirstName());
        contentValues.put(DBAdapter.COLUMN_LAST_NAME, contact.getLastName());
        contentValues.put(DBAdapter.COLUMN_EMAIL_ADDRESS, contact.getEmailAddress());
        contentValues.put(DBAdapter.COLUMN_CELL_PHONE_NUMBER, contact.getCellPhoneNumber());
        contentValues.put(DBAdapter.COLUMN_HOME_ADDRESS, contact.getHomeAddress());

        database.insertOrThrow(DBAdapter.TABLE_CONTACTS, null, contentValues);
        Log.d("asdfawf","creating contact");
        close();
    }

    @Override
    public List<Contact> viewContact() {
        String selectQuery = "SELECT * FROM " + DBAdapter.TABLE_CONTACTS;
        List<Contact> contacts = new ArrayList<Contact>();

        try {
            open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Cursor cursor = database.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                final Contact contact = new Contact.ContactBuilder()
                        .firstName(cursor.getString(0))
                        .lastName(cursor.getString(1))
                        .emailAddress(cursor.getString(2))
                        .cellPhoneNumber(cursor.getString(3))
                        .homeAddress(cursor.getString(4))
                        .build();
                    contacts.add(contact);
            } while (cursor.moveToNext());
        }
        close();

        return contacts;
    }

    @Override
    public String searchLastName(String searchValue) {

        int counter = 0;
        List<Contact>contactList = new ArrayList<Contact>();
                contactList = viewContact();

        for (Contact con : contactList) {
            if (contactList.get(counter).getLastName().equalsIgnoreCase(searchValue)) {
                String count = String.valueOf(counter);
                return count;
            }
            else {
                counter++;
            }
        }
        System.out.println("NO Record");
        return null;
    }
}
