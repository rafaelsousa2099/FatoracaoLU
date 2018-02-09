package implementacao;

/**
 *
 * @author Rafael Sousa 
 */
public class LU {
    private double [][] L;
    private double [] VetorB, VetorY, VetorX;
    private int lengthMatriz;

    public void setVetorB(double[] VetorB) {
        this.VetorB = VetorB;
    }
    
    public void procedimentos(double [][] M, double [] B){
        matrizLY(M,B);
        matrizUX(M);
        
        printVetorB();               
        printMatrizU(M);
        printMatrizL();
                        
        printVetorY();
        printVetorX();
    }
    
    public void iniciar(double [][] M, int X){  //Inicia a matriz identidade de acordo com a ordem da matriz.        
        L = new double [X][X];
        lengthMatriz = X;
        int linha,coluna;
        
        for (linha = 0; linha < X ; linha++) {   
            for (coluna = 0; coluna < X; coluna++) {
                if(linha == coluna){
                    L[linha][coluna]=1;
                }else L[linha][coluna]=0;
            }
        }
        // INICIANDO OS PROCESSOS
        pivô(M);
    }

    public void pivô(double [][] M){
        int linha,coluna;

        for (linha = 0; linha < M.length ; linha++) {   
            for (coluna = 0; coluna < M.length; coluna++) {
                if(linha==coluna && linha != (M.length-1)){
                    //System.out.println("FLAG:"+linha+"-"+coluna);
                    multiplicador(M,M[linha][coluna], linha, coluna);  
                }
            }
        }
    }
    
    public void multiplicador(double [][] M, double pivo, int linhaPivo, int colunaPivo){ // p -> Pivô
        int linha;
        
        for (linha = linhaPivo + 1; linha < M.length ; linha++) {  //Percorre a linha do pivô 
            L[linha][colunaPivo] = (M[linha][colunaPivo]) / pivo;
            eliminação(M,L[linha][colunaPivo],linha,colunaPivo,linhaPivo);
        }
    }
    
    public void eliminação(double[][] M, double multip, int linhaMult, int colunaMult, int linhaPivo){
        int coluna;
        
         for (coluna = colunaMult; coluna < M.length; coluna++) {
            M[linhaMult][coluna]-= (multip * M[linhaPivo][coluna]);
        }
    }
    
    public void matrizLY(double [][] M, double [] B){
        VetorB = B;
        VetorY = new double [M.length];
        int i, j;
        RCDMatrizes(M); // Reduz as casas decimais da MatrizPricipal e MatrizIdentidade.
        
        for (i = 0; i < M.length ; i++) { //Percorre as linhas
            VetorY[i] = VetorB[i];
            for (j = 0; j < M.length; j++) { //Percorre as colunas
                if(i!=j){
                    VetorY[i] -= (VetorY[j]*L[i][j]);
                }   
            }
        }
    }
    
    public void matrizUX(double [][] M){
        VetorX = new double [M.length];
        int i, j;
        
        for (i = M.length-1; i > -1  ; i--) { //Percorre as linhas
            VetorX[i] = VetorY[i];
            for (j = 0; j < M.length ; j++) { //Percorre as colunas
                if(i!=j)
                    VetorX[i] -= (VetorX[j]*M[i][j]);
            }
            if(VetorX[i]!=0)
                VetorX[i]/=M[i][i];
        }
    }
    
     public double RCD(double valor){ //Reduz Casas Decimais
        int aux = (int)(valor*100); // duas casas decimais
        valor = (double)aux/100;
        return valor;
    }
    
    public void RCDMatrizes(double [][] M){
        int linha,coluna;

        for (linha = 0; linha < M.length ; linha++) {   
            for (coluna = 0; coluna < M.length; coluna++) {
                L[linha][coluna] = RCD(L[linha][coluna]);
            }
        }
        for (linha = 0; linha < M.length ; linha++) {   
            for (coluna = 0; coluna < M.length; coluna++) {
                M[linha][coluna] = RCD(M[linha][coluna]);
            }
        }
    }
    
    public void printMatrizU(double [][] M){
        int linha,coluna;
        
        System.out.println("\n\n-- MATRIZ U ---------------|");
        for (linha = 0; linha < M.length ; linha++) {
            System.out.println("\n");
            for (coluna = 0; coluna < M.length; coluna++) { // coluna < Y-1 
                System.out.format("%.2f    ", M[linha][coluna]);
            }
        }
    }
    
    public void printMatrizL(){// Matriz Identidade
        int linha,coluna;
        
        System.out.println("\n\n-- MATRIZ L ---------------|");
        for (linha = 0; linha < L.length ; linha++) {
            System.out.println("\n");
            for (coluna = 0; coluna < L.length; coluna++)
                System.out.format("%.2f    ", L[linha][coluna]);
        }
    }
    
    public void printVetorX(){
        int i;
        System.out.print("\n\n-VETOR X {");
        for(i=0; i < lengthMatriz ; i++){
            VetorX[i] = RCD(VetorX[i]);
            System.out.format("  %.2f  ", VetorX[i]);
        }
        System.out.println("}");
    }
    
    public void printVetorY(){
        int i;
        System.out.print("\n\n-VETOR Y {");
        for(i=0; i < lengthMatriz ; i++){
            VetorY[i] = RCD(VetorY[i]);
            System.out.format("  %.2f  ", VetorY[i]);
        }
        System.out.println("}");
    }
    
    public void printVetorB(){
        int i;
        System.out.print("\n\n-VETOR B {");
        for(i=0; i < lengthMatriz ; i++){
            VetorB[i] = RCD(VetorB[i]);
            System.out.format("  %.2f  ", VetorB[i]);
        }
        System.out.println("}");
    }
}
