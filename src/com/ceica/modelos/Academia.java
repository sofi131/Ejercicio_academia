package com.ceica.modelos;

import java.util.Arrays;

public class Academia {
    private String nombre;
    private Alumno[] alumnos;

    //constructor vacío que solo pilla esos parámetros
//    public Academia() {
//        //array 20 objetos de tipo alumno (20 nulls de momento)
//        alumnos=new Alumno [20];
//        nombre="CEICA";
//    }
//otro más --> construir objetos de tipo alumnos, con los nombres y cosas que le pase

    public Academia(String nombre, int numero_alumnos) {
        this.nombre = nombre;
        this.alumnos = new Alumno[numero_alumnos];

    }

    //creamos el toString (la clase padre)
    @Override
    public String toString() {
        return "Academia{" +
                "nombre='" + nombre + '\'' +
                ", alumnos=" + Arrays.toString(alumnos) +
                '}';
    }

    public boolean altaAlumno(String nombre, String apellidos, String dni, String fechaNacimiento) {
        int year, mes, dia;
        dia = Integer.parseInt(fechaNacimiento.split("-")[0]);
        mes = Integer.parseInt(fechaNacimiento.split("-")[1]);
        //mes=fechaNacimiento.split("-")[1]; así es como se escribe originalmente
        year = Integer.parseInt(fechaNacimiento.split("-")[2]);
        Alumno alumno = new Alumno(nombre, apellidos, dni, year, mes, dia);
        boolean lleno = true;

        for (int i = 0; i < alumnos.length; i++) {
            //si está vacío, que guarde alumno en un hueco
            if (alumnos[i] == null) {
                alumnos[i] = alumno;
                //lleno=false;
                break;
            }
        }
        //esto va a dar mal sí o sí y el public antes era static
        return lleno;
    }

    public int AlumnosMatriculados() {
        int contador = 0;
        //this alumnos
        //tb puede ser asó for for(Alumno alumno : alumnos)
        for (int i = 0; i < alumnos.length; i++) {
            //si está vacío, que guarde alumno en un hueco - this.alumno que ya se pone solo con el lenght

            if (alumnos[i] != null) {
                //alumnos[i]=new Alumno;
                contador++;
                //lleno=false;
                //break;
            }
        }
        return contador;
        // return contador;
    }

    //cuantas plazas hay
    public int plazas() {
        return alumnos.length;
    }

    public String buscarPorDNI(String dni) {
        for (int i = 0; i < alumnos.length; i++) {
            //compara dni
            if (alumnos[i] != null)
            if (dni.equals(alumnos[i].getDni())) { //!= null && alumnos[i].dni.equals(dni))//
                return alumnos[i].getNombre() + " " + alumnos[i].getApellidos();
            }
        }
        return "No existe ningún alumno con ese DNI";
    }

    public String borrarAlumnoPorDNI(String dni) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null)
                if (alumnos.equals(alumnos[i].getDni())) {
                    String nombre=alumnos[i].getNombre();
                    alumnos[i]=null;
                    return "El alumno"+ nombre + "ha sido eliminado";
                }
        }
        return "No hay ningún alumno con ese dni";
    }

}

