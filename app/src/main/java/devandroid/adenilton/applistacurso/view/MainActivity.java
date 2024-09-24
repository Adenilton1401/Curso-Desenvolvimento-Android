package devandroid.adenilton.applistacurso.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.adenilton.applistacurso.R;
import devandroid.adenilton.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    private EditText editPrimeiroNome;
    private EditText editSobrenome;
    private EditText editCurso;
    private EditText editContato;
    private Button btnLimpar;
    private Button btnSalvar;
    private Button btnFinalizar;
    Pessoa pessoa;
    Pessoa outraPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pessoa = new Pessoa();

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Elane");
        outraPessoa.setSobreNome("Morais");
        outraPessoa.setCursoDesejado("Android");
        outraPessoa.setContato("96 99992255");



        inicicarComponentesDoLayout();
        monstrarNaTela(outraPessoa);
    }

    private void monstrarNaTela(Pessoa pessoa) {
        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editCurso.setText(pessoa.getCursoDesejado());
        editContato.setText(pessoa.getContato());
    }

    private void inicicarComponentesDoLayout() {
        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCurso = findViewById(R.id.editCurso);
        editContato = findViewById(R.id.editContato);


        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editCurso.setText("");
                editContato.setText("");

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobrenome.getText().toString());
                pessoa.setCursoDesejado(editCurso.getText().toString());
                pessoa.setContato(editContato.getText().toString());

                Toast.makeText(MainActivity.this,"Salvo"+pessoa.toString(), Toast.LENGTH_LONG).show();


            }
        });

    }


}