package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Ninja {  
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private Image imagen;
	
	
	public Ninja (int x, int y, int ancho, int alto) {  //constructor	
		this.x= x;
		this.y= y;
		this.ancho= ancho;
		this.alto= alto;
		this.imagen= Herramientas.cargarImagen("imagenes//ninja.png");
		}
	
//GETTERS Y SETTERS
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

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	
//METODO DIBUJARSE
	public void dibujar(Entorno entorno) {  
		entorno.dibujarImagen(imagen, this.x, this.y, 0, 0.2);
		}
	
	
	
// METODOS MOVER
	public void moverIzquierda() {
		this.x= this.x-2;
	}
	
	public void moverDerecha() {
		this.x= this.x+2;
	}
	public void moverArriba() {
		this.y= this.y-2;
	}
	
	public void moverAbajo() {
		this.y= this.y+2;
	}

}
