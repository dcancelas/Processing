// Importamos la libreria proncipal
import processing.core.PApplet;

import java.util.ArrayList;

/**
 * Esta será nuestra clase principal
 * Hererda de PApplet, que es la clase padre que tiene todos los métodos
 * y atributos para usar Processing
 * Desde este fichero si le damos al triangulito verde a la izquierda
 * podemos ejecutar esta clase sin ser 'main'
 */
public class Formas extends PApplet {
    // definimos atributos para todoa la clase
    // es la ventana de salida de la aplicacion
    // en Processing las aplicaciones se llaman sketchs
    int viewport_w = 900; // ancho en pixels
    int viewport_h = 600; // alto en pixels

    // truco para poder ejecutar nuestro código
    // en el entorno gráfico ya creado
    public static void main(String args[]) {
        PApplet.main("Formas");
    }

    // método que tiene las configuraciones iniciales
    @Override
    public void settings() {
        size(viewport_w, viewport_h, P2D);
        smooth(8);
    }

    ArrayList<Float> estrellaX = new ArrayList<>();
    ArrayList<Float> estrellaY = new ArrayList<>();

    // en este metodo tambien podemos meter configuraciones iniciales de nuestro sketch
    @Override
    public void setup() {
        //Coordenadas estrellas
        for (int i = 0; i < 100; i++) {
            estrellaX.add(random(10, 890));
        }
        for (int i = 0; i < 100; i++) {
            estrellaY.add(random(10, 590));
        }
    }

    // método principal. Aqui estará el grueso de nuestro código
    // sería equivalente a un 'main'
    // la DIFERENCIA principal es que se ejecuta en bucle
    // es decir, se repite el código infinitamente
    @Override
    public void draw() {
        // pintamos la ventana según rgb
        // hay muchas paginas que nos dan los colores en rgb
        // esta es una de ellas https://htmlcolorcodes.com/es/
        // prueba a cambiar estos colores
        background(0, 0, 0);

        //Estrellas
        stroke(255, 255, 255);
        fill(255, 255, 255);
        for (int i = 0; i < 100; i++) {
            ellipse(estrellaX.get(i), estrellaY.get(i), 5, 5);
        }

        //Tierra por detrás del Sol
        if (mouseY <= 200) {
            stroke(0, 162, 255);
            fill(0, 162, 255);
            ellipse(mouseX, mouseY, mouseY, mouseY);
        }

        //Sol
        stroke(255, 251, 0);
        fill(255, 251, 0);
        ellipse(450, 300, 550, 550);

        //Tierra por delante del Sol
        if (mouseY > 200) {
            stroke(0, 162, 255);
            fill(0, 162, 255);
            ellipse(mouseX, mouseY, mouseY, mouseY);
        }
    }
}
