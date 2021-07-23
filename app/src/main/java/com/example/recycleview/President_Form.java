package com.example.recycleview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import model.President;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class President_Form extends AppCompatActivity {

    Button btn_cancel ;
    Button btn_save;
    List<President> presidentList;
    MyApplication myApplication = (MyApplication) this.getApplication();
    EditText et_pr_name , et_pr_img , et_pr_date , et_pr_country;
    TextView tv_president_id;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {





        presidentList = myApplication.getPresidentList();




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president_form);

        btn_cancel = findViewById(R.id.btn_cancel);
        btn_save = findViewById(R.id.btn_save);

        et_pr_name = findViewById(R.id.tv_Name);
        et_pr_img = findViewById(R.id.tv_url);
        et_pr_date = findViewById(R.id.tv_date);
        et_pr_country = findViewById(R.id.ed_country);
        tv_president_id = findViewById(R.id.tv_code);

        long presidentId;

        Intent intent = getIntent();
        presidentId = intent.getLongExtra("id", -1);

        President president = null;

        if(presidentId >= 0) {

            for (President p: presidentList) {

                if (p.getId() == ((long)presidentId)) {
                    president = p;
                }

            }

            et_pr_name.setText(president.getName());
            et_pr_country.setText(president.getCountry());
            et_pr_date.setText(president.getDateElection());
            et_pr_img.setText(president.getImageUrl());
            tv_president_id.setText(String.valueOf(presidentId));
            btn_save.setText("Update");


        }
        else {
            Log.d("presidentId", String.valueOf(presidentId));
        }

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(President_Form.this, MainActivity.class );
                startActivity(intent);
            }
        });


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                long nextId = myApplication.getNextId();
                if(et_pr_img.getText().equals(null) ||  et_pr_img.getText().equals(null) || et_pr_country.getText().equals(null) || et_pr_date.getText().equals(null)  ) {
                    Toast.makeText(President_Form.this, "Campos Vazios, por favor preencha todos campos", Toast.LENGTH_SHORT ).show();



                }
                else {

                    if(presidentId >= 0) {
                        presidentList.set(Math.toIntExact(presidentId)-1, new President(presidentId, et_pr_name.getText().toString(), et_pr_country.getText().toString(), et_pr_date.getText().toString(), et_pr_img.getText().toString() ));
                        Toast.makeText(President_Form.this, "Dados do Presidente actualizados", Toast.LENGTH_SHORT ).show();
                    }
                    else {
                        President president = new President(nextId, et_pr_name.getText().toString(), et_pr_country.getText().toString(), et_pr_date.getText().toString(), et_pr_img.getText().toString());
                        presidentList.add(president);
                        Toast.makeText(President_Form.this, "Presidente Adicionado", Toast.LENGTH_SHORT ).show();
                        int i=(int)nextId;
                    }


                }






            }
        });



    }







}