
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct node {
    int id;
    char name[50];
    struct node *next;
};

struct node *front = NULL;
struct node *rear = NULL;

// Add a patient to the queue
void enqueue() {
    struct node *newnode;
    newnode = (struct node*)malloc(sizeof(struct node));

    if (newnode == NULL) {
        printf("Memory allocation failed!\n");
        return;
    }

    printf("Enter patient ID: ");
    scanf("%d", &newnode->id);

    printf("Enter patient name: ");
    scanf(" %49[^\n]", newnode->name);

    newnode->next = NULL;

    if (front == NULL) {
        front = rear = newnode;
    } else {
        rear->next = newnode;
        rear = newnode;
    }

    printf("Patient added to queue.\n");
}

// Consult and remove the first patient
void dequeue() {
    struct node *temp;

    if (front == NULL) {
        printf("No patients waiting!\n");
        return;
    }

    temp = front;

    printf("Consulting patient: %s (ID: %d)\n",
           temp->name, temp->id);

    front = front->next;

    if (front == NULL)
        rear = NULL;

    free(temp);

    printf("Checkup completed. Patient removed from queue.\n");
}

// Display waiting patients
void display() {
    struct node *temp = front;

    if (front == NULL) {
        printf("No patients waiting!\n");
        return;
    }

    printf("\nPatients waiting for checkup:\n");

    while (temp != NULL) {
        printf("ID: %d, Name: %s\n",
               temp->id, temp->name);
        temp = temp->next;
    }
}

int main() {
    int choice;

    do {
        printf("\n--- Hospital Patient Queue ---\n");
        printf("1. Add Patient\n");
        printf("2. Consult Next Patient\n");
        printf("3. Display Waiting Patients\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                enqueue();
                break;

            case 2:
                dequeue();
                break;

            case 3:
                display();
                break;

            case 4:
                printf("Exiting program.\n");
                break;

            default:
                printf("Invalid choice!\n");
        }
    } while (choice != 4);

    return 0;
}
