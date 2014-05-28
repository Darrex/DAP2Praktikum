public class lcs{
	
	public static int[][] lcslänge(String x, String y){
		int m = x.length();
		int n = y.length();
		int[][] c = new int[m+1][n+1];
		for (int i = 0; i<=m ;i++ ) {
			c[i][0] = 0;
		}
		for (int j = 0; j<=n ;j++ ) {
			c[0][j] = 0;
		}
		for (int i = 0; i<m ;i++ ) {
			for (int j = 0; j<n ;j++ ) {
				längenberechnung(x,y,c,i,j);
			}
		}
		return c;
	}

	public static void längenberechnung(String x, String y, int[][] c, int i, int j){
		if(x.charAt(i) == y.charAt(j) ){
			c[i+1][j+1] = c[i][j] + 1;
		}
		else if(c[i][j+1] >= c[i+1][j]){
			c[i+1][j+1] = c[i][j+1];
		}
		else{
			c[i+1][j+1] = c[i+1][j];
		}
	}

	public static String randStr(int n, java.util.Random r){
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder res = new StringBuilder(n);
		while( --n >= 0){
			res.append(alphabet.charAt(r.nextInt(alphabet.length())));
		}
		return res.toString();
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		java.util.Random gen = new java.util.Random();
		String nr1 = randStr(n,gen);
		String nr2 = randStr(n,gen);
		int[][] array = new int[n][n];
		long tStart, tEnd, msecs;
		tStart = System.currentTimeMillis();
		array = lcslänge(nr1,nr2);
		tEnd = System.currentTimeMillis();
		msecs = tEnd -tStart;
		System.out.println(msecs);
	}
}