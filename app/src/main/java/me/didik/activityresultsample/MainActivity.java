package me.didik.activityresultsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    public static final String TAG = "TagMain";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        initRecycler();
    }

    private void initRecycler(){
        List<Contact> list = new ArrayList<>();
        list.add(new Contact("Didik", "Mobile phone", "089682040617"));
        list.add(new Contact("Didik", "Mobile phone", "089682040617"));
        list.add(new Contact("Didik", "Mobile phone", "089682040617"));
        list.add(new Contact("Didik", "Mobile phone", "089682040617"));
        list.add(new Contact("Didik", "Mobile phone", "089682040617"));
        list.add(new Contact("Didik", "Mobile phone", "089682040617"));

        ContactAdapter adapter = new ContactAdapter(list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void addContact(View view) {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Log.d(TAG, "Success add contact");
                String name = data.getStringExtra("name");
                String type = data.getStringExtra("type");
                //tvName.append(name + ": " + type + "\n");
            } else if (resultCode == RESULT_CANCELED)
                Log.d(TAG, "Add contact canceled");
        }
    }
}
