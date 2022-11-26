package com.example.cadastroaluno.controller;

import com.example.cadastroaluno.controller.model.Aluno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlunoController {

    private List<Aluno> alunos = new java.util.ArrayList<>(List.of(new Aluno("Wanderson", 45), new Aluno("Stephany", 24)));

    @GetMapping(value = "/alunos")
    public List<Aluno> getAlunos(){
        return alunos;
    }

    @GetMapping(value = "/alunos/{id}")
    public Aluno getAlunoById(@PathVariable Long id){
        if( id.equals(1L)){
            return alunos.get(0);
        }
        return alunos.get(1);
    }


    @GetMapping(value = "/alunos/filter")
    public Aluno getAlunoFilter(@RequestParam Long id){
        if( id.equals(1L)){
            return alunos.get(0);
        }
        return alunos.get(1);
    }

    @PostMapping(value = "/alunos")
    public Aluno getAlunoFilter(@RequestBody Aluno aluno){
        alunos.add(aluno);
        return aluno;
    }

}
