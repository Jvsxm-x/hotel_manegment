package com.example.hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class reservation extends AppCompatActivity {

    Calendar calendar;
    private EditText mFName, mLName, mRoom, mAdult, mChild, mdate_E, mdate_D;
    private String Fname, Fsubname, Froom, Fadult, Fchild, Date_E, Date_D;
    private FirebaseAuth fAuth;
    private Button mUpload;
    private String nameRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        // Initialize Firebase Auth
        fAuth = FirebaseAuth.getInstance();

        // UI Elements
        mFName = findViewById(R.id.Fname);
        mLName = findViewById(R.id.Lname);
        mRoom = findViewById(R.id.room);
        mAdult = findViewById(R.id.adult);
        mChild = findViewById(R.id.child);
        mdate_E = findViewById(R.id.arrival);
        mdate_D = findViewById(R.id.dep);
        mUpload = findViewById(R.id.rezvv);
        calendar = Calendar.getInstance();

        // Get room name if passed via intent or static field
        nameRoom = nameRooM.getNameRoom(); // Replace with actual getter or intent extra
        mRoom.setText(nameRoom);

        // Get current user info from Firebase
        String currentUserId = fAuth.getCurrentUser().getUid();
        DatabaseReference referance = FirebaseDatabase.getInstance().getReference().child("users").child(currentUserId);
        // Préremplir prénom et nom depuis Firebase
        DatabaseReference referenceforuser = FirebaseDatabase.getInstance().getReference().child("users").child(currentUserId);

        referenceforuser.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String name = snapshot.child("name").getValue(String.class);
                    String surname = snapshot.child("surname").getValue(String.class);
                    if (name != null) mFName.setText(name);
                    if (surname != null) mLName.setText(surname);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
        referance.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    mFName.setText(snapshot.child("name").getValue(String.class));
                    mLName.setText(snapshot.child("surname").getValue(String.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        // Date picker for arrival
        mdate_E.setOnClickListener(v -> showDatePickerDialog(mdate_E));

        // Date picker for departure
        mdate_D.setOnClickListener(v -> showDatePickerDialog(mdate_D));

        // Upload reservation
        mUpload.setOnClickListener(v -> submitReservation());

        // Return button
        ImageView back = findViewById(R.id.reture2);
        back.setOnClickListener(v -> onBackPressed());
    }

    private void showDatePickerDialog(EditText targetEditText) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                reservation.this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    targetEditText.setText(selectedDate);
                },
                year, month, day
        );
        datePickerDialog.show();
    }

    private void submitReservation() {
        Fname = mFName.getText().toString().trim();
        Fsubname = mLName.getText().toString().trim();
        Froom = mRoom.getText().toString().trim();
        Fadult = mAdult.getText().toString().trim();
        Fchild = mChild.getText().toString().trim();
        Date_E = mdate_E.getText().toString().trim();
        Date_D = mdate_D.getText().toString().trim();

        if (TextUtils.isEmpty(Fadult)) {
            mAdult.setError("Veuillez entrer le nombre d'adultes");
            return;
        }

        if (TextUtils.isEmpty(Fchild)) {
            mChild.setError("Veuillez entrer le nombre d'enfants");
            return;
        }

        if (TextUtils.isEmpty(Date_E)) {
            mdate_E.setError("Veuillez entrer la date d'arrivée");
            return;
        }

        if (TextUtils.isEmpty(Date_D)) {
            mdate_D.setError("Veuillez entrer la date de départ");
            return;
        }

        EnregResV enregResV = new EnregResV(Fname, Fsubname, Froom, Fadult, Fchild, Date_E, Date_D);
        String userId = fAuth.getCurrentUser().getUid();

        FirebaseDatabase.getInstance().getReference("reservation")
                .child(userId)
                .setValue(enregResV)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(reservation.this, "Réservation enregistrée avec succès !", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(reservation.this, "Erreur : " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}
