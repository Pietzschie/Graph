import java.util.ArrayList;

public class GraphImpl implements Graph {
  private int[][] a;
  
  public GraphImpl(int[][] adjacencyMatrix) {
	a = adjacencyMatrix;
  }
  
  @Override
  public int size() {
	return a.length;
  }
  
  @Override
  public int deg(int v) {
	return a[v].length;
  }
  
  @Override
  public int succ(int v, int i) {
	return a[v][i];
  }
  
  @Override
  public Graph transpose() {
	//TODO laufzeit is noch übelster Bullshit. Geht bestimmt noch besser, aber fürs erste klappts :)
	int[][] aTransposed = new int[a.length][];
	ArrayList<Integer>[] temp = new ArrayList[size()];
	
	for (int i = 0; i < size(); i++) {
	  for (int j = 0; j < a[i].length; j++) {
		int ind = a[i][j];
		if (temp[ind] == null) temp[ind] = new ArrayList<>();
		temp[ind].add(i);
	  }
	}
	
	for (int i = 0; i < size(); i++) {
	  aTransposed[i] = new int[temp[i].size()];
	  for (int j = 0; j < temp[i].size(); j++) {
		aTransposed[i][j] = temp[i].get(j);
	  }
	}
	
	return new GraphImpl(aTransposed);
  }
  
  private int countNum(int n) {
	int c = 0;
	for (int i = 0; i < a.length; i++) {
	  for (int j = 0; j < a[i].length; j++) if (a[i][j] == n) c++;
	}
	
	return c;
  }
}