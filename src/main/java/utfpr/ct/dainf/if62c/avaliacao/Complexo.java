package utfpr.ct.dainf.if62c.avaliacao;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Primeira avaliação parcial 2015/1.
 * @author 
 */
public class Complexo {
    private double real;
    private double img;

    public Complexo() {
    }

    public Complexo(double real, double img) {
        this.real=real;
        this.img=img;
    }

    public double getReal() {
        return real;
    }

    public double getImg() {
        return img;
    }

    public Complexo soma(Complexo c) {
        return new Complexo(real + c.real, img + c.img);
    }
    
    public Complexo sub(Complexo c) {
        return new Complexo(real - c.real, img - c.img);
    }

    public Complexo prod(double r) {
        return new Complexo(real * r, img * r);
    }

    public Complexo prod(Complexo c) {
        return new Complexo((real * c.real) - (img * c.img), (img * c.real) + (real * c.img));
    }
    
    public Complexo div(Complexo c) {
        return new Complexo(((real * c.real) + (img * c.img)) / (Math.pow(c.real,2) + Math.pow(c.img,2)), ((img * c.real) - (real * c.img)) / (Math.pow(c.real,2) + Math.pow(c.img,2)));
    }
    
    public Complexo[] sqrt() {
        double ro = Math.sqrt(Math.sqrt(Math.pow(real, 2) + Math.pow(img, 2))); 
        double fi1 =0; //verificar se der zica
        double fi2 =0; //verificar se der zica
        if(real==0) {
            if(img==0) {
                fi1 = 0;
                fi2 = Math.PI;
            }
            if(img>0) {
                fi1 = Math.PI/4;
                fi2 = (Math.PI/4) + Math.PI;
            }
            if(img<0) {
                fi1 = (3 * (Math.PI/4));
                fi2 = (3 * (Math.PI/4)) + Math.PI;
            }
        } else {
            if(real>0) {
                fi1 = (Math.atan(img/real)/2);
                fi2 = (Math.atan(img/real)/2) + Math.PI;
            }
            if(real<0) {
                fi1 = ((Math.atan(img/real) + Math.PI)/2);
                fi2 = ((Math.atan(img/real) + Math.PI)/2) + Math.PI;
            }
        }
        Complexo raiz1 = new Complexo(ro * (Math.cos(fi1)), ro*(Math.sin(fi1)));
        Complexo raiz2 = new Complexo(ro * (Math.cos(fi2)), ro*(Math.sin(fi2)));
        Complexo[] vetor = {raiz1, raiz2};
        return vetor;
    }
    
   // public Complexo[] sqrt() {
        // completar implementação
        // retornar o vetor contendo as raízes
   //     return null;
   // }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (Double.doubleToLongBits(real)
            ^ (Double.doubleToLongBits(real) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(img)
            ^ (Double.doubleToLongBits(img) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        final Complexo c = (Complexo) obj;
        return obj != null && getClass() == obj.getClass()
            && real == c.real && img == c.img;
    }

    @Override
    public String toString() {
        return String.format("%+f%+fi", real, img);
    }
}
