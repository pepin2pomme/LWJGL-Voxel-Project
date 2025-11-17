package main.world;

public class World {

    private final Chunk[][] chunks;
    private final int largeur;
    private final int longueur;
    private final int hauteur;

    public World(int largeur, int longueur, int hauteur) {
        this.largeur = largeur;
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.chunks = new Chunk[largeur][longueur];
    }

    public void initWorld(){
        for(int x = 0; x < this.largeur; x++){
            for(int y = 0; y < this.longueur; y++){
                if(this.chunks[x][y] == null){
                    this.chunks[x][y] = new Chunk(x,y,hauteur);
                    this.chunks[x][y].initChunk();
                }
            }
        }
    }

    public void drawWorld(){
        for(int x = 0; x < this.largeur; x++){
            for(int y = 0; y < this.longueur; y++){
                if(this.chunks[x][y] != null){
                    this.chunks[x][y].drawChunk();
                }
            }
        }
    }

    public int getHauteur(){
        return this.hauteur;
    }
}
