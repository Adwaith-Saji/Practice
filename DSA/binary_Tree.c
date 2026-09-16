#include <stdio.h>
#include <stdlib.h>

struct Node{
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int data){
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));

    newNode->data=data;
    newNode->left=NULL;
    newNode->right=NULL;

    return newNode;

}
struct Node* createTree() {
    int data;

    printf("Enter data (-1 for no node): ");
    scanf("%d", &data);

    if (data == -1)
        return NULL;

    struct Node* root = createNode(data);

    printf("Enter left child of %d\n", data);
    root->left = createTree();

    printf("Enter right child of %d\n", data);
    root->right = createTree();

    return root;
}

int main() {
    struct Node* root;

    root = createTree();

    return 0;
}
