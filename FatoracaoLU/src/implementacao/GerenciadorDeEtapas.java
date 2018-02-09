package implementacao;

import java.util.Scanner;

/**
 *
 * @author Rafael Sousa 
 */
public class GerenciadorDeEtapas {
    
    public void resolve(double [][] M, double [] B){
        LU lu=new LU();
        
        //Primeira Parte
        lu.iniciar(M,M.length);
        lu.procedimentos(M, B);
        
        //Segunda Parte, usando um novo vetor de constantes
        double [] BB = novoVetorB(M);
        lu.procedimentos(M, BB);
    }
    
    public double [] novoVetorB(double [][] M){
        double [] B = new double [M.length];
        
        System.out.println("\n\n\nInforme o novo Vetor de Constantes B:\n-Vetor B-");
        for(int i = 0; i < M.length; i++){
            System.out.print(" B["+i+"]:");
            Scanner sc = new Scanner(System.in);
            B[i] = sc.nextInt();
        }
        return B;
    }
}
