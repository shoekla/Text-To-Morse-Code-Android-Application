package com.example.shukla14.texttomorsecode;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.View;
import android.widget.ImageButton;

import static java.lang.Thread.sleep;

public class flash extends AppCompatActivity {
    TextView titleText;
    TextView transText;
    String textFromUser;
    String textAlreadyTrans;
    public static Camera cam = null;
    //flag to detect flash is on or off
    private Camera camera;
    ImageButton flashlightSwitchImg;
    Parameters params;
    Button backButton;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Bundle userGivenText = getIntent().getExtras();
        textFromUser = userGivenText.getString("text");
        titleText = (TextView) findViewById(R.id.titleTrans);
        transText = (TextView) findViewById(R.id.transText);
        backButton = (Button) findViewById(R.id.button);
        textAlreadyTrans = "";
        titleText.setText("Translated");
        boolean isCameraFlash = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!isCameraFlash) {
            showNoCameraAlert();
        } else {
            camera = Camera.open();
            params = camera.getParameters();
        }
        transText.setText(textAlreadyTrans);
        startTranslation();


    }
    public void startTranslation () {
        for (int i = 0; i < textFromUser.length(); i++) {
            textAlreadyTrans = textAlreadyTrans + textFromUser.charAt(i);
            translateToMorse(textFromUser.charAt(i));
            transText.setText(textAlreadyTrans);
        }
    }
    private void showNoCameraAlert(){
        new AlertDialog.Builder(this)
                .setTitle("Error: No Camera Flash!")
                .setMessage("Camera flashlight not available in this Android device!")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); // close the Android app
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
        return;
    }
    private void setFlashlightOn() {
        params = camera.getParameters();
        params.setFlashMode(Parameters.FLASH_MODE_TORCH);
        camera.setParameters(params);
        camera.startPreview();
    }

    private void setFlashlightOff() {
        params.setFlashMode(Parameters.FLASH_MODE_OFF);
        camera.setParameters(params);
        camera.stopPreview();
    }
    public void shortFlash(){
        setFlashlightOn();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setFlashlightOff();
    }
    public void longFlash() {
        setFlashlightOn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setFlashlightOff();
    }
    public void backT(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void translateToMorse(char c) {
        switch (c) {
            case 'a':
                shortFlash();
                longFlash();
                break;
            case 'b':
                longFlash();
                shortFlash();
                shortFlash();
                shortFlash();
                break;
            case 'c':
                longFlash();
                shortFlash();
                longFlash();
                shortFlash();
                break;
            case 'd':
                longFlash();
                shortFlash();
                shortFlash();
                break;
            case 'e':
                shortFlash();
                break;
            case 'f':
                shortFlash();
                shortFlash();
                longFlash();
                shortFlash();
                break;
            case 'g':
                longFlash();
                longFlash();
                shortFlash();
                break;
            case 'h':
                shortFlash();
                shortFlash();
                shortFlash();
                shortFlash();
                break;
            case 'i':
                shortFlash();
                shortFlash();
                break;
            case 'j':
                shortFlash();
                longFlash();
                longFlash();
                longFlash();
                break;
            case 'k':
                longFlash();
                shortFlash();
                longFlash();
                break;
            case 'l':
                shortFlash();
                longFlash();
                shortFlash();
                shortFlash();
                break;
            case 'm':
                longFlash();
                longFlash();
                break;
            case 'n':
                longFlash();
                shortFlash();
                break;
            case 'o':
                longFlash();
                longFlash();
                longFlash();
                break;
            case 'p':
                shortFlash();
                longFlash();
                longFlash();
                shortFlash();
                break;
            case 'q':
                longFlash();
                longFlash();
                shortFlash();
                longFlash();
                break;
            case 'r':
                shortFlash();
                longFlash();
                shortFlash();
                break;
            case 's':
                shortFlash();
                shortFlash();
                shortFlash();
                break;
            case 't':
                longFlash();
                break;
            case 'u':
                shortFlash();
                shortFlash();
                longFlash();
                break;
            case 'v':
                shortFlash();
                shortFlash();
                shortFlash();
                longFlash();
                break;
            case 'w':
                shortFlash();
                longFlash();
                longFlash();
                break;
            case 'x':
                longFlash();
                shortFlash();
                shortFlash();
                longFlash();
                break;
            case 'y':
                longFlash();
                shortFlash();
                longFlash();
                longFlash();
                break;
            case 'z':
                longFlash();
                longFlash();
                shortFlash();
                shortFlash();
                break;
            default:
                break;
        }
    }

}
