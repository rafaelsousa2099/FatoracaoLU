/*
 * Universidade Federal do Pará
 * Curso: Ciência da computação 
 * Autor: Rafael Nascimento de Sousa
 */
package implementacao;

/**
 *
 * @author Rafael Sousa 
 */
public class Principal {

    public static void main(String[] args) {
        IniciarVariaveisLU M = new IniciarVariaveisLU();
        GerenciadorDeEtapas G = new GerenciadorDeEtapas();
        
        System.out.println("-MÉTODOS DIRETOS - FATORAÇÃO LU-");
        M.Iniciar();
        G.resolve(M.iniciarMatriz(), M.getMatrizB());
    }
}
