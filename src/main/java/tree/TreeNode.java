package tree;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TreeNode {
    private String key;
    private String value;
    private TreeNode root;
    private TreeNode leftSon;
    private TreeNode centerSon;
    private TreeNode rightSon;
    
    public TreeNode(String key, String value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return key + "=" + value + " - VISITED";
    }
}
