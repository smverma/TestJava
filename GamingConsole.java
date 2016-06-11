/**
 * 
 */
package sa.techgig;

/**
 * @author Sandeep
 *
 */
public class GamingConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] multi = new int[][]{
				  { 0, 1, 2},
				  { 3, 4, 5},
				  { 6, 7, 8},
				  { -1, 9, -1}
				 
				};
		
		//System.out.println(multi[3][2]);
		int m=3;
		int maxMoves=getAllMoves(m,multi);

	}

	private static int getAllMoves(int m, int[][] multi) {
		int total_moves=0;
		for(int i=0;i<4;i++){
			for(int j=0;j<3;j++){
				System.out.println(" position  "+multi[i][j]);
				int temp=getMoves(multi,i,j,m);
				System.out.println("temp  "+temp);
				System.out.println("=========================================>>>>>>>");
				total_moves=total_moves+temp;
			}
			
		}
		System.out.println("total_moves "+total_moves);
		return total_moves;
	}

	private static int getMoves(int[][] multi, int i, int j, int m) {
		
		if(i<0 || j<0 || i>3 || j>2){
			return -1;
		}
		System.out.println("i "+i+" j "+j+" val "+multi[i][j]);
		if(i==3 && j!=1){
			return 0;
		}
		
		if(m==1){
			if(multi[i][j]== -1)return 0;
			return 1;
		}
		int up= getMoves(multi,i+1,j,m-1);
		int down= getMoves(multi,i-1,j,m-1);
		int right= getMoves(multi,i,j-1,m-1);
		int left= getMoves(multi,i,j+1,m-1);
		int self= getMoves(multi,i,j,m-1);
		if (up<0)up=0;
		if (down<0)down=0;
		if (right<0)right=0;
		if (left<0)left=0;
		if(self<0)self=0;
		return up+down+right+left+self;
	}

}
