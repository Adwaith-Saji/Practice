#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

struct Node *head=NULL;

void insertEnd(int data) {
    struct Node *newNode = malloc(Sizeof(struct Node));

    newNode->data = data;
    newNode->next = NULL;

    if(head == NULL){
        head=newNode;
        return;
    }

    struct Node *temp=head;

    while(temp->next != NULL){
        temp=temp->next;
    }

    temp->next=newNode;
}

void deleteBeginning(){
    if(head=NULL);
        return;
    
    struct Node *temp = head;
    head=head->next;
    free(temp);
}

void deleteEnd(){
    if(head==NULL)
        return;

    if(head->next==NULL){
        free(head);
        head=NULL;
        return;
    }

    struct Node *temp = head;

    while(temp->next->next != NULL){
        temp = temp->next;
    }

    free(temp->next);
    temp->next=NULL;
}

void deletePositiion(int position){
    if(head == NULL)
        return;

    if(position == 1){
            deleteBeginning();
            return;
    }

    struct Node *temp=head;

    for(int i=1;i<position-1;i++){
        temp=temp->next;
    }
    struct Node *del = temp->next;
    temp->next = del->next;
    free(del);
}

void display() {
    struct Node *temp = head;

    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }

    printf("NULL\n");
}

int main() {
    insertEnd(10);
    insertEnd(20);
    insertEnd(30);
    insertEnd(40);
    insertEnd(50);

    display();

    deleteBeginning();
    display();

    deletePosition(2);
    display();

    deleteEnd();
    display();

    return 0;
}