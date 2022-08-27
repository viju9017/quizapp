package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView questionsobj,qno;
    Button option1obj,option2obj,option3obj,option4obj;
    ArrayList<quizmodel> quizmodelArrayList;
    Random random;
    int currentscore=0,questionsttempted=1,currentpos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionsobj = findViewById(R.id.questions);
        qno = findViewById(R.id.attempt);
        option1obj = findViewById(R.id.op1);
        option2obj = findViewById(R.id.op2);
        option3obj = findViewById(R.id.op3);
        option4obj = findViewById(R.id.op4);
        quizmodelArrayList = new ArrayList<>();
        random = new Random();
        getquizquestions(quizmodelArrayList);
        currentpos = random.nextInt(quizmodelArrayList.size());
        dataview(currentpos);
        option1obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizmodelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(option1obj.getText().toString().trim().toLowerCase()))

                {
                    currentscore++;
                }
                questionsttempted++;
                currentpos=random.nextInt(quizmodelArrayList.size());
                dataview(currentpos);

            }


        });
        option2obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizmodelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(option2obj.getText().toString().trim().toLowerCase()))

                {
                    currentscore++;
                }
                questionsttempted++;
                currentpos=random.nextInt(quizmodelArrayList.size());
                dataview(currentpos);



            }
        });
        option3obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizmodelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(option3obj.getText().toString().trim().toLowerCase()))

                {
                    currentscore++;
                }
                questionsttempted++;
                currentpos=random.nextInt(quizmodelArrayList.size());
                dataview(currentpos);

            }

        });
        option4obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizmodelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(option4obj.getText().toString().trim().toLowerCase()))
                {
                    currentscore++;
                }
                questionsttempted++;
                currentpos=random.nextInt(quizmodelArrayList.size());
                dataview(currentpos);

            }
        });
    }
    private void scorebottomsheet(){
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(MainActivity.this);
        View sheetview= LayoutInflater.from(getApplicationContext()).inflate(R.layout.scoresheet,(LinearLayout)findViewById(R.id.lrt));
        TextView score=sheetview.findViewById(R.id.score);
        Button restart=sheetview.findViewById(R.id.btnrestart);
        score.setText("your Score is:"+currentscore+"/10");
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentpos=random.nextInt(quizmodelArrayList.size());
                dataview(currentpos);
                questionsttempted=1;
                currentscore=0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(sheetview);
        bottomSheetDialog.show();
    }
    private void dataview(int currentpos){
        qno.setText("questions Attempted:"+questionsttempted+"/10");
        if(questionsttempted==10)
        {
            scorebottomsheet();
        }
        else
        {
            questionsobj.setText(quizmodelArrayList.get(currentpos).getQuestions());
            option1obj.setText(quizmodelArrayList.get(currentpos).getOption1());
            option2obj.setText(quizmodelArrayList.get(currentpos).getOption2());
            option3obj.setText(quizmodelArrayList.get(currentpos).getOption3());
            option4obj.setText(quizmodelArrayList.get(currentpos).getOption4());
        }


    }
    private void getquizquestions(ArrayList<quizmodel> quizmodelArrayList) {
        quizmodelArrayList.add(new quizmodel("Which one of the following river flows between Vindhyan and Satpura ranges?","Narmada"," Mahanadi","Son","Netravati","Narmada"));
        quizmodelArrayList.add( new quizmodel(" The Central Rice Research Station is situated in?","Chennai","Cuttack"," Bangalore","Quilon","Cuttack"));
        quizmodelArrayList.add( new quizmodel("Who among the following wrote Sanskrit grammar?"," Kalidasa"," Charak"," Panini"," Aryabhatt","Panini"));
        quizmodelArrayList.add( new quizmodel("Which among the following headstreams meets the Ganges in last?"," Alaknanda","Pindar","Mandakini","Bhagirathi","Bhagirathi"));
        quizmodelArrayList.add( new quizmodel("The metal whose salts are sensitive to light is?"," Zinc"," Silver","Copper","Aluminum"," Silver"));
        quizmodelArrayList.add( new quizmodel(" Patanjali is well known for the compilation of –"," Yoga Sutra","Panchatantra"," Ayurveda","Brahma Sutra","Yoga Sutra"));
        quizmodelArrayList.add( new quizmodel("River Luni originates near Pushkar and drains into which one of the following?","Rann of Kachchh"," Arabian Sea"," Gulf of Cambay"," Lake Sambhar","Rann of Kachchh"));
        quizmodelArrayList.add( new quizmodel("Which one of the following rivers originates in Brahmagiri range of Western Ghats?","Pennar","Cauvery","Krishna"," Tapti"," Cauvery"));
        quizmodelArrayList.add( new quizmodel("The country that has the highest in Barley Production?"," China","India"," Russia","France","Russia"));

    }
    }
