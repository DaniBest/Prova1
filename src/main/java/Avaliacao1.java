
import utfpr.ct.dainf.if62c.avaliacao.Complexo;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Primeira avaliação parcial 2014/2.
 * @author 
 */
public class Avaliacao1 {

    public static void main(String[] args) {
        // implementar main
        Complexo x1;
        Complexo x2;
        Complexo a = new Complexo(1,0);
        Complexo b = new Complexo(5,0);
        Complexo c = new Complexo(4,0);
        
        Complexo y1;
        Complexo y2;
        Complexo d = new Complexo(1,0);
        Complexo e = new Complexo(2,0);
        Complexo f = new Complexo(5,0);
        
        Complexo[] respostax = raizesEquacao(a,b,c);
        x1 = respostax[0];
        x2 = respostax[1];
        
        Complexo[] respostay = raizesEquacao(d,e,f);
        y1 = respostay[0];
        y2 = respostay[1];
        
        System.out.println(String.format("x1=%s", x1.toString()));
        System.out.println();
        System.out.println(String.format("x2=%s", x2.toString()));
        System.out.println();
        System.out.println(String.format("y1=%s", y1.toString()));
        System.out.println();
        System.out.println(String.format("y2=%s", y2.toString()));
        
    }
    
    // implementar raizesEquacao(Complexo, Complexo, Complexo)
    public static Complexo[] raizesEquacao(Complexo a, Complexo b, Complexo c) {
        Complexo raiz1;
        Complexo raiz2;
        Complexo bmenos = b.prod(-1);
        Complexo a2 = a.prod(2);
        Complexo[] numerador = new Complexo[2];
        Complexo b2 = b.prod(b);
        Complexo ac = a.prod(c);
        Complexo ac4 = ac.prod(4);
        Complexo delta = b2.sub(ac4);
        Complexo[] vetor = delta.sqrt();
        numerador[0] = bmenos.soma(vetor[0]);
        numerador[1] = bmenos.soma(vetor[1]);
        raiz1 = numerador[0].div(a2);
        raiz2 = numerador[1].div(a2);
        Complexo[] resposta = {raiz1, raiz2};
        return resposta;
    }
    
}
