package br.com.srbit;

import br.com.srbit.entities.Discipline;
import br.com.srbit.entities.Teacher;
import br.com.srbit.enumeration.SemestreEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // POPULATION INITIAL
        System.out.print("Entre com a quantidade da population: ");
        int quant_pop = scanner.nextInt();

        ArrayList<Integer> notes = new ArrayList<Integer>();
        ArrayList<ArrayList<Discipline>> population = generatePopulation(quant_pop);

        ArrayList<ArrayList<Discipline>> populationRanked = new ArrayList<>();

        // POPULATION RANKED CRESCENT
        for(ArrayList<Discipline> disciplines: population){
            notes.add(assessmentIndividual(disciplines));
        }

        Collections.sort(notes);
        for(int note: notes){
            for(ArrayList<Discipline> disciplines: population){
                if(assessmentIndividual(disciplines) == note){
                    populationRanked.add(disciplines);
                }
            }
        }





        for(ArrayList<Discipline> disciplines: populationRanked){
            System.out.println(assessmentIndividual(disciplines));
        }
    }

    public static int assessmentIndividual(ArrayList<Discipline> array){
        int count = 0;

        for( int h = 0; h < array.size(); h++ )
            for( int i = h + 10; i < array.size(); i += 10)
                if(array.get(h).getTeacher().equals(array.get(i).getTeacher()))
                    count ++;
        return count;
    }

    public static ArrayList<ArrayList<Discipline>> generatePopulation(int quant_pop){
        //PROFESSORES
        Teacher t_bruno = new Teacher("Bruno Queiroz Pinto");
        Teacher t_camilo = new Teacher("Camilo de Lellis Barreto Junior");
        Teacher t_carlos_eduardo = new Teacher("Carlos Eduardo de Carvalho");
        Teacher t_calors_magno = new Teacher("Carlos Magno Medeiro Queiroz");
        Teacher t_clarimundo = new Teacher("Clarimundo Machado Moraes Junior");
        Teacher t_cricia = new Teacher("Crícia Zilda Felício Paixão");
        Teacher t_angoti = new Teacher("Edson Angoti Junior");
        Teacher t_jose = new Teacher("Jose Carlos de Castro Junior");
        Teacher t_ricardo = new Teacher("Ricardo Soares Bôaventura ");
        Teacher t_samira = new Teacher("Samira Daura Botelho");
        Teacher t_wilton = new Teacher("Wilton de Paula Filho");

        //DISCIPLINAS
        Discipline dis_fundamentos = new Discipline("Fundamentos de Sistemas Para Internet", t_camilo, SemestreEnum.PRIMEIRO);
        Discipline dis_logica  = new Discipline("Lógica de Programação", t_bruno, SemestreEnum.PRIMEIRO);
        Discipline dis_requisitos = new Discipline("Requisitos", t_angoti, SemestreEnum.PRIMEIRO);
        Discipline dis_empreendorismo = new Discipline("Empreendedorismo", t_jose, SemestreEnum.PRIMEIRO);
        Discipline dis_web_static = new Discipline("Projeto Website Estático", t_wilton, SemestreEnum.PRIMEIRO);

        Discipline dis_algoritos = new Discipline("ALGORITMOS E PROGRAMAÇÃO", t_bruno, SemestreEnum.SEGUNDO);
        Discipline dis_fundamentos_db = new Discipline("FUNDAMENTOS DE BANCO DE DADOS", t_cricia, SemestreEnum.SEGUNDO);
        Discipline dis_js_basico = new Discipline("JAVASCRIPT BÁSICO", t_wilton, SemestreEnum.SEGUNDO);
        Discipline dis_poo1 = new Discipline("PROGRAMAÇÃO ORIENTADA A OBJETOS 1", t_clarimundo, SemestreEnum.SEGUNDO);
        Discipline dis_mvc = new Discipline("PROJETO SISTEMA WEB MVC E SQL", t_angoti, SemestreEnum.SEGUNDO);

        Discipline dis_bd_avancado = new Discipline("Banco de Dados Avançado", t_cricia, SemestreEnum.TERCEIRO);
        Discipline dis_poo2 = new Discipline("Programação Orientada a Objetos 2", t_carlos_eduardo, SemestreEnum.TERCEIRO);
        Discipline dis_back_end_monolito = new Discipline("Projeto Back-end Monolítico Com Orm", t_angoti, SemestreEnum.TERCEIRO);
        Discipline dis_front_end = new Discipline("Projeto Front-end Web Javascript", t_wilton, SemestreEnum.TERCEIRO);
        Discipline dis_teste = new Discipline("Testes Automatizados", t_bruno, SemestreEnum.TERCEIRO);

        Discipline dis_db_nosql = new Discipline("BANCO DE DADOS NOSQL", t_camilo, SemestreEnum.QUARTO);
        Discipline dis_ihc = new Discipline("INTERFACE HUMANO-COMPUTADOR", t_wilton, SemestreEnum.QUARTO);
        Discipline dis_app_mobile = new Discipline("PROJETO APLICAÇÃO PARA DISPOSITIVOS MÓVEIS", t_angoti, SemestreEnum.QUARTO);
        Discipline dis_back_nosql = new Discipline("PROJETO BACK-END MICROSSERVIÇOS E NOSQL", t_camilo, SemestreEnum.QUARTO);
        Discipline dis_sistemas_distribuidos = new Discipline("SISTEMAS DISTRIBUÍDOS", t_carlos_eduardo, SemestreEnum.QUARTO);

        Discipline dis_libras = new Discipline("Libras", t_samira, SemestreEnum.QUINTO);
        Discipline dis_topicos = new Discipline("Tópicos Especiais 1", t_ricardo, SemestreEnum.QUINTO);
        Discipline dis_ic = new Discipline("Inteligência Computacional", t_clarimundo, SemestreEnum.QUINTO);
        Discipline dis_monografia = new Discipline("Produção de Relatório, Artigo e Monografia", t_calors_magno, SemestreEnum.QUINTO);
        Discipline dis_seguranca = new Discipline("Segurança em Sistemas Para Internet", t_camilo, SemestreEnum.QUINTO);

        ArrayList<Discipline> p_primeiro = new ArrayList<>();
        ArrayList<Discipline> p_segundo = new ArrayList<>();
        ArrayList<Discipline> p_terceiro = new ArrayList<>();
        ArrayList<Discipline> p_quarto = new ArrayList<>();
        ArrayList<Discipline> p_quinto = new ArrayList<>();

        p_primeiro.add(dis_fundamentos);
        p_primeiro.add(dis_logica);
        p_primeiro.add(dis_requisitos);
        p_primeiro.add(dis_empreendorismo);
        p_primeiro.add(dis_web_static);
        p_primeiro.add(dis_fundamentos);
        p_primeiro.add(dis_logica);
        p_primeiro.add(dis_requisitos);
        p_primeiro.add(dis_empreendorismo);
        p_primeiro.add(dis_web_static);

        p_segundo.add(dis_algoritos);
        p_segundo.add(dis_fundamentos_db);
        p_segundo.add(dis_js_basico);
        p_segundo.add(dis_poo1);
        p_segundo.add(dis_mvc);
        p_segundo.add(dis_algoritos);
        p_segundo.add(dis_fundamentos_db);
        p_segundo.add(dis_js_basico);
        p_segundo.add(dis_poo1);
        p_segundo.add(dis_mvc);

        p_terceiro.add(dis_bd_avancado);
        p_terceiro.add(dis_poo2);
        p_terceiro.add(dis_back_end_monolito);
        p_terceiro.add(dis_front_end);
        p_terceiro.add(dis_teste);
        p_terceiro.add(dis_bd_avancado);
        p_terceiro.add(dis_poo2);
        p_terceiro.add(dis_back_end_monolito);
        p_terceiro.add(dis_front_end);
        p_terceiro.add(dis_teste);

        p_quarto.add(dis_db_nosql);
        p_quarto.add(dis_ihc);
        p_quarto.add(dis_app_mobile);
        p_quarto.add(dis_back_nosql);
        p_quarto.add(dis_sistemas_distribuidos);
        p_quarto.add(dis_db_nosql);
        p_quarto.add(dis_ihc);
        p_quarto.add(dis_app_mobile);
        p_quarto.add(dis_back_nosql);
        p_quarto.add(dis_sistemas_distribuidos);

        p_quinto.add(dis_libras);
        p_quinto.add(dis_topicos);
        p_quinto.add(dis_ic);
        p_quinto.add(dis_monografia);
        p_quinto.add(dis_seguranca);
        p_quinto.add(dis_libras);
        p_quinto.add(dis_topicos);
        p_quinto.add(dis_ic);
        p_quinto.add(dis_monografia);
        p_quinto.add(dis_seguranca);

        // ARRAY LIST DECLARATION FOR THE POPULATION
        ArrayList<ArrayList<Discipline>> population = new ArrayList<>();

        for( int i = 0; i < quant_pop; i++){
            // MIXING THE MATERIALS OF THE PERIODS
            Collections.shuffle(p_primeiro);
            Collections.shuffle(p_segundo);
            Collections.shuffle(p_terceiro);
            Collections.shuffle(p_quarto);
            Collections.shuffle(p_quinto);

            // DEFINING ARRAYLIST FOR INDIVIDUAL
            ArrayList<Discipline> individual = new ArrayList<>();

            // ADD DISCIPLINE IN INDIVIDUAL
            individual.addAll(p_primeiro);
            individual.addAll(p_segundo);
            individual.addAll(p_terceiro);
            individual.addAll(p_quarto);
            individual.addAll(p_quinto);

            // INSERT INDIVIDUAL IN POPULATION
            population.add(individual);
        }
        return population;
    }
}