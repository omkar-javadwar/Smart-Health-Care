package com.example.shp;

import java.io.FileNotFoundException;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ShareFragment extends AppCompatActivity implements OnClickListener {
    private static Button selectImage, shareImage, shareText;
    private static ImageView imageView;
    private static EditText textToShare;

    // Uri for image path
    private static Uri imageUri = null;

    private final int select_photo = 1; // request code fot gallery intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_share);

        init();
        setListeners();

    }

    // Initialize views
    private void init() {
        selectImage = (Button) findViewById(R.id.select_image);
        shareImage = (Button) findViewById(R.id.share_image);
        shareText = (Button) findViewById(R.id.btnTextShare);

        imageView = (ImageView) findViewById(R.id.share_imageview);

        textToShare = (EditText) findViewById(R.id.text_share);
    }

    // Implement click listeners
    private void setListeners() {
        selectImage.setOnClickListener(this);
        shareImage.setOnClickListener(this);
        shareText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select_image:
                // Intent to gallery
                Intent in = new Intent(Intent.ACTION_PICK);
                in.setType("image/*");
                startActivityForResult(in, select_photo);// start
                // activity
                // for
                // result
                break;
            case R.id.share_image:

                // share image
                shareImage(imageUri);

                break;
            case R.id.btnTextShare:

                // Share text
                String getText = textToShare.getText().toString();
                if (!getText.equals("") && getText.length() != 0)
                    shareText(getText);
                else
                    Toast.makeText(ShareFragment.this,
                            "Please enter something to share.", Toast.LENGTH_SHORT)
                            .show();

                break;

        }
    }

    protected void onActivityResult(int requestcode, int resultcode,
                                    Intent imagereturnintent) {
        super.onActivityResult(requestcode, resultcode, imagereturnintent);
        switch (requestcode) {
            case select_photo:
                if (resultcode == RESULT_OK) {
                    try {

                        imageUri = imagereturnintent.getData();// Get intent
                        // data

                        Bitmap bitmap = Utils.decodeUri(ShareFragment.this,
                                imageUri, 200);// call
                        // deocde
                        // uri
                        // method
                        // Check if bitmap is not null then set image else show
                        // toast
                        if (bitmap != null) {
                            imageView.setImageBitmap(bitmap);// Set image over
                            // bitmap
                            shareImage.setVisibility(View.VISIBLE);// Visible button
                            // if bitmap is
                            // not null
                        } else {
                            shareImage.setVisibility(View.GONE);
                            Toast.makeText(ShareFragment.this,
                                    "Error while decoding image.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } catch (FileNotFoundException e) {

                        e.printStackTrace();
                        Toast.makeText(ShareFragment.this, "File not found.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
        }
    }

    // Share image
    private void shareImage(Uri imagePath) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        sharingIntent.setType("image/*");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, imagePath);
        startActivity(Intent.createChooser(sharingIntent, "Share Image Using"));
    }

    // Share text
    private void shareText(String text) {

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");// Plain format text

        // You can add subject also
        /*
         * sharingIntent.putExtra( android.content.Intent.EXTRA_SUBJECT,
         * "Subject Here");
         */
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, text);
        startActivity(Intent.createChooser(sharingIntent, "Share Text Using"));
    }
}