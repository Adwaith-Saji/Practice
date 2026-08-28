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

void search(int value) {
    struct Node *temp = head;
    int position = 1;

    while (temp != NULL) {
        if (temp->data == value) {
            printf("%d found at position %d\n", value, position);
            return;
        }

        temp = temp->next;
        position++;
    }

    printf("%d not found\n", value);
}

void update(int position, int value) {
    struct Node *temp = head;

    for (int i = 1; i < position; i++)
        temp = temp->next;

    temp->data = value;
}

int countNodes() {
    struct Node *temp = head;
    int count = 0;

    while (temp != NULL) {
        count++;
        temp = temp->next;
    }

    return count;
}

void reverse() {
    struct Node *temp = head;
    struct Node *swap = NULL;

    while (temp != NULL) {
        swap = temp->prev;
        temp->prev = temp->next;
        temp->next = swap;

        temp = temp->prev;
    }

    if (swap != NULL)
        head = swap->prev;
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

    display();

    search(30);

    update(3, 35);
    display();

    printf("Number of nodes: %d\n", countNodes());

    reverse();
    display();

    return 0;
}