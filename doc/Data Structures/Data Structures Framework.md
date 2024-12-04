
### Data Storage

**There are only two ways to store data structures: as arrays (sequential storage) or as linked lists (linked storage).**

These structures are _structural basis_, every other structure can be stored using these two.
All other diverse data structures can be viewed as special operations 
on linked lists or arrays; they just have different APIs.

#### Queue and Stack
`queue` and `stack` data structures can be implemented with both linked 
lists and arrays. 

Using **arrays**, we need to deal with the problem of expanding and shrinking capacity. 

Using **linked lists**, there is no such problem, but more memory space is needed to store node pointers.

### Graph
A `graph` can be implemented with both **linked lists** and **arrays**.

An _adjacency table_ is a **linked list**.

An _adjacency table_ is more space-saving, but the efficiency of many operations is certainly less than for an _adjacency 
matrix_.

An _adjacency matrix_ is a **two-dimensional array**. 

An _adjacency matrix_ can be used to evaluate connectivity quickly and can solve some problems via matrix operations, 
but if the graph is sparse, this becomes very time-consuming. 

#### Hashtables
`Hashtables` map keys to a large **array** by making use of a hash function to solve hash conflicts. 
_Chaining_ needs **linked list** features with simple operations, but with the extra space needed to store pointers.  
_Linear exploration methods_ need **array** features, to address continuously, and does not need the extra storage space
for pointers, but the operation is slightly more complex.

#### Trees
The implementation of `trees` with **arrays** is a `heap`, because a `heap` is a complete _binary tree_.  
`Heap` storage with **arrays** does not need node pointers and the operation is relatively simple.  
The implementation with **linked list** is a very common kind of `tree`, because it is not necessarily a complete binary  
tree, so it is not suitable to use array storage.  
For this reason, based on the _tree structure of the list_, various ingenious designs have been derived, such as `binary  
search trees (BST)`, `AVL trees`, `red-black trees`, `interval trees`, `B-trees`, etc., to deal with different problems.

#### Conclusion
**The advantages and disadvantages of the two are as follows:**

- **Arrays** offer compact and continuous storage, which can be accessed randomly.  
They make it possible to find elements quickly via index and use storage space efficiently.   
- Because of the need for continuous chunks of memory, sufficient storage space must be allocated at one time. 
Therefore, if the array has to be expanded, we need to find and reallocate a larger space first, 
and then copy all the data over; time complexity **O(n)**.  
And if you want to insert and delete elements in the middle of the array, you must move all the data each time to 
maintain the continuity; time complexity **O(n)**.
Because the elements of a linked list are not continuous (the pointer points to the position of the next element), 
linked lists don't share the expansion problem faced by arrays. 
If you know the parent and child of a node, the operation can delete the element or insert a new element, 
with time complexity of **O(1)**. 
But because the storage space is not continuous, you can't calculate the address of the corresponding element according 
to an index, so you can't access it randomly. 
Because each element must store a pointer to the location of parent and/or child nodes, it will consume more storage 
space.

### Basic Operations on Data Structures
For any data structure, its basic operation is no more than _traversal + access_, and more specific point are: 
**add, delete, search and modify**. 

How to traverse + access?  
There are two forms of  traversal: linear and non-linear.  
Linear is represented by for / while iteration, and nonlinear is represented by recursion. 

#### Array traversal

```java
void traverse(int[] arr){
    for(int i = 0; i < arr.length; i++){
        // iteratively visit array
    }
}
```

#### Linked List traversal
```java
// Basic Node of a Singly-linked list
class ListNode {
    int val;
    ListNode next;
}
```
Iterative traversal:
```java
void traverse(ListNode head) {
    for(ListNode p = head; p != null; p = p.next) {
        //iteratively p.val
    }
}
```

Recursive traversal:
```java
void traverse(ListNode head) {
    // recursively head.val
    travers(head.next);
}
```

Tree traversal:
It is very similar to recursive Linked List traversal.
```java
/* Basic node of the binary tree */
class TreeNode {
    int val;
    TreeNode left, right;
}

void traverse(TreeNode root) {
    // pre-order traversal
    traverse(root.left);
    // in-order traversal
    traverse(root.right);
    // post-order traversal
}
```

It can easily be extended to N-tree traversal:
```java
/* Basic node of the N-tree */
class TreeNode {
    int val;
    TreeNode[] children;
}

void traverse(TreeNode root) {
    for (TreeNode child : root.children)
        traverse(child);
}
```

And it can be easily extended to Graph traversal by adding array to keep track of visited nodes.