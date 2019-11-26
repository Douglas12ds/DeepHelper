package br.com.douglasonofre.deephelper.dados;

public class Perfil {
    private int nivel;
    private int xp;

    public Perfil(int nivel, int xp) {
        this.nivel = 1;
        this.xp = 0;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void levelUp(){
        if ( this.getXp() >= (this.getNivel()*200)){
            this.setXp(this.getXp() + 1);
        }
    }

    public void reiniciar(){
        this.setXp(0);
        this.setNivel(1);
    }
}
