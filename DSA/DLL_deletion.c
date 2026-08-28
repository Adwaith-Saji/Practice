#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *prev;
    struct Node *next;
};

struct Node *head = NULL;

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

    while (temp->next != NULL)
        temp = temp->next;

    newNode->prev = temp;
    temp->next = newNode;
}

void deleteBeginning() {
    if (head == NULL)
        return;

    struct Node *temp = head;

    head = head->next;

    if (head != NULL)
        head->prev = NULL;

    free(temp);
}

void deleteEnd() {
    if (head == NULL)
        return;

    struct Node *temp = head;

    if (temp->next == NULL) {
        free(temp);
        head = NULL;
        return;
    }

    while (temp->next != NULL)
        temp = temp->next;

    temp->prev->next = NULL;

    free(temp);
}

void deletePosition(int position) {
    if (head == NULL)
        return;

    if (position == 1) {
        deleteBeginning();
        return;
    }

    struct Node *temp = head;

    for (int i = 1; i < position; i++)
        temp = temp->next;

    temp->prev->next = temp->next;

    if (temp->next != NULL)
        temp->next->prev = temp->prev;

    free(temp);
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