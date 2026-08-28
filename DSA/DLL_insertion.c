#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *prev;
    struct Node *next;
};

struct Node *head = NULL;

void insertBeginning(int data) {
    struct Node *newNode = malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->prev = NULL;
    newNode->next = head;

    if (head != NULL)
        head->prev = newNode;

    head = newNode;
}

void insertPosition(int data, int position) {
    if (position == 1) {
        insertBeginning(data);
        return;
    }

    struct Node *temp = head;

    for (int i = 1; i < position - 1; i++) {
        temp = temp->next;
    }

    struct Node *newNode = malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->prev = temp;
    newNode->next = temp->next;

    if (temp->next != NULL)
        temp->next->prev = newNode;

    temp->next = newNode;
}

void insertEnd(int data) {
    struct Node *newNode = malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = NULL;

    if (head == NULL) {
        newNode->prev = NULL;
        head = newNode;
        return;
    }

    struct Node *temp = head;

    while (temp->next != NULL) {
        temp = temp->next;
    }

    newNode->prev = temp;
    temp->next = newNode;
}

void display() {
    struct Node *temp = head;

    while (temp != NULL) {
        printf("%d <-> ", temp->data);
        temp = temp->next;
    }

    printf("NULL\n");
}

int main() {
    insertBeginning(20);
    insertBeginning(10);
    insertEnd(40);
    insertPosition(30, 3);

    display();

    return 0;
}