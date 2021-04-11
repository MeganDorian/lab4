package tree;

import lombok.Getter;

import java.util.Queue;

public class Tree {
    @Getter
    private final TreeNode root;
    
    public Tree(String rootValue) {
        root = new TreeNode();
        root.setKey(rootValue);
        root.setValue("?");
        root.setRoot(null);
        root.setLeftSon(null);
        root.setCenterSon(null);
        root.setRightSon(null);
    }
    
    private String[] getKeyValue(String item) {
        return item.split("=");
    }
    
    public void add(Queue<String> list) {
        TreeNode currentNode = root;
        TreeNode node = currentNode;
        
        while (!list.isEmpty()) {
            String[] item = getKeyValue(list.peek());
    
            node = findNode(currentNode, item[0], item[1], false);
            
            if (node != null && node.getValue().equals(item[1])) {
                list.remove();
                currentNode = node;
            } else {
                node = currentNode;
                break;
            }
        }
        
        add(node, list);
    }
    
    private void add(TreeNode node, Queue<String> list) {
        while (!list.isEmpty()) {
            String[] item = getKeyValue(list.peek());
            TreeNode newNode = new TreeNode();
            newNode.setKey(item[0]);
            newNode.setValue(item[1]);
            newNode.setRoot(node);
            newNode.setLeftSon(null);
            newNode.setCenterSon(null);
            newNode.setRightSon(null);
            if (node.getLeftSon() == null) {
                node.setLeftSon(newNode);
            } else if (node.getCenterSon() == null) {
                node.setCenterSon(newNode);
            } else if (node.getRightSon() == null) {
                node.setRightSon(newNode);
            }
            node = newNode;
            list.remove();
        }
    }
    
    public TreeNode findNode(TreeNode node, String key, String value, boolean isOutput) {
        try {
            while (!node.getKey().equals(key)) {
                if (node.getLeftSon() != null && node.getLeftSon().getKey().equals(key)) {
                    node = node.getLeftSon();
                } else if (node.getCenterSon() != null && node.getCenterSon().getKey().equals(key)) {
                    node = node.getCenterSon();
                } else if (node.getRightSon() != null && node.getRightSon().getKey().equals(key)) {
                    node = node.getRightSon();
                } else {
                    return null;
                }
            }
            
            if (node.getValue().equals(value)) {
                if (isOutput) {
                    System.out.println(node);
                }
                return node;
            } else {
                node = node.getRoot();
                
                while (!node.getValue().equals(value)) {
                    if (node.getLeftSon() != null && node.getLeftSon().getValue().equals(value)) {
                        node = node.getLeftSon();
                    } else if (node.getCenterSon() != null && node.getCenterSon().getValue().equals(value)) {
                        node = node.getCenterSon();
                    } else if (node.getRightSon() != null && node.getRightSon().getValue().equals(value)) {
                        node = node.getRightSon();
                    } else {
                        return null;
                    }
                }
    
                if (isOutput) {
                    System.out.println(node);
                }
                return node;
            }
        } catch (NullPointerException e) {
            return node;
        }
    }
    
    public TreeNode search(TreeNode node, TreeNode find) {
        TreeNode current = null;
        if (node == null) {
            return current;
        }
        if (node != root) {
            System.out.println(node);
        }
        
        if (node.getKey().equals(find.getKey()) && node.getValue().equals(find.getValue())) {
            current = node;
            return current;
        }
        
        if (current == null) {
            current = search(node.getLeftSon(), find);
        }
        if (current == null) {
            current = search(node.getCenterSon(), find);
        }
        if (current == null) {
            current = search(node.getRightSon(), find);
        }
        
        return current;
    }
}
