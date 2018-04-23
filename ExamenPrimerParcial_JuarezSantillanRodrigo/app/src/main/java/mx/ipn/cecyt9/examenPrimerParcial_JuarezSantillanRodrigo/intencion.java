package mx.ipn.cecyt9.examenPrimerParcial_JuarezSantillanRodrigo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class intencion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_int);
    }

    public void abrirPaginaWeb(View paginaWeb)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://drakebell.com/"));
        startActivity(intent);
    }

    public void llamadaTelefono(View llamada)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:5563190817"));
        startActivity(intent);
    }

    public void googleMaps(View maps)
    {
        Uri ubicacion = Uri.parse("google.streetview:cbll=19.6023113,-99.19135289999997");
        Intent mapa = new Intent(Intent.ACTION_VIEW, ubicacion);
        mapa.setPackage("com.google.android.apps.maps");
        startActivity(mapa);
    }

    public void tomarFoto(View maps)
    {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    public void mandarCorreo(View correo)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Examen");
        intent.putExtra(Intent.EXTRA_TEXT, "Examen Alexis");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "eoropezag@ipn.mx"} );
        startActivity(intent);
    }
    public void reserva(View res)
    {
        Intent inicio = new Intent(this, res.class);
        startActivity(inicio);
        finish();
    }
    public void calcu(View cal)
    {///
        Intent inicio = new Intent(this, calcula.class);
        startActivity(inicio);
        finish();
    }

}
