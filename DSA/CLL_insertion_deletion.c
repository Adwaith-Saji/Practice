#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

struct Node *head = NULL;

void insertBeginning(int data) {
    struct Node *newNode = malloc(sizeof(struct Node));

    newNode->data = data;

    if (head == NULL) {
        newNode->next = newNode;
        head = newNode;
        return;
    }

    newNode->next = head;

    struct Node *temp = head;

    while (temp->next != head)
        temp = temp->next;

    temp->next = newNode;
    head = newNode;
}

void insertEnd(int data) {
    struct Node *newNode = malloc(sizeof(struct Node));

    newNode->data = data;

    if (head == NULL) {
        newNode->next = newNode;
        head = newNode;
        return;
    }

    struct Node *temp = head;

    while (temp->next != head)
        temp = temp->next;

    newNode->next = head;
    temp->next = newNode;
}

void insertPosition(int data, int position) {
    if (position == 1) {
        insertBeginning(data);
        return;
    }

    struct Node *temp = head;

    for (int i = 1; i < position - 1; i++)
        temp = temp->next;

    struct Node *newNode = malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = temp->next;
    temp->next = newNode;
}

void deleteBeginning() {
    if (head == NULL)
        return;

    if (head->next == head) {
        free(head);
        head = NULL;
        return;
    }

    struct Node *temp = head;
    head = head->next;

    struct Node *last = head;

    while (last->next != temp)
        last = last->next;

    last->next = head;

    free(temp);
}

void deleteEnd() {
    if (head == NULL)
        return;

    if (head->next == head) {
        free(head);
        head = NULL;
        return;
    }

    struct Node *temp = head;

    while (temp->next->next != head)
        temp = temp->next;

    free(temp->next);
    temp->next = head;
}

void deletePosition(int position) {
    if (head == NULL)
        return;

    if (position == 1) {
        deleteBeginning();
        return;
    }

    struct Node *temp = head;

    for (int i = 1; i < position - 1; i++)
        temp = temp->next;

    struct Node *del = temp->next;

    temp->next = del->next;

    free(del);
}

void display() {
    if (head == NULL)
        return;

    struct Node *temp = head;

    do {
        printf("%d -> ", temp->data);
        temp = temp->next;
    } while (temp != head);

    printf("(head)\n");
}

int main() {
    insertBeginning(20);
    insertBeginning(10);
    insertEnd(40);
    insertPosition(30, 3);

    display();

    deleteBeginning();
    display();

    deletePosition(2);
    display();

    deleteEnd();
    display();

    return 0;
}