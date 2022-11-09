package ArrayListE1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Usuario extends Persona {
    ArrayList<Persona> lista = new ArrayList<Persona>();

    HashMap<String, ArrayList<Persona>> map = new HashMap<String, ArrayList<Persona>>();
    int Num_personas = 0;
    int edadMayor = 0;
    int MenorEdad = 0;
    int sumEdadUsuarios = 0;

    public void  Datos_usuario(){

        String preg="";
        do{
            int complet = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de personas que deseas registrar"));
            int iterar [] = new int[complet];
            for (int i = 0; i < iterar.length; i++) {
                try {
                    Persona persona = new Persona();
                    persona.setNombre(JOptionPane.showInputDialog("ingrese el nombre de la persona"));
                    persona.setApellido(JOptionPane.showInputDialog("ingrese el apellido de la persona"));
                    persona.setEdad(Integer.parseInt(JOptionPane.showInputDialog("ingrese la edad de la persona")));
                    persona.setDni(JOptionPane.showInputDialog("ingrese el dni de la persona"));
                    persona.setDireccion(JOptionPane.showInputDialog("ingrese la direccion de la persona"));
                    persona.setTelefono(JOptionPane.showInputDialog("ingrese el telefono de la persona"));
                    persona.setEmail(JOptionPane.showInputDialog("ingrese el email de la persona"));
                    lista.add(persona);
                    map.put(persona.dni,lista);
                }catch (Exception e) {
                    System.out.println("error");
                    i--;
                }catch (Error e) {
                    System.out.println("error");
                    i--;
                }
            }
            preg = JOptionPane.showInputDialog("Ingresar un nuevo usuario? (S/N)");
    }while (preg.equalsIgnoreCase("si"));
        procesas_Informacion();
    }
    private void procesas_Informacion() {

        Iterator<String> items = map.keySet().iterator();
        while (items.hasNext()) {
            String key = items.next();
            System.out.println("DNI: " + key);
            ArrayList<Persona> lista = map.get(key);
            for (Persona persona : lista) {
                System.out.println("Nombre: " + persona.getNombre());
                System.out.println("Apellido: " + persona.getApellido());
                System.out.println("Edad: " + persona.getEdad());
                System.out.println("Direccion: " + persona.getDireccion());
                System.out.println("Telefono: " + persona.getTelefono());
                System.out.println("Email: " + persona.getEmail()+"\n");
            }
        }
        consultar_Datos_Usuario();
    }

    private void consultar_Datos_Usuario() {

        for (int i = 0; i < lista.size(); i++) {
            Num_personas = lista.size();
            sumEdadUsuarios += lista.get(i).getEdad();
            if(lista.get(i).getNombre().equalsIgnoreCase("juan")){
                System.out.println("El usuario Juan tiene "+lista.get(i).getEdad()+" años");
            }
            if(lista.get(i).getEdad() > 18){
                edadMayor++;
            }else{
                MenorEdad++;
            }
        }

        System.out.println("El numero de personas es: " + Num_personas+"\n");
        System.out.println("La suma de las edades de las personas es: " + sumEdadUsuarios);
        System.out.println("El numero de personas mayores de edad es: " + edadMayor+"\n");
        System.out.println("El numero de personas menores " + MenorEdad +"\n");

        Imprimir_Persona_method();
    }
    private void Imprimir_Persona_method() {

        Iterator<String> listMapa = map.keySet().iterator();

        while (listMapa.hasNext()){

            String keyData = listMapa.next();
            ArrayList<Persona> indixe = map.get(keyData);

            for (Persona object : indixe) {
                System.out.println("Data: "+ object.toString());

            }

        }


    }
}
