package mx.ipn.cecyt9.examenPrimerParcial_JuarezSantillanRodrigo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Alexis on 15/04/2018.
 */

public class fallo  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_falla);

    }
    public void falla(View v){
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
        finish();
    }
}
