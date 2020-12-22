언어 : javascript

시간복잡도 : O(N)

~~~java
public Node flatten(Node head) {
    Node child = null;
    Node node = head;
    List<Node> list = new ArrayList<>();
    
    while(node != null || child != null) {
        if(node.child != null) {
            child = node;
            //우선 이후 노드의 prev를 제거한다
            if(node.next != null) {
                node.next.prev = null;
            }
            //리스트에 이후 노드를 넣는다
            list.add(node.next);
            //현재노드 다음으로 child를 지정하고 child의 prev로 현재 노드를 지정해준다.
            node.next = node.child;
            node.child.prev = node;
            node.child = null;
            child = null;
        }
        
        //child가 없고 다음이 null일 경우에 list에 담아뒀던 Node들을 붙입니다.
        if(node.next == null && child == null) {
            for (int i = list.size() - 1; i >= 0; i--) {
                Node listNode = list.get(i);
                if(listNode == null)
                    continue;
                    
                listNode.prev = node;
                node.next = listNode;
                while(node.next != null) {
                    node = node.next;
                }
            }
        }
        node = node.next;
    }
    return head;
}
~~~
