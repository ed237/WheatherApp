package org.esiea.kamgaing_ascar.weatherapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    public static EditText editText1;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.button = (Button) findViewById(R.id.button1);
        this.editText1 = (EditText) findViewById(R.id.text1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText1.length() < 5)  {
                    Toast.makeText(getApplicationContext(), R.string.toast1, Toast.LENGTH_SHORT).show();
                }
                else if (editText1.length() > 8){
                    Toast.makeText(getApplicationContext(), R.string.toast2, Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent otherActivity = new Intent(getApplicationContext(), Weather.class);
                    startActivity(otherActivity);
                    finish();
                }


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item1:

                PackageManager pm=getPackageManager();

                try {
                    Intent intent = pm.getLaunchIntentForPackage("com.google.android.apps.maps");
                    startActivity(intent);
                }
                catch(Exception e) {
                    showDialog(10);


                }
                return true;

            case R.id.item2:

                String text3 = getString(R.string.toast4);
                Toast.makeText(getApplicationContext(), text3 , Toast.LENGTH_LONG).show();

                return true;
           // startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Londre")));
        }
        return super.onOptionsItemSelected(item);
    }
}
