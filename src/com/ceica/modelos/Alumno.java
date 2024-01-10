package com.ceica.modelos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

public class Alumno {
    //nuevo y número--> para tener un contador de alumnos

    public static int id=0;
    public int numero;

    private String nombre;

    private String apellidos;

    private String dni;

    private Date fecha_nacimiento;

    public Alumno(String nombre, String apellidos, String dni, Date fecha_nacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
        this.numero=Alumno.id++;
    }

    public Alumno(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.numero=Alumno.id++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

//un nuevo método para hacer los datos sin date (deprecado),
//para ya usar fecha de nacimiento (se pueden usar dos a la vez)
    public void setFecha_nacimiento(int year, int month, int day){
    this.fecha_nacimiento= Date.from((LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault())).toInstant());
    }

//nuevo constructor para contar alumnos, por eso el id++
    public Alumno(){
        this.numero=Alumno.id++;
    }
//añadimos más cositas y el id++ en cada constructor
    public Alumno(String nombre, String apellidos, String dni, int year, int month, int day) {
        //this.nombre="Tomás"; los alumnos se llamarán tomás
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.dni=dni;
        setFecha_nacimiento(year, month, day);
        this.numero=Alumno.id++;

    }
//lo borramos y generamos los datos de número que pusimos
    @Override
    public String toString() {
        //para poner el formato de fecha como queremos
        DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormateada = formatoFecha.format(fecha_nacimiento);
        return "Alumno{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                ", fecha_nacimiento=" + fechaFormateada +
                '}';
    }


    public boolean esMayorDeEdad(){
        if(((new Date()).getYear() - this.fecha_nacimiento.getYear())>=18){
            return true;
        }else{
            return false;
        }
    }
}



