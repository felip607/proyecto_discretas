package controller;

import javax.swing.*;
import java.util.Stack;
import java.util.LinkedList;
public class Control {
    private String function;
    private JTextField jTextField;
    public Control(String function, JTextField jTextField) {
        this.function = function;
        this.jTextField = jTextField;
        int i = 0;
        // validar espacios vacios
        if (validar_no_campos_vacios()==true)
            i++;
         else
            JOptionPane.showMessageDialog(null, "Debe ingresar una función.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        //validar caracteres validos
        if (validar_caracteres() == true)
            i++;
        else
            JOptionPane.showMessageDialog(null, "Debe ingresar caracteres validos", "Advertencia", JOptionPane.WARNING_MESSAGE);

        // *Validar operaciones
        /*
        if(validar_operaciones() == true)
            i++;
        else
            JOptionPane.showMessageDialog(null, "Operacion no valida", "Advertencia", JOptionPane.WARNING_MESSAGE);
        */

        // Validar parentesis
        if(valida_parentesis() == true)
            i++;
        else
            JOptionPane.showMessageDialog(null, "Parentesis no validos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        if (i == 3)
            System.out.println("Bienvenido");
    }
    public boolean validar_no_campos_vacios() {
        if(jTextField.getText().isEmpty())
            return false;
        else
            return true;
    }
    public boolean validar_caracteres() {
        for (char caracter : function.toCharArray()) {
            if (caracter != 'X' && caracter != 'Y' && caracter != 'Z' && caracter != 'W' &&
                    caracter != '^' && caracter != 'v' && caracter != '\'' && caracter != '(' &&
                    caracter != ')') {
                return false;
            }
        }
        return true;
    }
    public boolean validar_operaciones() {
        LinkedList<Character> lista = new LinkedList<>();

        for (char caracter : function.toCharArray()) {
            if (Character.isLetter(caracter)) {
                lista.add(caracter);
            } else if (caracter == '^' || caracter == 'v') {
                if (lista.isEmpty()) {
                    return false; // Operador antes de una variable
                }
                char variable = lista.removeLast(); // Removemos la última variable
                if (caracter == '\'' && lista.isEmpty()) {
                    return false; // Símbolo de negación al final de la cadena
                }
                if (caracter != '\'' && lista.isEmpty()) {
                    return false; // Operador antes de una variable
                }
                lista.add('V'); // Agregamos una variable ficticia para indicar que se realizó una operación.
            } else {
                return false; // Carácter no válido en la función.
            }
        }

        // Al final de la función, debe haber exactamente una variable en la lista.
        return lista.size() == 1 && Character.isLetter(lista.getLast());
    }
    public boolean valida_parentesis() {
        Stack<Character> pila = new Stack<>();
        for (char caracter : function.toCharArray()) {
            if (caracter == '(') {
                pila.push(caracter); // Si encontramos un paréntesis abierto, lo agregamos a la pila.
            } else if (caracter == ')') {
                if (pila.isEmpty() || pila.pop() != '(') {
                    // Si encontramos un paréntesis cerrado y la pila está vacía o el elemento superior de la pila no es un paréntesis abierto, la función no está equilibrada.
                    return false;
                }
            }
        }
        // Si la pila está vacía al final y no hay paréntesis vacíos, significa que todos los paréntesis se cerraron correctamente.
        return pila.isEmpty() && !function.contains("()");
    }
}
