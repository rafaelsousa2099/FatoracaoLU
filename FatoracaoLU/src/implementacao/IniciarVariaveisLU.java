package implementacao;

import java.util.Scanner;

/**
 *
 * @author Rafael Sousa 
 */
public class IniciarVariaveisLU {
    int x;
    double [] matrizB;
    
    public void Iniciar(){
        System.out.print("\nInforme o N° de Variaveis:");
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();       
    }
    
    public double[][] iniciarMatriz(){
        
        int linha,coluna;
        double [][] matriz = new double[x][x];
        matrizB = new double[x];
        
        for (linha = 0; linha < x ; linha++) {
            System.out.println("\n\n[Linha "+linha+"]");
            for (coluna = 0; coluna < (x); coluna++) {
                System.out.print(" X"+coluna+" = ");
                Scanner sc = new Scanner(System.in);
                matriz [linha][coluna] = sc.nextInt();
            }
            System.out.print(" B["+linha+"]:");
            Scanner sc = new Scanner(System.in);
            matrizB[linha] = sc.nextInt();
        }
        return (matriz);
    }     

    public double[] getMatrizB() {
        return matrizB;
    }
}

