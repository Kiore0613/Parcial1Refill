package com.example.kiore.refil_parcialu1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText edtNumber1, edtNumber2;
    RadioButton rdbS, rdbR, rdbM, rdbD;

    String num1, num2;
    double N1, N2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumber1 = findViewById(R.id.edtNum1);
        edtNumber2 = findViewById(R.id.edtNum2);

        rdbS = findViewById(R.id.rdbSumar);
        rdbR = findViewById(R.id.rdbRestar);
        rdbM = findViewById(R.id.rdbMultiplicar);
        rdbD = findViewById(R.id.rdbDividir);
    }
    public void Calcular(View btnCalcular){

        num1 = edtNumber1.getText().toString().trim();
        num2 = edtNumber2.getText().toString().trim();

        if(TextUtils.isEmpty(num1)){
            edtNumber1.setError("Campo obligatorio");
            edtNumber1.requestFocus();
        }
        else if(TextUtils.isEmpty(num2)){
            edtNumber2.setError("Campo obligatorio");
            edtNumber2.requestFocus();
        }
        else{
            N1 = Double.parseDouble(num1);
            N2 = Double.parseDouble(num2);

            if(rdbS.isChecked()){
                result = N1 + N2;
                edtNumber1.setText(String.valueOf(result));
                edtNumber2.setText("");
                edtNumber2.requestFocus();
            }
            else if(rdbR.isChecked()){
                result = N1 - N2;
                edtNumber1.setText(String.valueOf(result));
                edtNumber2.setText("");
                edtNumber2.requestFocus();
            }
            else if(rdbM.isChecked()){
                if(N2 == 0){
                    edtNumber2.setError("no se puede multiplicar por cero");
                    edtNumber2.setText("");
                    edtNumber2.requestFocus();
                }
                else{
                    result = N1 * N2;
                    edtNumber1.setText(String.valueOf(result));
                    edtNumber2.setText("");
                    edtNumber2.requestFocus();
                }
            }
            else if(rdbD.isChecked()){
                if(N2 == 0){
                    edtNumber2.setError("no se puede dividir entre cero");
                    edtNumber2.setText("");
                    edtNumber2.requestFocus();
                }
                else{
                    result = N1 / N2;
                    edtNumber1.setText(String.valueOf(result));
                    edtNumber2.setText("");
                    edtNumber2.requestFocus();
                }
            }
        }
    }
    public void Limpiar(View btnLimpiar){

        edtNumber1.setText("");
        edtNumber2.setText("");
    }
}
