package me.didik.activityresultsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.didik.activityresultsample.model.Contact;
import pl.aprilapps.easyphotopicker.EasyImage;

public class AddContactActivity extends AppCompatActivity {
    private EditText etName, etPhone, etEmail;
    private ImageView ivPhoto;
    private Spinner spinner;
    private String selectedString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        etName = (EditText) findViewById(R.id.et_name);
        etPhone = (EditText) findViewById(R.id.et_phone);
        etEmail = (EditText) findViewById(R.id.et_email);
        spinner = (Spinner) findViewById(R.id.spinner);
        ivPhoto = (ImageView) findViewById(R.id.iv_photo);

        initSpinner();
    }

    private void initSpinner() {
        List<String> list = new ArrayList<>();
        list.add("Mobile phone");
        list.add("Home");
        list.add("Work");

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selectedString = adapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void save(View view) {
        String name = etName.getText().toString().trim();

        Intent returnIntent = new Intent();
        String type = (String) spinner.getSelectedItem();
        String phone = etPhone.getText().toString();
        String email = etEmail.getText().toString();

        returnIntent.putExtra("data", new Contact(name, email, type, phone));
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    public void cancel(View view) {
        Intent returnIntent = new Intent();
        setResult(RESULT_CANCELED, returnIntent);
        finish();
    }

    public void choosePhoto(View view) {
        EasyImage.openChooserWithGallery(this, "Pilih gambar", 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new EasyImage.Callbacks() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {

            }

            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                onPhotoReturned(imageFile);
            }

            @Override
            public void onCanceled(EasyImage.ImageSource source, int type) {
                if (source == EasyImage.ImageSource.CAMERA) {
                    File photoFile = EasyImage.lastlyTakenButCanceledPhoto(MainActivity.this);
                    if (photoFile != null) photoFile.delete();
                }
            }
        });
    }

    private void onPhotoReturned(File imageFile) {
        if (imageFile != null) {
            Glide.with(this)
                    .load(imageFile)
                    .crossFade()
                    .centerCrop()
                    .into(ivPhoto);
            Log.d("path", imageFile.getAbsolutePath());
        }
    }


}
