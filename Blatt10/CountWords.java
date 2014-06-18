import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class CountWords{
  
  // Festgelegte Menge der interessierenden Wörter
  static String[] words = {
	"a",
	"about",
	"all",
	"an",
	"and",
	"are",
	"around",
	"as",
	"at",
	"away",
	"back",
	"be",
	"beach",
	"beat",
	"black",
	"body",
	"brown",
	"but",
	"by",
	"can",
	"close",
	"come",
	"cut",
	"day",
	"did",
	"do",
	"door",
	"down",
	"eyes",
	"face",
	"find",
	"for",
	"from",
	"get",
	"gets",
	"go",
	"going",
	"gonna",
	"got",
	"has",
	"have",
	"he",
	"her",
	"here",
	"him",
	"his",
	"how",
	"i",
	"if",
	"in",
	"inside",
	"into",
	"is",
	"it",
	"jungle",
	"just",
	"know",
	"library",
	"like",
	"look",
	"looks",
	"lost",
	"main",
	"man",
	"matrix",
	"me",
	"mean",
	"my",
	"now",
	"of",
	"off",
	"oh",
	"on",
	"one",
	"open",
	"out",
	"over",
	"phone",
	"right",
	"room",
	"see",
	"sees",
	"she",
	"something",
	"sun",
	"tank",
	"that",
	"the",
	"their",
	"them",
	"then",
	"there",
	"they",
	"think",
	"this",
	"through",
	"to",
	"turns",
	"two",
	"up",
	"us",
	"walks",
	"wanna",
	"want",
	"was",
	"we",
	"well",
	"what",
	"when",
	"where",
	"who",
	"why",
	"with",
	"would",
	"yeah",
	"you",
	"your"
  };
  
  public static void main(String[] args){
    if(args.length < 2 || args.length > 3){								//Zu viele zu wenige Parameter abfangen
    	System.out.println("zwischen 1 und 3 Parameter eingeben!");
    	return;
    }
    String hash;
    int hashsize;
    if(args.length == 2){												//bei 2 Eingaben
    	if(args[1].equals("RSHash") || args[1].equals("JSHash")){		//wenn 2. eingabe die hashfunktion angibt, wird size auf 10 gesetzt
    		hashsize = 10;
    		hash = args[1];
    	}
    	else{															//sonst hashfunktion auf rshash
    		try{
    			hashsize = Integer.parseInt(args[1]);					
    			hash = "RSHash";
    		}
    		catch(Exception e){
    			System.out.println("Fehler 2. Argument");
    			return;
    		}
    	}
    }
    else{																//3 Eingaben
    	hash = args[2];
    	try{
    		hashsize = Integer.parseInt(args[1]);
    	}
    	catch (Exception e) {
    		System.out.println("Integer Zahl als 2. Argument wählen");
    		return;
    	}
    }
    HashTable test = new HashTable(hashsize);							//neuen Hashtable mit hashsize erzeugen
    RandomAccessFile file;												
    try{
    	file = new RandomAccessFile(args[0],"r");						//Randomaccessfile erzeugen
    }
    catch(Exception e){
    	System.out.println("File not Found");
    	return;
    }
    String line;
    try{
    	line = file.readLine();											//lines auslesen
    	if(line != null){
    		StringTokenizer st = new StringTokenizer(line, " ");		//Strinktokenizer
    		while(st.hasMoreTokens()){									//solange es noch tokens gibt
    			test.put(st.nextToken(),hash);							//Einfügen
    		}
    	}
    }
    catch(Exception e){
    	System.out.println("Fehler beim Lesen von Zeilen");
    }  
    test.printHashTable();												//Ausgeben
  }
  
}