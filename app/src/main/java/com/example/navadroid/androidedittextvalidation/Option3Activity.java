package com.example.navadroid.androidedittextvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Option3Activity extends AppCompatActivity {

    private EditText etName;
    private EditText etPwd;
    private EditText etEmail;
    private EditText etPhone;

    private static final String EMAIL_PATTERN = "^([A-Za-z0-9]+)([\\._A-Za-z0-9]+)(@)([A-Za-z0-9]+)(\\.[A-Za-z]{2,})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option3);
        bindView();
        initView();
    }

    private void bindView() {
        etName = (EditText) findViewById(R.id.et_name3);
        etPwd = (EditText) findViewById(R.id.et_pwd3);
        etEmail = (EditText) findViewById(R.id.et_email3);
        etPhone = (EditText) findViewById(R.id.et_phone3);
    }

    private void initView() {
        // OnClickListener
        findViewById(R.id.btn_validate3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateEditText()) {
                    Toast.makeText(Option3Activity.this, "Okay. You are good to go.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // TextChangedListener
        etName.addTextChangedListener(new TextValidator(etName) {
            @Override
            public void validate(TextView textView, String text) {
                if (text.length() == 0) {
                    etName.setError("Required");
                }
            }
        });

        etPwd.addTextChangedListener(new TextValidator(etPwd) {
            @Override
            public void validate(TextView textView, String text) {
                if (text.length() == 0) {
                    etPwd.setError("Required");
                }
            }
        });

        etEmail.addTextChangedListener(new TextValidator(etEmail) {
            @Override
            public void validate(TextView textView, String text) {
                if (text.length() == 0) {
                    etEmail.setError("Required");
                }
            }
        });

        etPhone.addTextChangedListener(new TextValidator(etPhone) {
            @Override
            public void validate(TextView textView, String text) {
                if (text.length() == 0) {
                    etPhone.setError("Required");
                }
            }
        });
    }


    // To validate all EditTexts
    private boolean validateEditText() {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(etEmail.getText().toString());

        boolean isValidated = true;
        if (etName.getText().toString().length() == 0) {
            etName.setError("Required");
            isValidated = false;
        }

        if (etPwd.getText().toString().length() == 0) {
            etPwd.setError("Required");
            isValidated = false;
        }

        if (etEmail.getText().toString().length() == 0) {
            etEmail.setError("Required");
            isValidated = false;
        }
        else if (!matcher.find()) {
            etEmail.setError("Invalid Email");
            isValidated = false;
        }

        if (etPhone.getText().toString().length() == 0) {
            etPhone.setError("Required");
            isValidated = false;
        }

        return isValidated;
    }
}
