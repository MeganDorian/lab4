import tree.Tree;

import java.util.Queue;

public class Algorithm {
    
    private final Tree tree;
    private Queue vars;
    
    public Algorithm(Tree tree) {
        this.tree = tree;
    }
    
    public void doAlgorithm() {
        
        //вводим исходную ситуацию
        tree.search(tree.getRoot());
    }
}
