package devandroid.adenilton.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.adenilton.applistacurso.model.Pessoa;
import devandroid.adenilton.applistacurso.view.MainActivity;


public class PessoaController {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";
    private SharedPreferences.Editor listaVip;

    public PessoaController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString(){
        Log.d("MVC_Controller","Controller iniciada");

        return super.toString();
    }


    public void salvar(Pessoa pessoa) {
        Log.i("MVC_Controller", "Salvo"+pessoa.toString());

        listaVip.putString("primeiroNome",pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome",pessoa.getSobreNome());
        listaVip.putString("cursoDesejado",pessoa.getCursoDesejado());
        listaVip.putString("contato",pessoa.getContato());
        listaVip.apply();

    }

    public Pessoa buscar(Pessoa pessoa){

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome",""));
        pessoa.setSobreNome(preferences.getString("sobreNome",""));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado",""));
        pessoa.setContato(preferences.getString("contato",""));

        return pessoa;

    }

    public void limpar(){

        listaVip.clear();
        listaVip.apply();
    }
}
