package main.world;

import main.blocks.Block;

import static org.lwjgl.opengl.GL11.*;

public class Chunk {

    private int xChunk;
    private int yChunk;
    private int hauteur;
    private final Block[][][] tab;

    public Chunk(int xChunk, int yChunk, int hauteur) {
        this.xChunk = xChunk;
        this.yChunk = yChunk;
        this.hauteur = hauteur;
        this.tab = new Block[16][50][16];
    }

    public void initChunk(){
        for(int x = 0; x < 16; x++){
            for(int y = 0; y < hauteur; y++){
                for(int z = 0; z < 16; z++){
                    if(y<=10){
                        tab[x][y][z] = new Block(x,y,z,1);
                    }else{
                        tab[x][y][z] = null;
                    }
                }
            }
        }
    }

    public void drawChunk(){
        glPushMatrix();
        glTranslatef(xChunk * 16, 0, yChunk * 16);

        for(int x = 0; x < 16; x++){
            for(int y = 0; y < hauteur; y++){
                for(int z = 0; z < 16; z++){
                    if(tab[x][y][z] != null) tab[x][y][z].draw();
                }
            }
        }

        glPopMatrix();
    }

    public Block getBlock(int x, int y, int z){
        return tab[x][y][z];
    }
}
