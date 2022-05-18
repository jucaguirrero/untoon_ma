package com.example.toonun_ma;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btn_accept, btn_cancel, btn_pdf, btn_image;
    EditText et_name,et_author,et_date,et_description;
    String sImage, sPdf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_accept = findViewById(R.id.btn_accept);
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_pdf = findViewById(R.id.btn_pdf);
        btn_image = findViewById(R.id.btn_image );
        et_author = findViewById(R.id.et_author);
        et_date = findViewById(R.id.et_date);
        et_description = findViewById(R.id.et_description);
        et_name = findViewById(R.id.et_name);





        btn_pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(MainActivity.this
                            , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
                } else
                {
                    selectPdf();
                }
            }
        });

        btn_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(MainActivity.this
                            , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
                } else
                {
                    selectImage();
                }
            }
        })

        ;

    }

    private void selectPdf() {


        Intent intentPDF = new Intent(Intent.ACTION_GET_CONTENT);
        intentPDF.setType("application/pdf");
        intentPDF.addCategory(Intent.CATEGORY_OPENABLE);
        // start activity result
        startActivityForResult(Intent.createChooser(intentPDF,"Select Document"),100);
    }

    private void selectImage() {

        Intent intent=new Intent(Intent.ACTION_PICK);

        intent.setType("image/*");

        startActivityForResult(Intent.createChooser(intent,"Select Image"),101);
        Toast.makeText(this, sPdf, Toast.LENGTH_LONG).show();

    }


    public void to64(Intent i){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check condition
        if (requestCode==100 && resultCode==RESULT_OK && data!=null)
        {
            // when result is ok
            // initialize uri
            Uri uri=data.getData();
            // Initialize bitmap
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                // initialize byte stream
                ByteArrayOutputStream stream=new ByteArrayOutputStream();
                // compress Bitmap
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
                // Initialize byte array
                byte[] bytes=stream.toByteArray();
                // get base64 encoded string
                sImage= Base64.encodeToString(bytes,Base64.DEFAULT);
                // set encoded text on textview


            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ((requestCode==100 && resultCode==RESULT_OK && data!=null)){

                ByteArrayOutputStream stream=new ByteArrayOutputStream();

                byte[] bytes=stream.toByteArray();
                sPdf= Base64.encodeToString(bytes,Base64.DEFAULT);




        }
    }

}