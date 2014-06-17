import java.util.LinkedList;

public class Hashtable
{
	private LinkedList[] hashtabelle;
	private int hashsize;


	public Hashtable(int hashsize)
	{
		this.hashsize = hashsize;
		hashtabelle = new LinkedList[hashsize];
	}

	public void put(String key)
	{
		long hash = GeneralHashFunctionLibrary.RSHash(key);
		if(hash < 0){
			hash = hash * (-1);
		}
		int wert = hash % hashsize;
		boolean vorhanden = false:
		for (int i = 0; i < hashtabelle[wert].size() ;i++ ) {
			if(hashtabelle[wert].get(i).getKey() == key){
				vorhanden = true;
				hashtabelle[wert].setInfo(hashtabelle[wert].getInfo() + 1);
			}
		}
		if(!vorhanden){
			hashtabelle[wert].add(new HashItem(key));
		}
	}

	public HashItem get(String key){
		long hash = GeneralHashFunctionLibrary.RSHash(key);
		if(hash < 0){
			hash 0 hash +(-1);
		}
		int wert = hash % hashsize
		for(int i = 0; i <hashtabelle[wert].size())
		{
			if(hashtabelle[wert].get(i).getKey == key){
				return hashtabelle[wert].get(i);
			}
		}
		return null;
	}

	public void clear(){
		for(int i = 0; i<hashtabelle.length; i++){
			hashtabelle[i].clear();
		}
	}

	public int numberOfCollisions(){
		int collisions = 0;
		for(int i = 0; i < hashtabelle.length; i++){
			collisions = collisions + hashtabelle[i].size() -1;
		}
		return collisions;
	}

	public void printHashTable(){
		System.out.println("*********************************************************");
		for(int i = 0; i<hashtabelle.length; i++){
			System.out.println("--------------------------------------------------------");
			System.out.println("Hash items with hash value " + i + ":");
			for(int j = 0; j < hashtabelle[i].size(); j++){
				System.out.println("key: " + hashtabelle[i].get(j).getKey() + "		-- info: " + hashtabelle[i].get(j).getInfo);
			}
			System.out.println("--------------------------------------------------------")
		}
		System.out.println("The number of collisions is " + numberOfCollisions());
		System.out.println("*********************************************************");
	}
}