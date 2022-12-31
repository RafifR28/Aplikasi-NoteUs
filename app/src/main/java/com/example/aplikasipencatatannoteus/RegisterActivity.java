package com.example.aplikasipencatatannoteus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    EditText edtEmail, edtUser, edtPass, edtConfirm;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtEmail = findViewById(R.id.emailDaftar);
        edtUser = findViewById(R.id.userDaftar);
        edtPass = findViewById(R.id.passwordDaftar);
        edtConfirm = findViewById(R.id.confirmDaftar);

        mAuth = FirebaseAuth.getInstance();
    }


    public void Daftar(View view) {
        String email, username, password, confirm;
        email = edtEmail.getText().toString();
        username = edtUser.getText().toString();
        password = edtPass.getText().toString();
        confirm = edtConfirm.getText().toString();

        if (password.equals(confirm)){
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()) {
                               FirebaseUser user = mAuth.getCurrentUser();
                               startActivity(new Intent(getApplicationContext(), Home.class)
                                       .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                       .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                           } else {
                               Log.w("auth_error", "error registrasi", task.getException());
                           }
                       }
                    });
            } else {
            Toast.makeText(this, "Password dan Konfirmasi Password tidak sama", Toast.LENGTH_LONG).show();
        }
    }

}