import java.util.ArrayList;

public class WeightedGraphImpl implements WeightedGraph {
  private int[][] a;
  private double[][] w;
  
  public WeightedGraphImpl(int[][] adjacencyMatrix, double[][] weights) {
	a = adjacencyMatrix;
	w = weights;
  }
  
  @Override
  public int size() {
	return a.length;
  }
  
  @Override
  public int deg(int v) {
	if(v >= a.length) return -1;
	return a[v].length;
  }
  
  @Override
  public int succ(int v, int i) {
	if(v >= a.length) return -1;
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
	  int size = temp[i] == null ? 0 : temp[i].size();
	  aTransposed[i] = new int[size];
	  for (int j = 0; j < size; j++) {
		aTransposed[i][j] = temp[i].get(j);
	  }
	}
	
	return new GraphImpl(aTransposed);
  }
  
  @Override
  public double weight(int v, int i) {
	if(v >= a.length) return -1;
	return w[v][i];
  }
}
