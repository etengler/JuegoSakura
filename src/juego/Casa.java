package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Casa {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private Image imagen;
	
	
	public Casa (int x, int y, int ancho, int alto) {  //constructor	
		this.x= x;
		this.y= y;
		this.ancho= ancho;
		this.alto= alto;
		this.setImagen(Herramientas.cargarImagen("imagenes//casa.png"));
		}
	
	
	//getters and setters
	public int getX() {
		return x;}

	public void setX(int x) {
		this.x = x;}

	public int getY() {
		return y;}

	public void setY(int y) {
		this.y = y;}

	public int getAncho() {
		return ancho;}

	public void setAncho(int ancho) {
		this.ancho = ancho;}

	public int getAlto() {
		return alto;}

	public void setAlto(int alto) {
		this.alto = alto;}
	
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}


	                                              // ******* METODOS ********//
		//metodo dibujar  
		public void dibujarse(Entorno entorno) {  
			entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.red);
			}
		public void dibujar(Entorno entorno) {  
			entorno.dibujarImagen(imagen,this.x, this.y, 0, 0.03);
			}


	
		   
}
