package devandroid.adenilton.applistacurso.model;

public class Pessoa {

    //Construtor - primeiro passo au criar um nova classe
    //Atributos -- devem ser protegidos
    //Métodos de Acesso - Gets and Sets


    private String primeiroNome;
    private String sobreNome;
    private  String cursoDesejado;
    private String contato;


    public Pessoa(){

    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    // To String

    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", cursoDesejado='" + cursoDesejado + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }
}
