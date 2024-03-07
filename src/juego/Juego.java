package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Random;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	/************************************ VARIABLES Y METODOS ****************************************/
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;

	// Variables y métodos propios de cada grupo
	private Sakura sakura;
	private Ninja ninjas[];
	private Manzana manzanas[];
	private Casa casas[];
	private Rasengan rasengan;	
	private Calle calles[];
	private Pedido pedido;

	Random numero;
	int numeroRand;

	private int puntos;
	private int enemigos;
	private int[] volverNinjas;
	
	int tiempo = 0;
	int tick = 0;
	
	private boolean juegoTerminado; //perder
	private boolean juegoTerminadoWin; //ganar
	private boolean inicioJuego;

	

	/**************************************** COLISIONES ******************************************/
	// SAKURA - NINJA
	boolean colisionSakuraNinja() {
		for (int i = 0; i < this.ninjas.length; i++) {
			if(this.ninjas[i] !=null ) {
			if (this.sakura.getY() + this.sakura.getAlto() / 2 > this.ninjas[i].getY() - this.ninjas[i].getAlto() / 2
					&& this.sakura.getX() + this.sakura.getAncho() / 2 > this.ninjas[i].getX()
					- this.ninjas[i].getAncho() / 2
					&& this.sakura.getY() - this.sakura.getAlto() / 2 < this.ninjas[i].getY()
					+ this.ninjas[i].getAlto() / 2
					&& this.sakura.getX() - this.sakura.getAncho() / 2 < this.ninjas[i].getX()
					+ this.ninjas[i].getAncho() / 2)
				return true;
		}}

		return false;
	}


	//SAKURA - MANZANA
	boolean colisionSakuraManzana() {
		for (int i = 0; i < this.manzanas.length; i++) {
			if (this.sakura.getY() + this.sakura.getAlto() / 2 >= this.manzanas[i].getY()
					- this.manzanas[i].getAlto() / 2
					&& this.sakura.getX() + this.sakura.getAncho() / 2 >= this.manzanas[i].getX()
					- this.manzanas[i].getAncho() / 2
					&& this.sakura.getY() - this.sakura.getAlto() / 2 <= this.manzanas[i].getY()
					+ this.manzanas[i].getAlto() / 2
					&& this.sakura.getX() - this.sakura.getAncho() / 2 <= this.manzanas[i].getX()
					+ this.manzanas[i].getAncho() / 2)
				return true;
		}

		return false;
	}

	//SAKURA - PEDIDO
	boolean colisionSakuraPedido() {

		if (this.sakura.getY() + this.sakura.getAlto() / 2 >= this.pedido.getY()
				- this.pedido.getAlto() / 2
				&& this.sakura.getX() + this.sakura.getAncho() / 2 >= this.pedido.getX()
				- this.pedido.getAncho() / 2
				&& this.sakura.getY() - this.sakura.getAlto() / 2 <= this.pedido.getY()
				+ this.pedido.getAlto() / 2
				&& this.sakura.getX() - this.sakura.getAncho() / 2 <= this.pedido.getX()
				+ this.pedido.getAncho() / 2)
			return true;


		return false;
	}

	//RASENGAN - NINJA
//	boolean colisionRasenganNinja() {
//		for (int i = 0; i < this.ninjas.length; i++) {
//			if (this.rasengan.getY() + this.rasengan.getDiametro() / 2 >= this.ninjas[i].getY()
//					- this.ninjas[i].getAlto() / 2
//					&& this.rasengan.getX() + this.rasengan.getDiametro() / 2 >= this.ninjas[i].getX()
//					- this.ninjas[i].getAncho() / 2
//					&& this.rasengan.getY() - this.rasengan.getDiametro() / 2 <= this.ninjas[i].getY()
//					+ this.ninjas[i].getAlto() / 2
//					&& this.rasengan.getX() - this.rasengan.getDiametro() / 2 <= this.ninjas[i].getX()
//					+ this.ninjas[i].getAncho() / 2)
//				
//				return true;
//		}
//
//		return false;
//	}
	
//	void colisionRasNinja(Ninja n) {
//		if (this.rasengan.getY() + this.rasengan.getDiametro() / 2 >= n.getY()
//				- this.n.getAlto() / 2
//				&& this.rasengan.getX() + this.rasengan.getDiametro() / 2 >= n.getX()
//				- this.n.getAncho() / 2
//				&& this.rasengan.getY() - this.rasengan.getDiametro() / 2 <= n.getY()
//				+ this.n.getAlto() / 2
//				&& this.rasengan.getX() - this.rasengan.getDiametro() / 2 <= n.getX()
//				+ this.n.getAncho() / 2) {
//				this.n=null;
//			}			
//
//	}
	
	
	boolean colisionNinjaRasengan(Ninja n) {
		if(this.rasengan ==null ) {
			return false;
		}
	
			if(this.ninjas !=null ) {
				if (this.rasengan.getY() + this.rasengan.getDiametro() / 2 >= n.getY()
				- n.getAlto() / 2
				&& this.rasengan.getX() + this.rasengan.getDiametro() / 2 >= n.getX()
				- n.getAncho() / 2
				&& this.rasengan.getY() - this.rasengan.getDiametro() / 2 <= n.getY()
				+ n.getAlto() / 2
				&& this.rasengan.getX() - this.rasengan.getDiametro() / 2 <= n.getX()
				+ n.getAncho() / 2)
			return true;
		}
		
		
			return false;		
	}

//	boolean colisionNinjaRasengan() {
//		if(this.rasengan ==null ) {
//			return false;
//		}
//		for (int i = 0; i < this.ninjas.length; i++) {
//			if(this.ninjas[i] !=null ) {
//		if (this.rasengan.getY() + this.rasengan.getDiametro() / 2 >= this.ninjas[i].getY()
//				- this.ninjas[i].getAlto() / 2
//				&& this.rasengan.getX() + this.rasengan.getDiametro() / 2 >= this.ninjas[i].getX()
//				- this.ninjas[i].getAncho() / 2
//				&& this.rasengan.getY() - this.rasengan.getDiametro() / 2 <= this.ninjas[i].getY()
//				+ this.ninjas[i].getAlto() / 2
//				&& this.rasengan.getX() - this.rasengan.getDiametro() / 2 <= this.ninjas[i].getX()
//				+ this.ninjas[i].getAncho() / 2) 
//			return true;
//		}
//		}
//		
//			return false;		
//	}
	


	//RASENGAN - MANZANA
	boolean colisionRasenganManzana() {
		for (int i = 0; i < this.manzanas.length; i++) {
			if (this.rasengan.getY() + this.rasengan.getDiametro() / 2 >= this.manzanas[i].getY()
					- this.manzanas[i].getAlto() / 2
					&& this.rasengan.getX() + this.rasengan.getDiametro() / 2 >= this.manzanas[i].getX()
					- this.manzanas[i].getAncho() / 2
					&& this.rasengan.getY() - this.rasengan.getDiametro() / 2 <= this.manzanas[i].getY()
					+ this.manzanas[i].getAlto() / 2
					&& this.rasengan.getX() - this.rasengan.getDiametro() / 2 <= this.manzanas[i].getX()
					+ this.manzanas[i].getAncho() / 2)
				return true;
		}

		return false;
	}



	/****************************************** JUEGO *****************************************/

	Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo 9 - v1", 800, 700);

		// Inicializar lo que haga falta para el juego
		this.sakura = new Sakura(400, 300, 25, 30, "abajo");
		this.ninjas = new Ninja[4];
		this.manzanas = new Manzana[12];
		this.casas = new Casa[48];	
		this.calles= new Calle[9];
		this.rasengan = null;


		numero= new Random();
		numeroRand= this.numero.nextInt(49);
		volverNinjas = new int[] {0,0,0,0}; //cuando llega a 5 seg vuelve a aparecer el ninja
		
		this.puntos= 0;
		this.enemigos=0;

		this.inicioJuego= true;
		this.juegoTerminado = false;
		this.juegoTerminadoWin = false;

		
//		volverNinjas1= 0;
//		volverNinjas2= 0;
//		volverNinjas3= 0;
//		volverNinjas4= 0;

		/************************************ CREAR OBJETOS ******************************************/

		// CREAR MANZANAS
		int a = 115; // x
		int c = 115; // x
		int e = 115; // x
		for (int i = 0; i < 12; i++) {
			if (i < 4) {
				this.manzanas[i] = new Manzana(a, 110, 130, 130);
				a = a + 190;
			}
			if (i > 3 && i < 8) {
				this.manzanas[i] = new Manzana(c, 300, 130, 130);
				c = c + 190;
			}
			if (i > 7) {
				this.manzanas[i] = new Manzana(e, 490, 130, 130);
				e = e + 190;
			}
		}


		// CREAR CASAS
		int x = 75;
		int y1 = 85;
		for (int i = 0; i < 48; i++) {
			if (i % 2 == 0) {
				this.casas[i] = new Casa(x, y1, 40, 40);
				x = x + 80;
			}
			if (i % 2 != 0 && i != 7 && i != 15 && i != 23 && i != 31 && i != 39) {
				this.casas[i] = new Casa(x, y1, 40, 40);
				x = x + 110;
			}
			if (i == 7 || i == 23 || i == 39) {
				this.casas[i] = new Casa(x, y1, 40, 40);
				x = 75;
				y1 = y1 + 55;
			}
			if (i == 15 || i == 31) {
				this.casas[i] = new Casa(x, y1, 40, 40);
				x = 75;
				y1 = y1 + 135;
			}
		}


		// CREAR NINJAS
		for (int i = 0; i < this.ninjas.length; i++) {
//			if(this.ninjas[i] != null) {
			if (i == 0 ) {
				this.ninjas[i] = new Ninja(210, 15, 25, 25);
			}
			if (i == 1) {
				this.ninjas[i] = new Ninja(780, 205, 25, 25);
			}
			if (i == 2) {
				this.ninjas[i] = new Ninja(590, 580, 25, 25);
			}
			if (i == 3) {
				this.ninjas[i] = new Ninja(20, 395, 25, 25);
			}
			
//			else {
//				
//			}
		}


		// CREAR CALLES
		int y=15;
		x=20;
		for (int i = 0; i < 9; i++) {
			if (i < 4) { //calles horizontales
				this.calles[i] = new Calle(400, y, 0);
				y=y+190;
			}
			if (i>3) {  //calles verticales
				this.calles[i] = new Calle(x, 28, 1.5705);
				x=x+190;
			}	
		}


		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */

	public void tick() // metodo
	{
		// Procesamiento de un instante de tiempo

		if (this.inicioJuego == true) {  //pantalla inicial
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes//inicio.png"),400,300,0,0.8);
			this.entorno.cambiarFont(Font.SANS_SERIF, 18, Color.magenta);
			this.entorno.escribirTexto("¡PRESIONE ENTER PARA COMENZAR!", 20, 180);
			this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes//play.png"),160,100,0,0.1);
			if (this.entorno.estaPresionada(this.entorno.TECLA_ENTER)){
				this.inicioJuego = false;

			}
		}
		
		else {
			if (this.juegoTerminado == false && this.juegoTerminadoWin == false) {  // si no perdio

				// CONTADOR DE TICKS//
				if (this.tick < 70) {
					tick = tick + 1;
				}
				else {
					tiempo = tiempo + 1;
					tick =0;
				}
				
				
				


				
				
				
				
				
				
//				// DIBUJAR PEDIDO
//				this.pedido = new Pedido(this.casas[this.numeroRand].getX(), this.casas[this.numeroRand].getY());
//				pedido.dibujarse(entorno); //invisible

				//DIBUJAR CALLES
				for (int i = 0; i < this.calles.length; i++) {
					this.calles[i].dibujar(entorno);
					}

				// DIBUJAR MANZANAS
				for (int i = 0; i < this.manzanas.length; i++) {
					this.manzanas[i].dibujarse(entorno);
				}

				// DIBUJAR CASAS
				for (int i = 0; i < this.casas.length; i++) {
					this.casas[i].dibujar(entorno);
				}
				
				// DIBUJAR NINJAS
				for (int i = 0; i < this.ninjas.length; i++) {        //si no hay ninjas muertos
					if (this.ninjas[i] !=null ) {
						this.ninjas[i].dibujar(entorno);
					}
					else {                                            //si hay ninjas muertos
						for (int j=0; j < this.volverNinjas.length ; j++) {
						if (i==j && this.volverNinjas[j]>=400 && this.ninjas[i] ==null ) {			
								if (i == 0 ) {
									this.ninjas[i] = new Ninja(210, 15, 25, 25);
									this.volverNinjas[j]=0;
								}
								if (i == 1) {
									this.ninjas[i] = new Ninja(780, 205, 25, 25);
									this.volverNinjas[j]=0;
								}
								if (i == 2) {
									this.ninjas[i] = new Ninja(590, 580, 25, 25);
									this.volverNinjas[j]=0;
								}
								if (i == 3) {
									this.ninjas[i] = new Ninja(20, 395, 25, 25);
									this.volverNinjas[j]=0;
								}
								
							this.ninjas[i].dibujar(entorno);
						}
						
						}
					}		
				}
				

				
				// DIBUJAR PEDIDO
				this.pedido= new Pedido(this.casas[numeroRand].getX(), this.casas[numeroRand].getY());
				pedido.dibujar(entorno);

				// DIBUJAR SAKURA
				sakura.dibujar(entorno);
				
				

				/************************** mover objetos ************************************/

				// MOVER NINJA CONSTANTEMENTE Y REAPARECER EN PANTALLA
				for (int i = 0; i < 4; i++) {
					if (this.ninjas[i] !=null) {
					if (i == 0) {
						this.ninjas[i].moverAbajo();
						if (this.ninjas[0].getY() > 600) { 
							this.ninjas[0].setY(0);
						}
					}
					if (i == 1) {
						this.ninjas[i].moverIzquierda();
						if (this.ninjas[1].getX() < 0) { 
							this.ninjas[1].setX(800);
						}
					}
					if (i == 2) {
						this.ninjas[i].moverArriba();
						if (this.ninjas[2].getY() < 0) { 
							this.ninjas[2].setY(600);
						}
					}
					if (i == 3) {
						this.ninjas[i].moverDerecha();
						if (this.ninjas[3].getX() > 800) { 
							this.ninjas[3].setX(0);
						}
					}
				}
					}



				// MOVER SAKURA
				if (colisionSakuraManzana() == false) {
					if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) && this.sakura.getX() > 15) {
						this.sakura.setDireccion("izquierda");
						sakura.moverIzquierda();
					}

					if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) && this.sakura.getX() < 785) {
						this.sakura.setDireccion("derecha");
						sakura.moverDerecha();
					}

					if (this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA) && this.sakura.getY() > 15) {
						this.sakura.setDireccion("arriba");
						sakura.moverArriba();
					}

					if (this.entorno.estaPresionada(this.entorno.TECLA_ABAJO) && this.sakura.getY() < 585) {
						this.sakura.setDireccion("abajo");
						sakura.moverAbajo();
					}
				}

				if (colisionSakuraManzana() == true) {
					if (this.sakura.getDireccion() == "izquierda") {
						if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)) {
							this.sakura.setDireccion("derecha");
							sakura.moverDerecha();
						}
						if (this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)) {
							this.sakura.setDireccion("arriba");
							sakura.moverArriba();
						}
						if (this.entorno.estaPresionada(this.entorno.TECLA_ABAJO)) {
							this.sakura.setDireccion("abajo");
							sakura.moverAbajo();
						}
					}

					if (this.sakura.getDireccion() == "derecha") {
						if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)) {
							this.sakura.setDireccion("izquierda");
							sakura.moverIzquierda();

						}
						if (this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)) {
							this.sakura.setDireccion("arriba");
							sakura.moverArriba();
						}
						if (this.entorno.estaPresionada(this.entorno.TECLA_ABAJO)) {
							this.sakura.setDireccion("abajo");
							sakura.moverAbajo();
						}
					}

					if (this.sakura.getDireccion()== "abajo") {
						if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)) {
							this.sakura.setDireccion("derecha");
							sakura.moverDerecha();
						}
						if (this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)) {
							this.sakura.setDireccion("arriba");
							sakura.moverArriba();
						}
						if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)) {
							this.sakura.setDireccion("izquierda");
							sakura.moverIzquierda();
						}
					}

					if (this.sakura.getDireccion()== "arriba") {
						if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)) {
							this.sakura.setDireccion("derecha");
							sakura.moverDerecha();
						}
						if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)) {
							this.sakura.setDireccion("izquierda");
							sakura.moverIzquierda();
						}
						if (this.entorno.estaPresionada(this.entorno.TECLA_ABAJO)) {
							this.sakura.setDireccion("abajo");
							sakura.moverAbajo();
						}
					}
				}


				/*************************** rayo******************************/
				//RASENGAN
				if (this.entorno.estaPresionada(this.entorno.TECLA_ESPACIO) && this.rasengan == null) {
					this.rasengan = this.sakura.Lanzar(); // modifica el valor de disparo = se crea

					if (this.sakura.getDireccion() == "abajo"){  //setear el valor de direccion de rasengan 
						this.rasengan.setDireccion("abajo");
					}

					if (this.sakura.getDireccion()=="arriba"){
						this.rasengan.setDireccion("arriba");
					}

					if(this.sakura.getDireccion()=="izquierda"){
						this.rasengan.setDireccion("izquierda");
					} 	

					if(this.sakura.getDireccion()=="derecha"){
						this.rasengan.setDireccion("derecha");
					} 
				}

				//mover rasengan
				if (this.rasengan != null) {
					if (this.rasengan.getDireccion() == "abajo"){
						this.rasengan.dibujar(entorno);
						this.rasengan.moverAbajo();
					}

					if (this.rasengan.getDireccion() == "arriba"){
						this.rasengan.dibujar(entorno);
						this.rasengan.moverArriba();
					}

					if(this.rasengan.getDireccion() =="izquierda"){
						this.rasengan.dibujar(entorno);
						this.rasengan.moverIzquierda();
					} 		

					if(this.rasengan.getDireccion() =="derecha"){	
						this.rasengan.dibujar(entorno);
						this.rasengan.moverDerecha();
					} 
				}


				//ver si hubo colision del rasengan con BORDE, MANZANA O NINJAS
				if (this.rasengan != null) {  //BORDE
					if(this.rasengan.getX()<0 || this.rasengan.getX()>800 || this.rasengan.getY()<0 || this.rasengan.getY()>600){
						this.rasengan=null;
					}
				}

				if (this.rasengan != null) { //MANZANAS
					for (int i = 0; i < this.manzanas.length; i++) {  	
						if (colisionRasenganManzana() == true) {
							this.rasengan=null;
						}
					}
				}
				
				
//				if (this.rasengan != null) {  //NINJAS		-----------------------------------------------
//					if(colisionRasenganNinja(this.ninjas) == true) {
//						for (int i = 0; i < this.ninjas.length; i++) {
//							this.colisionRasNinja((this.ninjas[i]));
//						}
//						this.enemigos= this.enemigos + 1;
//						this.rasengan=null;
//					}
//				}
				
				

				if (this.rasengan != null) {  //NINJAS		-----------------------------------------------
					
						for (int k = 0; k < this.ninjas.length; k++) {
							if(this.ninjas[k] !=null){
								if(colisionNinjaRasengan(this.ninjas[k])==true) {
								this.ninjas[k]=null;
								this.enemigos= this.enemigos + 1;
								this.rasengan=null;
							}
						}
					}}
				
				
				
				
				for (int i = 0; i < this.ninjas.length; i++) { //sumar segundas para reaparecer ninjas
					if(this.ninjas[i] ==null){
						this.volverNinjas[i]++;
					}

				}
				
//				for (int i = 0; i < this.ninjas.length; i++) {
//					if (this.ninjas[i] == null) {
//						if (i==0) {
//							volverNinjas1++;
//						}
//						if (i==1) {
//							volverNinjas1++;
//						}
//						if (i==2) {
//							volverNinjas2++;
//						}
//						if (i==3) {
//							volverNinjas3++;
//						}
//				}
//				}

				//			
				//			for (int i = 0; i < this.ninjas.length; i++) {
				//				if (this.ninjas[i]==null) {
				//					
				//						if (i == 0) {
				//							this.ninjas[i] = new Ninja(210, 15, 25, 25);
				//						}
				//						if (i == 1) {
				//							this.ninjas[i] = new Ninja(780, 205, 25, 25);
				//						}
				//						if (i == 2) {
				//							this.ninjas[i] = new Ninja(590, 580, 25, 25);
				//						}
				//						if (i == 3) {
				//							this.ninjas[i] = new Ninja(20, 395, 25, 25);
				//						
				//					}
				//				}
				//			}


				// COLISION SAKURA - NINJAS
				for (int i = 0; i < this.ninjas.length; i++) {
					if (colisionSakuraNinja() == true) {
						this.juegoTerminado = true;
					}
				}

				/************************** sakura-pedido ****************************/
				
				if (colisionSakuraPedido() == true) {
					this.puntos= this.puntos + 5;
					//this.numero= new Random();
					numeroRand= numero.nextInt(49);
				}
				
				//ganar juego
				if(tiempo==20)
					if(puntos >= 20) {
						juegoTerminadoWin=true;
				}
					else {
						juegoTerminado=true;
					}

				//PUNTAJE
				entorno.cambiarFont("Arial", 30, Color.lightGray);
				entorno.escribirTexto("Enemigos:",30, 650);
				entorno.escribirTexto(Integer.toString(this.enemigos), 190, 650);	
				entorno.escribirTexto("Puntaje:",30, 680);
				entorno.escribirTexto(Integer.toString(this.puntos), 150, 680);	
				entorno.escribirTexto("tiempo:",500, 650);
				entorno.escribirTexto(Integer.toString(this.tiempo), 610, 650);	

			}
			if(juegoTerminadoWin==true && this.juegoTerminado==false){
				this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes//fin.png"),400,300,0,1.2);
				this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes//cartel.png"),130,90,0,0.15);
				this.entorno.cambiarFont(Font.SANS_SERIF,30, Color.white);
				this.entorno.escribirTexto("Puntaje:",50, 100);
				this.entorno.escribirTexto(Integer.toString(this.puntos), 175, 100);
				this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes//win2.jpg"),400,600,0,0.27);
			}

			if(juegoTerminadoWin==false && this.juegoTerminado==true){
				this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes//fin.png"),400,300,0,1.2);
				this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes//cartel.png"),130,90,0,0.15);
				this.entorno.cambiarFont(Font.SANS_SERIF,30, Color.white);
				this.entorno.escribirTexto("Puntaje:",50, 100);
				this.entorno.escribirTexto(Integer.toString(this.puntos), 175, 100);
				this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes//gameover.PNG"),400,600,0,0.5);

			}


		}

	} // cierre del tick

	/*****************************************************************************************************************************/
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
