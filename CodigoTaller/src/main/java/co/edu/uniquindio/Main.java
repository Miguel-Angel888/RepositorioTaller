/*Nombre: Miguel Angel
* Fecha:15/02/2026
* Descripcion: Programa que recibe n cantidad de notas y muestra el promedio,
*              nota mayor y menor, la mas repetida,organizada(metodo burbuja creciente)
*              y (metodo burbuja decreciente).
 */

package co.edu.uniquindio;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        //Ingresa la cantidad de notas y el valor de las notas
        int contNotas = Integer.valueOf(JOptionPane.showInputDialog(null,"Ingrese la cantidad de notas"));
        double [] notas = new double [contNotas];
        notas = ingresarNotasArreglo(notas, contNotas);

        //Realiza operaciones con las notas para encontrar(mayor-menor-promedio-mas repetido) y lo muestra
        double mayor = encontrarMayor(notas);
        double menor = encontrarMenor(notas);
        double promedio = encontrarPromedio(notas);
        double repetido = encontrarRepetido(notas);

        //Muestra los datos obtenidos
        mostrarMensaje(mayor,menor,promedio,repetido);
        mostrarArray(notas);

        //Realiza el metodo burbuja creciente y lo muestra
        double [] burbuja = organizarMetodoBurbuja(notas);
        mostrarMetodoBurbuja(burbuja);

        //Realiza el metodo burbuja decreciente y lo muestra
        double [] burbujaInverso =organizarMetodoBurbujaInverso(notas);
        mostrarMetodoBurbujaInverso(burbujaInverso);

    }
    //Metodo para ingresar las notas con JOptionPane
    public static double [] ingresarNotasArreglo (double [] notas,int contNotas){
        for(int i =0; i<contNotas;i++ ){
            notas [i]= Integer.valueOf(JOptionPane.showInputDialog(null,"Ingrese la nota N° "+(i+1)+":"));
        }
        return notas;
    }

    //Metodo para organizar valores numericos llamado(metodo burbuja)
    public static double [] organizarMetodoBurbuja (double [] notas){

        double aux = 0;
        for(int i=0;i<notas.length;i++){
            for(int j=0;j<notas.length;j++){
                if(notas[i]< notas[j]){
                    aux = notas[j];
                    notas[j] = notas[i];
                    notas[i] = aux;
                }
            }
        }
        return notas;
    }

    //Metodo para encontrar el numero mayor de un arreglo
    public static double encontrarMayor( double [] notas){
        double mayor =0;
        for(int i =0; i<notas.length;i++){
            if(notas[i]> mayor){
                mayor = notas[i];
            }
        }
        return mayor;
    }

    //Metodo para encontrar el numero menor de un arreglo
    public static double encontrarMenor( double [] notas){
        double menor = Integer.MAX_VALUE;
        for(int i=0;i<notas.length;i++){
            if(notas[i]<menor){
                menor= notas[i];
            }
        }
        return menor;
    }

    //Metodo para encontrar el promedio de un arreglo
    public static double encontrarPromedio(double [] notas){
        double acumulador =0;
        for(int i=0;i<notas.length;i++){
            acumulador+=notas[i];
        }
        return acumulador/notas.length;
    }

    /*Metodo para encontrar el numero que mas se repite de un arreglo
    (Si todos los numeros tienen el mismo de apariciones, el codigo
     toma el primero numero ingresado por el usuario)*/
    public static double encontrarRepetido(double [] notas){
        int maxRepeticiones =0;
        double aux =0;

        for(int i=0;i<notas.length;i++){
            int contador =0;
            for(int j = 0; j<notas.length;j++){
                if(notas[i]== notas[j]){
                    contador++;
                }

            }
            if(contador>maxRepeticiones){
                maxRepeticiones = contador;
                aux = notas[i];
            }
        }
        return aux;
    }

    //Metodo para organizar valores numericos de forma inversa al metodo burbuja
    public static double [] organizarMetodoBurbujaInverso(double [] notas){
        double aux = 0;
        for(int i=0;i < notas.length;i++){
            for(int j=0; j<notas.length;j++){
                if(notas[i]>notas[j]){
                    aux = notas[j];
                    notas[j] = notas[i];
                    notas[i] = aux;
                }
            }
        }
        return notas;
    }

    //Metodo para mostrar el mensaje final
    public static void mostrarMensaje(double mayor,double menor,double promedio,double repetido){
        System.out.println("El numero mayor es :"+mayor
                +"\nEl numero menor es :"+menor
                +"\nEl promedio es :"+promedio
                +"\nEl numero repetido mas veces es :"+repetido);
    }

    //Metodo para mostrar el resultado del metodo burbuja
    public static void mostrarMetodoBurbuja(double [] burbuja){
        System.out.println("De forma organizada (creciente) las notas se ven asi :");
        for(double nota: burbuja){
            System.out.println(nota);
        }
    }

    //Metodo para mostrar un arreglo
    public static void mostrarArray(double [] notas){
        System.out.println("El array fue ingresado asi:");
        for(double nota: notas){
            System.out.println(nota);
        }
    }

    //Metodo para mostrar el resultado del metodo burbuja inverso
    public static void mostrarMetodoBurbujaInverso(double [] burbujaInverso){
        System.out.println("El array organizado por el metodo burbuja decreciente se ve asi:");
        for(double nota: burbujaInverso){
            System.out.println(nota);
        }
    }
}