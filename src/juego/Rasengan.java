package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Rasengan {
	private int x;
	private int y;
	private int diametro;
	private int velocidad;
	private String direccion;
	private Image imagen;
	
	
	public Rasengan (int x, int y, int diametro, String direccion) {  //constructor	
		this.x= x;
		this.y= y;
		this.diametro=diametro;
		this.direccion=direccion;
		this.velocidad = +2;
		this.imagen= Herramientas.cargarImagen("imagenes//rasengan.png");
		}
	
	
//		//metodo dibujar  	
		public void dibujar(Entorno entorno) {  
			entorno.dibujarImagen(imagen, this.x, this.y, 0, 0.3);}
		
		
		
		////metodo mover
		public void moverIzquierda(){
			this.x = this.x - 5;}
		
		public void moverDerecha(){
			this.x = this.x + 5;}
		
		public void moverArriba(){
			this.y = this.y - 5;}
		
		public void moverAbajo(){
			this.y = this.y + 5;}
		
		
		
		//GETTERS AND SETTERS
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

		public int getDiametro() {
			return diametro;
		}

		public void setDiametro(int diametro) {
			this.diametro = diametro;
		}


		public int getVelocidad() {
			return velocidad;
		}


		public void setVelocidad(int velocidad) {
			this.velocidad = velocidad;
		}


		public Image getImagen() {
			return imagen;
		}


		public void setImagen(Image imagen) {
			this.imagen = imagen;
		}


		public String getDireccion() {
			return direccion;
		}


		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		
		

	
}
