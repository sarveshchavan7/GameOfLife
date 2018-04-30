
public class GameOfLife {
	
	/* Rules
	 * 1. cell with exactly 3 neighbor alive will come alive due to reproduction
	 * 2. cell with less than 2 or greater than 3 cell will die of isolation and starvation respectively
	 * 3. cell with 2 or 3 cell alive will remain alive in next generation
	 */
	private int row = 10;
	private int column = 10;
	private Cell[][] cells = new Cell[row][column];
	private Cell[][] newGridCells = new Cell[row][column];
	
	public void InitialStage(){
		for(int i= 0;i < row ;i++){
			for(int j=0;j<column;j++){
				int x = Math.random() <0.5? 0:1;
				cells[i][j] =  x==0? new Cell(false): new Cell(true);
			}
		}
		
		for(int i= 0;i < row ;i++){
			for(int j=0;j<column;j++){
				newGridCells[i][j] =  new Cell(false);
			}
		}
	}
	
	public void NextGeneration(){
		System.out.println();
		for(int i= 0 ;i< row;i++){
			for(int j=0;j<column;j++){
				int x = getNeighBour(i,j);
				//Rules
				if(cells[i][j].isAlive){
					if(x < 2 || x > 3){
						newGridCells[i][j].isAlive = false;
					}
					if(x > 3){
						newGridCells[i][j].isAlive = false;
					}
					if(x==2 || x==3){
						newGridCells[i][j].isAlive = true;
					}
				}else{
					if(x==3){
						newGridCells[i][j].isAlive = true;
					}
					if(x==2 || x==3){
						newGridCells[i][j].isAlive = false;
					}
				}
		
			
			}
		}
		
		//copying array
		for(int i = 0 ;i < row;i++){
			for(int j = 0 ; j < column;j++){
				cells[i][j] = newGridCells[i][j];
			}
		}
	}
	
	public int getNeighBour(int i,int j){
		int countAlive = 0;
		try{
			countAlive = cells[i-1][j-1].isAlive ? countAlive+1 : countAlive;
			
		}catch(Exception e){
		
		}
		try{
			countAlive = cells[i-1][j].isAlive ? countAlive+1 : countAlive;		
			
		}catch(Exception e){
				
		}
		try{
			countAlive = cells[i-1][j+1].isAlive ? countAlive+1 : countAlive;
			
		}catch(Exception e){
			
		}
		try{
			countAlive = cells[i][j-1].isAlive ? countAlive+1: countAlive;
			
		}catch(Exception e){
			
		}
		try{
			countAlive = cells[i][j+1].isAlive ? countAlive+1 : countAlive;
		
		}catch(Exception e){
			
		}
		try{
			countAlive = cells[i+1][j-1].isAlive ? countAlive+1 : countAlive;
			
		}catch(Exception e){
			
		}
		try{
			countAlive = cells[i+1][j].isAlive ? countAlive+1 : countAlive;
			
		}catch(Exception e){
		
		}
		try{
			countAlive = cells[i+1][j+1].isAlive ? countAlive+1 : countAlive;
			
		}catch(Exception e){
			
		}
		return countAlive;
	}
	
	
	
	public void DisplayCells(){
		for(int i=0;i<row;i++){
			System.out.println();
			for(int j=0;j<column;j++){
				int x = cells[i][j].isAlive ? 1:0;
				System.out.print(String.valueOf(x)+" ");
			}
		}
	}
	
	public void RecursiveCall() {
		boolean truevariable = true;
		while(truevariable){	
			DisplayCells();
			NextGeneration();
			System.out.println();
		}
	}

	
	public static void main(String args[]){
		GameOfLife g = new GameOfLife();
		g.InitialStage();
		g.RecursiveCall();
	}
}
