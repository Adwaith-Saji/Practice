#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

struct Node *head = NULL;
//-----------------------------insertion at beginning---------------------------
void insertBeginning(int data) {                        
    struct Node *newNode = malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = head;
    head = newNode;
}
//-------------------------------------------------------------------------------
//------------------------------insertion at end---------------------------------
void insertEnd(int data) {                              
    struct Node *newNode = malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = NULL;

    if (head == NULL) {
        head = newNode;
        return;
    }

    struct Node *temp = head;

    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
}
//----------------------------------------------------------------------------------
//----------------------------------insertion inbetween-----------------------------
void insertBetween(int data, int position) {            
    struct Node *newNode = malloc(sizeof(struct Node));

    newNode->data = data;

    struct Node *temp = head;

    for (int i = 1; i < position - 1; i++) {
        temp = temp->next;
    }

    newNode->next = temp->next;
    temp->next = newNode;
}
//------------------------------------------------------------------------------------
void display() {
    struct Node *temp = head;

    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }

    printf("NULL\n");
}

int main() {
    insertBeginning(20);
    insertBeginning(10);

    insertEnd(40);
    insertBetween(30, 3);

    display();

    return 0;
}