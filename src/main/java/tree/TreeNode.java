package tree;

import lombok.Data;

@Data
public class TreeNode {
    private String key;
    private String value;
    private TreeNode root;
    private TreeNode leftSon;
    private TreeNode centerSon;
    private TreeNode rightSon;
    
    @Override
    public String toString() {
        return key + "=" + value;
    }
}