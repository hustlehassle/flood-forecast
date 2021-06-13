MainActivity.java
package bulusan.com.a2dbulusanfloodforecasting;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder builder, floodRules;
    Spinner spinner, spinner1, spinner2;
    ArrayAdapter<CharSequence> zone, time, intensity;
    TextView info, warning1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PhotoView photoView = (PhotoView) findViewById(R.id.map);
        photoView.setImageResource(R.drawable.bulusan);


        final ImageView flood = (ImageView) findViewById(R.id.img_flood);
        flood.setAlpha(100);
        flood.setVisibility(View.GONE);

        final ImageView flood1 = (ImageView) findViewById(R.id.img_flood1);
        flood1.setAlpha(100);
        flood1.setVisibility(View.GONE);

        info = (TextView) findViewById(R.id.txt_information);
        info.setGravity(Gravity.CENTER);
        info.setTextSize(18);

        //Spinner for Zone
        spinner = (Spinner) findViewById(R.id.spn_zone);
        zone = ArrayAdapter.createFromResource(this, R.array.array_zone, android.R.layout.simple_spinner_item);
        zone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(zone);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    info.setText("Please select zone.");
                }else if(position == 1){
                    info.setText(R.string.zone1_info);
                    info.setBackgroundColor(Color.parseColor("#FFC0CB"));
                } else if(position == 2){
                    info.setText(R.string.zone2_info);
                    info.setBackgroundColor(Color.parseColor("#6495ED"));
                } else if(position == 3){
                    info.setText(R.string.zone3_info);
                    info.setBackgroundColor(Color.parseColor("#90EE90"));
                } else if(position == 4){
                    info.setText(R.string.zone4_info);
                    info.setBackgroundColor(Color.parseColor("#EE82EE"));
                } else if(position == 5){
                    info.setText(R.string.zone5_info);
                    info.setBackgroundColor(Color.parseColor("#F0E68C"));
                } else if(position == 6){
                    info.setText(R.string.zone6_info);
                    info.setBackgroundColor(Color.parseColor("#40E0D0"));
                } else if(position == 7){
                    info.setText(R.string.zone7_info);
                    info.setBackgroundColor(Color.parseColor("#D3D3D3"));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Spinner for Rain Duration
        spinner1 = (Spinner) findViewById(R.id.spn_duration);
        time = ArrayAdapter.createFromResource(this, R.array.array_duration, android.R.layout.simple_spinner_item);
        time.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(time);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    intensity = ArrayAdapter.createFromResource(MainActivity.this, R.array.select, android.R.layout.simple_spinner_item);
                    intensity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(intensity);
                }else if(position == 1){
                    intensity = ArrayAdapter.createFromResource(MainActivity.this, R.array.one, android.R.layout.simple_spinner_item);
                    intensity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(intensity);
                    flood.getLayoutParams().height = 100;
                    flood.getLayoutParams().width = 100;
                    flood1.getLayoutParams().height = 100;
                    flood1.getLayoutParams().width = 100;
                } else if(position == 2){
                    intensity = ArrayAdapter.createFromResource(MainActivity.this, R.array.three, android.R.layout.simple_spinner_item);
                    intensity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(intensity);
                    flood.getLayoutParams().height = 100 * 2;
                    flood.getLayoutParams().width = 100 * 2;
                    flood1.getLayoutParams().height = 100 * 2;
                    flood1.getLayoutParams().width = 100 * 2;
                } else if(position == 3){
                    intensity = ArrayAdapter.createFromResource(MainActivity.this, R.array.six, android.R.layout.simple_spinner_item);
                    intensity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(intensity);
                    flood.getLayoutParams().height = 100 * 3;
                    flood.getLayoutParams().width = 100 * 3;
                    flood1.getLayoutParams().height = 100 * 3;
                    flood1.getLayoutParams().width = 100 * 3;
                } else if(position == 4){
                    intensity = ArrayAdapter.createFromResource(MainActivity.this, R.array.twelve, android.R.layout.simple_spinner_item);
                    intensity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(intensity);
                    flood.getLayoutParams().height = 100 * 4;
                    flood.getLayoutParams().width = 100 * 4;
                    flood1.getLayoutParams().height = 100 * 4;
                    flood1.getLayoutParams().width = 100 * 4;
                } else if(position == 5){
                    intensity = ArrayAdapter.createFromResource(MainActivity.this, R.array.twentyfour, android.R.layout.simple_spinner_item);
                    intensity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(intensity);
                    flood.getLayoutParams().height = 100 * 5;
                    flood.getLayoutParams().width = 100 * 5;
                    flood1.getLayoutParams().height = 100 * 5;
                    flood1.getLayoutParams().width = 100 * 5;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Spinner for Intensity
        spinner2 = (Spinner) findViewById(R.id.spn_intensity);
        intensity = ArrayAdapter.createFromResource(this, R.array.select, android.R.layout.simple_spinner_item);
        intensity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(intensity);
        spinner2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (spinner1.getSelectedItem().toString().contains("Select")) {
                    Toast.makeText(MainActivity.this, "Select Duration first.", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

        LayoutInflater inflater = getLayoutInflater();

        //Toast layout
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.toast));

        warning1 = (TextView) layout.findViewById(R.id.txt_toast);
        warning1.setMovementMethod(LinkMovementMethod.getInstance());
        warning1.setGravity(Gravity.CENTER);
        warning1.setTextSize(18);
        warning1.setHeight(180);
        warning1.setCompoundDrawablePadding(5);

        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP | Gravity.FILL_HORIZONTAL, 0, 0);
        toast.setView(layout);

        //Alert Dialog for Flood Safety Rules
        floodRules = new AlertDialog.Builder(MainActivity.this);
        floodRules.setCancelable(true);
        floodRules.setTitle("FLOOD SAFETY RULES");
        floodRules.setMessage(R.string.flood_rules);
        floodRules.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        //Alert Dialog After Clicking Start
        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                floodRules.show();
                dialog.cancel();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                toast.cancel();
            }
        });

        final CountDownTimer cd = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                toast.show();
            }

            @Override
            public void onFinish() {
                toast.cancel();
            }
        };

        final Button start = (Button) findViewById(R.id.btn_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(spinner.getSelectedItem().toString().contains("Select") || spinner1.getSelectedItem().toString().contains("Select") || spinner2.getSelectedItem().toString().contains("Select")){
                    Toast.makeText(MainActivity.this, "Please select valid item.", Toast.LENGTH_SHORT).show();
                } else if(spinner2.getSelectedItem().toString().contains("Light")){
                    cd.start();
                    builder.setTitle(R.string.lightTitle);
                    builder.setMessage(R.string.infoLight);
                    builder.show();
                    warning1.setText(R.string.light);
                    warning1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.yellow, 0, 0, 0);
                    warning1.setBackgroundColor(Color.YELLOW);
                    flood.setVisibility(View.VISIBLE);
                    flood1.setVisibility(View.VISIBLE);
                } else if(spinner2.getSelectedItem().toString().contains("Moderate")){
                    cd.start();
                    builder.setTitle(R.string.moderateTitle);
                    builder.setMessage(R.string.infoModerate);
                    builder.show();
                    warning1.setText(R.string.moderate);
                    warning1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.orange, 0, 0, 0);
                    warning1.setBackgroundColor(0xFFF06D2F);
                    flood.setVisibility(View.VISIBLE);
                    flood1.setVisibility(View.VISIBLE);
                } else if(spinner2.getSelectedItem().toString().contains("Heavy")){
                    cd.start();
                    builder.setTitle(R.string.heavyTitle);
                    builder.setMessage(R.string.infoHeavy);
                    builder.show();
                    warning1.setText(R.string.heavy);
                    warning1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.red, 0, 0, 0);
                    warning1.setBackgroundColor(Color.RED);
                    flood.setVisibility(View.VISIBLE);
                    flood1.setVisibility(View.VISIBLE);
                }

            }
        });

}
}
