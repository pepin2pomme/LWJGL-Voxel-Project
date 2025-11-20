package main.world;

public class ChunkMesh {
    private float[] vertices;
    private int[] indices;

    int vaoId;
    int vboId;
    int iboId;
    int indexCount;

    boolean uploaded = false;

    public ChunkMesh(float[] vertices, int[] indices){
        this.vertices = vertices;
        this.indices = indices;
    }

    void uploadToGPU(){
        uploaded = true;
    }

    void render(){

    }

    void delete(){

    }



}
