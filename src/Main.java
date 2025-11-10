import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.glfw.GLFWVidMode;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Main {
    private long window;
    private Camera cam;
    private World world;

    public void run() {
        System.out.println("Lancement LWJGL " + Version.getVersion());
        init();
        loop();

        //glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    public static void gluPerspectiveLWJGL3(float fovY, float aspect, float zNear, float zFar) {
        float fH = (float)Math.tan(Math.toRadians(fovY / 2)) * zNear;
        float fW = fH * aspect;
        glFrustum(-fW, fW, -fH, fH, zNear, zFar);
    }

    private void init() {
        if (!glfwInit()) throw new IllegalStateException("Impossible d'initialiser GLFW");

        GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        window = glfwCreateWindow(videoMode.width(), videoMode.height(),
                "Hello LWJGL!", glfwGetPrimaryMonitor(), NULL);


        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);
        GL.createCapabilities();

        //ne pas voir les pixels et faces cachés
        glEnable(GL_DEPTH_TEST);
        glDepthFunc(GL_LEQUAL);

        glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_DISABLED);

        // Projection perspective
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        float aspect = (float) videoMode.width() / (float) videoMode.height();
        gluPerspectiveLWJGL3(90, aspect, 0.1f, 100f);
        glMatrixMode(GL_MODELVIEW);

        //------------- INITIALISATION JEU

        world = new World(2,2,50);
        world.initWorld();

        cam = new Camera();
        cam.setY(12);

    }

    private void loop() {
        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glClearColor(0.3f, 0.6f, 1.0f, 0.0f);

            cam.lireRotationSouris(window);
            cam.lireInput(window);
            cam.applyView();

            world.drawWorld();

            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
