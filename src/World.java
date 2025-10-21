public class World {

    private final Block[][][] tab;
    private final int largeur;
    private final int hauteur;
    private final int profondeur;

    public World(int largeur, int hauteur, int profondeur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.profondeur = profondeur;
        this.tab = new Block[largeur][hauteur][profondeur];
    }

    public void initWorld(){
        for(int x = 0; x < this.largeur; x++){
            for(int y = 0; y < this.hauteur; y++){
                for(int z = 0; z < this.profondeur; z++){
                    if(y<=10){
                        tab[x][y][z] = new Block(x,y,z,1);
                    }else{
                        tab[x][y][z] = null;
                    }
                }
            }
        }
    }

    public void drawWorld(){
        for(int x = 0; x < this.largeur; x++){
            for(int y = 0; y < this.hauteur; y++){
                for(int z = 0; z < this.profondeur; z++){
                    if(tab[x][y][z] != null) tab[x][y][z].draw();
                }
            }
        }
    }

    public int getHauteur(){
        return this.hauteur;
    }
}
