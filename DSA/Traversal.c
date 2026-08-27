/* struct Node *temp;

temp=head;

while (temp != NULL)
{
    printf("%d ", temp->data);
    temp = temp->next;
}                               */


#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *next;
};

int main()
{
    struct Node *head, *second, *third, *temp;

    head = malloc(sizeof(struct Node));
    second = malloc(sizeof(struct Node));
    third = malloc(sizeof(struct Node));

    head->data = 10;
    head->next = second;

    second->data = 20;
    second->next = third;

    third->data = 30;
    third->next = NULL;

    temp = head;

    while (temp != NULL)
    {
        printf("%d ", temp->data);
        temp = temp->next;
    }

    free(head);
    free(second);
    free(third);

    return 0;
}