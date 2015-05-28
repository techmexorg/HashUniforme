/**
 * 
 */
package org.hashuniforme.hash.tabla;

import java.util.ArrayList;

import org.hashuniforme.hash.funciones.FuncionHash;

/**
 * @author "Jorge Medina"
 *
 */
public class TablaHash {
	
	private FuncionHash funcionHash;
	
	private ArrayList<String>[] tablaHash;
	private Integer[] sizesCasillas;
	
	public TablaHash( FuncionHash funcionHash,
					  int capacity ) {
		this.funcionHash = funcionHash;
		this.tablaHash = new ArrayList[capacity];
		this.sizesCasillas = new Integer[capacity];
		for( int i=0; i<capacity; i++ ) {
			this.tablaHash[i] = new ArrayList<String>();
			this.sizesCasillas[i] = 0;
		}
	}
	
	public void add( Object o) {
		String objeto = o.toString();
		int hash = this.funcionHash.getHash(objeto);
		
		//System.out.println( "HASH="+hash );
		
		if( hash < tablaHash.length ) {
			this.tablaHash[hash].add( objeto );
			this.sizesCasillas[hash]++;
		} else {
			System.out.println( "indice hash, fuera de rango!" );
		}
	}

	public int getVacias() {
		int vacias = 0;
		for( int i=0; i<this.sizesCasillas.length; i++ ) {
			if( this.sizesCasillas[i] == 0 ) {
				vacias++;
			}
		}
		
		return vacias;
	}

	public String toSizes() {
		int vacias = 0;
		int ocupadas = 0;
		for( int i=0; i<this.sizesCasillas.length; i++ ) {
			if( this.sizesCasillas[i] == 0 ) {
				System.out.println( this.sizesCasillas[i] );
				vacias++;
				continue;
			}
			System.out.println( this.sizesCasillas[i] );
			ocupadas++;
		}
		
		return "\nOCUPADAS="+ocupadas+"\nVACIAS="+vacias;
	}
	
	@Override
	public String toString() {
		String toString = "";
		int size;
		int vacias = 0;
		int ocupadas = 0;
		for( int i=0; i<tablaHash.length; i++ ) {
			size = tablaHash[i].size();
			if( size == 0 ) {
				System.out.println( tablaHash[i].size() );
				vacias++;
				continue;
			}
			System.out.println( tablaHash[i].size() );
			toString += tablaHash[i].toString();
			ocupadas++;
		}
		
		return toString + "\nOCUPADAS="+ocupadas+"\nVACIAS="+vacias;
	}

}
