package br.com.srbit.entities;

import br.com.srbit.enumeration.SemestreEnum;

public class Discipline {
    private String name;
    private Teacher teacher;
    private SemestreEnum semestre;

    public Discipline(String name, Teacher teacher, SemestreEnum semestre) {
        this.name = name;
        this.teacher = teacher;
        this.semestre = semestre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public SemestreEnum getSemestre() {
        return semestre;
    }

    public void setSemestre(SemestreEnum semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "name='" + name;
    }
}
