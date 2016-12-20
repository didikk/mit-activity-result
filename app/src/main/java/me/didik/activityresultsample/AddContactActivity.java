package me.didik.activityresultsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {
    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        etName = (EditText) findViewById(R.id.et_name);
    }

    public void save(View view) {
        String name = etName.getText().toString().trim();

        Intent returnIntent = new Intent();
        returnIntent.putExtra("name", name);
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    public void cancel(View view) {
        Intent returnIntent = new Intent();
        setResult(RESULT_CANCELED, returnIntent);
        finish();
    }
}
