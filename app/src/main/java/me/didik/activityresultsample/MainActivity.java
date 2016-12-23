package me.didik.activityresultsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    public static final String TAG = "TagMain";
    private RecyclerView recyclerView;

    private List<Contact> list;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        initRecycler();
    }

    private void initRecycler() {
        list = new ArrayList<>();
        list.add(new Contact("Didik", "Mobile phone", "089682040617"));
        list.add(new Contact("Ari", "Mobile phone", "089682040617"));
        list.add(new Contact("Fitra", "Mobile phone", "089682040617"));
        list.add(new Contact("Ahyar", "Mobile phone", "089682040617"));
        list.add(new Contact("Bayu", "Mobile phone", "089682040617"));
        list.add(new Contact("Wildan", "Mobile phone", "089682040617"));

        adapter = new ContactAdapter(list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Contact contact = adapter.getItem(position);
                        Toast.makeText(MainActivity.this, contact.getName(),
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));
    }

    public void addContact(View view) {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
        //adapter.remove(0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Log.d(TAG, "Success add contact");
                Contact contact = data.getParcelableExtra("data");
                adapter.insert(contact);
                recyclerView.scrollToPosition(0);
                //tvName.append(name + ": " + type + "\n");
            } else if (resultCode == RESULT_CANCELED)
                Log.d(TAG, "Add contact canceled");
        }
    }
}
