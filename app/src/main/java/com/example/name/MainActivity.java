package com.example.name;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button show;
    EditText write;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show=findViewById(R.id.show);
        write=findViewById(R.id.write);
        name=findViewById(R.id.name);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                class Divider {
                    String name="Имена:";
                    String surname="Фамилии:";
                    String patronymic="Отчества:";

                    String divider() {
                        String str = write.getText().toString();
                        String word = "";
                        int u = 0;
                        for (int i = 0; i < str.length(); i++) {
                            String tex = Character.toString(str.charAt(i));
                            if (tex.equals(" ")) {
                                u++;
                                if (u == 1) {
                                    surname = surname+" "+word ;
                                    word="";
                                }
                                if (u == 2) {
                                    name = name+" "+word;
                                    word="";
                                }
                                if (u == 3) {
                                    patronymic = patronymic+" "+word ;
                                    word="";
                                    u = 0;
                                }
                            } else {
                                word = word + tex;
                            }

                        }
                        String all=name+"\n"+surname+"\n"+patronymic+" "+word;
                        return all;
                    }

                }
                Divider d=new Divider();
                name.setText(d.divider());
            }
        });
    }
}

