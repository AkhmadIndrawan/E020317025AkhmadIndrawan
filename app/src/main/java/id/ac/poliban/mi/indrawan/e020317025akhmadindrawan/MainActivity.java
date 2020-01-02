package id.ac.poliban.mi.indrawan.e020317025akhmadindrawan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView switchStatus;
    private Switch mySwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    private void initComponents() {
        Switch switch1 = findViewById(R.id.switch1);
        EditText etNim = findViewById(R.id.etNim);
        EditText etNama = findViewById(R.id.etNama);
        EditText etAlamat = findViewById(R.id.etAlamat);
        EditText etTelepon = findViewById(R.id.etTelepon);
        RadioButton rbLakiLaki = findViewById(R.id.rbLakiLaki);
        RadioButton rbPerempuan = findViewById(R.id.rbPerempuan);
        Button btClear = findViewById(R.id.btClear);
        Button btSubmit = findViewById(R.id.btSubmit);

        btClear.setOnClickListener(view ->{
            etNim.setText("");
            etNama.setText("");
            etAlamat.setText("");
            etTelepon.setText("");
            rbLakiLaki.setText("");
            rbPerempuan.setText("");
            etNim.requestFocus();
        });

        btSubmit.setOnClickListener((v -> {
            String gender = "";
            if(rbLakiLaki.isChecked()){
                gender+= "Laki-laki";
            }
            if(rbPerempuan.isChecked()){
                gender+= "Perempuan";
            }
            new AlertDialog.Builder(this)
                    .setTitle("Info Registrasi")
                    .setMessage("Nim: " + etNim.getText() + "\n"
                    + "Nama: " + etNama.getText() + "\n"
                            + "Gender"+gender.toString()+ "\n"
                    + "Alamat: " + etAlamat.getText() + "\n"
                    + "Telepon: " + etTelepon.getText() + "\n")
                    .setNegativeButton("Cancel", null)
                    .setPositiveButton("Ok", null).show();
        }));

        switchStatus = (TextView) findViewById(R.id.switch1);
        mySwitch = (Switch) findViewById(R.id.switch1);

        //set the switch to ON
        mySwitch.setChecked(true);
        //attach a listener to check for changes in state
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (mySwitch.isChecked()) {
                    etNim.setEnabled(true);
                    etNama.setEnabled(true);
                    rbLakiLaki.setEnabled(true);
                    rbPerempuan.setEnabled(true);
                    etAlamat.setEnabled(true);
                    etTelepon.setEnabled(true);
                    btClear.setEnabled(true);
                    btSubmit.setEnabled(true);
                } else {
                    etNim.setEnabled(false);
                    etNama.setEnabled(false);
                    rbLakiLaki.setEnabled(false);
                    rbPerempuan.setEnabled(false);
                    etAlamat.setEnabled(false);
                    etTelepon.setEnabled(false);
                    btClear.setEnabled(false);
                    btSubmit.setEnabled(false);
                }

            }
        });

    }
}
