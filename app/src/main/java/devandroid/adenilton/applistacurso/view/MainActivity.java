package devandroid.adenilton.applistacurso.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.adenilton.applistacurso.R;
import devandroid.adenilton.applistacurso.controller.PessoaController;
import devandroid.adenilton.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    private EditText editPrimeiroNome;
    private EditText editSobrenome;
    private EditText editCurso;
    private EditText editContato;
    Pessoa pessoa;
    PessoaController pessoaController;


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

        inicicarComponentesDoLayout();

        pessoaController = new PessoaController(MainActivity.this);

       pessoaController.buscar(pessoa);

        monstrarNaTela(pessoa);
    }//Fim onCreate

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


        Button btnLimpar = findViewById(R.id.btnLimpar);
        Button btnSalvar = findViewById(R.id.btnSalvar);
        Button btnFinalizar = findViewById(R.id.btnFinalizar);

        btnLimpar.setOnClickListener(view -> {
            editPrimeiroNome.setText("");
            editSobrenome.setText("");
            editCurso.setText("");
            editContato.setText("");

            pessoaController.limpar();

        });

        btnFinalizar.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
            finish();

        });

        btnSalvar.setOnClickListener(view -> {
            pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
            pessoa.setSobreNome(editSobrenome.getText().toString());
            pessoa.setCursoDesejado(editCurso.getText().toString());
            pessoa.setContato(editContato.getText().toString());

            Toast.makeText(MainActivity.this,
                    "Salvo" + pessoa.toString(), Toast.LENGTH_LONG).show();

            pessoaController.salvar(pessoa);



        });

    }


}