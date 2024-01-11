package com.ceica;

//import com.ceica.modelos.Alumno;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.time.ZoneId;
//import java.util.Date;

import com.ceica.modelos.Academia;
import com.ceica.modelos.Alumno;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //variable fuera para que tenga acceso en las 2 ramas que tiene el if
        Academia academia;
        /*
        para poner nombre a la academia
        academia.nombre="Otra";
        System.out.println(academia);
        Academia academia1=new Academia=("Ceica","20");
        System.out.println(academia1);
        ;*/

        //comprobar si args tiene algo args es un array de string pero lo trata como una cadena de carácteres
        if(args.length>1){
          String nombre_academia=args[0];
          int numero_alumnos;
          //este try lo metemos en la configuración 20k <- es un error y para resguardarlo por que lo que queremos es un número
          try {
              numero_alumnos= Integer.parseInt(args[1]);
          }catch (NumberFormatException e){
              System.out.println("Número no válido");
              numero_alumnos=20;

          }
          academia=new Academia(nombre_academia,numero_alumnos);
        }else{
            academia=new Academia("CEICA", 20);
        }
        //para llenar los alumnos y ponerlos como completos, esto es para probar ---MIRAR---
//        for (int i = 0; i < 20; i++) {
//            academia.altaAlumno("n"+i,"a"+i,"d"+i,"2-3-1996");
//        }

        //Creo que el objeto de la aplicación
        Scanner leer = new Scanner(System.in);
        String opcion, dni;
        String MENU = "1. Alta alumno\n" +
                    "2. Buscar alumnos por DNI\n" +
                "3. Borrar alumnos por DNI\n" +
                     "9. Mostrar información academia\n" +
                    "10. Salir";
        do {
            System.out.println(MENU);
            opcion= leer.nextLine();
            switch(opcion) {
                case "1":
                    if (academia.AlumnosMatriculados() >= academia.plazas()) {
                        System.out.println("Academia llena");
                    } else {
                        System.out.println("------------------------------");
                    System.out.println("Alta de alumno");
                    if (nuevoAlumno(leer, academia)) {
                        System.out.println("La academia está llena");
                    } else {
                        System.out.println("Alumno añadido");
                    }
                    //función
                    // nuevoAlumno(leer, academia);
            }
                    break;

                case "2":
                    //para probar
                    //System.out.println(academia.toString());
                    System.out.println("Buscar por DNI");
                    System.out.println("Introduce DNI alumno");
                    dni= leer.nextLine();
                    //pa que saque el dni
                    System.out.println(academia.buscarPorDNI(dni));
                    //aquí habrá que llamar a los datos de alumno pa que devuelvan
                    break;
                case "3":
                    System.out.println("Borrar alumno dni");
                    System.out.println("Introduce dni alumno");
                    dni= leer.nextLine();
                    //pa que saque el dni
                    System.out.println(academia.borrarAlumnoPorDNI(dni));
                    //aquí habrá que llamar a los datos de alumno pa que devuelvan
                    break;

                case "9":
                    System.out.println("Mostrar información academia");
                    System.out.println(academia.toString());
                case "10":
                    System.out.println("Gracias por usar la AcademiaAPP");
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        //distinto de...
        }while(! opcion.equals("10"));

        System.out.println("chao...");

        //son dos parámetros - ceica y 20 alumnos
//        System.out.println(args[0]);
//        System.out.println(args[1]);
//        //Academia academia=new Academia();
//        System.out.println(academia.toString());
//        //nuevo para contar alumnos y ahora nos guardan el id uno a uno
//        Alumno alumno=new Alumno();
//       Alumno alumno1=new Alumno();
//
//        System.out.println(alumno);
//        System.out.println(alumno1);
//
//        System.out.println(Alumno.id);
//        //prueba de nombre ficticio
//        Alumno alumno2=new Alumno ("Juan", "Alonso", "1212998H");
//        System.out.println(alumno2);
        //Alumno al=new Alumno("Tomás", "Paz", "1212398H",year, 3, 27);
//        LocalDate fecha=LocalDate.of(2003, Month.APRIL,23);
//
//        Date fecha_date= Date.from((fecha.atStartOfDay(ZoneId.systemDefault())).toInstant());
//        //Date fecha=new Date(103, 2, 27); // para poder poner la fecha, pero pone la de hoy
//        Alumno alumno=new Alumno("Tomás", "Fermoso", "1212398H", fecha_date );
//        //fecha=new Date(80,4,23);
//        Alumno pepito=new Alumno("José", "Cuchi", "1212998H", new Date(80,5,12));
//        Alumno juan= new Alumno("Juan", "Alonso", "1212998H");
//        juan.setFecha_nacimiento(1980,12,12);
//        //poner esMayorDeEdad para que haga el booleano
//        System.out.println(alumno.toString());
//        System.out.println(pepito.toString());
//        System.out.println(juan.toString());
    }

    //nuevo para editar las cosas
    private static void editarAlumno(Scanner leer, Academia academia, String dni) {
        String MENUEDITAR = """
                1. Editar Nombre
                2. Editar Apellidos
                3. Editar Fecha Nacimiento
                """;
        String opcionEditar, nuevoNombre, nuevoApellido, nuevaFecha;
        System.out.println(MENUEDITAR);
        opcionEditar = leer.nextLine();

        switch (opcionEditar) {
            case "1":
                System.out.println("El alumno que vas a editar es: " + academia.buscarPorDNI(dni));
                System.out.println("Nuevo nombre");
                nuevoNombre = leer.nextLine();
                //System.out.println(academia.buscarPorDNI(dni));
                academia.editarNombreAlumnoPorDNI(dni, nuevoNombre);
                break;
            case "2":
                System.out.println("El alumno que vas a editar es: " + academia.buscarPorDNI(dni));
                System.out.println("Nuevo apellido");
                nuevoApellido = leer.nextLine();
                academia.editarApellidosAlumnoPorDNI(dni, nuevoApellido);
                break;
            case "3":
                System.out.println("El alumno que vas a editar es: " + academia.buscarPorDNI(dni));
                System.out.println("Fecha de nacimiento: dd-MM-yyyy");
                nuevaFecha = leer.nextLine();
                academia.editarFechaNacimientoAlumnoPorDNI(dni, nuevaFecha);
                break;

            default:
                System.out.println("No válido");
        }
    }

    //método nuevo alumno - de void a boo
    private static boolean nuevoAlumno(Scanner leer, Academia academia) {
        String nombre, apellidos, dni;
        String fecha_nacimiento;
        System.out.println("Nombre: ");
        nombre= leer.nextLine();
        System.out.println("Apellidos: ");
        apellidos= leer.nextLine();
        System.out.println("Dni ");
        //dato
        dni= leer.nextLine();
        System.out.println("Fecha nacimiento dd-mm-yyyy");
        fecha_nacimiento= leer.nextLine();
        //esto lo crea en hoja academia
        academia.altaAlumno(nombre, apellidos, dni, fecha_nacimiento);
        return academia.altaAlumno(nombre,apellidos, dni, fecha_nacimiento);
    }
}
