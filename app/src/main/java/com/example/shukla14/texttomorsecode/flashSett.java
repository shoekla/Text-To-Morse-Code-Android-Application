package com.example.shukla14.texttomorsecode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class flashSett extends AppCompatActivity {
    Button subButton;
    EditText longLen;
    EditText shortLen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_sett);
        subButton = (Button) findViewById(R.id.subButton);
        longLen = (EditText) findViewById(R.id.longLen);
        shortLen = (EditText) findViewById(R.id.shortLen);
        longLen.setHint("Enter Long Length (Current: "+flashData.longLength+" milliS.)");
        shortLen.setHint("Enter Short Length (Current: "+flashData.shortLength+" milliS.)");
    }
    public void changeT(View view) {
        int l = Integer.parseInt(longLen.getText().toString());
        int s = Integer.parseInt(shortLen.getText().toString());
        flashData.setLongLength(l);
        flashData.setShortLength(s);
        Intent m = new Intent(this, MainActivity.class);
        Toast.makeText(this, "Timings Changed!", Toast.LENGTH_SHORT).show();
        startActivity(m);
    }
}
