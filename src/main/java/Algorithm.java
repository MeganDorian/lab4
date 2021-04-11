import tree.Tree;
import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Algorithm {
    
    private final Tree tree;
    private Queue vars;
    private TreeNode result;
    private LinkedList<TreeNode> currentVars;
    
    public Algorithm(Tree tree) {
        this.tree = tree;
        vars = new ConcurrentLinkedQueue();
        currentVars = new LinkedList<>();
        result = new TreeNode();
        result.setRoot(tree.getRoot());
    }
    
    public TreeNode doAlgorithm() {
        Scanner scan = new Scanner(System.in);
        TreeNode find = null;
        //вводим исходную ситуацию
        vars.add(new TreeNode("Ответственность", "Есть"));
        vars.add(new TreeNode("Условия труда", "Минимальная загруженность"));
        
        while (!vars.isEmpty()) {
            find = tree.search(tree.getRoot(), (TreeNode) vars.peek());
            if (find != null) {
                vars.remove();
            } else {
                return null;
            }
        }
        
        if (find != null && !find.getLeftSon().getKey().equals("Вид стрессоустойчивости")) {
            while (!find.getLeftSon().getKey().equals("Вид стрессоустойчивости")) {
                System.out.print(find.getLeftSon().getKey() + "=");
                String value = scan.nextLine();
                
                if (find.getLeftSon().getValue().equals(value)) {
                    find = find.getLeftSon();
                } else if (find.getCenterSon().getValue().equals(value)) {
                    find = find.getCenterSon();
                } else if (find.getRightSon().getValue().equals(value)) {
                    find = find.getRightSon();
                } else {
                    System.err.println("Вы неправильно ввели вариант ответа");
                }
            }
        }
        
        return find.getLeftSon();
    }
}
