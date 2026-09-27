#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node *createNode(int data){
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));

    newNode->data=data;
    newNode->left=NULL;
    newNode->right=NULL;

    return newNode;
}
struct Node *createTree(){
    int data;

    printf("Enter data(-1 for noo node)");
    scanf("%d",&data);
    
    if (data==-1)
        return NULL;

    struct Node *root=createNode(data);

    printf("Enter the left child of %d\n",data);
    root->left=createTree();

    printf("ENter the right child of %d\n",data);
    root->right=createTree();

    return root;
}

//INORDER
void inorder(struct Node *root){
    if (root==NULL)
        return;
    inorder(root->left);
    printf("%d",root->data);
    inorder(root->right);
}

//PREORDER
void preorder(struct Node *root){
    if (root==NULL)
        return;
    
    printf("%d ", root->data);
    preorder(root->left);
    preorder(root->right);
}
// POSTORDER
void postorder(struct Node* root) {
    if (root == NULL)
        return;

    postorder(root->left);
    postorder(root->right);
    printf("%d ", root->data);
}

int main(){
    struct Node* root;
    int ch;

    do{
        printf("1-Create Tree\n2-Inorder\n3-Preorder\n4-Postorder\n5-Exit\n");
        printf("Enter a choice :");
        scanf("%d",&ch);

        switch (ch){
            case 1:
                root = createTree();
                printf("\nBinary tree created successfully.\n");
                break;
            case 2:
                printf("\n----Inorder----\n");
                inorder(root);
                printf("\n");
            case 3:
                printf("\nPreorder: ");
                preorder(root);
                printf("\n");
                break;

            case 4:
                printf("\nPostorder: ");
                postorder(root);
                printf("\n");
                break;

            case 5:
                printf("\nExiting...\n");
                break;
            default:
                printf("\nInvalid choice\n"); 
            
        }
    }while(ch != 5);
   return 0;
}