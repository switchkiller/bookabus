package com.develop.everest.bookabus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.develop.everest.bookabus.Database.DBhelper;

public class Result extends AppCompatActivity {
    DBhelper my_db;
    EditText Dest,Src,Name,Time,Price;
    Button btn_Add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        my_db = new DBhelper(this);
        Dest = (EditText)findViewById(R.id.Destination);
        Src = (EditText)findViewById(R.id.Source);
        Name = (EditText)findViewById(R.id.Name);
        Time = (EditText)findViewById(R.id.Time);
        Price = (EditText)findViewById(R.id.Price);
        btn_Add = (Button)findViewById(R.id.Add);
        AddData();
    }

    public void AddData(){
        btn_Add.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                if (TextUtils.isEmpty(Dest.getText().toString()) || TextUtils.isEmpty(Src.getText().toString()) || TextUtils.isEmpty(Name.getText().toString()) || TextUtils.isEmpty(Time.getText().toString()) || TextUtils.isEmpty(Price.getText().toString())){
                    Toast.makeText(Result.this,"Error",Toast.LENGTH_LONG).show();
                    return;
                }
                boolean isInserted = my_db.insertData(Dest.getText().toString(),
                        Src.getText().toString(),
                        Name.getText().toString(),
                        Time.getText().toString(),
                        Price.getText().toString());
                if( isInserted == true)
                    Toast.makeText(Result.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Result.this,"Error",Toast.LENGTH_LONG).show();

                Dest.setText("");
                Src.setText("");
                Name.setText("");
                Time.setText("");
                Price.setText("");
            }
        });
    }

}
