package id.sch.smktelkom_mlg.tugas01.xiirpl1004.formordershopie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton RBI, RBS, RBA;
    EditText idnumb, ref;
    TextView tvhasil;
    RadioGroup RG;
    CheckBox CBB, CBW, CBP;
    Spinner JumlahOrder;
    Button OK;

    boolean requestBackground = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        idnumb = (EditText) findViewById(R.id.editTextID);
        ref = (EditText) findViewById(R.id.editTextRef);
        RG = (RadioGroup) findViewById(R.id.radioGroupKategori);

        RBI = (RadioButton) findViewById(R.id.radioButtonI);
        RBS = (RadioButton) findViewById(R.id.radioButtonS);
        RBA = (RadioButton) findViewById(R.id.radioButtonA);

        CBB = (CheckBox) findViewById(R.id.checkBoxB);
        CBW = (CheckBox) findViewById(R.id.checkBoxW);
        CBP = (CheckBox) findViewById(R.id.checkBoxPK);
        OK = (Button) findViewById(R.id.buttonOK);


        JumlahOrder = (Spinner) findViewById(R.id.spinnerJ);

        tvhasil = (TextView) findViewById(R.id.textViewHasil);
        JumlahOrder = (Spinner) findViewById(R.id.spinnerJ);


        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Button OK KLIK!
                if (idnumb.getText().toString().isEmpty()) {
                    idnumb.setError("Nama harus diisi!");
                } else {
                    doKlik();
                    Toast.makeText(getApplicationContext(), "Terima kasih sudah order!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void doKlik() {


        StringBuilder builder = new StringBuilder();
        builder.append("ID Pemesan : ").append(idnumb.getText()).append("\n");
        int jum = Integer.parseInt(JumlahOrder.getSelectedItem().toString());

        String kategori = null;
        if (RBI.isChecked()) {
            kategori = RBI.getText().toString();

        } else if (RBS.isChecked()) {
            kategori = RBS.getText().toString();
        } else if (RBA.isChecked()) {
            kategori = RBA.getText().toString();
        }

        builder.append("Kategori  : ").append(kategori).append("\n");

        builder.append("Fasilitas pengiriman : ").append("\n");
        if (CBB.isChecked()) {
            builder.append("\t Box").append("\n");

        }
        if (CBW.isChecked()) {
            builder.append("\t Waterresist: ").append("\n");

        }
        if (CBP.isChecked()) {
            builder.append("\t Peti kemas").append("\n");

        }

        builder.append("Jumlah Order : ").append(jum).append("\n");

        builder.append("Harga        : ").append("\n");

        tvhasil.setText(builder);
    }
}

