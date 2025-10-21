import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;

public class Block {

    private float x;
    private float y;
    private float z;
    private float size;

    public Block(float x, float y, float z, float size) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = size;
    }

    public void draw(){
        float hs = size/2;

        glBegin(GL_QUADS);

        // Face avant
        glColor3f(0.6f, 0.4f, 0.2f);
        glVertex3f(x - hs, y - hs, z + hs);
        glVertex3f(x + hs, y - hs, z + hs);
        glVertex3f(x + hs, y + hs, z + hs);
        glVertex3f(x - hs, y + hs, z + hs);

        // Face arrière
        glColor3f(0.6f, 0.3f, 0.2f);
        glVertex3f(x - hs, y - hs, z - hs);
        glVertex3f(x - hs, y + hs, z - hs);
        glVertex3f(x + hs, y + hs, z - hs);
        glVertex3f(x + hs, y - hs, z - hs);

        // Face gauche
        glColor3f(0.5f, 0.4f, 0.2f);
        glVertex3f(x - hs, y - hs, z - hs);
        glVertex3f(x - hs, y - hs, z + hs);
        glVertex3f(x - hs, y + hs, z + hs);
        glVertex3f(x - hs, y + hs, z - hs);

        // Face droite
        glColor3f(0.7f, 0.4f, 0.2f);
        glVertex3f(x + hs, y - hs, z - hs);
        glVertex3f(x + hs, y + hs, z - hs);
        glVertex3f(x + hs, y + hs, z + hs);
        glVertex3f(x + hs, y - hs, z + hs);

        // Face haut
        glColor3f(0.1f, 1f, 0.1f);
        glVertex3f(x - hs, y + hs, z - hs);
        glVertex3f(x - hs, y + hs, z + hs);
        glVertex3f(x + hs, y + hs, z + hs);
        glVertex3f(x + hs, y + hs, z - hs);

        // Face bas
        glColor3f(0.4f, 0.3f, 0.2f);
        glVertex3f(x - hs, y - hs, z - hs);
        glVertex3f(x + hs, y - hs, z - hs);
        glVertex3f(x + hs, y - hs, z + hs);
        glVertex3f(x - hs, y - hs, z + hs);

        glEnd();
    }

}
