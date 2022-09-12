import java.lang.Math;
import java.util.Scanner;
import java.text.DecimalFormat;
//O programa funciona com apenas duas dimensões
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static double[][] mainMatrix = new double[2][1];
    //Cria um ponto com apenas duas dimensões
    public static double [][] createPoint(){
        double input[][] = new double[2][1];
        System.out.println("x:");
        input[0][0] = scanner.nextDouble();
        System.out.println("y:");
        input[1][0] = scanner.nextDouble();
        return input;
    }
    
    public static double[][] translate(){
        double input[][] = new double[2][1];
        System.out.println("x:");
        input[0][0] = scanner.nextDouble();
        System.out.println("y:");
        input[1][0] = scanner.nextDouble();
        return sum(mainMatrix,input);
    }

    public static double[][] scale(){
        double input[][] = new double[2][1];
        System.out.println("x:");
        double sX = scanner.nextDouble();
        System.out.println("y:");
        double sY = scanner.nextDouble();
        return multiply(mainMatrix,new double[][]{{sX,0},{0,sY}});
    }

    public static double[][] rotate(){
        System.out.println("Ângulo:");
        double angle = scanner.nextDouble();
        return multiply(mainMatrix,new double[][]{{Math.cos(angle), -1 * Math.sin(angle)},{Math.sin(angle),Math.cos(angle)}});
    }

    public static void menu(){
        System.out.println("-----------MENU--------------");
        System.out.println("1. Criar novo ponto");
        System.out.println("2. Translação");
        System.out.println("3. Rotação");
        System.out.println("4. Escala");
        System.out.println("5. Imprimir resultado");
        System.out.println("-----------------------------");
    }
    //Translação = somar matrizes
    public static double[][] sum(double[][] matrixA, double[][] matrixB){
        //Se ambas as matrizes são de mesma ordem (possuem mesma quantidade de linhas e colunas)
        if(matrixA.length == matrixB.length && matrixA[0].length == matrixB[0].length){
            double[][] result = new double[matrixA.length][matrixA[0].length];
            for(int i = 0; i < result.length; i++){
                for(int j = 0; j < result[0].length; j++){
                    result[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }
            return result;
        }
        System.out.println("Não é possível realizar a translação.");
        return null;
    }
    public static void printMatrix(){
        final DecimalFormat decimalFormat = new DecimalFormat("0.00");
        for(int i = 0; i < mainMatrix.length; i++){
            for(int j = 0; j < mainMatrix[0].length; j++){
                System.out.printf(" " + decimalFormat.format(mainMatrix[i][j]));
            }
            System.out.println();
        }
    }
    //concatenar, rotacionar e escalar matrizes = multiplicar matrizes
    public static double[][] multiply(double[][] matrixA, double[][] matrixB){
        //A coluna de matrixA é igual a linha de matrixB
        if(matrixA[0].length == matrixB.length){
            //Linhas de A e colunas de B
            double [][] result = new double [matrixA.length][matrixB[0].length];
            //Percorre as linhas da matriz A
            for(int i = 0; i < matrixA.length; i++){
                //percorre as colunas da matriz B
                for(int j = 0; j < matrixB[0].length; j++){
                    double sum = 0.0;
                    //Percorre as colunas da matriz A
                    for(int k = 0; k < matrixA[0].length; k++){
                        sum += matrixA[i][k] * matrixB[k][j];
                    }
                    result[i][j] = sum;
                }
            }
        }
        System.out.println("Não é possível concatenar as matrizes.");
        return null;
    }
    public static void main(String[] args){
        int option = 1;
        while(option >= 1 && option <= 4){
            menu();
            option = scanner.nextInt();
            switch(option){
                case 1:
                    mainMatrix = createPoint();
                    break;
                case 2:
                    mainMatrix = translate();
                    break;
                case 3:
                    mainMatrix = rotate();
                    break;
                case 4:
                    mainMatrix = scale();
                    break;
                case 5:
                    printMatrix();
                    break;
                default:
                    System.out.println("Alternativa inválida");
                    break;
            }
        }
        //Resposta do exercício
    }
}
