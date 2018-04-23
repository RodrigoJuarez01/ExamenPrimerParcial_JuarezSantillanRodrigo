package mx.ipn.cecyt9.examenPrimerParcial_JuarezSantillanRodrigo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class calcula extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
    }
    public void onClickUno(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "1");
    }
    public void onClickDos(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "2");
    }
    public void onClickTres(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "3");
    }
    public void onClickCuatro(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "4");
    }
    public void onClickCinco(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "5");
    }
    public void onClickSeis(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "6");
    }
    public void onClickSiete(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "7");
    }
    public void onClickOcho(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "8");
    }
    public void onClickNueve(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "9");
    }
    public void onClickCero(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "0");
    }
    public void onClickPunto(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + ".");
    }
    public void onClickLimpia(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText("");
    }

    public void onClickSuma(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "+");
    }
    public void onClickResta(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "-");
    }
    public void onClickMultiplicacion(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "*");
    }
    public void onClickDivision(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "/");
    }
    public void onClickSeno(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "L");
    }

    public void onClickCoseno(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "π");
    }

    public void onClickTangente(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "%");
    }
    public void onClickCuadrado(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "^");
    }
    public void onClickRaiz(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.resultados) ;
        tv.setText(tv.getText() + "√");
    }
    public void onClickIgual(View miView)
    {
        try{
            TextView tv = (TextView) findViewById(R.id.resultados) ;
            tv.setText(eval(tv.getText().toString())+ "");
        }catch (Exception e){
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "Operacion Incorrecta", Toast.LENGTH_SHORT);

            toast1.show();
        }
    }
    public double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }


            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // suma
                    else if (eat('-')) x -= parseTerm(); // resta
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplicacion
                    else if (eat('/')) x /= parseFactor(); // division
                    else if (eat('%')) x %= parseFactor(); // modulo
                    else return x;
                }
            }

            double parseFactor() {

                double x;
                int startPos = this.pos;
                 if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // cuadrado
                if (eat('√')) x = Math.sqrt(x); // raiz
                if (eat('L')) x = Math.log(x); //LOG
                if (eat('π')) x = Math.PI * x; //PI

                return x;
            }
        }.parse();
    }



}
