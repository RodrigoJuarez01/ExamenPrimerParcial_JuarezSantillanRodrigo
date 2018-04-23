package mx.ipn.cecyt9.examenPrimerParcial_JuarezSantillanRodrigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void validacion(View v){
        EditText usuario = (EditText) findViewById(R.id.txt_usr);
        String usr = usuario.getText().toString();
        EditText contra = (EditText) findViewById(R.id.txt_pass);
        String pass = contra.getText().toString();
        if(usr.equals("rodrigo") && pass.equals("123")){
            Toast toast1 = Toast.makeText(getApplicationContext(),
                            "Correcto", Toast.LENGTH_SHORT);

            toast1.show();
            Intent inicio = new Intent(this, intencion.class);
            startActivity(inicio);
            finish();
        }
        else{
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "InCorrecto", Toast.LENGTH_SHORT);

            toast1.show();
            Intent inici = new Intent(this, fallo.class);
            startActivity(inici);
            finish();
        }
    }
}
