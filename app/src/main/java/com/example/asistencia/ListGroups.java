package com.example.asistencia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ListGroups extends AppCompatActivity {

    private ActionBar actionBar;
    private FloatingActionButton btnCreateGroup;
    private RecyclerView recyclerGroups;
    private EditText edtxNewGroup;
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_groups);
        actionBar = getSupportActionBar();
        actionBar.setTitle("GRUPOS");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        btnCreateGroup = findViewById(R.id.btnCreateGroup);
        recyclerGroups = findViewById(R.id.recyclerGroups);

        btnCreateGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createGroup();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    public void createGroup() {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.input_dialog_group,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(ListGroups.this);
        builder.setView(view);
        edtxNewGroup = view.findViewById(R.id.edtxNewGroup);
        edtxNewGroup.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30),new InputFilter.AllCaps()});
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.edit_text_save, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (edtxNewGroup.getText().toString().equals("")) {
                    Toast empty = Toast.makeText(context, "INGRESE UN NOMBRE", Toast.LENGTH_SHORT);
                    empty.setGravity(Gravity.CENTER,0,250);
                    empty.show();
                }else {
                    //saveDataLocal();
                    Toast saveData = Toast.makeText(context, "GRUPO CREADO", Toast.LENGTH_SHORT);
                    saveData.setGravity(Gravity.CENTER,0,250);
                    saveData.show();
                    //showListGroups();
                }
            }
        });
        builder.setNegativeButton(R.string.edit_text_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
