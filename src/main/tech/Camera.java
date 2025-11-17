package main.tech;

import static org.lwjgl.opengl.GL11.*;
    import static org.lwjgl.glfw.GLFW.*;

    public class Camera {
        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        public float getZ() {
            return z;
        }

        public void setZ(float z) {
            this.z = z;
        }

        public float getPitch() {
            return pitch;
        }

        public void setPitch(float pitch) {
            this.pitch = pitch;
        }

        public float getYaw() {
            return yaw;
        }

        public void setYaw(float yaw) {
            this.yaw = yaw;
        }

        public float getSensitivity() {
            return sensitivity;
        }

        public void setSensitivity(float sensitivity) {
            this.sensitivity = sensitivity;
        }

        private float  x=0,y=2,z=0;
        private float pitch=0, yaw=0;

        private double lastMouseX = 400;
        private double lastMouseY = 300;
        private boolean firstMouse = true;
        private float sensitivity = 0.1f;

        double[] xpos = new double[1];
        double[] ypos = new double[1];

        public void applyView(){
            glLoadIdentity();
            glRotatef(-pitch, 1,0,0);
            glRotatef(yaw, 0, 1, 0);
            glTranslatef(-x,-y,-z);
        }

        public void lireInput(long window){
            float speed = 0.05f;

            float dx = (float)Math.sin(Math.toRadians(yaw)) * speed;
            float dz = (float)Math.cos(Math.toRadians(yaw)) * speed;

            float dxLeft = (float)Math.sin(Math.toRadians(yaw - 90)) * speed;
            float dzLeft = (float)Math.cos(Math.toRadians(yaw - 90)) * speed;

            if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS) {
                x += dx;
                z -= dz;
            }
            if (glfwGetKey(window, GLFW_KEY_S) == GLFW_PRESS) {
                x -= dx;
                z += dz;
            }
            if (glfwGetKey(window, GLFW_KEY_A) == GLFW_PRESS) {
                x += dxLeft;
                z -= dzLeft;
            }
            if (glfwGetKey(window, GLFW_KEY_D) == GLFW_PRESS) {
                x -= dxLeft;
                z += dzLeft;
            }

            if (glfwGetKey(window, GLFW_KEY_SPACE) == GLFW_PRESS) y += speed;
            if (glfwGetKey(window, GLFW_KEY_LEFT_SHIFT) == GLFW_PRESS) y -= speed;
        }

        public void lireRotationSouris(long window){
            glfwGetCursorPos(window, xpos, ypos);
            if(firstMouse){
                lastMouseX = xpos[0];
                lastMouseY = ypos[0];
                firstMouse = false;
            }

            double xoffset = xpos[0] - lastMouseX;
            double yoffset = lastMouseY - ypos[0];

            lastMouseX = xpos[0];
            lastMouseY = ypos[0];

            yaw += (float) (xoffset * sensitivity);
            pitch += (float) (yoffset * sensitivity);

            if(pitch > 89.0f) pitch = 89.0f;
            if(pitch < -89.0f) pitch = -89.0f;
        }


    }
