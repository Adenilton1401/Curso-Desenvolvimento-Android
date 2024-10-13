package devandroid.adenilton.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.adenilton.applistacurso.model.Curso;

public class CursoController {

    private List listCursos;

    public List getListaDeCursos(){

        listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso("Java")); //Java
        listCursos.add(new Curso("HTML")); //C#
        listCursos.add(new Curso("Python")); //C++
        listCursos.add(new Curso("PHP"));
        listCursos.add(new Curso("MySQL"));


        return listCursos;

    }
}
