package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Calle {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private double angulo; //necesario para dibujarse
	private Image imagen;
	
	
	
	
	public Calle (int x, int y, double angulo) {  //constructor	
		this.x= x;
		this.y= y;
		this.angulo= angulo;
		this.imagen= Herramientas.cargarImagen("imagenes//calles2.png");
		}
	
	
	//metodo dibujar  
	public void dibujarse(Entorno entorno) {  
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.GRAY);
		}
	
	public void dibujar(Entorno entorno) {  
		entorno.dibujarImagen(imagen, this.x, this.y, this.angulo, 1.35);
		}
	
}
