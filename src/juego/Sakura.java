package juego;
import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

//clase sakura

public class Sakura {    // Variables de instancia
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private String direccion;
	private Image imagen;
	
	
	public Sakura(int x, int y, int ancho, int alto, String direccion) {  //constructor	
		this.x= x;
		this.y= y;
		this.alto= alto;
		this.ancho= ancho;
		this.direccion= direccion;
		this.imagen= Herramientas.cargarImagen("imagenes//sakura.png");
		}
	
	
                                                // ******* METODOS ********//
	
	//DIBUJARSE
	public void dibujar(Entorno entorno) {   //parametro entorno
		entorno.dibujarImagen(imagen, this.x, this.y, 0, 0.04);}
	
	
	//MOVERSE
	public void moverIzquierda() {
		this.x= this.x-5;
	}
	
	public void moverDerecha() {
		this.x= this.x+5;
	}
	public void moverArriba() {
		this.y= this.y-5;
	}
	
	public void moverAbajo() {
		this.y= this.y+5;
	}
	
	
	
	//DISPARAR RASENGAN
	 Rasengan Lanzar() {
		 return new Rasengan(this.x, this.y,5, this.direccion);	 
	 }
	
	
	

	//getters and setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
