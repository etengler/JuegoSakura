package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Pedido {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private Image imagen;
	
	
//	public Pedido (int x, int y) {  //constructor	
//		this.x= x;
//		this.y= y;
//		this.ancho= 109;
//		this.alto= 20;
//		
//		}
	
	public Pedido (int x, int y) {  //constructor	
		this.x= x;
		this.y= y;
		this.ancho= 109;
		this.alto= 20;
		this.imagen= Herramientas.cargarImagen("imagenes//flecha.jpg");
		}

	
	//METODO DIBUJARSE
//		public void dibujarse(Entorno entorno) {  
//			entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.orange);
//			}
		
		public void dibujar(Entorno entorno) {  
			entorno.dibujarImagen(imagen, this.x, this.y - 20, 0, 0.19);
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
		
}
