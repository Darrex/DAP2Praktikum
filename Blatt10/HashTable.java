import java.util.LinkedList;

public class HashTable
{
	private LinkedList<HashItem>[] hashtabelle;					//Hashtabelle
	private int hashsize;										//Tabellengröße


	public HashTable(int hashsize){								//Konstruktor
		this.hashsize = hashsize;
		hashtabelle = new LinkedList[hashsize];
	}

	public void put(String key,String function){
		long hash;
		if(function.equals("RSHash")){
			hash = GeneralHashFunctionLibrary.RSHash(key);		//Ausführung der Hash funktion
		}
		else{
			hash = GeneralHashFunctionLibrary.JSHash(key);
		}
		if(hash < 0){												//Betrag des hash wertes nehmen
			hash = hash * (-1);
		}
		int wert =(int) (hash % hashsize);							//Arraystelle berechnen
		boolean vorhanden = false;
		for (int i = 0; i < hashtabelle[wert].size() ;i++ ) {		//Schleife zum nachschauen, ob key schon vorhanden ist
			if(hashtabelle[wert].get(i).getKey().equals(key)){
				vorhanden = true;
				hashtabelle[wert].get(i).setInfo(hashtabelle[wert].get(i).getInfo() + 1);
			}
		}
		if(!vorhanden){												//wenn der Wert nicht vorhanden ist, wird der Wert zur liste hinzugefügt
			hashtabelle[wert].add(new HashItem(key));
		}
	}

	public HashItem get(String key,String function){								//getFunktion
		long hash;
		if(function.equals("RSHash")){								//Hash funktion ausführen
			hash = GeneralHashFunctionLibrary.RSHash(key);
		}
		else{
			hash = GeneralHashFunctionLibrary.JSHash(key);
		}
		if(hash < 0){												//Betrag nehmen
			hash = hash *(-1);
		}
		int wert = (int) (hash % hashsize);							//Tabellenwert berechnen
		for(int i = 0; i <hashtabelle[wert].size(); i++)
		{
			if(hashtabelle[wert].get(i).getKey().equals(key)){		//key in der Liste suchen
				return hashtabelle[wert].get(i);
			}
		}
		return null;
	}

	public void clear(){											//Listen leeren
		for(int i = 0; i<hashtabelle.length; i++){
			hashtabelle[i].clear();
		}
	}

	public int numberOfCollisions(){								//Collisions berechnen
		int collisions = 0;
		for(int i = 0; i < hashtabelle.length; i++){				//Listensize -1 aufaddieren
			collisions = collisions + hashtabelle[i].size() -1;
		}
		return collisions;
	}

	public void printHashTable(){									//Tabelle ausgeben
		System.out.println("*********************************************************");
		for(int i = 0; i<hashtabelle.length; i++){
			System.out.println("--------------------------------------------------------");
			System.out.println("Hash items with hash value " + i + ":");
			for(int j = 0; j < hashtabelle[i].size(); j++){
				System.out.println("key: " + hashtabelle[i].get(j).getKey() + "		-- info: " + hashtabelle[i].get(j).getInfo());
			}
			System.out.println("--------------------------------------------------------");
		}
		System.out.println("The number of collisions is " + numberOfCollisions());
		System.out.println("*********************************************************");
	}
}