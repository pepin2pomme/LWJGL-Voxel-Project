import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class TestLWJGL {
    private long window;

    public void run() {
        System.out.println("Lancement LWJGL " + Version.getVersion());
        init();
        loop();

        //glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    private void init() {
        if (!glfwInit()) throw new IllegalStateException("Impossible d'initialiser GLFW");

        window = glfwCreateWindow(800, 600, "Hello LWJGL!", NULL, NULL);
        if (window == NULL) throw new RuntimeException("Échec de création de fenêtre");

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);
        GL.createCapabilities();
    }

    private void loop() {
        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glClearColor(0.3f, 0.6f, 1.0f, 0.0f);
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    public static void main(String[] args) {
        new TestLWJGL().run();
    }
}
